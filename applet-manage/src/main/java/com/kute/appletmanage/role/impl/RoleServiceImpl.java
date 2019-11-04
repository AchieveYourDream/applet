package com.kute.appletmanage.role.impl;


import com.kute.appletcore.dao.SysDataStructDefineMapper;
import com.kute.appletcore.dao.SysRoleMapper;
import com.kute.appletcore.dao.SysRoleMenuRelationMapper;
import com.kute.appletcore.entity.SysDataStructDefine;
import com.kute.appletcore.entity.SysRole;
import com.kute.appletcore.entity.SysRoleMenuRelation;
import com.kute.appletcore.entity.SysUser;
import com.kute.appletcore.util.JsonUtil;
import com.kute.appletcore.util.tree.TreeNode;
import com.kute.appletcore.util.tree.TreeNodeState;
import com.kute.appletcore.util.tree.TreeNodeVO;
import com.kute.appletmanage.role.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Name: 角色管理
 * @Description: 角色管理
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class RoleServiceImpl  implements RoleService {

    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Autowired
    private SysRoleMenuRelationMapper sysRoleMenuRelationMapper;

    @Autowired
    private SysDataStructDefineMapper sysDataStructDefineMapper;

    /**
     * 获取角色列表
     */
    public List<SysRole> selectAll() throws Exception {
        return sysRoleMapper.selectAll();
    }
    /**
     * 获取角色用户列表
     */
    public List<SysUser>  getRoleUserList(String roleId) throws Exception {
        return sysRoleMapper.getRoleUserList(roleId);
    }

    /**
     * 获取角色信息
     *
     * @param roleId 角色ID
     */
    public SysRole getRoleInfo(String roleId) throws Exception {
        return sysRoleMapper.selectByPrimaryKey(roleId);
    }

    /**
     * 获取角色信息
     *
     * @param roleName 角色名称
     */
    public SysRole getRoleInfoByRoleName(String roleName) throws Exception {
        return sysRoleMapper.getRoleInfoByRoleName(roleName);
    }

    /**
     * 获取角色信息
     *
     * @param roleId   角色ID
     * @param roleName 角色名称
     */
    public SysRole getRoleInfoByRoleIdName(String roleId, String roleName) throws Exception {
        Map<String, Object> parameterMap = new HashMap<>();
        parameterMap.put("roleId", roleId);
        parameterMap.put("roleName", roleName);
        return sysRoleMapper.getRoleInfoByRoleIdName(parameterMap);
    }

    /**
     * 新增角色
     */
    @Transactional
    public void addRole(SysRole sr) throws Exception {
        sysRoleMapper.insert(sr);
    }

    /**
     * 编辑角色
     */
    @Transactional
    public void editRole(SysRole sr) throws Exception {
        sysRoleMapper.updateByPrimaryKey(sr);
    }

    /**
     * 获取菜单权限树结构
     *
     * @param roleId 角色ID
     */
    public String getMenuAuthTreeStruct(String roleId) throws Exception {
        return sysRoleMapper.getMenuAuthTreeStruct(roleId);
    }

    /**
     * 获取菜单权限树
     *
     * @param roleId 角色ID
     */
    public String  getMenuAuthTree(String roleId, String menuStructCode) throws Exception {
        //获取菜单资源 menu_resource
        SysDataStructDefine dsd = sysDataStructDefineMapper.selectByPrimaryKey(menuStructCode);

//        //第一层树节点data
//        TreeNodeData tnd = new TreeNodeData();
//        tnd.setNodeCode("auto".equals(dsd.getNodeCodeRule()) ? dsd.getRulePrefix() : "root");                // 节点编码
//        tnd.setNodeName(dsd.getStructName());        // 节点名称 menu_resource
//        tnd.setParentNodeCode("-1");  // 父节点编码
//
//        //第一层树节点状态state
//        TreeNodeState state = new TreeNodeState();
//        state.setChecked("unchecked".equals(tnd.getState()) ? "false" : "true");
//
//        //树节点返回数据return
//        TreeNode rootNode = new TreeNode();
//        rootNode.setText(dsd.getStructName());//第一层树节点text放入返回值中
//        rootNode.setData(tnd);                //第一层树节点data放入返回值中
//        rootNode.setState(state);            //第一层树节点state放入返回值中


        List<TreeNodeVO> subTreeList = sysRoleMapper.getMenuAuthTree(menuStructCode,roleId);
        // 4.递归生成子树
        List<TreeNode> sublist = this.generateSubTree(subTreeList, dsd.getRulePrefix());
//        rootNode.setNodes(sublist);

        TreeNode topNode = new TreeNode();
        topNode.setText(dsd.getStructName());
        topNode.setNodes(sublist);

        String json = JsonUtil.getJSONFromObject(topNode);

        json = json.replaceAll("\"nodes\":\\[\\],", "");

        return json;
    }

    /**
     * 递归生成子树
     */
    private List<TreeNode>  generateSubTree(List<TreeNodeVO> list,  String  parentNode) throws Exception {

        //子节点的树节点
        List<TreeNode> subNodeList = new ArrayList<TreeNode>();
            for (TreeNodeVO menu : list) {
                TreeNode subNode = new TreeNode();
                subNode.setText(menu.getNodeName());
                subNode.setData(menu.getTreeNodeData());
//                子树节点状态
                TreeNodeState state = new TreeNodeState();
                state.setChecked("true".equals(menu.getIsChecked()) ? true : false);//是否被选中-复选框
                subNode.setState(state);
                String menuId = menu.getNodeCode();
                String parentCode = menu.getParentNodeCode();
                if (parentNode.equals(parentCode) ) {
                    List<TreeNode> menuLists = generateSubTree(list, menuId);
                    subNode.setNodes(menuLists);
                    subNodeList.add(subNode);
                }
            }

        return  subNodeList;

    }


    public void roleDelete(String roleId) throws Exception {
        sysRoleMapper.deleteByPrimaryKey(roleId);
    }

    public void saveRoleMenuAuth(Integer roleId, String menu_code) throws Exception {
        //先删除角色的所有权限
        String[] checked = menu_code.split(",");
        sysRoleMenuRelationMapper.removeRoleMenuAuthList(roleId);


        List<SysRoleMenuRelation> list=new ArrayList<>();
        //再把所有权限新增一遍
        for (String str : checked) {
            SysRoleMenuRelation srr = new SysRoleMenuRelation();
            srr.setMenuCode(str);
            srr.setRoleId(roleId);
            list.add(srr);

        }
        sysRoleMenuRelationMapper.insert(list);

    }

    /**
     * @Description:  删除角色用户关系
     * @Author: 王斌
     * @Date: 2019/11/4
     */
    public void delRoleUserRelation(String roleId, String userList) throws Exception {

        sysRoleMapper.delRoleUserRelation(roleId,userList);

    }

}

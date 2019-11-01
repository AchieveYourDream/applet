//package com.kute.appletmanage.role.impl;
//
//
//import com.kute.appletcore.dao.SysDataStructDefineMapper;
//import com.kute.appletcore.dao.SysRoleMapper;
//import com.kute.appletcore.dao.SysRoleResourceMapper;
//import com.kute.appletcore.entity.SysDataStructDefine;
//import com.kute.appletcore.entity.SysRole;
//import com.kute.appletcore.entity.SysRoleResource;
//import com.kute.appletcore.util.tree.TreeNode;
//import com.kute.appletcore.util.tree.TreeNodeData;
//import com.kute.appletcore.util.tree.TreeNodeState;
//import com.kute.appletmanage.role.service.RoleService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
///**
// * @Name: 角色管理
// * @Description: 角色管理
// */
//@Service
//public class RoleServiceImpl  implements RoleService {
//
//    @Autowired
//    private SysRoleMapper sysRoleMapper;
//
//    @Autowired
//    private SysRoleResourceMapper sysRoleResourceMapper;
//
//    @Autowired
//    private SysDataStructDefineMapper sysDataStructDefineMapper;
//
//    /**
//     * 获取角色列表
//     */
//    public List<SysRole> selectAll() throws Exception {
//        return sysRoleMapper.selectAll();
//    }
//
//    /**
//     * 获取角色信息
//     *
//     * @param roleId 角色ID
//     */
//    public SysRole getRoleInfo(String roleId) throws Exception {
//        return sysRoleMapper.selectByPrimaryKey(roleId);
//    }
//
//    /**
//     * 获取角色信息
//     *
//     * @param roleName 角色名称
//     */
//    public SysRole getRoleInfoByRoleName(String roleName) throws Exception {
//        return sysRoleMapper.getRoleInfoByRoleName(roleName);
//    }
//
//    /**
//     * 获取角色信息
//     *
//     * @param roleId   角色ID
//     * @param roleName 角色名称
//     */
//    public SysRole getRoleInfoByRoleIdName(String roleId, String roleName) throws Exception {
//        Map<String, Object> parameterMap = new HashMap<>();
//        parameterMap.put("roleId", roleId);
//        parameterMap.put("roleName", roleName);
//        return sysRoleMapper.getRoleInfoByRoleIdName(parameterMap);
//    }
//
//    /**
//     * 新增角色
//     */
//    @Transactional
//    public void addRole(SysRole sr) throws Exception {
//        sysRoleMapper.insert(sr);
//    }
//
//    /**
//     * 编辑角色
//     */
//    @Transactional
//    public void editRole(SysRole sr) throws Exception {
//        sysRoleMapper.updateByPrimaryKey(sr);
//    }
//
//    /**
//     * 获取菜单权限树结构
//     *
//     * @param roleId 角色ID
//     */
//    public String getMenuAuthTreeStruct(String roleId) throws Exception {
//        return sysRoleMapper.getMenuAuthTreeStruct(roleId);
//    }
//
//    /**
//     * 获取菜单权限树
//     *
//     * @param roleId 角色ID
//     */
//    public TreeNode getMenuAuthTree(String roleId, String menuStructCode) throws Exception {
//        //获取菜单资源 menu_resource
//        SysDataStructDefine dsd = sysDataStructDefineMapper.selectByPrimaryKey(menuStructCode);
//
//        //第一层树节点data
//        TreeNodeData tnd = new TreeNodeData();
//        tnd.setNodeCode("auto".equals(dsd.getNodeCodeRule()) ? dsd.getRulePrefix() : "root");                // 节点编码
//        tnd.setNodeName(dsd.getStructName());        // 节点名称 menu_resource
//        tnd.setParentNodeCode("-1");                // 父节点编码
//
//        //第一层树节点状态state
//        TreeNodeState state = new TreeNodeState();
//        state.setChecked("unchecked".equals(tnd.getState()) ? false : true);
//
//        //树节点返回数据return
//        TreeNode rootNode = new TreeNode();
//        rootNode.setText("菜单");                //第一层树节点text放入返回值中
//        rootNode.setData(tnd);                //第一层树节点data放入返回值中
//        rootNode.setState(state);            //第一层树节点state放入返回值中
//
//        //递归查询子节点
//        this.generateSubTree(roleId, menuStructCode, rootNode);
////        String json = JsonUtil.getJSONFromObject(rootNode);
////		String newJson = json.replaceAll("\"nodes\":\\[\\],", "");
////		rootNode = JsonUtil.getObjectFromJSON(newJson, TreeNode.class);
//        return rootNode;
//    }
//
//    /**
//     * 递归生成子树
//     */
//    private void generateSubTree(String roleId, String structCode, TreeNode parentNode) throws Exception {
//        //mapper查询参数
//        Map<String, Object> parameterMap = new HashMap<>();
//        parameterMap.put("roleId", roleId);
//        parameterMap.put("structCode", structCode);
//        parameterMap.put("parentCode", parentNode.getData().getNodeCode());
//
//        //查询当前节点 角色拥有权限的所有子节点
//        List<TreeNodeData> subTreeList = sysRoleMapper.getMenuAuthTree(parameterMap);
//
//        //子节点的树节点
//        List<TreeNode> subNodeList = new ArrayList<TreeNode>();
//
//        for (TreeNodeData menu : subTreeList) {
//
//            //子节点树节点
//            TreeNodeData tnd = new TreeNodeData();
//            tnd.setNodeCode(menu.getNodeCode());            //树节点code
//            tnd.setNodeName(menu.getNodeName());            //树节点name
//            tnd.setParentNodeCode(parentNode.getData().getNodeCode()); //树节点父节点
//            tnd.setState(menu.getIsChecked());                    //树节点state
//
//            //子树节点状态
//            TreeNodeState state = new TreeNodeState();
//            state.setChecked("true".equals(menu.getIsChecked()) ? true : false);//是否被选中-复选框
//
//            //子树节点返回数据
//            TreeNode subNode = new TreeNode();
//            subNode.setText(menu.getNodeName());        //子树节点text放入返回值中
//            subNode.setData(tnd);                        //子树节点data放入返回值中
//            subNode.setState(state);                    //子树节点state放入返回值中
//
//            //继续递归
//            generateSubTree(roleId, structCode, subNode);
//
//            subNodeList.add(subNode);
//        }
//
//        if (subNodeList != null && subNodeList.size() > 0) {
//            parentNode.setNodes(subNodeList);
//        }
//    }
//
//
//    public void roleDelete(String roleId) throws Exception {
//        sysRoleMapper.deleteByPrimaryKey(roleId);
//    }
//
//    public void saveRoleMenuAuth(String roleId, String menu_code) throws Exception {
//        //先删除角色的所有权限
//        sysRoleMapper.removeRoleMenuAuthList(roleId);
//        String[] checked = menu_code.split(",");
//        sysRoleResourceMapper.removeRoleMenuAuthList(roleId);
//
//        //再把所有权限新增一遍
//        for (String str : checked) {
//            SysRoleResource srr = new SysRoleResource();
//            srr.setResource_id(str);
//            srr.setResource_type("menu");
//            srr.setRole_id(roleId);
//            sysRoleResourceMapper.insert(srr);
//
//        }
//
//    }
//
//}

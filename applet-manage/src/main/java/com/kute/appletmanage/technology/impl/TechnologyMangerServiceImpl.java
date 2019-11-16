

package com.kute.appletmanage.technology.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kute.appletcore.dao.AppTechnologyAttributeMapper;
import com.kute.appletcore.dao.AppTechnologyNodeMapper;
import com.kute.appletcore.entity.AppTechnologyAttribute;
import com.kute.appletcore.entity.AppTechnologyNode;
import com.kute.appletcore.util.JsonUtil;
import com.kute.appletcore.util.tree.TreeNode;
import com.kute.appletcore.util.tree.TreeNodeVO;
import com.kute.appletcore.vo.ResponseResult;
import com.kute.appletmanage.technology.dao.TechnologyMangerMapper;
import com.kute.appletmanage.technology.service.TechnologyMangerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @Name: 尺码管理
 * @Description: 尺码管理
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class TechnologyMangerServiceImpl implements TechnologyMangerService {


    @Autowired
    private TechnologyMangerMapper technologyMangerMapper;

    @Autowired
    private AppTechnologyAttributeMapper appTechnologyAttributeMapper;
    @Autowired
    private AppTechnologyNodeMapper appTechnologyNodeMapper;


    /**
     * 获取工艺节点树
     */
    public String getTechnologyNodeTree() throws Exception {

        List<TreeNodeVO> mainTreeList = technologyMangerMapper.getDataStructNodeTree();
        List<TreeNodeVO> subTreeList = technologyMangerMapper.getTechnologyNodeTree();
        mainTreeList.addAll(subTreeList);
        List<TreeNode> list= generateSubTree(mainTreeList,"G");

        String json = JsonUtil.getJSONFromObjectList(list);

        json = json.replaceAll("\"nodes\":\\[\\],", "");

        return json;
    }


    /**
     * 递归生成子树
     */
    public List<TreeNode> generateSubTree(List<TreeNodeVO> list, String parentNode) throws Exception {
        List<TreeNode> subNodeList = new ArrayList<>();
        for (TreeNodeVO menu : list) {
            TreeNode subNode = new TreeNode();
            subNode.setText(menu.getNodeName());
            subNode.setData(menu.getTreeNodeData());
            String menuId = menu.getNodeCode();
            String parentCode = menu.getParentNodeCode();
            if (parentNode.equals(parentCode) ) {
                List<TreeNode> menuLists = generateSubTree(list, menuId);
                subNode.setNodes(menuLists);
                subNodeList.add(subNode);
            }
        }

        return subNodeList;
    }

    /**
     * 获取工艺节点信息
     */
    public AppTechnologyNode getTechnologyNodeInfo(String  nodeCode)  {
        return appTechnologyNodeMapper.selectByPrimaryKey(nodeCode);
    }





    /**
     * 新建工艺节点
     */
    @Transactional
    public void addTechnologyNode(AppTechnologyNode appTechnologyNode)  {
        appTechnologyNodeMapper.insert(appTechnologyNode);
    }

    /**
     * 编辑工艺节点
     */
    @Transactional
    public void editTechnologyNode(AppTechnologyNode appTechnologyNode)  {
        appTechnologyNodeMapper.updateByPrimaryKey(appTechnologyNode);
    }

    /**
     * 删除工艺节点
     *
     */
    @Transactional
    public void removeTechnologyNode(String nodeCode) throws Exception {
        // 1.删除当前工艺节点的扩展属性列表
        technologyMangerMapper.removeTechnologyNodeAttributeListByNodeCode(nodeCode);

        // 2.删除当前工艺节点
        technologyMangerMapper.deleteTechnologyNodeByNodeCode(nodeCode);

    }



    /**
     * 获取尺码列表
     */
    public PageInfo<AppTechnologyAttribute> getTechnologyList(Integer pageNum, Integer pageSize,String nodeCode, String search) throws Exception {
        PageHelper.startPage(pageNum, pageSize, true, false);
        List<AppTechnologyAttribute> list = technologyMangerMapper.getTechnologyList(nodeCode,search);
        return new PageInfo<>(list);
    }


    /**
     * 获取尺码信息
     */
    public AppTechnologyAttribute getTechnologyInfoByTechnologyAttributeId(Integer TechnologyId)  {
        return appTechnologyAttributeMapper.selectByPrimaryKey(TechnologyId);
    }

    /**
     * 新增尺码
     */

    public ResponseResult addTechnology(AppTechnologyAttribute technology) throws Exception {
        if(technology.getIsDefault().equals("Y")){
          Integer count=  technologyMangerMapper.selectDefaultNum(technology.getNodeCode());
            if (count!=0) {
                return new ResponseResult("W", "当前默认工艺已经存在!无法增加为默认工艺");
            }
        }
            appTechnologyAttributeMapper.insert(technology);
            return new ResponseResult("S", "保存成功");

    }

    /**
     * 编辑尺码
     */

    public ResponseResult editTechnology(AppTechnologyAttribute technology)  {
        appTechnologyAttributeMapper.updateByPrimaryKey(technology);
        return new ResponseResult("S", "编辑成功");
    }

    /**
     * 删除尺码
     */

    public void removeTechnology(Integer technologyId)  {
        appTechnologyAttributeMapper.deleteByPrimaryKey(technologyId);    //删除尺码

    }
    /**
    * @Description: 设置工艺默认值
    * @Author: 王斌
    * @Date: 2019/11/13
    */
    @Override
    public void updateTechnologyDefault(Integer technologyId, String nodeCode) throws Exception {
        //将所有节点下的工艺设置成非默认
        technologyMangerMapper.updateTechnologyIsDefault(nodeCode);
        //设置工艺默认值
        technologyMangerMapper.updateTechnologyDefault(technologyId,nodeCode);

        
    }

    /**
     * 获取一个节点下面的默认工艺数量
     */
    public int selectDefaultNum( String nodeCode) throws Exception{
       return  technologyMangerMapper.selectDefaultNum(nodeCode);
    }



}


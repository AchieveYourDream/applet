package com.kute.appletmanage.technology.dao;


import com.kute.appletcore.entity.AppTechnologyAttribute;
import com.kute.appletcore.util.tree.TreeNodeVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Name: 工艺管理
 * @Description: 工艺管理
 */
public interface TechnologyMangerMapper {




    /**
     * 获取数据结构节点树
     */
    List<TreeNodeVO> getDataStructNodeTree() throws Exception;


    /**
     * 获取工艺节点树
     */
    List<TreeNodeVO> getTechnologyNodeTree() throws Exception;

    /**
     * 删除工艺节点树节点
     */
    Integer removeTechnologyNodeAttributeListByNodeCode(String nodeCode) throws Exception;
    /**
     * 删除工艺节点树节点下工艺
     */
    Integer deleteTechnologyNodeByNodeCode(String nodeCode) throws Exception;



    /**
     * 获取工艺列表
     */
    List<AppTechnologyAttribute> getTechnologyList(@Param("nodeCode")String  nodeCode,@Param("search")String search) throws Exception;



    /**
     * 将所有节点下的工艺设置成非默认
     */
    Integer updateTechnologyIsDefault(String nodeCode) throws Exception;

    /**
     * 设置工艺默认值
     */
    Integer updateTechnologyDefault(@Param("technologyId") Integer technologyId,@Param("nodeCode") String nodeCode) throws Exception;

    /**
     * 获取一个节点下面的默认工艺数量
     */
    Integer selectDefaultNum(@Param("nodeCode") String nodeCode) throws Exception;




}

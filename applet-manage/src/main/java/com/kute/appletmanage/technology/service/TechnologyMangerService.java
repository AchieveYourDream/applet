package com.kute.appletmanage.technology.service;

import com.github.pagehelper.PageInfo;
import com.kute.appletcore.entity.AppTechnologyAttribute;
import com.kute.appletcore.entity.AppTechnologyNode;
import com.kute.appletcore.vo.ResponseResult;

public interface TechnologyMangerService {

    /**
     * 获取工艺节点树
     */
    String getTechnologyNodeTree() throws Exception;
    /**
     * 获取工艺节点信息
     */
    AppTechnologyNode getTechnologyNodeInfo( String nodeCode) throws Exception;
    /**
     * 新建工艺节点
     */
    void addTechnologyNode(AppTechnologyNode appTechnologyNode) throws Exception;
    /**
     * 编辑工艺节点
     */
    void editTechnologyNode(AppTechnologyNode appTechnologyNode) throws Exception;
    /**
     * 删除工艺节点
     * @param nodeCode   数据节点编码
     */
    void removeTechnologyNode( String nodeCode) throws Exception;


    /**
     * 获取尺码列表
     */
    PageInfo<AppTechnologyAttribute> getTechnologyList(Integer pageNum, Integer pageSize,String  nodeCode, String search) throws Exception;
    /**
     * 获取尺码信息
     */
    AppTechnologyAttribute getTechnologyInfoByTechnologyAttributeId(Integer TechnologyId) throws Exception;
    /**
     * 新增尺码
     */
    ResponseResult addTechnology(AppTechnologyAttribute technology) throws Exception;
    /**
     * 编辑尺码
     */
    ResponseResult editTechnology(AppTechnologyAttribute technology) throws Exception;

    /**
     * 删除尺码
     */
    void removeTechnology(Integer technologyId) throws Exception;
    /**
     * 设置工艺默认值
     */
    void updateTechnologyDefault(Integer technologyId,String nodeCode) throws Exception;



}

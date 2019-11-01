package com.kute.appletmanage.datastruct.impl;

import com.kute.appletcore.entity.SysDataStructAttribute;
import com.kute.appletcore.entity.SysDataStructDefine;
import com.kute.appletcore.entity.SysDataStructNode;
import com.kute.appletcore.entity.SysDataStructNodeAttribute;
import com.kute.appletcore.vo.SysDataStructAttributeVO;
import com.kute.appletcore.vo.SysDataStructDefineVO;
import com.kute.appletcore.vo.SysDataStructNodeAttributeVO;

import java.util.List;

public interface DataStructService {
    /**
     * 获取数据结构定义列表
     */
    List<SysDataStructDefineVO> getDataStructDefineList() throws Exception;
    /**
     * 获取数据结构定义信息
     * @param structCode 数据结构编码
     */
    SysDataStructDefine getDataStructDefineInfo(String structCode) throws Exception;
    /**
     * 获取数据结构属性列表
     */
    List<SysDataStructAttributeVO> getDataStructAttributeList(String structCode) throws Exception;
    /**
     * 获取数据结构属性信息
     */
    SysDataStructAttributeVO getDataStructAttributeInfo(String structCode, String attributeCode)throws Exception;
    /**
     * 新建数据结构定义
     */
    void addDataStructDefine(SysDataStructDefine dsd) throws Exception;
    /**
     * 编辑数据结构定义
     */
    void editDataStructDefine(SysDataStructDefine dsd) throws Exception;
    /**
     * 删除数据结构定义
     */
    void removeDataStructDefine(String structCode) throws Exception;
    /**
     * 新建数据结构属性
     */
    void addDataStructAttribute(SysDataStructAttribute dsa) throws Exception;
    /**
     * 编辑数据结构属性
     */
    void editDataStructAttribute(SysDataStructAttribute dsa) throws Exception;
    /**
     * 删除数据结构属性
     */
    void removeDataStructAttribute(String structCode, String attributeCode) throws Exception;
    /**
     * 获取数据结构节点树
     */
    String getDataStructNodeTree(String structCode) throws Exception;
    /**
     * 获取数据结构节点信息
     */
    SysDataStructNode getDataStructNodeInfo(String structCode, String nodeCode) throws Exception;
    /**
     * 新建数据结构节点
     */
    void addDataStructNode(SysDataStructNode dsn) throws Exception;
    /**
     * 编辑数据结构节点
     */
    void editDataStructNode(SysDataStructNode dsn) throws Exception;
    /**
     * 删除数据结构节点
     * @param structCode 数据结构编码
     * @param nodeCode   数据节点编码
     */
    void removeDataStructNode(String structCode, String nodeCode) throws Exception;
    /**
     * 获取数据结构节点属性列表
     * @param structCode 数据结构编码
     * @param nodeCode   数据节点编码
     */
    List<SysDataStructNodeAttributeVO> getDataStructNodeAttributeList(String structCode, String nodeCode)throws Exception;
    /**
     * 保存数据结构节点属性
     */
    void saveDataStructNodeAttributes(List<SysDataStructNodeAttribute> dsnaList) throws Exception;

    List<SysDataStructNode> getDataStructNodeList() throws Exception;

}

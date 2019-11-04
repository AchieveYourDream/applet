package com.kute.appletmanage.datastruct.dao;

import com.kute.appletcore.util.tree.TreeNodeVO;
import com.kute.appletcore.vo.SysDataStructAttributeVO;
import com.kute.appletcore.vo.SysDataStructDefineVO;
import com.kute.appletcore.vo.SysDataStructNodeAttributeVO;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @Name: 数据结构
 * @Description: 数据结构
 * @CreatedBy: zoran
 * @CreateDate: 2018-04-17
 * @LastUpdatedBy: zoran
 * @LastUpdateDate 2018-04-17
 */
@Repository
public interface DataStructMapper {

    /**
     * 获取数据结构定义列表
     */
    List<SysDataStructDefineVO> getDataStructDefineList() throws Exception;

    /**
     * 获取数据结构属性列表
     */
    List<SysDataStructAttributeVO> getDataStructAttributeList(String structCode) throws Exception;

    /**
     * 获取数据结构属性信息
     *
     * @param parameterMap 参数MAP
     */
    SysDataStructAttributeVO getDataStructAttributeInfo(Map<String, Object> parameterMap) throws Exception;

    /**
     * 获取数据结构节点树
     *
     * @param structCode 参数MAP
     */
    List<TreeNodeVO> getDataStructNodeTree(String structCode) throws Exception;

    /**
     * 获取数据结构节点树根据父节点
     *
     */
    List<TreeNodeVO> getDataStructNodeTreeByParent(Map map) throws Exception;

    /**
     * 获取数据结构节点编码
     *
     * @param parameterMap 参数MAP
     */
    String getDataStructNodeCode(Map<String, Object> parameterMap) throws Exception;

    /**
     * 获取数据结构节点属性列表
     *
     * @param parameterMap 参数MAP
     */
    List<SysDataStructNodeAttributeVO> getDataStructNodeAttributeList(Map<String, Object> parameterMap) throws Exception;

    /**
     * 删除当前数据结构的扩展属性列表
     *
     * @param structCode 数据结构定义编码
     */
    void removeDataStructAttributeList(String structCode) throws Exception;


    /**
     * 删除当前数据结构的数据节点扩展属性列表
     *
     * @param structCode 数据结构定义编码
     */
    void removeDataStructNodeAttributeListByStructCode(String structCode) throws Exception;

    /**
     * 删除当前数据结构的数据节点列表
     *
     * @param structCode 数据结构定义编码
     */
    void removeDataStructNodeList(String structCode) throws Exception;

    /**
     * 删除当前数据节点的扩展属性列表
     *
     * @param parameterMap 参数MAP
     */
    void removeDataStructNodeAttributeListByNodeCode(Map<String, Object> parameterMap) throws Exception;

    /**
     * 删除当前数据结构节点的扩展属性列表
     *
     * @param parameterMap 参数MAP
     */
    void removeDataStructNodeAttributeListByAttributeCode(Map<String, Object> parameterMap) throws Exception;

}

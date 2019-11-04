package com.kute.appletmanage.datadict.dao;


import com.kute.appletcore.entity.SysDataDictItem;
import com.kute.appletcore.entity.SysDataDictType;

import java.util.List;
import java.util.Map;

/**
 * @Name: 数据字典
 * @Description: 数据字典
 * @CreatedBy: zoran
 * @CreateDate: 2018-04-16
 * @LastUpdatedBy: zoran
 * @LastUpdateDate 2018-04-16
 */
public interface DataDictMapper {

    /**
     * 获取数据字典类型列表
     */
    List<SysDataDictType> getDataDictTypeList() throws Exception;

    /**
     * 删除当前数据字典类型的扩展属性列表
     *
     * @param typeCode 数据字典类型编码
     */
    void removeDataDictTypeAttributeList(String typeCode) throws Exception;

    /**
     * 删除当前数据字典类型的数据字典项列表
     *
     * @param typeCode 数据字典类型编码
     */
    void removeDataDictItemList(String typeCode) throws Exception;

    /**
     * 删除当前数据字典类型的数据字典项扩展属性列表
     *
     * @param typeCode 数据字典类型编码
     */
    void removeDataDictItemAttributeListByTypeCode(String typeCode) throws Exception;

    /**
     * 删除当前数据字典项的扩展属性列表
     *
     * @param parameterMap 参数MAP
     */
    void removeDataDictItemAttributeListByItemCode(Map<String, Object> parameterMap) throws Exception;

    /**
     * 获取数据字典项列表
     *
     * @param typeCode 数据字典类型编码
     */
    List<SysDataDictItem> getDataDictItemList(String typeCode) throws Exception;



    /**
     * 根据一个数据字典类型获取数据字典项列表
     *
     */
    List<SysDataDictItem> getSingleDataDictItemList(String  typeCode) throws Exception;


}

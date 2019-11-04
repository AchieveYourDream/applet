package com.kute.appletmanage.datadict.service;

import com.kute.appletcore.entity.SysDataDictItem;
import com.kute.appletcore.entity.SysDataDictType;

import java.util.List;

public interface DataDictService {
    /**
     * 获取数据字典类型列表
     */
    List<SysDataDictType> getDataDictTypeList() throws Exception;
    /**
     * 获取数据字典类型信息
     * @param typeCode 数据字典类型编码
     */
    SysDataDictType getDataDictTypeInfo(String typeCode) throws Exception;
    /**
     * 新建数据字典类型
     * @param ddt 数据字典类型
     */
    void addDataDictType(SysDataDictType ddt) throws Exception;
    /**
     * 编辑数据字典类型
     * @param ddt 数据字典类型
     */
    void editDataDictType(SysDataDictType ddt) throws Exception;
    /**
     * 删除数据字典类型
     * @param typeCode 数据字典类型编码
     */
    void removeDataDictType(String typeCode) throws Exception;
    /**
     * 获取数据字典项列表
     * @param typeCode 数据字典类型编码
     */
    List<SysDataDictItem> getDataDictItemList(String typeCode) throws Exception;
    /**
     * 获取数据字典项信息
     * @param typeCode 数据字典类型编码
     */
    SysDataDictItem getDataDictItemInfo(String item_code, String typeCode) throws Exception;
    /**
     * 新建数据字典项
     * @param ddi 数据字典项
     */
    void addDataDictItem(SysDataDictItem ddi) throws Exception;

    /**
     * 编辑数据字典项
     * @param ddi 数据字典项
     */
    void editDataDictItem(SysDataDictItem ddi) throws Exception;
    /**
     * 删除数据字典项
     *
     * @param typeCode 数据字典类型编码
     * @param itemCode 数据字典项编码
     */
    void removeDataDictItem(String typeCode, String itemCode) throws Exception;

    List<SysDataDictItem> getSingleDataDictItemList(String typeCode) throws Exception;

}

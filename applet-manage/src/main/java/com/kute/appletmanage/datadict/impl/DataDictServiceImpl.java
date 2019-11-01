package com.kute.appletmanage.datadict.impl;

import com.kute.appletcore.dao.SysDataDictItemMapper;
import com.kute.appletcore.dao.SysDataDictTypeMapper;
import com.kute.appletcore.entity.SysDataDictItem;
import com.kute.appletcore.entity.SysDataDictType;
import com.kute.appletmanage.datadict.dao.DataDictMapper;
import com.kute.appletmanage.datadict.service.DataDictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
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
@Service
@Transactional(rollbackFor = Exception.class)
public class DataDictServiceImpl implements DataDictService {

    @Autowired
    private DataDictMapper dataDictMapper;

    @Autowired
    private SysDataDictTypeMapper sysDataDictTypeMapper;

    @Autowired
    private SysDataDictItemMapper sysDataDictItemMapper;

//    @Autowired
//    private DataDictRedisDao dataDictRedisDao;

    /**
     * 获取数据字典类型列表
     */
    public List<SysDataDictType> getDataDictTypeList() throws Exception {
        return dataDictMapper.getDataDictTypeList();
    }

    /**
     * 获取数据字典类型信息
     *
     * @param typeCode 数据字典类型编码
     */
    public SysDataDictType getDataDictTypeInfo(String typeCode) throws Exception {
        return sysDataDictTypeMapper.selectByPrimaryKey(typeCode);
    }

    /**
     * 新建数据字典类型
     *
     * @param ddt 数据字典类型
     */
    public void addDataDictType(SysDataDictType ddt) throws Exception {
        // 1.新增数据字典类型
        sysDataDictTypeMapper.insert(ddt);
        // 2.更新Redis缓存
        // dataDictRedisDao.addDataDictType(ddt.getType_code());
    }

    /**
     * 编辑数据字典类型
     *
     * @param ddt 数据字典类型
     */
   
    public void editDataDictType(SysDataDictType ddt) throws Exception {
        sysDataDictTypeMapper.updateByPrimaryKey(ddt);
    }

    /**
     * 删除数据字典类型
     *
     * @param typeCode 数据字典类型编码
     */
   
    public void removeDataDictType(String typeCode) throws Exception {
        // 1.删除当前数据字典类型的数据字典项扩展属性列表
        dataDictMapper.removeDataDictItemAttributeListByTypeCode(typeCode);

        // 2.删除当前数据字典类型的数据字典项列表
        dataDictMapper.removeDataDictItemList(typeCode);

        // 3.删除当前数据字典类型的扩展属性列表
        dataDictMapper.removeDataDictTypeAttributeList(typeCode);

        // 4.删除当前数据字典类型
        sysDataDictTypeMapper.deleteByPrimaryKey(typeCode);

        // 5.更新Redis缓存
//        dataDictRedisDao.removeDataDictType(typeCode);
    }

    /**
     * 获取数据字典项列表
     *
     * @param typeCode 数据字典类型编码
     */
    public List<SysDataDictItem> getDataDictItemList(String typeCode) throws Exception {
        return dataDictMapper.getDataDictItemList(typeCode);
    }

    /**
     * 获取数据字典项信息
     *
     * @param typeCode 数据字典类型编码
     */
    public SysDataDictItem getDataDictItemInfo(String item_code, String typeCode) throws Exception {
        return sysDataDictItemMapper.selectByPrimaryKey(item_code, typeCode);
    }

    /**
     * 新建数据字典项
     *
     * @param ddi 数据字典项
     */
   
    public void addDataDictItem(SysDataDictItem ddi) throws Exception {
        // 1.新建数据字典项
        sysDataDictItemMapper.insert(ddi);

        // 2.更新Redis缓存
        //dataDictRedisDao.addDataDictItem(ddi);
    }

    /**
     * 编辑数据字典项
     *
     * @param ddi 数据字典项
     */
   
    public void editDataDictItem(SysDataDictItem ddi) throws Exception {
        sysDataDictItemMapper.updateByPrimaryKey(ddi);
        List<SysDataDictItem> list = dataDictMapper.getDataDictItemList(ddi.getTypeCode());
    }

    /**
     * 删除数据字典项
     *
     * @param typeCode 数据字典类型编码
     * @param itemCode 数据字典项编码
     */
   
    public void removeDataDictItem(String typeCode, String itemCode) throws Exception {
        Map<String, Object> parameterMap = new HashMap<>();
        parameterMap.put("typeCode", typeCode);
        parameterMap.put("itemCode", itemCode);

        // 1.删除当前数据字典项的扩展属性列表
        dataDictMapper.removeDataDictItemAttributeListByItemCode(parameterMap);

        // 2.删除当前数据字典项
        sysDataDictItemMapper.deleteByPrimaryKey(itemCode, typeCode);

        // 3.更新Redis缓存
//        dataDictRedisDao.removeDataDictItem(typeCode, itemCode);
    }


    public List<SysDataDictItem> getSingleDataDictItemList(String typeCode, String enabledFlag) throws Exception {
        Map<String, Object> parameterMap = new HashMap<>();
        parameterMap.put("typeCode", typeCode);
        parameterMap.put("enabledFlag", enabledFlag);
        return dataDictMapper.getSingleDataDictItemList(parameterMap);
    }

}

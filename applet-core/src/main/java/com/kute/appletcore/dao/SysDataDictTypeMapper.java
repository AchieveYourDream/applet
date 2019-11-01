package com.kute.appletcore.dao;

import com.kute.appletcore.entity.SysDataDictType;
import java.util.List;

public interface SysDataDictTypeMapper {
    int deleteByPrimaryKey(String typeCode);

    int insert(SysDataDictType record);

    SysDataDictType selectByPrimaryKey(String typeCode);

    List<SysDataDictType> selectAll();

    int updateByPrimaryKey(SysDataDictType record);
}
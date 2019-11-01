package com.kute.appletcore.dao;

import com.kute.appletcore.entity.SysDataStructAttribute;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysDataStructAttributeMapper {
    int deleteByPrimaryKey(@Param("attributeCode") String attributeCode, @Param("structCode") String structCode);

    int insert(SysDataStructAttribute record);

    SysDataStructAttribute selectByPrimaryKey(@Param("attributeCode") String attributeCode, @Param("structCode") String structCode);

    List<SysDataStructAttribute> selectAll();

    int updateByPrimaryKey(SysDataStructAttribute record);
}
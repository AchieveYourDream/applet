package com.kute.appletcore.dao;

import com.kute.appletcore.entity.SysDataDictItem;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysDataDictItemMapper {
    int deleteByPrimaryKey(@Param("itemCode") String itemCode, @Param("typeCode") String typeCode);

    int insert(SysDataDictItem record);

    SysDataDictItem selectByPrimaryKey(@Param("itemCode") String itemCode, @Param("typeCode") String typeCode);

    List<SysDataDictItem> selectAll();

    int updateByPrimaryKey(SysDataDictItem record);
}
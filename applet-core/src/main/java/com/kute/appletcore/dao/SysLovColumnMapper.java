package com.kute.appletcore.dao;

import com.kute.appletcore.entity.SysLovColumn;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysLovColumnMapper {
    int deleteByPrimaryKey(@Param("lovCode") String lovCode, @Param("columnName") String columnName);

    int insert(SysLovColumn record);

    SysLovColumn selectByPrimaryKey(@Param("lovCode") String lovCode, @Param("columnName") String columnName);

    List<SysLovColumn> selectAll();

    int updateByPrimaryKey(SysLovColumn record);
}
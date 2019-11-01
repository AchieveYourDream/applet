package com.kute.appletcore.dao;

import com.kute.appletcore.entity.SysDataStructNode;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysDataStructNodeMapper {
    int deleteByPrimaryKey(@Param("nodeCode") String nodeCode, @Param("structCode") String structCode);

    int insert(SysDataStructNode record);

    SysDataStructNode selectByPrimaryKey(@Param("nodeCode") String nodeCode, @Param("structCode") String structCode);

    List<SysDataStructNode> selectAll();

    int updateByPrimaryKey(SysDataStructNode record);
}
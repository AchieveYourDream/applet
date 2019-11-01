package com.kute.appletcore.dao;

import com.kute.appletcore.entity.SysLog;
import java.util.List;

public interface SysLogMapper {
    int deleteByPrimaryKey(Integer logId);

    int insert(SysLog record);

    SysLog selectByPrimaryKey(Integer logId);

    List<SysLog> selectAll();

    int updateByPrimaryKey(SysLog record);
}
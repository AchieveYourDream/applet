package com.kute.appletcore.dao;

import com.kute.appletcore.entity.SysDataStructDefine;
import java.util.List;

public interface SysDataStructDefineMapper {
    int deleteByPrimaryKey(String structCode);

    int insert(SysDataStructDefine record);

    SysDataStructDefine selectByPrimaryKey(String structCode);

    List<SysDataStructDefine> selectAll();

    int updateByPrimaryKey(SysDataStructDefine record);
}
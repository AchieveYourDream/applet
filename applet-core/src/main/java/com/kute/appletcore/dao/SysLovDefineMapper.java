package com.kute.appletcore.dao;

import com.kute.appletcore.entity.SysLovDefine;
import java.util.List;

public interface SysLovDefineMapper {
    int deleteByPrimaryKey(String lovCode);

    int insert(SysLovDefine record);

    SysLovDefine selectByPrimaryKey(String lovCode);

    List<SysLovDefine> selectAll();

    int updateByPrimaryKey(SysLovDefine record);
}
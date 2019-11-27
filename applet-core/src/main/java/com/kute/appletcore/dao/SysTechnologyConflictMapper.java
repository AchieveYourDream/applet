package com.kute.appletcore.dao;

import com.kute.appletcore.entity.SysTechnologyConflict;
import java.util.List;

public interface SysTechnologyConflictMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysTechnologyConflict record);

    SysTechnologyConflict selectByPrimaryKey(Integer id);

    List<SysTechnologyConflict> selectAll();

    int updateByPrimaryKey(SysTechnologyConflict record);
}
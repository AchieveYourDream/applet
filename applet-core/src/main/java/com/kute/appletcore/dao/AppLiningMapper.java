package com.kute.appletcore.dao;

import com.kute.appletcore.entity.AppLining;
import java.util.List;

public interface AppLiningMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AppLining record);

    AppLining selectByPrimaryKey(Integer id);

    List<AppLining> selectAll();

    int updateByPrimaryKey(AppLining record);
}
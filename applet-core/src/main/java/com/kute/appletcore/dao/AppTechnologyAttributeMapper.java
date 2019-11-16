package com.kute.appletcore.dao;

import com.kute.appletcore.entity.AppTechnologyAttribute;
import java.util.List;

public interface AppTechnologyAttributeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AppTechnologyAttribute record);

    AppTechnologyAttribute selectByPrimaryKey(Integer id);

    List<AppTechnologyAttribute> selectAll();

    int updateByPrimaryKey(AppTechnologyAttribute record);
}
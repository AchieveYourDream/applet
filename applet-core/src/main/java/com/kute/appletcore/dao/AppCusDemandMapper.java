package com.kute.appletcore.dao;

import com.kute.appletcore.entity.AppCusDemand;
import java.util.List;

public interface AppCusDemandMapper {
    int deleteByPrimaryKey(String demandId);

    int insert(AppCusDemand record);

    AppCusDemand selectByPrimaryKey(String demandId);

    List<AppCusDemand> selectAll();

    int updateByPrimaryKey(AppCusDemand record);
}
package com.kute.appletcore.dao;

import com.kute.appletcore.entity.AppSize;
import java.util.List;

public interface AppSizeMapper {
    int deleteByPrimaryKey(Integer sizeId);

    int insert(AppSize record);

    AppSize selectByPrimaryKey(Integer sizeId);

    List<AppSize> selectAll();

    int updateByPrimaryKey(AppSize record);
}
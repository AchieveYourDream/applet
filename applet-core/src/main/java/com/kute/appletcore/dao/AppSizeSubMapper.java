package com.kute.appletcore.dao;

import com.kute.appletcore.entity.AppSizeSub;
import java.util.List;

public interface AppSizeSubMapper {
    int deleteByPrimaryKey(String id);

    int insert(AppSizeSub record);

    AppSizeSub selectByPrimaryKey(String id);

    List<AppSizeSub> selectAll();

    int updateByPrimaryKey(AppSizeSub record);
}
package com.kute.appletcore.dao;

import com.kute.appletcore.entity.AppMeasureOrder;
import java.util.List;

public interface AppMeasureOrderMapper {
    int deleteByPrimaryKey(Integer measureId);

    int insert(AppMeasureOrder record);

    AppMeasureOrder selectByPrimaryKey(Integer measureId);

    List<AppMeasureOrder> selectAll();

    int updateByPrimaryKey(AppMeasureOrder record);
}
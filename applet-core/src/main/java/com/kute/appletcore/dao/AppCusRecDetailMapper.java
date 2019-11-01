package com.kute.appletcore.dao;

import com.kute.appletcore.entity.AppCusRecDetail;
import java.util.List;

public interface AppCusRecDetailMapper {
    int deleteByPrimaryKey(String detailId);

    int insert(AppCusRecDetail record);

    AppCusRecDetail selectByPrimaryKey(String detailId);

    List<AppCusRecDetail> selectAll();

    int updateByPrimaryKey(AppCusRecDetail record);
}
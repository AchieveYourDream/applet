package com.kute.appletcore.dao;

import com.kute.appletcore.entity.AppStitchWork;
import java.util.List;

public interface AppStitchWorkMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AppStitchWork record);

    AppStitchWork selectByPrimaryKey(Integer id);

    List<AppStitchWork> selectAll();

    int updateByPrimaryKey(AppStitchWork record);
}
package com.kute.appletcore.dao;

import com.kute.appletcore.entity.AppStitchWorkPosition;
import java.util.List;

public interface AppStitchWorkPositionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AppStitchWorkPosition record);

    AppStitchWorkPosition selectByPrimaryKey(Integer id);

    List<AppStitchWorkPosition> selectAll();

    int updateByPrimaryKey(AppStitchWorkPosition record);
}
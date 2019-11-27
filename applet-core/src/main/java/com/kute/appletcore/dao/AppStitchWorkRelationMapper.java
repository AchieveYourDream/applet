package com.kute.appletcore.dao;

import com.kute.appletcore.entity.AppStitchWorkRelation;
import java.util.List;

public interface AppStitchWorkRelationMapper {
    int deleteByPrimaryKey(Integer stitchWorkId);

    int insert(AppStitchWorkRelation record);

    AppStitchWorkRelation selectByPrimaryKey(Integer stitchWorkId);

    List<AppStitchWorkRelation> selectAll();

    int updateByPrimaryKey(AppStitchWorkRelation record);
}
package com.kute.appletcore.dao;

import com.kute.appletcore.entity.AppTechnologyNode;
import java.util.List;

public interface AppTechnologyNodeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AppTechnologyNode record);

    AppTechnologyNode selectByPrimaryKey(String nodeCode);

    List<AppTechnologyNode> selectAll();

    int updateByPrimaryKey(AppTechnologyNode record);
}
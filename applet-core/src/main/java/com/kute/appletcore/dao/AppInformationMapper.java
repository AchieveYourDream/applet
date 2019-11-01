package com.kute.appletcore.dao;

import com.kute.appletcore.entity.AppInformation;
import java.util.List;

public interface AppInformationMapper {
    int deleteByPrimaryKey(Integer informationId);

    int insert(AppInformation record);

    AppInformation selectByPrimaryKey(Integer informationId);

    List<AppInformation> selectAll();

    int updateByPrimaryKey(AppInformation record);
}
package com.kute.appletcore.dao;

import com.kute.appletcore.entity.AppCusAddress;
import java.util.List;

public interface AppCusAddressMapper {
    int deleteByPrimaryKey(String id);

    int insert(AppCusAddress record);

    AppCusAddress selectByPrimaryKey(String id);

    List<AppCusAddress> selectAll();

    int updateByPrimaryKey(AppCusAddress record);
}
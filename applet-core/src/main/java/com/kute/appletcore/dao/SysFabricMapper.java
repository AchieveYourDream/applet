package com.kute.appletcore.dao;

import com.kute.appletcore.entity.SysFabric;
import java.util.List;

public interface SysFabricMapper {
    int deleteByPrimaryKey(String code);

    int insert(SysFabric record);

    SysFabric selectByPrimaryKey(String code);

    List<SysFabric> selectAll();

    int updateByPrimaryKey(SysFabric record);
}
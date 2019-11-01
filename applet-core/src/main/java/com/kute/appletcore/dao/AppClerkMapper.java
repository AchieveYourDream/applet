package com.kute.appletcore.dao;

import com.kute.appletcore.entity.AppClerk;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AppClerkMapper {
    int deleteByPrimaryKey(@Param("storeCode") String storeCode, @Param("clerkId") String clerkId);

    int insert(AppClerk record);

    AppClerk selectByPrimaryKey(@Param("storeCode") String storeCode, @Param("clerkId") String clerkId);

    List<AppClerk> selectAll();

    int updateByPrimaryKey(AppClerk record);
}
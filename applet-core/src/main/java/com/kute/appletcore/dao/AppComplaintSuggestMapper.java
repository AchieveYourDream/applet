package com.kute.appletcore.dao;

import com.kute.appletcore.entity.AppComplaintSuggest;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AppComplaintSuggestMapper {
    int deleteByPrimaryKey(@Param("id") String id, @Param("memberTel") String memberTel);

    int insert(AppComplaintSuggest record);

    AppComplaintSuggest selectByPrimaryKey(@Param("id") String id, @Param("memberTel") String memberTel);

    List<AppComplaintSuggest> selectAll();

    int updateByPrimaryKey(AppComplaintSuggest record);
}
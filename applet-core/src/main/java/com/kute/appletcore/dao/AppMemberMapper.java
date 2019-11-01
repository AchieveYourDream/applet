package com.kute.appletcore.dao;

import com.kute.appletcore.entity.AppMember;
import java.util.List;

public interface AppMemberMapper {
    int deleteByPrimaryKey(String memberTel);

    int insert(AppMember record);

    AppMember selectByPrimaryKey(String memberTel);

    List<AppMember> selectAll();

    int updateByPrimaryKey(AppMember record);
}
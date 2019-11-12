package com.kute.appletmanage.member.dao;


import com.kute.appletcore.entity.AppMember;

import java.util.List;

/**
 * @Name: 会员管理
 * @Description: 会员管理
 */
public interface MemberMangerMapper {

    /**
     * 获取会员列表
     */
    List<AppMember> getMemberList(String search) throws Exception;




}

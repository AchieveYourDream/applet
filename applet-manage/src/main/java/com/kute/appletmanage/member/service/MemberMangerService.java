package com.kute.appletmanage.member.service;

import com.github.pagehelper.PageInfo;
import com.kute.appletcore.entity.AppMember;

public interface MemberMangerService {
    /**
     * 获取会员列表
     */
    PageInfo<AppMember> getMemberList(Integer pageNum, Integer pageSize, String search) throws Exception;
    /**
     * 获取会员信息
     */
    AppMember getMemberInfoByMemberTel(String memberTel) throws Exception;
    /**
     * 新增会员
     */
    void addMember(AppMember appMember) throws Exception;
    /**
     * 编辑会员
     */
    void editMember(AppMember appMember) throws Exception;

    /**
     * 删除会员
     */
    void removeMember(String memberTel) throws Exception;

}

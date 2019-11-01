package com.kute.appletmanage.member.impl;


import com.kute.appletcore.dao.AppMemberMapper;
import com.kute.appletcore.entity.AppMember;
import com.kute.appletmanage.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class MemberServiceImpl implements MemberService {



    @Autowired
    AppMemberMapper appMemberMapper;


    /**
     * 根据某个会员手机号修改个人信息
     */
    public int updateByPrimaryKey(AppMember appMember) throws Exception{
        return appMemberMapper.updateByPrimaryKey( appMember);

    }


}

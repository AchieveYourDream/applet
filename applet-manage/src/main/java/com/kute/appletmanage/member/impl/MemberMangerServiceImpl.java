package com.kute.appletmanage.member.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kute.appletcore.dao.AppMemberMapper;
import com.kute.appletcore.entity.AppMember;
import com.kute.appletmanage.member.dao.MemberMangerMapper;
import com.kute.appletmanage.member.service.MemberMangerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Name: 会员管理
 * @Description: 会员管理
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class MemberMangerServiceImpl implements MemberMangerService {

    @Autowired
    private MemberMangerMapper memberMangerMapper;

    @Autowired
    private AppMemberMapper appMemberMapper;


    /**
     * 获取会员列表
     */
    public PageInfo<AppMember> getMemberList(Integer pageNum, Integer pageSize, String search) throws Exception {
        PageHelper.startPage(pageNum, pageSize, true, false);
        List<AppMember> list = memberMangerMapper.getMemberList(search);
        return new PageInfo<>(list);
    }


    /**
     * 获取会员信息
     *
     */
    public AppMember getMemberInfoByMemberTel(String memberTel) throws Exception {
        return appMemberMapper.selectByPrimaryKey(memberTel);
    }

    /**
     * 新增会员
     */
    
    public void addMember(AppMember appMember) throws Exception {
        appMember.setMemberSource("pc");
        appMemberMapper.insert(appMember);
    }

    /**
     * 编辑会员
     */
    
    public void editMember(AppMember appMember) throws Exception {
        appMemberMapper.updateByPrimaryKey(appMember);
    }


    /**
     * 删除会员
     */
    
    public void removeMember(String memberTel) throws Exception {
        appMemberMapper.deleteByPrimaryKey(memberTel);    //删除会员

    }

}

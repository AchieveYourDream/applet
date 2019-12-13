package com.kute.appletweb.member.service;

import com.kute.appletcore.entity.AppCusAddress;
import com.kute.appletcore.vo.ResponseResult;

import java.util.List;

public interface MemberWebService {
    /**
     * 登录
     */
    public ResponseResult login(String  username,String verificationCode,String code) throws Exception;

    /**
     * 获取验证码
     *
     * @param username
     */
    public ResponseResult getVerificationCode(String username) throws Exception;

    /**
     * 获取会员收货地址列表
     *
     * @param member_id 会员手机号
     * @return
     */
    public List<AppCusAddress> selectCusAddressList(String member_id) throws Exception;

    /**
     * 插入收获地址
     */
    public int insetMemberAddress(AppCusAddress address) throws Exception;


    /**
     * 修改收货地址
     */
    public int updateMemberAddress(AppCusAddress address) throws Exception;


    /**
     * 删除收获地址
     */
    public int deleteMemberAddress(String id) throws Exception;


    /**
     * 修改默认地址
     * member_id 用户ID
     * id 需要默认收货地址
     */
    public void updateAddressDefault(String member_id, String id) throws Exception;
}

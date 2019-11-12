package com.kute.appletweb.member.dao;

import com.kute.appletcore.entity.AppCusAddress;

import java.util.List;

public interface MemberWebMapper {

    //获取会员收货地址列表
    List<AppCusAddress> selectCusAddressList(String member_id);
    //将原来的默认收货地址设置为非默认-
    void updateAddressDefault(String member_id);
    //设置默认收货地址
    void setAddressDefault(String id);

}

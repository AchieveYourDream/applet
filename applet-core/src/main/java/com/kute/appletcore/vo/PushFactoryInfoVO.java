package com.kute.appletcore.vo;

import com.kute.appletcore.entity.OrderInfo;

/**
 * @ClaseName
 * @Auther 王斌
 * @Date
 **/
public class PushFactoryInfoVO extends OrderInfo {

    public String member_name;

    public String create_date;

    public String getCreate_date() {
        return create_date;
    }

    public void setCreate_date(String create_date) {
        this.create_date = create_date;
    }

    public String getMember_name() {
        return member_name;
    }

    public void setMember_name(String member_name) {
        this.member_name = member_name;
    }
}

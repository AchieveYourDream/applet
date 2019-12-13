package com.kute.appletcore.vo;

import com.kute.appletcore.entity.OrderHead;

import java.util.List;

/**
 * @ClaseName
 * @Auther 王斌
 * @Date
 **/
public class OrderHeadVO extends OrderHead {
    private List<OrderInfoVO> infolist;

    public List<OrderInfoVO> getInfolist() {
        return infolist;
    }

    public void setInfolist(List<OrderInfoVO> infolist) {
        this.infolist = infolist;
    }
}

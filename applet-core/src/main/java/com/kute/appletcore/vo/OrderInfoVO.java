package com.kute.appletcore.vo;

import com.kute.appletcore.entity.OrderInfo;

import java.util.List;

/**
 * @ClaseName
 * @Auther 王斌
 * @Date
 **/
public class OrderInfoVO extends OrderInfo {

    private List<OrderLine> Linelist;

    public List<OrderLine> getLinelist() {
        return Linelist;
    }

    public void setLinelist(List<OrderLine> linelist) {
        Linelist = linelist;
    }
}

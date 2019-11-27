package com.kute.appletcore.vo;

import com.kute.appletcore.entity.OrderHead;

import java.util.List;

/**
 * @ClaseName
 * @Auther 王斌
 * @Date
 **/
public class OrderHeadVO extends OrderHead {

    private List<OrderLine> Linelist;

    public List<OrderLine> getLinelist() {
        return Linelist;
    }

    public void setLinelist(List<OrderLine> linelist) {
        Linelist = linelist;
    }
}

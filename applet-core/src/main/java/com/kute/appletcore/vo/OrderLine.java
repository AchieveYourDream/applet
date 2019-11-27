package com.kute.appletcore.vo;

import com.kute.appletcore.entity.OrderDetails;
import com.kute.appletcore.entity.OrderStitchWork;
import com.kute.appletcore.entity.OrderTechnology;

import java.util.List;

public class OrderLine  extends OrderDetails {


    /**
    * @Description: 订单工艺列表
    * @Author: 王斌
    * @Date: 2019/11/23
    */
    List<OrderTechnology>  technologyList;
    /**
     * @Description: 订单刺绣列表
     * @Author: 王斌
     * @Date: 2019/11/23
     */
    List<OrderStitchWork>  stitchWorkList;

    public List<OrderTechnology> getTechnologyList() {
        return technologyList;
    }

    public void setTechnologyList(List<OrderTechnology> technologyList) {
        this.technologyList = technologyList;
    }

    public List<OrderStitchWork> getStitchWorkList() {
        return stitchWorkList;
    }

    public void setStitchWorkList(List<OrderStitchWork> stitchWorkList) {
        this.stitchWorkList = stitchWorkList;
    }
}
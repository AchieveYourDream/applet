package com.kute.appletmanage.order.service;

import com.github.pagehelper.PageInfo;
import com.kute.appletcore.vo.OrderDetailsVO;
import com.kute.appletcore.vo.ResponseResult;

public interface OrderMangerService {
    /**
     * 获取订单列表
     */
    PageInfo<OrderDetailsVO> getOrderList(Integer pageNum, Integer pageOrder, String search) throws Exception;
    /**
     * 获取订单工艺和刺绣
     */
     ResponseResult getOrderTechnologyAndStitchWork(Integer detailId) throws Exception ;
}

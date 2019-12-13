package com.kute.appletmanage.order.dao;


import com.kute.appletcore.entity.OrderDetails;
import com.kute.appletcore.entity.OrderStitchWork;
import com.kute.appletcore.entity.OrderTechnology;
import com.kute.appletcore.vo.OrderDetailsVO;

import java.util.List;

/**
 * @Name: 订单管理
 * @Description: 订单管理
 */
public interface OrderMangerMapper {

    /**
     * 获取订单列表
     */
    List<OrderDetailsVO> getOrderList(String search) throws Exception;
    /**
     * 获取订单详情列表
     */
    List<OrderDetails> getOrderDetailsList(String infoId) throws Exception;
    /**
     * 根据订单ID获取订单工艺
     */
    List<OrderTechnology> getOrderTechnologyListById(Integer detailId) throws Exception;
    /**
     * 根据订单ID获取订单刺绣
     */
    List<OrderStitchWork> getOrderStitchWorkListById(Integer detailId) throws Exception;




}

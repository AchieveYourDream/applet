package com.kute.appletmanage.order.controller;

import com.github.pagehelper.PageInfo;
import com.kute.appletcore.vo.OrderDetailsVO;
import com.kute.appletcore.vo.ResponseResult;
import com.kute.appletmanage.order.service.OrderMangerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Name: 订单管理
 * @Description: 订单管理
 */
@RestController
@RequestMapping("/app/system/order/")
@Api(value = "OrderMangerController", tags = " 系统模块-订单管理")
public class OrderMangerController {

    @Autowired
    private OrderMangerService orderMangerService;

    /**
     * 获取订单列表
     */
    @ApiOperation(value = "获取订单列表")
    @RequestMapping(value = "getOrderList", method = RequestMethod.GET)
    public Map getOrderList(Integer pageNum, Integer pageOrder, String search) throws Exception {
        Map dataMap = new HashMap();
        PageInfo<OrderDetailsVO> list =  orderMangerService.getOrderList( pageNum,  pageOrder,  search);

        dataMap.put("total", list.getTotal());
        dataMap.put("rows", list.getList());

        return dataMap;
    }
    /**
     * 获取订单工艺和刺绣
     */
    @ApiOperation(value = "获取订单工艺和刺绣")
    @RequestMapping(value = "getOrderTechnologyAndStitchWork", method = RequestMethod.GET)
    public ResponseResult getOrderTechnologyAndStitchWork(Integer detailId) throws Exception {
      return  orderMangerService.getOrderTechnologyAndStitchWork(detailId);

    }



}

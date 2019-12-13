package com.kute.appletmanage.order.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kute.appletcore.entity.OrderDetails;
import com.kute.appletcore.vo.OrderDetailsVO;
import com.kute.appletcore.vo.ResponseResult;
import com.kute.appletmanage.order.dao.OrderMangerMapper;
import com.kute.appletmanage.order.service.OrderMangerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Name: 订单管理
 * @Description: 订单管理
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class OrderMangerServiceImpl implements OrderMangerService {

    @Autowired
    private OrderMangerMapper orderMangerMapper;


    /**
     * 获取订单列表
     */
    public PageInfo<OrderDetailsVO> getOrderList(Integer pageNum, Integer pageOrder, String search) throws Exception {
        PageHelper.startPage(pageNum, pageOrder, true, false);
        List<OrderDetailsVO> list = orderMangerMapper.getOrderList(search);
        return new PageInfo<>(list);
    }


    /**
     * 获取订单详情列表
     */
   public  List<OrderDetails> getOrderDetailsList(String infoId) throws Exception{
      return orderMangerMapper.getOrderDetailsList(infoId);
    }
    /**
     * 获取订单工艺和刺绣
     */
    public ResponseResult getOrderTechnologyAndStitchWork(Integer detailId) throws Exception {
        Map<String,Object> map=new HashMap();
        map.put("Technology",orderMangerMapper.getOrderTechnologyListById(detailId));
        map.put("StitchWork",orderMangerMapper.getOrderStitchWorkListById(detailId));
        return new ResponseResult("S","",map);
    }






}

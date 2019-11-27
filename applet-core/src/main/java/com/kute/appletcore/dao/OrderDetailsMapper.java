package com.kute.appletcore.dao;

import com.kute.appletcore.entity.OrderDetails;
import java.util.List;

public interface OrderDetailsMapper {
    int deleteByPrimaryKey(Integer lineId);

    int insert(OrderDetails record);

    OrderDetails selectByPrimaryKey(Integer lineId);

    List<OrderDetails> selectAll();

    int updateByPrimaryKey(OrderDetails record);
}
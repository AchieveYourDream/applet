package com.kute.appletcore.dao;

import com.kute.appletcore.entity.OrderStitchWork;
import java.util.List;

public interface OrderStitchWorkMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OrderStitchWork record);

    OrderStitchWork selectByPrimaryKey(Integer id);

    List<OrderStitchWork> selectAll();

    int updateByPrimaryKey(OrderStitchWork record);
}
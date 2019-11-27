package com.kute.appletcore.dao;

import com.kute.appletcore.entity.OrderHead;
import java.util.List;

public interface OrderHeadMapper {
    int deleteByPrimaryKey(Integer headId);

    int insert(OrderHead record);

    OrderHead selectByPrimaryKey(Integer headId);

    List<OrderHead> selectAll();

    int updateByPrimaryKey(OrderHead record);
}
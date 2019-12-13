package com.kute.appletcore.dao;

import com.kute.appletcore.entity.OrderInfo;
import java.util.List;

public interface OrderInfoMapper {
    int deleteByPrimaryKey(Integer infoId);

    int insert(OrderInfo record);

    OrderInfo selectByPrimaryKey(Integer infoId);

    List<OrderInfo> selectAll();

    int updateByPrimaryKey(OrderInfo record);
}
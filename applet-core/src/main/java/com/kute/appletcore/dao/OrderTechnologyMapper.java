package com.kute.appletcore.dao;

import com.kute.appletcore.entity.OrderTechnology;
import java.util.List;

public interface OrderTechnologyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OrderTechnology record);

    OrderTechnology selectByPrimaryKey(Integer id);

    List<OrderTechnology> selectAll();

    int updateByPrimaryKey(OrderTechnology record);
}
package com.kute.appletcore.dao;

import com.kute.appletcore.entity.AppGoods;
import java.util.List;

public interface AppGoodsMapper {
    int deleteByPrimaryKey(Integer goodsId);

    int insert(AppGoods record);

    AppGoods selectByPrimaryKey(String goodsId);

    List<AppGoods> selectAll();

    int updateByPrimaryKey(AppGoods record);
}
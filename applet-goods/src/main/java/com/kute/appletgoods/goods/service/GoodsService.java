package com.kute.appletgoods.goods.service;

import com.kute.appletcore.vo.ResponseResult;

import java.util.List;
import java.util.Map;

public interface GoodsService {
    /**
     * 获取小程序商品列表 根据品类
     * @return
     */
    ResponseResult selectAppGoodsListByCategory(String category,String subStyle,String flag) throws Exception;
    /**
     * 获取商品主品类下拉选
     *
     * @throws Exception
     */
    ResponseResult getMainSelectInfo() throws Exception;
    /**
     *  获取首页APP显示品类及数量
     *
     */
    ResponseResult getAppMainShowTypeAndNum();
    /**
     * 根据商品id获取商品详情
     *
     * @throws Exception
     */
    ResponseResult selectByPrimaryKey(String goods_id) throws Exception;

    /**
     * 获取商品菜单树
     */
    List<Map> getGoodsNodeTree() throws Exception ;
}

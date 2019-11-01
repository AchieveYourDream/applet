package com.kute.appletmanage.goods.service;

import com.kute.appletcore.vo.ResponseResult;

public interface GoodsService {
    /**
     * 获取小程序商品列表 根据服装风格
     * @return
     */
    ResponseResult selectAppGoodsListByStyle(String style_type) throws Exception;
    /**
     * 获取商品主品类下拉选
     *
     * @throws Exception
     */
    ResponseResult getMainSelectInfo() throws Exception;
    /**
     * 获取小程序商品列表 根据服装大类
     * @return
     */
    ResponseResult selectAppGoodsListByMenu(String main_style,String sub_style) throws Exception;
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
}

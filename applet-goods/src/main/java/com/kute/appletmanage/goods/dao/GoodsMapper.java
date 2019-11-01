package com.kute.appletmanage.goods.dao;

import com.kute.appletcore.entity.AppGoods;
import com.kute.appletcore.entity.SysParameterDefine;
import com.kute.appletcore.vo.GoodsMenu;

import java.util.List;
import java.util.Map;

public interface GoodsMapper {
    /**
     * 获取小程序商品列表 根据服装风格
     * @param appid
     * @return
     */
    List<AppGoods> selectAppGoodsListByStyle(String style_type);

    /**
     * 获取小程序商品列表数量
     */
    int  selectAppGoodsListNum();


    /**
     *  修改商品头像
     *
     * @throws Exception
     */
    public int updateGoodsImage(Map map);


    /**
     * 获取商品主品类下拉选 -
     *
     * @throws Exception
     */
    public List<GoodsMenu> getMainSelectInfo();

    /**
     * 获取商品子品类下拉选
     *
     * @throws Exception
     */
    public List<GoodsMenu> getSubSelectInfo(String node_code);

    /**
     *   获取小程序商品列表 根据服装大类
     *
     */
    List<AppGoods> selectAppGoodsListByMenu(Map map);
    /**
     *  获取首页APP显示品类及数量-
     *
     */
    List<SysParameterDefine> getAppMainShowTypeAndNum();

    /**
     *  获取小程序前台展示商品数据
     *
     */
    List<AppGoods> selectAppMainShowGoods(Map map);
    

}

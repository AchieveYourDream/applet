package com.kute.appletmanage.goods.dao;

import com.kute.appletcore.entity.AppGoods;
import com.kute.appletcore.vo.SelectVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface GoodsManageMapper {


    /**
     * 获取商品主品类下拉选 -
     *
     * @throws Exception
     */
    List<SelectVO> getMainSelectInfo();

    /**
     * 获取商品子品类下拉选 -
     *
     * @throws Exception
     */
    List<SelectVO> getSubSelectInfo(String nodeCode);


    /**
     * 获取小程序商品列表 -
     *
     * @throws Exception
     */
    List<AppGoods> selectAppGoodsList(String search);


    /**
     * 删除商品
     *
     * @throws Exception
     */
    int deleteGoodsById(String goodsId);
    /**
     * 删除商品
     *
     * @throws Exception
     */
    AppGoods selectAppGoodsById(String goodsId);

    /**
     * - 上架下架商品
     *
     * @throws Exception
     */
    int updateGoodsStatus(@Param("goodsId") String goodsId,@Param("upOffShelf") String upOffShelf);
    /**
     * - 获取面料根据大类
     */
    List<Map> getFabricByCategory(@Param("category")String category,@Param("search")String search);


}
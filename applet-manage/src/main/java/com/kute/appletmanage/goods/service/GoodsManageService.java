package com.kute.appletmanage.goods.service;


import com.github.pagehelper.PageInfo;
import com.kute.appletcore.entity.AppGoods;
import com.kute.appletcore.vo.SelectVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface GoodsManageService {


    /**
     * 获取商品主品类下拉选 -
     *
     * @throws Exception
     */
    List<SelectVO> getMainSelectInfo() throws Exception;

    /**
     * 获取商品子品类下拉选 -
     *
     * @throws Exception
     */
    List<SelectVO> getSubSelectInfo(String node_code) throws Exception;


    /**
     * 获取小程序商品列表 -
     *
     * @throws Exception
     */
    PageInfo<AppGoods> selectAppGoodsList(Integer currentPage, Integer pageSize, String search) throws Exception;

    /**
     * 新增小程序商品
     *
     * @param obj
     * @return
     * @throws Exception
     */
    int insertAppGoods(AppGoods obj) throws Exception;

    /**
     * 修改小程序商品
     *
     * @param obj
     * @return
     * @throws Exception
     */
    int updateAppGoods(AppGoods obj) throws Exception;

    /**
     * 删除商品
     *
     * @throws Exception
     */
    int deleteGoodsById(String goods_id) throws Exception;

    /**
     * 上架下架商品
     *
     * @throws Exception
     */
    int updateGoodsStatus(@Param("goodsId")String goodsId, @Param("upOffShelf")String upOffShelf) throws Exception;

    /**
     * 根据商品ID获取商品详情
     *
     * @throws Exception
     */
    AppGoods selectAppGoodsByPk(String goods_id) throws Exception;

    /**
     * - 获取面料根据大类
     */
    List<Map> getFabricByCategory(@Param("category")String category, @Param("search")String search);

}

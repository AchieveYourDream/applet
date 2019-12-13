package com.kute.appletgoods.goods.dao;

import com.kute.appletcore.entity.AppGoods;
import com.kute.appletcore.entity.SysParameterDefine;
import com.kute.appletcore.util.tree.TreeNodeVO;
import com.kute.appletcore.vo.GoodsMenu;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

 public interface GoodsMapper {
    /**
     * 获取小程序商品列表 根据品类
     * @param appid
     * @return
     */
    List<AppGoods> selectAppGoodsListByCategory(@Param("category") String category ,@Param("subStyle")  String subStyle,@Param("flag") String flag);


    /**
     * 获取商品主品类下拉选 -
     *
     * @throws Exception
     */
     List<GoodsMenu> getMainSelectInfo();


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


     /**
      * 获取商品菜单树
      */
     List<TreeNodeVO> getGoodsNodeTree() throws Exception;
    

}

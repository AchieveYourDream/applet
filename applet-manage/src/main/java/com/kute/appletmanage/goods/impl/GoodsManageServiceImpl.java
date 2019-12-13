package com.kute.appletmanage.goods.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kute.appletcore.dao.AppGoodsMapper;
import com.kute.appletcore.entity.AppGoods;
import com.kute.appletcore.vo.SelectVO;
import com.kute.appletmanage.goods.dao.GoodsManageMapper;
import com.kute.appletmanage.goods.service.GoodsManageService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
@Transactional(rollbackFor = Exception.class)
public class GoodsManageServiceImpl implements GoodsManageService {

    @Resource
    private AppGoodsMapper appGoodsMapper;

    @Resource
    private GoodsManageMapper goodsManageMapper;


    /**
     * 获取商品主品类下拉选 -
     *
     * @
     */
    public List<SelectVO> getMainSelectInfo() {
        return goodsManageMapper.getMainSelectInfo();
    }

    /**
     * 获取商品子品类下拉选 -
     *
     * @
     */
    public List<SelectVO> getSubSelectInfo(String node_code) {
        return goodsManageMapper.getSubSelectInfo(node_code);
    }

    /**
     * 获取小程序商品列表 -
     *
     * @
     */
    public PageInfo<AppGoods> selectAppGoodsList(Integer pageNum, Integer pageSize, String search) {
        PageHelper.startPage(pageNum, pageSize, true, false);
        List<AppGoods> list = goodsManageMapper.selectAppGoodsList(search);
        return new PageInfo<>(list);
    }

    /**
     * 新增小程序商品
     *
     * @param obj
     * @return
     * @
     */
    public int insertAppGoods(AppGoods obj) {
        return appGoodsMapper.insert(obj);
    }

    /**
     * 修改小程序商品
     *
     * @param obj
     * @return
     * @
     */
    public int updateAppGoods(AppGoods obj) {
        return appGoodsMapper.updateByPrimaryKey(obj);
    }


    /**
     * 删除商品
     *
     * @
     */
    public int deleteGoodsById(String goodsId) {
        return goodsManageMapper.deleteGoodsById(goodsId);
    }

    /**
     * 上架下架商品
     *
     * @
     */
    public int updateGoodsStatus(String goodsId, String upOffShelf) {
        return goodsManageMapper.updateGoodsStatus(goodsId, upOffShelf);
    }

    /**
     * 根据商品ID获取商品详情
     *
     * @
     */
    public AppGoods selectAppGoodsByPk(String goodsId) {
        return goodsManageMapper.selectAppGoodsById(goodsId);
    }


    /**
     * - 获取面料根据大类
     */
    public List<Map> getFabricByCategory(String category,String search){
        return  goodsManageMapper.getFabricByCategory(category,search);
    }
}


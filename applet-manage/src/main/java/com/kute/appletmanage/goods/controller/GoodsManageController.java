package com.kute.appletmanage.goods.controller;


import com.github.pagehelper.PageInfo;
import com.kute.appletcore.entity.AppGoods;
import com.kute.appletcore.vo.ResponseResult;
import com.kute.appletmanage.goods.service.GoodsManageService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/app/appGoods/")
public class GoodsManageController {


    @Resource
    private GoodsManageService goodsManageService;

    /**
     * 获取商品主品类下拉选
     */
    @RequestMapping(value = "getMainSelectInfo", method = RequestMethod.POST)
    public ResponseResult getMainSelectInfo() throws Exception {
        return new ResponseResult("S", "", goodsManageService.getMainSelectInfo());


    }

    /**
     * 获取商品子品类下拉选
     */
    @RequestMapping(value = "getSubSelectInfo", method = RequestMethod.POST)
    public ResponseResult getSubSelectInfo(String node_code) throws Exception {
        return new ResponseResult("S", "", goodsManageService.getSubSelectInfo(node_code));


    }

    /**
     * 获取小程序商品列表
     */
    @GetMapping(value = "selectAppGoodsList")
    public Map selectAppGoodsList(Integer pageNum, Integer pageSize, String search) throws Exception {
        Map dataMap = new HashMap();
        PageInfo<AppGoods> list = goodsManageService.selectAppGoodsList(pageNum, pageSize, search);
        dataMap.put("total", list.getTotal());
        dataMap.put("rows", list.getList());
        return dataMap;

    }

    /**
     * 插入小程序商品
     */
    @RequestMapping(value = "insertAppGoods", method = RequestMethod.POST)
    public ResponseResult insertAppGoods(AppGoods ag) throws Exception {
        goodsManageService.insertAppGoods(ag);
        return new ResponseResult("S", "保存成功");

    }

    /**
     * 修改小程序商品
     */
    @RequestMapping(value = "updateAppGoods", method = RequestMethod.POST)
    public ResponseResult updateAppGoods(AppGoods ag) throws Exception {
            goodsManageService.updateAppGoods(ag);
            return new ResponseResult("S", "保存成功");

    }

    /**
     * 删除商品
     */
    @RequestMapping(value = "deleteGoodsById", method = RequestMethod.POST)
    public ResponseResult deleteGoodsById(String goodsId) throws Exception {
            goodsManageService.deleteGoodsById(goodsId);
            return new ResponseResult("S", "删除成功");
    }

    /**
     * 上架下架商品
     */
    @RequestMapping(value = "updateGoodsStatus", method = RequestMethod.POST)
    public ResponseResult updateGoodsStatus(@RequestParam("goodsId") String goodsId, @RequestParam("upOffShelf") String upOffShelf) throws Exception {
            goodsManageService.updateGoodsStatus(goodsId, upOffShelf);
            return new ResponseResult("S", "保存成功");
    }

    /**
     * 根据商品ID获取商品详情
     */
    @RequestMapping(value = "selectAppGoodsByPk", method = RequestMethod.POST)
    public ResponseResult selectAppGoodsByPk(@RequestParam("goodsId") String goodsId) throws Exception {
            AppGoods ag = goodsManageService.selectAppGoodsByPk(goodsId);
            return new ResponseResult("S", "保存成功",ag);
    }
}

package com.kute.appletmanage.goods.controller;

import com.kute.appletcore.vo.ResponseResult;
import com.kute.appletmanage.goods.service.GoodsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@SuppressWarnings("all")
@Api(value = "AppGoodsController", tags = "小程序")
@RequestMapping(value = "/appGoods")
public class GoodsController {


    @Autowired
    private GoodsService goodsService;

    //图片存放地址
    @Value("${applet.imgSavePath}")
    private String imgSavePath;



    @GetMapping(value = "/selectAppGoodsListByStyle")
    @ApiOperation(value = "获取小程序商品列表 根据服装风格")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "style_type", value = "风格", paramType = "query", dataType = "String", required = true),

    })
    public ResponseResult selectAppGoodsList(@Param("style_type") String  style_type) throws Exception {
        ResponseResult result = null;
        result  = goodsService.selectAppGoodsListByStyle(style_type );
        return result;
    }


    @PostMapping("getMainSelectInfo")
    @ApiOperation(value = "获取商品主品类菜单树")
    public @ResponseBody ResponseResult getMainSelectInfo() throws Exception {
        ResponseResult result = null;
        result  = goodsService.getMainSelectInfo();
        return result;
    }

    @GetMapping(value = "/selectAppGoodsListByMenu")
    @ApiOperation(value = "获取小程序商品列表 根据服装大类")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "main_style", value = "主菜单", paramType = "query", dataType = "String", required = true),
            @ApiImplicitParam(name = "sub_style", value = "子菜单", paramType = "query", dataType = "String", required = false),

    })
    public ResponseResult selectAppGoodsListByMenu(@Param("main_style") String  main_style, @Param("sub_style") String  sub_style) throws Exception {
        ResponseResult result = null;
        result  = goodsService.selectAppGoodsListByMenu(main_style,sub_style );
        return result;
    }


    @GetMapping(value = "/getAppMainShowTypeAndNum")
    @ApiOperation(value = "获取首页APP显示品类及数量")
    public ResponseResult getAppMainShowTypeAndNum() throws Exception {
        ResponseResult result = null;
        result  = goodsService.getAppMainShowTypeAndNum();
        return result;
    }
    @GetMapping(value = "/selectByPrimaryKey")
    @ApiOperation(value = "根据商品id获取商品详情")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "goods_id", value = "商品id", paramType = "query", dataType = "String", required = true),

    })
    public ResponseResult selectByPrimaryKey(@Param("goods_id") String  goods_id) throws Exception {
        ResponseResult result = null;
        result  = goodsService.selectByPrimaryKey(goods_id);
        return result;
    }

}

package com.kute.appletgoods.goods.controller;

import com.kute.appletcore.enumeration.EnumResultType;
import com.kute.appletcore.vo.ResponseResult;
import com.kute.appletgoods.goods.service.GoodsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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



    @GetMapping(value = "/selectAppGoodsListByCategory")
    @ApiOperation(value = "获取小程序商品列表 根据品类")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "category", value = "品类", paramType = "query", dataType = "String", required = true),
            @ApiImplicitParam(name = "subStyle", value = "详细分类", paramType = "query", dataType = "String", required = false),
            @ApiImplicitParam(name = "flag", value = "是否可定制", paramType = "query", dataType = "String", required = false),

    })
    public ResponseResult selectAppGoodsListByCategory(@RequestParam String  category, String  subStyle,@RequestParam String flag) throws Exception {
        ResponseResult result = null;
        result  = goodsService.selectAppGoodsListByCategory(category ,subStyle,flag);
        return result;
    }

//
//    @PostMapping("getMainSelectInfo")
//    @ApiOperation(value = "获取商品主品类菜单树")
//    public @ResponseBody ResponseResult getMainSelectInfo() throws Exception {
//        ResponseResult result = null;
//        result  = goodsService.getMainSelectInfo();
//        return result;
//    }


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


    /**
     *获取商品菜单树
     */
    @ApiOperation(value = "获取商品菜单树")
    @RequestMapping(value = "getGoodsNodeTree", method = RequestMethod.GET)
    public ResponseResult getTechnologyNodeTree() throws Exception {
        List<Map> list = goodsService.getGoodsNodeTree();

        ResponseResult result = new ResponseResult();
        result.setCode(EnumResultType.SUCCESS.toString());
        result.setData(list);

        return result;
    }

}

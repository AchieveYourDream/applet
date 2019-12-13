package com.kute.appletweb.order.controller;


import com.github.pagehelper.PageInfo;
import com.kute.appletcore.entity.SysFabric;
import com.kute.appletcore.vo.OrderHeadVO;
import com.kute.appletcore.vo.OrderListVO;
import com.kute.appletcore.vo.ResponseResult;
import com.kute.appletweb.order.service.OrderWebService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@SuppressWarnings("all")
@Api(value = "OrderWebController", tags = "订单模块")
@RequestMapping(value = "/api/")
public class OrderWebController {

    @Autowired
    private OrderWebService orderWebService;

    /**
     * 根据大类获取面料信息
     */
    @ApiOperation(value = "根据商品获取面料信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "goodsId", value = "商品ID", paramType = "query", required = true),
            @ApiImplicitParam(name = "Authorization", value = "令牌", paramType = "header", dataType = "String", required = true),
    })
    @RequestMapping(value = "selectFabricListByCategory", method = RequestMethod.GET)
    public List<SysFabric> selectFabricListByCategory( String goodsId) throws Exception {
        return orderWebService.selectFabricListByCategory(goodsId);

    }


    /**
     * 根据大类获取大类尺码
     */
    @ApiOperation(value = "根据大类获取大类尺码")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "category", value = "品类", paramType = "query", required = true),
            @ApiImplicitParam(name = "Authorization", value = "令牌", paramType = "header", dataType = "String", required = true),
    })
    @RequestMapping(value = "selectSizeListByCategory", method = RequestMethod.GET)
    public List<Map<String, Object>> selectSizeListByCategory(String category) throws Exception {
        return orderWebService.selectSizeListByCategory(category);

    }

    /**
     * 根据大类获取工艺节点尺码
     */
    @ApiOperation(value = "根据大类获取工艺节点尺码")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "category", value = "品类", paramType = "query", required = true),
            @ApiImplicitParam(name = "Authorization", value = "令牌", paramType = "header", dataType = "String", required = true),
    })
    @RequestMapping(value = "selectTechnologyTreeListByCategory", method = RequestMethod.GET)
    public List<Map<String, Object>> selectTechnologyTreeListByCategory(String category) throws Exception {
        return orderWebService.selectTechnologyTreeListByCategory(category);

    }


    /**
     * 验证工艺是否有冲突
     */
    @ApiOperation(value = "验证工艺是否有冲突")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "technologyCode", value = "工艺编码", paramType = "query", required = true),
            @ApiImplicitParam(name = "technologyList", value = "选中的工艺集合", paramType = "query", required = true),
            @ApiImplicitParam(name = "Authorization", value = "令牌", paramType = "header", dataType = "String", required = true),
    })
    @RequestMapping(value = "checkTechnologyConflict", method = RequestMethod.POST)
    public ResponseResult checkTechnologyConflict(@RequestParam String technologyCode ,@RequestParam String technologyList) throws Exception {
        return orderWebService.checkTechnologyConflict(technologyCode,technologyList);

    }


    /**
     * 根据大类获取刺绣位置
     */
    @ApiOperation(value = "根据大类获取刺绣位置")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "category", value = "品类", paramType = "query", required = true),
            @ApiImplicitParam(name = "Authorization", value = "令牌", paramType = "header", dataType = "String", required = true),
    })
    @RequestMapping(value = "selectStitchWorkPositionByCategory", method = RequestMethod.GET)
    public List<Map<String, Object>> selectStitchWorkPositionByCategory( String category) throws Exception {
        return orderWebService.selectStitchWorkPositionByCategory( category);

    }

//    /**
//     * 根据刺绣位置 获取刺绣图案
//     */
//    @ApiOperation(value = "根据刺绣位置 获取刺绣图案")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "pageNum", value = "当前页", paramType = "query", required = true),
//            @ApiImplicitParam(name = "pageSize", value = "每页条数", paramType = "query", required = true),
//            @ApiImplicitParam(name = "positionId", value = "位置id", paramType = "query", required = true),
//            @ApiImplicitParam(name = "Authorization", value = "令牌", paramType = "header", dataType = "String", required = true),
//    })
//    @RequestMapping(value = "selectStitchWorkByPositionId", method = RequestMethod.GET)
//    public PageInfo<AppStitchWork> selectStitchWorkByPositionId(Integer pageNum, Integer pageSize, Integer positionId) throws Exception {
//        return orderWebService.selectStitchWorkByPositionId(pageNum, pageSize, positionId);
//
//    }


    /**
     * 插入订单
     */
    @ApiOperation(value = "插入订单")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "oh", value = "订单信息", paramType = "body", dataType = "OrderHeadVO",  required = true),
            @ApiImplicitParam(name = "Authorization", value = "令牌", paramType = "header", dataType = "String", required = true),
    })
    @PostMapping(value = "insertOrder")
    public ResponseResult insertOrder(@RequestBody OrderHeadVO oh ) throws Exception {
        return orderWebService.insertOrder(oh);

    }



    /**
     * 获取订单列表
     */
    @ApiOperation(value = "获取订单列表")
    @RequestMapping(value = "getOrderListByMemberTel", method = RequestMethod.GET)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "memberTel", value = "客户手机号", paramType = "query", dataType = "String",  required = true),
            @ApiImplicitParam(name = "orderState", value = "支付状态", paramType = "query", dataType = "String",  required = false),
            @ApiImplicitParam(name = "Authorization", value = "令牌", paramType = "header", dataType = "String", required = true),
    })
    public ResponseResult getOrderListByMemberTel(Integer pageNum, Integer pageOrder, @RequestParam String memberTel,String orderState) throws Exception {
        PageInfo<OrderListVO> list =  orderWebService.getOrderListByMemberTel( pageNum,  pageOrder,  memberTel,orderState);
        return new ResponseResult("S","",list.getList());
    }

}

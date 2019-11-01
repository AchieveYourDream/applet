package com.kute.appletmanage.measureOrder.controller;

import com.kute.appletcore.entity.AppMeasureOrder;
import com.kute.appletcore.enumeration.EnumResultType;
import com.kute.appletcore.util.ApplicationConstant;
import com.kute.appletcore.vo.ResponseResult;
import com.kute.appletmanage.measureOrder.service.MeasureOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@SuppressWarnings("all")
@Api(value = "AppMeasureOrderController", tags = "小程序")
@RequestMapping(value = "/appMeasureOrder")
public class MeasureOrderController {


    @Autowired
    private MeasureOrderService measureOrderService;


    @PostMapping("/insertMeasureOrder")
    @ApiOperation(value = " 插入预约量体订单信息")
    public @ResponseBody
    ResponseResult updateClerkImage(@RequestBody AppMeasureOrder amo) throws Exception {
        ResponseResult result = new ResponseResult();
        measureOrderService.insert(amo);
            result.setCode(EnumResultType.SUCCESS.toString());
            result.setInfo(ApplicationConstant.SAVE_SUCCESS);
        return result;
    }



    @DeleteMapping ("/delMeasureOrder")
    @ApiOperation(value = "删除量体订单并填写撤单原因")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "measure_id", value = "预约量体ID", paramType = "query", dataType = "String", required = true),
            @ApiImplicitParam(name = "order_cancle_dict_id", value = "撤销原因", paramType = "query", dataType = "String", required = true),
            @ApiImplicitParam(name = "order_cancle_extra_content", value = "撤销手输原因", paramType = "query", dataType = "String", required = false),

    })
    public @ResponseBody ResponseResult updateClerkImage(@Param("measure_id") String measure_id, @Param("order_cancle_dict_id")String order_cancle_dict_id, @Param("order_cancle_extra_content") String order_cancle_extra_content) throws Exception {
        ResponseResult result = new ResponseResult();
        measureOrderService.delMeasureOrder(  measure_id, order_cancle_dict_id, order_cancle_extra_content);
        result.setCode(EnumResultType.SUCCESS.toString());
        result.setInfo(ApplicationConstant.SAVE_SUCCESS);
        return result;
    }
}

package com.kute.appletmanage.size.controller;

import com.github.pagehelper.PageInfo;
import com.kute.appletcore.entity.AppSize;
import com.kute.appletcore.enumeration.EnumResultType;
import com.kute.appletcore.util.ApplicationConstant;
import com.kute.appletcore.vo.ResponseResult;
import com.kute.appletmanage.size.service.SizeMangerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Name: 尺码管理
 * @Description: 尺码管理
 */
@RestController
@RequestMapping("/app/system/size/")
@Api(value = "UserController", tags = " 系统模块-尺码管理")
public class SizeMangerController {

    @Autowired
    private SizeMangerService sizeMangerService;

    /**
     * 获取尺码列表
     */
    @ApiOperation(value = "获取尺码列表")
    @RequestMapping(value = "getSizeList", method = RequestMethod.GET)
    public Map getSizeList(Integer pageNum, Integer pageSize, String search) throws Exception {
        Map dataMap = new HashMap();
        PageInfo<AppSize> list =  sizeMangerService.getSizeList( pageNum,  pageSize,  search);

        dataMap.put("total", list.getTotal());
        dataMap.put("rows", list.getList());

        return dataMap;
    }

    /**
     * 获取尺码信息
     */
    @ApiOperation(value = "获取尺码信息")
    @ApiImplicitParams({@ApiImplicitParam(name = "SizeId", value = "尺码ID", paramType = "query", required = true)})
    @RequestMapping(value = "getSizeInfoBySizeId", method = RequestMethod.GET)
    public ResponseResult getSizeInfoBySizeId(@RequestParam(value = "sizeId") Integer sizeId) throws Exception {
        AppSize size = sizeMangerService.getSizeInfoBySizeId(sizeId);

        ResponseResult result = new ResponseResult();
        result.setCode(EnumResultType.SUCCESS.toString());
        result.setData(size);

        return result;
    }


    /**
     * 新增尺码
     */
    @ApiOperation(value = "新增尺码")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "size", value = "尺码对象[AppSize]", paramType = "body", dataType = "AppSize", required = true)})
    @RequestMapping(value = "addSize", method = RequestMethod.POST)
    public ResponseResult addSize( AppSize size) throws Exception {
        return sizeMangerService.addSize(size);

    }

    /**
     * 编辑尺码
     */
    @ApiOperation(value = "编辑尺码")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "su", value = "尺码对象[AppSize]", paramType = "body", dataType = "AppSize", required = true)})
    @RequestMapping(value = "editSize", method = RequestMethod.POST)
    public ResponseResult editSize( AppSize size) throws Exception {

        return  sizeMangerService.editSize(size);
    }


    /**
     * 删除尺码
     */
    @ApiOperation(value = "删除尺码")
    @ApiImplicitParams({@ApiImplicitParam(name = "sizeId", value = "尺码id", paramType = "query", required = true)})
    @RequestMapping(value = "removeSize", method = RequestMethod.POST)
    public ResponseResult removeSize(@RequestParam(value = "sizeId") Integer sizeId) throws Exception {
        sizeMangerService.removeSize(sizeId);
        ResponseResult result = new ResponseResult();
        result.setCode(EnumResultType.SUCCESS.toString());
        result.setInfo(ApplicationConstant.REMOVE_SUCESS);

        return result;
    }


}

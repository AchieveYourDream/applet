package com.kute.appletmanage.fabric.controller;

import com.github.pagehelper.PageInfo;
import com.kute.appletcore.entity.SysFabric;
import com.kute.appletcore.enumeration.EnumResultType;
import com.kute.appletcore.util.ApplicationConstant;
import com.kute.appletcore.vo.ResponseResult;
import com.kute.appletmanage.fabric.service.FabricMangerService;
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
 * @Name: 面料管理
 * @Description: 面料管理
 */
@RestController
@RequestMapping("/app/system/fabric/")
@Api(value = "FabricController", tags = " 系统模块-面料管理")
public class FabricMangerController {

    @Autowired
    private FabricMangerService fabricMangerService;

    /**
     * 获取面料列表
     */
    @ApiOperation(value = "获取面料列表")
    @RequestMapping(value = "getFabricList", method = RequestMethod.GET)
    public Map getFabricList(Integer pageNum, Integer pageSize, String search) throws Exception {
        Map dataMap = new HashMap();
        PageInfo<SysFabric> list =  fabricMangerService.getFabricList( pageNum,  pageSize,  search);

        dataMap.put("total", list.getTotal());
        dataMap.put("rows", list.getList());

        return dataMap;
    }

    /**
     * 获取面料信息
     */
    @ApiOperation(value = "获取面料信息")
    @ApiImplicitParams({@ApiImplicitParam(name = "FabricId", value = "面料ID", paramType = "query", required = true)})
    @RequestMapping(value = "getFabricInfoByFabricCode", method = RequestMethod.GET)
    public ResponseResult getFabricInfoByFabricCode(@RequestParam(value = "fabricCode") String fabricCode) throws Exception {
        SysFabric su = fabricMangerService.getFabricInfoByFabricCode(fabricCode);

        ResponseResult result = new ResponseResult();
        result.setCode(EnumResultType.SUCCESS.toString());
        result.setData(su);

        return result;
    }

    /**
     * 检查面料名是否存在
     */
    @ApiOperation(value = "检查面料名是否存在")
    @ApiImplicitParams({@ApiImplicitParam(name = "id", value = "面料名", paramType = "query", required = true)})
    @RequestMapping(value = "checkFabricCode", method = RequestMethod.GET)
    public boolean checkFabricCode(@RequestParam(value = "fabricCode") String fabricCode) throws Exception {
        boolean result;

        SysFabric su = fabricMangerService.getFabricInfoByFabricCode(fabricCode);

        if (su == null) {
            result = true;
        } else {
            result = false;
        }

        return result;
    }

    /**
     * 新增面料
     */
    @ApiOperation(value = "新增面料")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sf", value = "面料对象[SysFabric]", paramType = "body", dataType = "SysFabric", required = true)})
    @RequestMapping(value = "addFabric", method = RequestMethod.POST)
    public ResponseResult addFabric( SysFabric sf) throws Exception {
        fabricMangerService.addFabric(sf);
        ResponseResult result = new ResponseResult();
        result.setCode(EnumResultType.SUCCESS.toString());
        result.setInfo(ApplicationConstant.SAVE_SUCCESS);

        return result;
    }

    /**
     * 编辑面料
     */
    @ApiOperation(value = "编辑面料")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "su", value = "面料对象[SysFabric]", paramType = "body", dataType = "SysFabric", required = true)})
    @RequestMapping(value = "editFabric", method = RequestMethod.POST)
    public ResponseResult editFabric( SysFabric sf) throws Exception {
        fabricMangerService.editFabric(sf);
        ResponseResult result = new ResponseResult();
        result.setCode(EnumResultType.SUCCESS.toString());
        result.setInfo(ApplicationConstant.SAVE_SUCCESS);
        return result;
    }

    /**
     * 修改面料状态
     */
    @ApiOperation(value = "修改面料状态")
    @RequestMapping(value = "updateFabricStatus", method = RequestMethod.POST)
    public ResponseResult updateFabricStatus(@RequestParam String  fabricCode,@RequestParam String fabricState) throws Exception {
        fabricMangerService.updateFabricStatus(fabricCode, fabricState);
        ResponseResult result = new ResponseResult();
        result.setCode(EnumResultType.SUCCESS.toString());
        result.setInfo(ApplicationConstant.SAVE_SUCCESS);

        return result;
    }

    /**
     * 删除面料
     */
    @ApiOperation(value = "删除面料")
    @ApiImplicitParams({@ApiImplicitParam(name = "fabricCode", value = "面料code", paramType = "query", required = true)})
    @RequestMapping(value = "removeFabric", method = RequestMethod.POST)
    public ResponseResult removeFabric(@RequestParam(value = "fabricCode") String fabricCode) throws Exception {
        fabricMangerService.removeFabric(fabricCode);
        ResponseResult result = new ResponseResult();
        result.setCode(EnumResultType.SUCCESS.toString());
        result.setInfo(ApplicationConstant.REMOVE_SUCESS);

        return result;
    }


}

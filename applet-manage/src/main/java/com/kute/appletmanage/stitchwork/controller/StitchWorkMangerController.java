package com.kute.appletmanage.stitchwork.controller;

import com.github.pagehelper.PageInfo;
import com.kute.appletcore.entity.AppStitchWork;
import com.kute.appletcore.entity.AppStitchWorkPosition;
import com.kute.appletcore.enumeration.EnumResultType;
import com.kute.appletcore.util.ApplicationConstant;
import com.kute.appletcore.vo.AppStitchWorkPositionVO;
import com.kute.appletcore.vo.ResponseResult;
import com.kute.appletmanage.stitchwork.service.StitchWorkMangerService;
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
import java.util.List;
import java.util.Map;

/**
 * @Name: 刺绣管理
 * @Description: 刺绣管理
 */
@RestController
@RequestMapping("/app/system/stitchWork/")
@Api(value = "UserController", tags = " 系统模块-刺绣管理")
public class StitchWorkMangerController {

    @Autowired
    private StitchWorkMangerService stitchWorkMangerService;

    /**
     * 获取刺绣位置列表
     */
    @ApiOperation(value = "获取刺绣位置列表")
    @RequestMapping(value = "getStitchWorkPositionList", method = RequestMethod.GET)
    public Map getStitchWorkPositionList(Integer pageNum, Integer pageSize, String search) throws Exception {
        Map dataMap = new HashMap();
        PageInfo<AppStitchWorkPosition> list =  stitchWorkMangerService.getStitchWorkPositionList( pageNum,  pageSize,  search);

        dataMap.put("total", list.getTotal());
        dataMap.put("rows", list.getList());

        return dataMap;
    }

    /**
     * 获取刺绣位置信息
     */
    @ApiOperation(value = "获取刺绣位置信息")
    @ApiImplicitParams({@ApiImplicitParam(name = "id", value = "刺绣ID", paramType = "query", required = true)})
    @RequestMapping(value = "getStitchWorkPositionInfoById", method = RequestMethod.GET)
    public ResponseResult getStitchWorkPositionInfoById(@RequestParam(value = "id") Integer id) throws Exception {
        AppStitchWorkPosition su = stitchWorkMangerService.getStitchWorkPositionInfoById(id);

        ResponseResult result = new ResponseResult();
        result.setCode(EnumResultType.SUCCESS.toString());
        result.setData(su);

        return result;
    }

    /**
     * 检查刺绣工厂编码是否存在
     */
    @ApiOperation(value = "检查刺绣工厂编码是否存在")
    @ApiImplicitParams({@ApiImplicitParam(name = "factoryCode", value = "工厂编码", paramType = "query", required = true)})
    @RequestMapping(value = "getStitchWorkPositionInfoByFactoryCode", method = RequestMethod.GET)
    public boolean getStitchWorkPositionInfoByFactoryCode(@RequestParam(value = "factoryCode") String factoryCode) throws Exception {
        boolean result;

        AppStitchWorkPosition su = stitchWorkMangerService.getStitchWorkPositionInfoByFactoryCode(factoryCode);

        if (su == null) {
            result = true;
        } else {
            result = false;
        }

        return result;
    }

    /**
     * 新增刺绣位置
     */
    @ApiOperation(value = "新增刺绣位置")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "asp", value = "刺绣对象[AppStitchWorkPosition]", paramType = "body", dataType = "AppStitchWorkPosition", required = true)})
    @RequestMapping(value = "addStitchWorkPosition", method = RequestMethod.POST)
    public ResponseResult addStitchWorkPosition( AppStitchWorkPosition asp) throws Exception {
        stitchWorkMangerService.addStitchWorkPosition(asp);
        ResponseResult result = new ResponseResult();
        result.setCode(EnumResultType.SUCCESS.toString());
        result.setInfo(ApplicationConstant.SAVE_SUCCESS);

        return result;
    }

    /**
     * 编辑刺绣位置
     */
    @ApiOperation(value = "编辑刺绣位置")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "su", value = "刺绣对象[AppStitchWorkPosition]", paramType = "body", dataType = "AppStitchWorkPosition", required = true)})
    @RequestMapping(value = "editStitchWorkPosition", method = RequestMethod.POST)
    public ResponseResult editStitchWorkPosition( AppStitchWorkPosition asp) throws Exception {
        stitchWorkMangerService.editStitchWorkPosition(asp);
        ResponseResult result = new ResponseResult();
        result.setCode(EnumResultType.SUCCESS.toString());
        result.setInfo(ApplicationConstant.SAVE_SUCCESS);
        return result;
    }


    /**
     * 删除刺绣位置
     */
    @ApiOperation(value = "删除刺绣位置")
    @ApiImplicitParams({@ApiImplicitParam(name = "id", value = "刺绣id", paramType = "query", required = true)})
    @RequestMapping(value = "removeStitchWorkPosition", method = RequestMethod.POST)
    public ResponseResult removeStitchWorkPosition(@RequestParam(value = "id") Integer id) throws Exception {
        stitchWorkMangerService.removeStitchWorkPosition(id);
        ResponseResult result = new ResponseResult();
        result.setCode(EnumResultType.SUCCESS.toString());
        result.setInfo(ApplicationConstant.REMOVE_SUCESS);

        return result;
    }


    /**
     * 获取刺绣列表
     */
    @ApiOperation(value = "获取刺绣列表")
    @RequestMapping(value = "getStitchWorkList", method = RequestMethod.GET)
    public Map getStitchWorkList(Integer pageNum, Integer pageSize, String search) throws Exception {
        Map dataMap = new HashMap();
        PageInfo<AppStitchWork> list =  stitchWorkMangerService.getStitchWorkList( pageNum,  pageSize,  search);

        dataMap.put("total", list.getTotal());
        dataMap.put("rows", list.getList());

        return dataMap;
    }

    /**
     * 获取刺绣信息
     */
    @ApiOperation(value = "获取刺绣信息")
    @ApiImplicitParams({@ApiImplicitParam(name = "StitchWorkId", value = "刺绣ID", paramType = "query", required = true)})
    @RequestMapping(value = "getStitchWorkInfoById", method = RequestMethod.GET)
    public ResponseResult getStitchWorkInfoById(@RequestParam(value = "id") Integer id) throws Exception {
        AppStitchWork su = stitchWorkMangerService.getStitchWorkInfoById(id);

        ResponseResult result = new ResponseResult();
        result.setCode(EnumResultType.SUCCESS.toString());
        result.setData(su);

        return result;
    }

    /**
     * 检查刺绣工厂编码是否存在
     */
    @ApiOperation(value = "检查刺绣名是否存在")
    @ApiImplicitParams({@ApiImplicitParam(name = "factoryCode", value = "刺绣名", paramType = "query", required = true)})
    @RequestMapping(value = "getStitchWorkInfoByFactoryCode", method = RequestMethod.GET)
    public boolean getStitchWorkInfoByFactoryCode(@RequestParam(value = "factoryCode") String factoryCode) throws Exception {
        boolean result;

        AppStitchWork appStitchWork = stitchWorkMangerService.getStitchWorkInfoByFactoryCode(factoryCode);

        if (appStitchWork == null) {
            result = true;
        } else {
            result = false;
        }

        return result;
    }

    /**
     * 新增刺绣
     */
    @ApiOperation(value = "新增刺绣")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "appStitchWork", value = "刺绣对象[AppStitchWork]", paramType = "body", dataType = "AppStitchWork", required = true)})
    @RequestMapping(value = "addStitchWork", method = RequestMethod.POST)
    public ResponseResult addStitchWork( AppStitchWork appStitchWork) throws Exception {
        stitchWorkMangerService.addStitchWork(appStitchWork);
        ResponseResult result = new ResponseResult();
        result.setCode(EnumResultType.SUCCESS.toString());
        result.setInfo(ApplicationConstant.SAVE_SUCCESS);

        return result;
    }

    /**
     * 编辑刺绣
     */
    @ApiOperation(value = "编辑刺绣")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "appStitchWork", value = "刺绣对象[AppStitchWork]", paramType = "body", dataType = "AppStitchWork", required = true)})
    @RequestMapping(value = "editStitchWork", method = RequestMethod.POST)
    public ResponseResult editStitchWork( AppStitchWork appStitchWork) throws Exception {
        stitchWorkMangerService.editStitchWork(appStitchWork);
        ResponseResult result = new ResponseResult();
        result.setCode(EnumResultType.SUCCESS.toString());
        result.setInfo(ApplicationConstant.SAVE_SUCCESS);
        return result;
    }


    /**
     * 删除刺绣
     */
    @ApiOperation(value = "删除刺绣")
    @ApiImplicitParams({@ApiImplicitParam(name = "id", value = "刺绣id", paramType = "query", required = true)})
    @RequestMapping(value = "removeStitchWork", method = RequestMethod.POST)
    public ResponseResult removeStitchWork(@RequestParam(value = "id") Integer id) throws Exception {
        stitchWorkMangerService.removeStitchWork(id);
        ResponseResult result = new ResponseResult();
        result.setCode(EnumResultType.SUCCESS.toString());
        result.setInfo(ApplicationConstant.REMOVE_SUCESS);

        return result;
    }

    /**
     * 获取刺绣位置信息
     */
    @ApiOperation(value = "获取关系列表")
    @ApiImplicitParams({@ApiImplicitParam(name = "stitchWorkId", value = "刺绣ID", paramType = "query", required = true)})
    @RequestMapping(value = "getStitchWorkRelationList", method = RequestMethod.GET)
    public ResponseResult getStitchWorkRelationList(@RequestParam Integer stitchWorkId) throws Exception {
        List<AppStitchWorkPositionVO> list = stitchWorkMangerService.getStitchWorkRelationList(stitchWorkId);
        ResponseResult result = new ResponseResult();
        result.setCode(EnumResultType.SUCCESS.toString());
        result.setData(list);

        return result;
    }



    /**
     * @Description: 修改刺绣与位置关系
     * @Author: 王斌
     * @Date: 2019/11/21
     */
    @ApiOperation(value = "修改刺绣与位置关系")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "stitchWorkId", value = "刺绣id", paramType = "query", required = true),
            @ApiImplicitParam(name = "positionArray", value = "位置id", paramType = "query", required = true),
    })
    @RequestMapping(value = "updateStitchWorkPositionRelation", method = RequestMethod.POST)
    public ResponseResult updateStitchWorkPositionRelation(@RequestParam Integer stitchWorkId,@RequestParam String  positionArray) throws Exception {
        return stitchWorkMangerService.updateStitchWorkPositionRelation(stitchWorkId,positionArray);
    }


}

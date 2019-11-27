package com.kute.appletmanage.technologyConflict.controller;

import com.github.pagehelper.PageInfo;
import com.kute.appletcore.entity.SysTechnologyConflict;
import com.kute.appletcore.enumeration.EnumResultType;
import com.kute.appletcore.util.ApplicationConstant;
import com.kute.appletcore.vo.ResponseResult;
import com.kute.appletmanage.technologyConflict.service.TechnologyConflictMangerService;
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
 * @Name: 工艺冲突管理
 * @Description: 工艺冲突管理
 */
@RestController
@RequestMapping("/app/system/technologyConflict/")
@Api(value = "UserController", tags = " 系统模块-工艺冲突管理")
public class TechnologyConflictMangerController {

    @Autowired
    private TechnologyConflictMangerService technologyConflictMangerService;
    /**
     * 获取工艺冲突列表
     */
    @ApiOperation(value = "获取工艺冲突列表")
    @RequestMapping(value = "getTechnologyConflictList", method = RequestMethod.GET)
    public Map getTechnologyConflictList(Integer pageNum, Integer pageSize, String search) throws Exception {
        Map dataMap = new HashMap();
        PageInfo<SysTechnologyConflict> list =  technologyConflictMangerService.getTechnologyConflictList( pageNum,  pageSize,  search);

        dataMap.put("total", list.getTotal());
        dataMap.put("rows", list.getList());

        return dataMap;
    }

    /**
     * 获取工艺冲突信息
     */
    @ApiOperation(value = "获取工艺冲突信息")
    @ApiImplicitParams({@ApiImplicitParam(name = "TechnologyConflictId", value = "工艺冲突ID", paramType = "query", required = true)})
    @RequestMapping(value = "getTechnologyConflictInfoByTechnologyConflictId", method = RequestMethod.GET)
    public ResponseResult getTechnologyConflictInfoByTechnologyConflictId(@RequestParam(value = "id") Integer id) throws Exception {
        SysTechnologyConflict su = technologyConflictMangerService.getTechnologyConflictInfoByTechnologyConflictId(id);

        ResponseResult result = new ResponseResult();
        result.setCode(EnumResultType.SUCCESS.toString());
        result.setData(su);

        return result;
    }


    /**
     * 获取工艺信息
     */
    @ApiOperation(value = "获取工艺信息")
    @RequestMapping(value = "getTechnologyList", method = RequestMethod.GET)
    public List<Map<String, String>> getTechnologyList(@RequestParam String search) throws Exception {
       return   technologyConflictMangerService.getTechnologyList(search);
    }

    /**
     * 新增工艺冲突
     */
    @ApiOperation(value = "新增工艺冲突")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sf", value = "工艺冲突对象[SysTechnologyConflict]", paramType = "body", dataType = "SysTechnologyConflict", required = true)})
    @RequestMapping(value = "addTechnologyConflict", method = RequestMethod.POST)
    public ResponseResult addTechnologyConflict( SysTechnologyConflict sf) throws Exception {
        return technologyConflictMangerService.addTechnologyConflict(sf);
    }


    /**
     * 删除工艺冲突
     */
    @ApiOperation(value = "删除工艺冲突")
    @ApiImplicitParams({@ApiImplicitParam(name = "id", value = "工艺冲突id", paramType = "query", required = true)})
    @RequestMapping(value = "removeTechnologyConflict", method = RequestMethod.POST)
    public ResponseResult removeTechnologyConflict( Integer id) throws Exception {
        technologyConflictMangerService.removeTechnologyConflict(id);
        ResponseResult result = new ResponseResult();
        result.setCode(EnumResultType.SUCCESS.toString());
        result.setInfo(ApplicationConstant.REMOVE_SUCESS);

        return result;
    }


}

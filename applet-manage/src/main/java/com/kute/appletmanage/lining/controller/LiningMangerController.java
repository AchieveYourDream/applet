package com.kute.appletmanage.lining.controller;

import com.github.pagehelper.PageInfo;
import com.kute.appletcore.entity.AppLining;
import com.kute.appletcore.enumeration.EnumResultType;
import com.kute.appletcore.util.ApplicationConstant;
import com.kute.appletcore.vo.ResponseResult;
import com.kute.appletmanage.lining.service.LiningMangerService;
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
 * @Name: 衬类型管理
 * @Description: 衬类型管理
 */
@RestController
@RequestMapping("/app/system/lining/")
@Api(value = "UserController", tags = " 系统模块-衬类型管理")
public class LiningMangerController {

    @Autowired
    private LiningMangerService liningMangerService;

    /**
     * 获取衬类型列表
     */
    @ApiOperation(value = "获取衬类型列表")
    @RequestMapping(value = "getLiningList", method = RequestMethod.GET)
    public Map getLiningList(Integer pageNum, Integer pageSize, String search) throws Exception {
        Map dataMap = new HashMap();
        PageInfo<AppLining> list =  liningMangerService.getLiningList( pageNum,  pageSize,  search);

        dataMap.put("total", list.getTotal());
        dataMap.put("rows", list.getList());

        return dataMap;
    }

    /**
//     * 获取衬类型信息
//     */
    @ApiOperation(value = "获取衬类型信息")
    @ApiImplicitParams({@ApiImplicitParam(name = "id", value = "衬类型ID", paramType = "query", required = true)})
    @RequestMapping(value = "getLiningInfoById", method = RequestMethod.GET)
    public ResponseResult getLiningInfoById(@RequestParam Integer id) throws Exception {
        AppLining su = liningMangerService.getLiningInfoById(id);
        ResponseResult result = new ResponseResult();
        result.setCode(EnumResultType.SUCCESS.toString());
        result.setData(su);

        return result;
    }

    /**
     * 检查衬类型名是否存在
     */
    @ApiOperation(value = "检查衬类型名是否存在")
    @ApiImplicitParams({@ApiImplicitParam(name = "id", value = "衬类型名", paramType = "query", required = true)})
    @RequestMapping(value = "checkLiningCode", method = RequestMethod.GET)
    public boolean checkLiningCode(@RequestParam(value = "liningCode") String liningCode,@RequestParam(value = "category") String category) throws Exception {
        boolean result;

        AppLining su = liningMangerService.getLiningInfoByLiningCode(liningCode,category);

        if (su == null) {
            result = true;
        } else {
            result = false;
        }

        return result;
    }

    /**
     * 新增衬类型
     */
    @ApiOperation(value = "新增衬类型")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sf", value = "衬类型对象[AppLining]", paramType = "body", dataType = "AppLining", required = true)})
    @RequestMapping(value = "addLining", method = RequestMethod.POST)
    public ResponseResult addLining( AppLining sf) throws Exception {
        liningMangerService.addLining(sf);
        ResponseResult result = new ResponseResult();
        result.setCode(EnumResultType.SUCCESS.toString());
        result.setInfo(ApplicationConstant.SAVE_SUCCESS);

        return result;
    }

    /**
     * 编辑衬类型
     */
    @ApiOperation(value = "编辑衬类型")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "su", value = "衬类型对象[AppLining]", paramType = "body", dataType = "AppLining", required = true)})
    @RequestMapping(value = "editLining", method = RequestMethod.POST)
    public ResponseResult editLining( AppLining sf) throws Exception {
        liningMangerService.editLining(sf);
        ResponseResult result = new ResponseResult();
        result.setCode(EnumResultType.SUCCESS.toString());
        result.setInfo(ApplicationConstant.SAVE_SUCCESS);
        return result;
    }


    /**
     * 删除衬类型
     */
    @ApiOperation(value = "删除衬类型")
    @ApiImplicitParams({@ApiImplicitParam(name = "id", value = "id", paramType = "query", required = true)})
    @RequestMapping(value = "removeLining", method = RequestMethod.POST)
    public ResponseResult removeLining(@RequestParam(value = "id") Integer id) throws Exception {
        liningMangerService.removeLining(id);
        ResponseResult result = new ResponseResult();
        result.setCode(EnumResultType.SUCCESS.toString());
        result.setInfo(ApplicationConstant.REMOVE_SUCESS);

        return result;
    }


    /**
     * 根据品类获取衬类型
     */
    @ApiOperation(value = "根据品类获取衬类型")
    @ApiImplicitParams({@ApiImplicitParam(name = "category", value = "品类", paramType = "query", required = true)})
    @RequestMapping(value = "getLiningListByCategory", method = RequestMethod.GET)
    public  ResponseResult  getLiningListByCategory(String category) throws Exception{
        return new ResponseResult("S","",liningMangerService.getLiningListByCategory(category)) ;
    }



}

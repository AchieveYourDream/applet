package com.kute.appletmanage.lov.controller;

import com.kute.appletcore.entity.SysLovColumn;
import com.kute.appletcore.entity.SysLovDefine;
import com.kute.appletcore.enumeration.EnumResultType;
import com.kute.appletcore.util.ApplicationConstant;
import com.kute.appletcore.vo.LovCountVO;
import com.kute.appletcore.vo.ResponseResult;
import com.kute.appletcore.vo.SysLovVO;
import com.kute.appletmanage.lov.service.LovService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Name: 值列表
 * @Description: 值列表
 * @CreatedBy: zoran
 * @CreateDate: 2018-04-18
 * @LastUpdatedBy: zoran
 * @LastUpdateDate 2018-04-18
 */
@RestController
@RequestMapping("/app/system/lov/")
@Api(value = "LovController", tags = " 系统模块-值列表")
public class LovController {

    @Autowired
    private LovService lovService;

    /**
     * 获取值列表定义列表
     */
    @ApiOperation(value = "获取值列表定义列表")
    @RequestMapping(value = "getLovDefineList", method = RequestMethod.GET)
    public ResponseResult getLovDefineList() throws Exception {
        List<SysLovDefine> list = lovService.getLovDefineList();

        ResponseResult result = new ResponseResult();
        result.setCode(EnumResultType.SUCCESS.toString());
        result.setData(list);

        return result;
    }

    /**
     * 获取值列表视图列表
     */
    @ApiOperation(value = "获取值列表视图列表")
    @RequestMapping(value = "getLovViewList", method = RequestMethod.GET)
    public ResponseResult getLovViewList() throws Exception {
        List<String> list = lovService.getLovViewList();

        ResponseResult result = new ResponseResult();
        result.setCode(EnumResultType.SUCCESS.toString());
        result.setData(list);

        return result;
    }

    /**
     * 获取值列表定义信息
     */
    @ApiOperation(value = "获取值列表定义信息")
    @ApiImplicitParams({@ApiImplicitParam(name = "lovCode", value = "值列表编码", paramType = "query", required = true)})
    @RequestMapping(value = "getLovDefineInfo", method = RequestMethod.GET)
    public ResponseResult getLovDefineInfo(@RequestParam(value = "lovCode") String lovCode) throws Exception {
        SysLovDefine sld = lovService.getLovDefineInfo(lovCode);

        ResponseResult result = new ResponseResult();
        result.setCode(EnumResultType.SUCCESS.toString());
        result.setData(sld);

        return result;
    }

    /**
     * 获取值列表字段列表
     */
    @ApiOperation(value = "获取值列表字段列表")
    @ApiImplicitParams({@ApiImplicitParam(name = "viewName", value = "视图名称", paramType = "query", required = true),
            @ApiImplicitParam(name = "lovCode", value = "值列表名称", paramType = "query", required = true)})
    @RequestMapping(value = "getLovColumnList", method = RequestMethod.GET)
    public ResponseResult getLovColumnList(@RequestParam(value = "viewName") String viewName) throws Exception {
        List<SysLovColumn> slcList = lovService.getLovColumnList(viewName);

        ResponseResult result = new ResponseResult();
        result.setCode(EnumResultType.SUCCESS.toString());
        result.setData(slcList);

        return result;
    }

    /**
     * 检查值列表编码
     */
    @ApiOperation(value = "检查值列表编码")
    @ApiImplicitParams({@ApiImplicitParam(name = "lovCode", value = "值列表编码", paramType = "query", required = true)})
    @RequestMapping(value = "checkLovCode", method = RequestMethod.GET)
    public boolean checkLovCode(@RequestParam(value = "lovCode") String lovCode) throws Exception {
        boolean result;

        SysLovDefine sld = lovService.getLovDefineInfo(lovCode);

        if (sld == null) {
            result = true;
        } else {
            result = false;
        }

        return result;
    }

    /**
     * 保存值列表信息
     */
    @ApiOperation(value = "保存LOV信息")
    @ApiImplicitParams({@ApiImplicitParam(name = "slVO", value = "值列表对象[SysLovVO]", paramType = "body", dataType = "SysLovVO", required = true)})
    @RequestMapping(value = "saveLovInfo", method = RequestMethod.POST)
    public ResponseResult saveLovInfo( @RequestBody  SysLovVO slVO) throws Exception {
        lovService.saveLovInfo(slVO.getSld(), slVO.getSlcList());

        ResponseResult result = new ResponseResult();
        result.setCode(EnumResultType.SUCCESS.toString());
        result.setInfo(ApplicationConstant.SAVE_SUCCESS);

        return result;
    }

    /**
     * 获取值列表字段列表
     */
    @ApiOperation(value = "获取值列表字段列表")
    @ApiImplicitParams({@ApiImplicitParam(name = "lovCode", value = "值列表编码", paramType = "query", required = true)})
    @RequestMapping(value = "getLovDataList", method = RequestMethod.GET)
    public ResponseResult getLovDataList(@RequestParam(value = "lovCode") String lovCode) throws Exception {
        SysLovDefine sld = lovService.getLovDefineInfo(lovCode); //获取值列表
        List<SysLovColumn> slcList = lovService.getLovColumnList( lovCode);//获取 子值列表list
        LovCountVO vo = new LovCountVO();
        vo.setSlcList(slcList);
        for (SysLovColumn slc : vo.getSlcList()) {
            if ("Y".equals(slc.getReturnValueFlag())) {
                vo.setReturnValueColumn(slc.getColumnName());
            }
            if ("Y".equals(slc.getReturnTextFlag())) {
                vo.setReturnTextColumn(slc.getColumnName());
            }
        }

        ResponseResult result = new ResponseResult();
        result.setCode(EnumResultType.SUCCESS.toString());
        result.setData(vo);

        return result;
    }


    @ApiOperation(value = "获取值列表数据")
    @ApiImplicitParams({@ApiImplicitParam(name = "lovCode", value = "值列表编码", paramType = "query", required = true)})
    @RequestMapping(value = "getLovDataLists", method = RequestMethod.GET)
    public ResponseResult getLovDataLists(@RequestParam(value = "lovCode") String lovCode) throws Exception {
        SysLovDefine sld = lovService.getLovDefineInfo(lovCode); //获取值列表
        List<Map<String, Object>> dataList = lovService.getLovViewColumnList(sld.getViewName());//获取视图数据
        //map中的key全部变成小写

        List<Map<String, Object>> returnData = new ArrayList<>();
        if (dataList != null && !dataList.isEmpty()) {
            for (Map<String, Object> map : dataList) {
                Map<String, Object> resultMap = new HashMap<>();
                for (String key : map.keySet()) {
                    String newKey = key.toLowerCase();
                    resultMap.put(newKey, map.get(key));
                }
                returnData.add(resultMap);
            }
        }
        ResponseResult result = new ResponseResult();
        result.setCode(EnumResultType.SUCCESS.toString());
        //result.setData(JsonUtil.getJSONFromObjectList(dataList).toLowerCase());
        result.setData(returnData);
        return result;
    }

    @ApiOperation(value = "删除值列表")
    @ApiImplicitParams({@ApiImplicitParam(name = "lovCode", value = "值列表编码", paramType = "query", required = true)})
    @RequestMapping(value = "removeLovDefine", method = RequestMethod.GET)
    public ResponseResult removeLov(@RequestParam(value = "lovCode") String lovCode) throws Exception {
        lovService.removeLovDefine(lovCode); //获取值列表
        ResponseResult result = new ResponseResult();
        result.setCode(EnumResultType.SUCCESS.toString());
        result.setData("删除成功");

        return result;
    }


    @ApiOperation(value = "获取值列表字段列表 大数据量 后台分页")
    @ApiImplicitParams({@ApiImplicitParam(name = "lovCode", value = "值列表编码", paramType = "query", required = true),
            @ApiImplicitParam(name = "offset", value = "分页查询开始", paramType = "query", required = true),
            @ApiImplicitParam(name = "limit", value = "分页查询偏移量", paramType = "query", required = true),
            @ApiImplicitParam(name = "search", value = "搜索条件", paramType = "query", required = false),
            @ApiImplicitParam(name = "appSearch", value = "App模糊搜索", paramType = "query", required = false)})
    @RequestMapping(value = "getLovViewColumnListBigData", method = RequestMethod.GET)
    public Map<String, Object> getLovViewColumnListBigData(@RequestParam(value = "lovCode") String lovCode,
                                                           @RequestParam(value = "offset") String offset, @RequestParam(value = "limit") String limit,
                                                           @RequestParam(value = "search", required = false) String search, @RequestParam(value = "appSearch", required = false) String appSearch) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        String end = String.valueOf(Integer.parseInt(offset) + Integer.parseInt(limit));
        SysLovDefine sld = lovService.getLovDefineInfo(lovCode); //获取值列表
        List<SysLovColumn> dataList = lovService.getLovViewColumnListBigData(offset, end, search, sld.getViewName(), appSearch);
        int dataCount = lovService.getLovViewColumnCount(search, sld.getViewName(), appSearch);
        map.put("total", dataCount);
        map.put("rows", dataList);
        return map;
    }


}

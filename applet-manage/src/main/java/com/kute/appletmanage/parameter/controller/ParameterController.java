package com.kute.appletmanage.parameter.controller;

import com.kute.appletcore.entity.SysParameterConfig;
import com.kute.appletcore.entity.SysParameterDefine;
import com.kute.appletcore.entity.SysParameterType;
import com.kute.appletcore.enumeration.EnumResultType;
import com.kute.appletcore.util.ApplicationConstant;
import com.kute.appletcore.vo.ResponseResult;
import com.kute.appletcore.vo.SysParameterDefineVO;
import com.kute.appletmanage.parameter.service.ParameterService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Name: 系统设置
 * @Description: 包括系统参数定义和系统参数设置
 * @CreatedBy: zoran
 * @CreateDate: 2018-04-06
 * @LastUpdatedBy: zoran
 * @LastUpdateDate 2018-04-06
 */
@RestController
@RequestMapping("/app/system/parameter/")
@Api(value = "ParameterController", tags = " 系统模块-系统设置")
public class ParameterController {

    @Autowired
    private ParameterService parameterService;

    /**
     * 获取参数类型列表
     */
    @ApiOperation(value = "获取参数类型列表")
    @RequestMapping(value = "getParameterTypeList", method = RequestMethod.GET)
    public ResponseResult getParameterTypeList() throws Exception {
        List<SysParameterType> list = parameterService.getParameterTypeList();

        ResponseResult result = new ResponseResult();
        result.setCode(EnumResultType.SUCCESS.toString());
        result.setData(list);

        return result;
    }

    /**
     * 获取参数类型信息
     */
    @ApiOperation(value = "获取参数类型信息")
    @ApiImplicitParams({@ApiImplicitParam(name = "typeCode", value = "参数类型编码", paramType = "query", required = true)})
    @RequestMapping(value = "getParameterTypeInfo", method = RequestMethod.GET)
    public ResponseResult getParameterTypeInfo(@RequestParam(value = "typeCode") String typeCode) throws Exception {
        SysParameterType spt = parameterService.getParameterTypeInfo(typeCode);

        ResponseResult result = new ResponseResult();
        result.setCode(EnumResultType.SUCCESS.toString());
        result.setData(spt);

        return result;
    }

    /**
     * 检查参数类型编码
     */
    @ApiOperation(value = "检查参数类型编码")
    @ApiImplicitParams({@ApiImplicitParam(name = "typeCode", value = "参数类型编码", paramType = "query", required = true)})
    @RequestMapping(value = "checkParameterTypeCode", method = RequestMethod.GET)
    public boolean checkParameterTypeCode(@RequestParam(value = "typeCode") String typeCode) throws Exception {
        boolean result;

        SysParameterType spt = parameterService.getParameterTypeInfo(typeCode);

        if (spt == null) {
            result = true;
        } else {
            result = false;
        }

        return result;
    }

    /**
     * 新建参数类型
     */
    @ApiOperation(value = "新建参数类型")
    @ApiImplicitParams({@ApiImplicitParam(name = "spt", value = "参数类型对象[SysParameterType]", paramType = "body", dataType = "SysParameterType", required = true)})
    @RequestMapping(value = "addParameterType", method = RequestMethod.POST)
    public ResponseResult addParameterType(@RequestBody SysParameterType spt) throws Exception {
        parameterService.addParameterType(spt);

        ResponseResult result = new ResponseResult();
        result.setCode(EnumResultType.SUCCESS.toString());
        result.setInfo(ApplicationConstant.SAVE_SUCCESS);

        return result;
    }

    /**
     * 编辑参数类型
     */
    @ApiOperation(value = "编辑参数类型")
    @ApiImplicitParams({@ApiImplicitParam(name = "spt", value = "参数类型对象[SysParameterType]", paramType = "body", dataType = "SysParameterType", required = true)})
    @RequestMapping(value = "editParameterType", method = RequestMethod.POST)
    public ResponseResult editParameterType(@RequestBody SysParameterType spt) throws Exception {
        parameterService.editParameterType(spt);

        ResponseResult result = new ResponseResult();
        result.setCode(EnumResultType.SUCCESS.toString());
        result.setInfo(ApplicationConstant.SAVE_SUCCESS);

        return result;
    }

    /**
     * 删除参数类型
     */
    @ApiOperation(value = "删除参数类型")
    @ApiImplicitParams({@ApiImplicitParam(name = "typeCode", value = "参数类型编码", paramType = "body", required = true)})
    @RequestMapping(value = "removeParameterType", method = RequestMethod.POST, consumes = "text/plain")
    public ResponseResult removeParameterType(@RequestBody String typeCode) throws Exception {
        parameterService.removeParameterType(typeCode);

        ResponseResult result = new ResponseResult();
        result.setCode(EnumResultType.SUCCESS.toString());
        result.setInfo(ApplicationConstant.REMOVE_SUCESS);

        return result;
    }

    /**
     * 获取参数定义列表
     */
    @ApiOperation(value = "获取参数定义列表")
    @ApiImplicitParams({@ApiImplicitParam(name = "typeCode", value = "参数类型编码", paramType = "query", required = true)})
    @RequestMapping(value = "getParameterDefineList", method = RequestMethod.GET)
    public ResponseResult getParameterDefineList(@RequestParam(value = "typeCode") String typeCode) throws Exception {
        List<SysParameterDefineVO> list = parameterService.getParameterDefineList(typeCode);

        ResponseResult result = new ResponseResult();
        result.setCode(EnumResultType.SUCCESS.toString());
        result.setData(list);

        return result;
    }

    /**
     * 获取参数定义信息
     */
    @ApiOperation(value = "获取参数定义信息")
    @ApiImplicitParams({@ApiImplicitParam(name = "parameterCode", value = "参数编码", paramType = "query", required = true)})
    @RequestMapping(value = "getParameterDefineInfo", method = RequestMethod.GET)
    public ResponseResult getParameterDefineInfo(@RequestParam(value = "parameterCode") String parameterCode) throws Exception {
        SysParameterDefineVO vo = parameterService.getParameterDefineInfo(parameterCode);

        ResponseResult result = new ResponseResult();
        result.setCode(EnumResultType.SUCCESS.toString());
        result.setData(vo);

        return result;
    }

    /**
     * 检查参数编码
     */
    @ApiOperation(value = "检查参数编码")
    @ApiImplicitParams({@ApiImplicitParam(name = "parameterCode", value = "参数编码", paramType = "query", required = true)})
    @RequestMapping(value = "checkParameterCode", method = RequestMethod.GET)
    public boolean checkParameterCode(@RequestParam(value = "parameterCode") String parameterCode) throws Exception {
        boolean result = false;

        SysParameterDefineVO vo = parameterService.getParameterDefineInfo(parameterCode);

        if (vo == null) {
            result = true;
        } else {
            result = false;
        }

        return result;
    }

    /**
     * 新建参数
     */
    @ApiOperation(value = "新建参数")
    @ApiImplicitParams({@ApiImplicitParam(name = "spd", value = "参数对象[SysParameterDefine]", paramType = "body", dataType = "SysParameterDefine", required = true)})
    @RequestMapping(value = "addParameterDefine", method = RequestMethod.POST)
    public ResponseResult addParameterDefine(@RequestBody SysParameterDefine spd) throws Exception {
        parameterService.addParameterDefine(spd);

        ResponseResult result = new ResponseResult();
        result.setCode(EnumResultType.SUCCESS.toString());
        result.setInfo(ApplicationConstant.SAVE_SUCCESS);

        return result;
    }

    /**
     * 编辑参数
     */
    @ApiOperation(value = "编辑参数")
    @ApiImplicitParams({@ApiImplicitParam(name = "spd", value = "参数对象[SysParameterDefine]", paramType = "body", dataType = "SysParameterDefine", required = true)})
    @RequestMapping(value = "editParameterDefine", method = RequestMethod.POST)
    public ResponseResult editParameterDefine(@RequestBody SysParameterDefine spd) throws Exception {
        parameterService.editParameterDefine(spd);

        ResponseResult result = new ResponseResult();
        result.setCode(EnumResultType.SUCCESS.toString());
        result.setInfo(ApplicationConstant.SAVE_SUCCESS);

        return result;
    }

    /**
     * 删除参数
     */
    @ApiOperation(value = "删除参数")
    @ApiImplicitParams({@ApiImplicitParam(name = "parameterCode", value = "参数编码", paramType = "body", required = true)})
    @RequestMapping(value = "removeParameterDefine", method = RequestMethod.POST, consumes = "text/plain")
    public ResponseResult removeParameterDefine(@RequestBody String parameterCode) throws Exception {
        parameterService.removeParameterDefine(parameterCode);

        ResponseResult result = new ResponseResult();
        result.setCode(EnumResultType.SUCCESS.toString());
        result.setInfo(ApplicationConstant.REMOVE_SUCESS);

        return result;
    }

    /**
     * 获取参数配置列表
     */
    @ApiOperation(value = "获取参数配置列表")
    @ApiImplicitParams({@ApiImplicitParam(name = "typeCode", value = "参数类型编码", paramType = "query", required = true)})
    @RequestMapping(value = "getParameterConfigList", method = RequestMethod.GET)
    public ResponseResult getParameterConfigList(@RequestParam(value = "typeCode") String typeCode) throws Exception {
        List<SysParameterDefineVO> list = parameterService.getParameterConfigList(typeCode);

        ResponseResult result = new ResponseResult();
        result.setCode(EnumResultType.SUCCESS.toString());
        result.setData(list);

        return result;
    }

    /**
     * 保存参数设置
     */
    @ApiOperation(value = "保存参数设置")
    @ApiImplicitParams({@ApiImplicitParam(name = "spcList", value = "参数列表[SysParameterConfig]", paramType = "body", dataType = "List<SysParameterConfig>", required = true)})
    @RequestMapping(value = "saveParameterConfig", method = RequestMethod.POST)
    public ResponseResult saveParameterConfig(@RequestBody List<SysParameterConfig> spcList) throws Exception {
        parameterService.saveParameterConfig(spcList);

        ResponseResult result = new ResponseResult();
        result.setCode(EnumResultType.SUCCESS.toString());
        result.setData(ApplicationConstant.SAVE_SUCCESS);

        return result;
    }

    /**
     * 获取参数值
     */
    @ApiOperation(value = "获取参数值")
    @RequestMapping(value = "getParameterValue", method = RequestMethod.GET)
    public ResponseResult getParameterValue(@RequestParam String parameterCode) {
        return parameterService.getParameterValue(parameterCode);
    }
}

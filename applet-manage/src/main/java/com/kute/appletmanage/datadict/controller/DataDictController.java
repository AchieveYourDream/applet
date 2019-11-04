package com.kute.appletmanage.datadict.controller;

import com.kute.appletcore.entity.SysDataDictItem;
import com.kute.appletcore.entity.SysDataDictType;
import com.kute.appletcore.enumeration.EnumResultType;
import com.kute.appletcore.util.ApplicationConstant;
import com.kute.appletcore.vo.ResponseResult;
import com.kute.appletmanage.datadict.service.DataDictService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Name: 数据字典
 * @Description: 数据字典
 * @CreatedBy: zoran
 * @CreateDate: 2018-04-16
 * @LastUpdatedBy: zoran
 * @LastUpdateDate 2018-04-16
 */
@RestController
@RequestMapping("/app/system/datadict/")
@Api(value = "DataDictController", tags = " 系统模块-数据字典")
public class DataDictController {

    @Autowired
    DataDictService dataDictService;
    /**
     * 根据一个数据字典类型获取数据字典项列表
     */
    @ApiOperation(value = "根据一个数据字典类型获取数据字典项列表")
    @ApiImplicitParam(name = "typeCode", value = "数据字典类型编码", paramType = "query", required = true)
    @GetMapping(value = "getSingleDataDictItemList")
    public ResponseResult getSingleDataDictItemList(@RequestParam(value = "typeCode") String typeCode)throws Exception {
        List<SysDataDictItem> list = dataDictService.getSingleDataDictItemList(typeCode);

        ResponseResult result = new ResponseResult();
        result.setCode(EnumResultType.SUCCESS.toString());
        result.setData(list);

        return result;
    }

    /**
     * 获取数据字典类型列表
     */
    @ApiOperation(value = "获取数据字典类型列表")
    @RequestMapping(value = "getDataDictTypeList", method = RequestMethod.GET)
    public ResponseResult getDataDictTypeList() throws Exception {
        List<SysDataDictType> list = dataDictService.getDataDictTypeList();

        ResponseResult result = new ResponseResult();
        result.setCode(EnumResultType.SUCCESS.toString());
        result.setData(list);

        return result;
    }

    /**
     * 获取数据字典类型信息
     */
    @ApiOperation(value = "获取数据字典类型信息")
    @ApiImplicitParams({@ApiImplicitParam(name = "typeCode", value = "数据字典类型编码", paramType = "query", required = true)})
    @RequestMapping(value = "getDataDictTypeInfo", method = RequestMethod.GET)
    public ResponseResult getDataDictTypeInfo(@RequestParam(value = "typeCode") String typeCode) throws Exception {
        SysDataDictType ddt = dataDictService.getDataDictTypeInfo(typeCode);

        ResponseResult result = new ResponseResult();
        result.setCode(EnumResultType.SUCCESS.toString());
        result.setData(ddt);

        return result;
    }

    /**
     * 检查数据字典类型编码
     */
    @ApiOperation(value = "检查数据字典类型编码")
    @ApiImplicitParams({@ApiImplicitParam(name = "typeCode", value = "数据字典类型编码", paramType = "query", required = true)})
    @RequestMapping(value = "checkDataDictTypeCode", method = RequestMethod.GET)
    public boolean checkDataDictTypeCode(@RequestParam(value = "typeCode") String typeCode) throws Exception {
        boolean result;

        SysDataDictType ddt = dataDictService.getDataDictTypeInfo(typeCode);

        if (ddt == null) {
            result = true;
        } else {
            result = false;
        }

        return result;
    }

    /**
     * 新建数据字典类型
     */
    @ApiOperation(value = "新建数据字典类型")
    @ApiImplicitParams({@ApiImplicitParam(name = "ddt", value = "数据字典类型对象[SysDataDictType]", paramType = "body", dataType = "SysDataDictType", required = true)})
    @RequestMapping(value = "addDataDictType", method = RequestMethod.POST)
    public ResponseResult addDataDictType( SysDataDictType ddt) throws Exception {
        dataDictService.addDataDictType(ddt);

        ResponseResult result = new ResponseResult();
        result.setCode(EnumResultType.SUCCESS.toString());
        result.setInfo(ApplicationConstant.SAVE_SUCCESS);

        return result;
    }

    /**
     * 编辑数据字典类型
     */
    @ApiOperation(value = "编辑数据字典类型")
    @ApiImplicitParams({@ApiImplicitParam(name = "ddt", value = "数据字典类型对象[SysDataDictType]", paramType = "body", dataType = "SysDataDictType", required = true)})
    @RequestMapping(value = "editDataDictType", method = RequestMethod.POST)
    public ResponseResult editDataDictType( SysDataDictType ddt) throws Exception {
        dataDictService.editDataDictType(ddt);

        ResponseResult result = new ResponseResult();
        result.setCode(EnumResultType.SUCCESS.toString());
        result.setInfo(ApplicationConstant.SAVE_SUCCESS);

        return result;
    }

    /**
     * 删除数据字典类型
     */
    @ApiOperation(value = "删除数据字典类型")
    @ApiImplicitParams({@ApiImplicitParam(name = "typeCode", value = "数据字典类型编码", paramType = "body", required = true)})
    @RequestMapping(value = "removeDataDictType", method = RequestMethod.POST)
    public ResponseResult removeDataDictType( String typeCode) throws Exception {
        dataDictService.removeDataDictType(typeCode);

        ResponseResult result = new ResponseResult();
        result.setCode(EnumResultType.SUCCESS.toString());
        result.setInfo(ApplicationConstant.REMOVE_SUCESS);

        return result;
    }

    /**
     * 获取数据字典项列表
     */
    @ApiOperation(value = "获取数据字典项列表")
    @ApiImplicitParams({@ApiImplicitParam(name = "typeCode", value = "数据字典类型编码", paramType = "query", required = true)})
    @RequestMapping(value = "getDataDictItemList", method = RequestMethod.GET)
    public ResponseResult getDataDictItemList(@RequestParam(value = "typeCode") String typeCode) throws Exception {
        List<SysDataDictItem> list = dataDictService.getDataDictItemList(typeCode);

        ResponseResult result = new ResponseResult();
        result.setCode(EnumResultType.SUCCESS.toString());
        result.setData(list);

        return result;
    }

    /**
     * 获取数据字典项信息
     */
    @ApiOperation(value = "获取数据字典项信息")
    @ApiImplicitParams({@ApiImplicitParam(name = "typeCode", value = "数据字典类型编码", paramType = "query", required = true)})
    @RequestMapping(value = "getDataDictItemInfo", method = RequestMethod.GET)
    public ResponseResult getDataDictItemInfo(@RequestParam(value = "typeCode") String typeCode, @RequestParam(value = "itemCode") String itemCode) throws Exception {
        SysDataDictItem ddi = dataDictService.getDataDictItemInfo(itemCode, typeCode);

        ResponseResult result = new ResponseResult();
        result.setCode(EnumResultType.SUCCESS.toString());
        result.setData(ddi);

        return result;
    }


    /**
     * 新建数据字典项
     */
    @ApiOperation(value = "新建数据字典项")
    @ApiImplicitParams({@ApiImplicitParam(name = "ddi", value = "数据字典项对象[SysDataDictItem]", paramType = "body", dataType = "SysDataDictItem", required = true)})
    @RequestMapping(value = "addDataDictItem", method = RequestMethod.POST)
    public ResponseResult addDataDictItem( SysDataDictItem ddi) throws Exception {
        dataDictService.addDataDictItem(ddi);

        ResponseResult result = new ResponseResult();
        result.setCode(EnumResultType.SUCCESS.toString());
        result.setInfo(ApplicationConstant.SAVE_SUCCESS);

        return result;
    }


    /**
     * 检查数据字典类型項是否存在
     */
    @ApiOperation(value = "检查数据字典类型項是否存在")
    @ApiImplicitParams(
            {@ApiImplicitParam(name = "typeCode", value = "数据字典类型编码", paramType = "query", required = true),
            @ApiImplicitParam(name = "itemCode", value = "数据字典項编码", paramType = "query", required = true)}
    )
    @RequestMapping(value = "checkDataDictItemCode", method = RequestMethod.GET)
    public boolean checkDataDictItemCode( String typeCode,String itemCode) throws Exception {
        boolean result;

        SysDataDictItem ddt = dataDictService.getDataDictItemInfo(itemCode,typeCode);

        if (ddt == null) {
            result = true;
        } else {
            result = false;
        }

        return result;
    }


    /**
     * 编辑数据字典项
     */
    @ApiOperation(value = "编辑数据字典项")
    @ApiImplicitParams({@ApiImplicitParam(name = "ddi", value = "数据字典项对象[SysDataDictItem]", paramType = "body", dataType = "SysDataDictItem", required = true)})
    @RequestMapping(value = "editDataDictItem", method = RequestMethod.POST)
    public ResponseResult editDataDictItem( SysDataDictItem ddi) throws Exception {
        dataDictService.editDataDictItem(ddi);

        ResponseResult result = new ResponseResult();
        result.setCode(EnumResultType.SUCCESS.toString());
        result.setInfo(ApplicationConstant.SAVE_SUCCESS);

        return result;
    }

    /**
     * 删除数据字典项
     */
    @ApiOperation(value = "删除数据字典项")
    @RequestMapping(value = "removeDataDictItem", method = RequestMethod.POST)
    public ResponseResult removeDataDictItem(String typeCode,String  itemCode) throws Exception {
        dataDictService.removeDataDictItem(typeCode, itemCode);

        ResponseResult result = new ResponseResult();
        result.setCode(EnumResultType.SUCCESS.toString());
        result.setInfo(ApplicationConstant.REMOVE_SUCESS);

        return result;
    }

}

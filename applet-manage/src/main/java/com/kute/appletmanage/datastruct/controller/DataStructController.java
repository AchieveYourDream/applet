package com.kute.appletmanage.datastruct.controller;

import com.kute.appletcore.entity.SysDataStructAttribute;
import com.kute.appletcore.entity.SysDataStructDefine;
import com.kute.appletcore.entity.SysDataStructNode;
import com.kute.appletcore.entity.SysDataStructNodeAttribute;
import com.kute.appletcore.enumeration.EnumResultType;
import com.kute.appletcore.util.ApplicationConstant;
import com.kute.appletcore.vo.ResponseResult;
import com.kute.appletcore.vo.SysDataStructAttributeVO;
import com.kute.appletcore.vo.SysDataStructDefineVO;
import com.kute.appletcore.vo.SysDataStructNodeAttributeVO;
import com.kute.appletmanage.datastruct.service.DataStructService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Name: 数据结构
 * @Description: 数据结构
 * @CreatedBy: zoran
 * @CreateDate: 2018-04-17
 * @LastUpdatedBy: zoran
 * @LastUpdateDate 2018-04-17
 */
@RestController
@RequestMapping("/app/system/datastruct/")
@Api(value = "DataStructController", tags = " 系统模块-数据结构")
public class DataStructController {

    @Autowired
    private DataStructService dataStructService;


    /**
     * 获取数据结构定义列表
     */
    @ApiOperation(value = "获取数据结构定义列表")
    @RequestMapping(value = "getDataStructDefineList", method = RequestMethod.GET)
    public ResponseResult getDataStructDefineList() throws Exception {
        List<SysDataStructDefineVO> list = dataStructService.getDataStructDefineList();

        ResponseResult result = new ResponseResult();
        result.setCode(EnumResultType.SUCCESS.toString());
        result.setData(list);

        return result;
    }

    /**
     * 获取数据结构定义信息
     */
    @ApiOperation(value = "获取数据结构定义信息")
    @ApiImplicitParams({@ApiImplicitParam(name = "structCode", value = "数据结构编码", paramType = "query", required = true)})
    @RequestMapping(value = "getDataStructDefineInfo", method = RequestMethod.GET)
    public ResponseResult getDataStructDefineInfo(@RequestParam(value = "structCode") String structCode) throws Exception {
        SysDataStructDefine dsd = dataStructService.getDataStructDefineInfo(structCode);

        ResponseResult result = new ResponseResult();
        result.setCode(EnumResultType.SUCCESS.toString());
        result.setData(dsd);

        return result;
    }

    /**
     * 检查数据结构编码是否存在
     */
    @ApiOperation(value = "检查数据结构编码是否存在")
    @ApiImplicitParams({@ApiImplicitParam(name = "structCode", value = "数据结构编码", paramType = "query", required = true)})
    @RequestMapping(value = "checkDataStructCode", method = RequestMethod.GET)
    public boolean checkDataStructCode(@RequestParam(value = "structCode") String structCode) throws Exception {
        boolean result;

        SysDataStructDefine dsd = dataStructService.getDataStructDefineInfo(structCode);

        if (dsd == null) {
            result = true;
        } else {
            result = false;
        }

        return result;
    }

    /**
     * 新建数据结构定义
     */
    @ApiOperation(value = "新建数据结构定义")
    @ApiImplicitParams({@ApiImplicitParam(name = "dsd", value = "数据结构定义对象[SysDataStructDefine]", paramType = "body", dataType = "SysDataStructDefine", required = true)})
    @RequestMapping(value = "addDataStructDefine", method = RequestMethod.POST)
    public ResponseResult addDataStructDefine( SysDataStructDefine dsd) throws Exception {
        dataStructService.addDataStructDefine(dsd);

        ResponseResult result = new ResponseResult();
        result.setCode(EnumResultType.SUCCESS.toString());
        result.setInfo(ApplicationConstant.SAVE_SUCCESS);

        return result;
    }

    /**
     * 编辑数据结构定义
     */
    @ApiOperation(value = "编辑数据结构定义")
    @ApiImplicitParams({@ApiImplicitParam(name = "dsd", value = "数据结构定义对象[SysDataStructDefine]", paramType = "body", dataType = "SysDataStructDefine", required = true)})
    @RequestMapping(value = "editDataStructDefine", method = RequestMethod.POST)
    public ResponseResult editDataStructDefine( SysDataStructDefine dsd) throws Exception {
        dataStructService.editDataStructDefine(dsd);

        ResponseResult result = new ResponseResult();
        result.setCode(EnumResultType.SUCCESS.toString());
        result.setInfo(ApplicationConstant.SAVE_SUCCESS);

        return result;
    }

    /**
     * 删除数据结构定义
     */
    @ApiOperation(value = "删除数据结构定义")
    @ApiImplicitParams({@ApiImplicitParam(name = "structCode", value = "数据结构编码", paramType = "body", required = true)})
    @RequestMapping(value = "removeDataStructDefine", method = RequestMethod.POST, consumes = "text/plain")
    public ResponseResult removeDataStructDefine( String structCode) throws Exception {
        dataStructService.removeDataStructDefine(structCode);

        ResponseResult result = new ResponseResult();
        result.setCode(EnumResultType.SUCCESS.toString());
        result.setInfo(ApplicationConstant.REMOVE_SUCESS);

        return result;
    }

    /**
     * 获取数据结构属性列表
     */
    @ApiOperation(value = "获取数据结构属性列表")
    @ApiImplicitParams({@ApiImplicitParam(name = "structCode", value = "数据结构编码", paramType = "query", required = true)})
    @RequestMapping(value = "getDataStructAttributeList", method = RequestMethod.GET)
    public ResponseResult getDataStructAttributeList(@RequestParam(value = "structCode") String structCode) throws Exception {
        List<SysDataStructAttributeVO> list = dataStructService.getDataStructAttributeList(structCode);

        ResponseResult result = new ResponseResult();
        result.setCode(EnumResultType.SUCCESS.toString());
        result.setData(list);

        return result;
    }

    /**
     * 获取数据结构属性信息
     */
    @ApiOperation(value = "获取数据结构属性信息")
    @ApiImplicitParams({@ApiImplicitParam(name = "structCode", value = "数据结构编码", paramType = "query", required = true),
            @ApiImplicitParam(name = "attributeCode", value = "数据结构属性编码", paramType = "query", required = true)})
    @RequestMapping(value = "getDataStructAttributeInfo", method = RequestMethod.GET)
    public ResponseResult getDataStructAttributeInfo(@RequestParam(value = "structCode") String structCode,
                                                     @RequestParam(value = "attributeCode") String attributeCode) throws Exception {
        SysDataStructAttributeVO dsaVO = dataStructService.getDataStructAttributeInfo(structCode, attributeCode);

        ResponseResult result = new ResponseResult();
        result.setCode(EnumResultType.SUCCESS.toString());
        result.setData(dsaVO);

        return result;
    }

    /**
     * 检查数据结构属性编码是否存在
     */
    @ApiOperation(value = "检查数据结构属性编码是否存在")
    @ApiImplicitParams({@ApiImplicitParam(name = "structCode", value = "数据结构编码", paramType = "query", required = true),
            @ApiImplicitParam(name = "attributeCode", value = "数据结构属性编码", paramType = "query", required = true)})
    @RequestMapping(value = "checkDataStructAttributeCode", method = RequestMethod.GET)
    public boolean checkDataStructAttributeCode(@RequestParam(value = "structCode") String structCode,
                                                @RequestParam(value = "attributeCode") String attributeCode) throws Exception {
        boolean result;

        SysDataStructAttributeVO dsaVO = dataStructService.getDataStructAttributeInfo(structCode, attributeCode);

        if (dsaVO == null) {
            result = true;
        } else {
            result = false;
        }

        return result;
    }

    /**
     * 新建数据结构属性
     */
    @ApiOperation(value = "新建数据结构属性")
    @ApiImplicitParams({@ApiImplicitParam(name = "dsa", value = "数据结构属性对象[SysDataStructAttribute]", paramType = "body", dataType = "SysDataStructAttribute", required = true)})
    @RequestMapping(value = "addDataStructAttribute", method = RequestMethod.POST)
    public ResponseResult addDataStructAttribute( SysDataStructAttribute dsa) throws Exception {
        dataStructService.addDataStructAttribute(dsa);

        ResponseResult result = new ResponseResult();
        result.setCode(EnumResultType.SUCCESS.toString());
        result.setInfo(ApplicationConstant.SAVE_SUCCESS);

        return result;
    }

    /**
     * 编辑数据结构属性
     */
    @ApiOperation(value = "编辑数据结构属性")
    @ApiImplicitParams({@ApiImplicitParam(name = "dsa", value = "数据结构属性对象[SysDataStructAttribute]", paramType = "body", dataType = "SysDataStructAttribute", required = true)})
    @RequestMapping(value = "editDataStructAttribute", method = RequestMethod.POST)
    public ResponseResult editDataStructAttribute( SysDataStructAttribute dsa) throws Exception {
        dataStructService.editDataStructAttribute(dsa);

        ResponseResult result = new ResponseResult();
        result.setCode(EnumResultType.SUCCESS.toString());
        result.setInfo(ApplicationConstant.SAVE_SUCCESS);

        return result;
    }

    /**
     * 删除数据结构属性
     */
    @ApiOperation(value = "删除数据结构属性")
    @ApiImplicitParams({@ApiImplicitParam(name = "structCode", value = "数据结构编码", paramType = "query", required = true),
            @ApiImplicitParam(name = "attributeCode", value = "数据结构属性编码", paramType = "query", required = true)})
    @RequestMapping(value = "removeDataStructAttribute", method = RequestMethod.GET)
    public ResponseResult removeDataStructAttribute(@RequestParam(value = "structCode") String structCode,
                                                    @RequestParam(value = "attributeCode") String attributeCode) throws Exception {
        dataStructService.removeDataStructAttribute(structCode, attributeCode);

        ResponseResult result = new ResponseResult();
        result.setCode(EnumResultType.SUCCESS.toString());
        result.setInfo(ApplicationConstant.REMOVE_SUCESS);

        return result;
    }

    /**
     * 获取数据结构节点树
     */
    @ApiOperation(value = "获取数据结构节点树")
    @ApiImplicitParams({@ApiImplicitParam(name = "structCode", value = "数据结构编码", paramType = "query", required = true)})
    @RequestMapping(value = "getDataStructNodeTree", method = RequestMethod.GET)
    public ResponseResult getDataStructNodeTree(@RequestParam(value = "structCode") String structCode) throws Exception {
        String tree = dataStructService.getDataStructNodeTree(structCode);

        ResponseResult result = new ResponseResult();
        result.setCode(EnumResultType.SUCCESS.toString());
        result.setData(tree);

        return result;
    }

    /**
     * 获取数据结构节点信息
     */
    @ApiOperation(value = "获取数据结构节点信息")
    @ApiImplicitParams({@ApiImplicitParam(name = "structCode", value = "数据结构编码", paramType = "query", required = true),
            @ApiImplicitParam(name = "nodeCode", value = "数据结构节点编码", paramType = "query", required = true)})
    @RequestMapping(value = "getDataStructNodeInfo", method = RequestMethod.GET)
    public ResponseResult getDataStructNodeInfo(@RequestParam(value = "structCode") String structCode,
                                                @RequestParam(value = "nodeCode") String nodeCode) throws Exception {
        SysDataStructNode dsn = dataStructService.getDataStructNodeInfo(structCode, nodeCode);

        ResponseResult result = new ResponseResult();
        result.setCode(EnumResultType.SUCCESS.toString());
        result.setData(dsn);

        return result;
    }

    /**
     * 检查数据结构节点编码是否存在
     */
    @ApiOperation(value = "检查数据结构节点编码是否存在")
    @ApiImplicitParams({@ApiImplicitParam(name = "structCode", value = "数据结构编码", paramType = "query", required = true),
            @ApiImplicitParam(name = "nodeCode", value = "数据结构节点编码", paramType = "query", required = true),
            @ApiImplicitParam(name = "nodeCodeRule", value = "数据结构节点编码规则", paramType = "query", required = true)})
    @RequestMapping(value = "checkDataStructNodeCode", method = RequestMethod.GET)
    public boolean checkDataStructNodeCode(@RequestParam(value = "structCode") String structCode,
                                           @RequestParam(value = "nodeCode") String nodeCode,
                                           @RequestParam(value = "nodeCodeRule") String nodeCodeRule) throws Exception {
        boolean result = false;

        if ("manual".equals(nodeCodeRule)) {
            SysDataStructNode dsn = dataStructService.getDataStructNodeInfo(structCode, nodeCode);

            if (dsn == null) {
                result = true;
            } else {
                result = false;
            }
        } else if ("auto".equals(nodeCodeRule)) {
            result = true;
        }

        return result;
    }

    /**
     * 新建数据结构节点
     */
    @ApiOperation(value = "新建数据结构节点")
    @ApiImplicitParams({@ApiImplicitParam(name = "dsn", value = "数据结构节点对象[SysDataStructNode]", paramType = "body", dataType = "SysDataStructNode", required = true)})
    @RequestMapping(value = "addDataStructNode", method = RequestMethod.POST)
    public ResponseResult addDataStructNode( SysDataStructNode dsn) throws Exception {
        dataStructService.addDataStructNode(dsn);

        ResponseResult result = new ResponseResult();
        result.setCode(EnumResultType.SUCCESS.toString());
        result.setInfo(ApplicationConstant.SAVE_SUCCESS);

        return result;
    }

    /**
     * 编辑数据结构节点
     */
    @ApiOperation(value = "编辑数据结构节点")
    @ApiImplicitParams({@ApiImplicitParam(name = "dsn", value = "数据据结节点对象[SysDataStructNode]", paramType = "body", dataType = "SysDataStructNode", required = true)})
    @RequestMapping(value = "editDataStructNode", method = RequestMethod.POST)
    public ResponseResult editDataStructNode( SysDataStructNode dsn) throws Exception {
        dataStructService.editDataStructNode(dsn);

        ResponseResult result = new ResponseResult();
        result.setCode(EnumResultType.SUCCESS.toString());
        result.setInfo(ApplicationConstant.SAVE_SUCCESS);

        return result;
    }

    /**
     * 删除数据结构节点
     */
    @ApiOperation(value = "删除数据结构节点")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "nodeCode", value = "数据结构节点编码", paramType = "query", required = true),
            @ApiImplicitParam(name = "structCode", value = "数据结构编码", paramType = "query", required = true)})
    @RequestMapping(value = "removeDataStructNode", method = RequestMethod.POST)
    public ResponseResult removeDataStructNode(@RequestParam(value = "nodeCode") String nodeCode, @RequestParam(value = "structCode") String structCode) throws Exception {
        dataStructService.removeDataStructNode(structCode, nodeCode);
        ResponseResult result = new ResponseResult();
        result.setCode(EnumResultType.SUCCESS.toString());
        result.setInfo(ApplicationConstant.REMOVE_SUCESS);

        return result;
    }

    /**
     * 获取数据结构节点属性列表
     */
    @ApiOperation(value = "获取数据结构节点属性列表")
    @ApiImplicitParams({@ApiImplicitParam(name = "structCode", value = "数据结构编码", paramType = "query", required = true),
            @ApiImplicitParam(name = "nodeCode", value = "数据结构节点编码", paramType = "query", required = true)})
    @RequestMapping(value = "getDataStructNodeAttributeList", method = RequestMethod.GET)
    public ResponseResult getDataStructNodeAttributeList(@RequestParam(value = "structCode") String structCode,
                                                         @RequestParam(value = "nodeCode") String nodeCode) throws Exception {
        List<SysDataStructNodeAttributeVO> list = dataStructService.getDataStructNodeAttributeList(structCode, nodeCode);

        ResponseResult result = new ResponseResult();
        result.setCode(EnumResultType.SUCCESS.toString());
        result.setData(list);

        return result;
    }

    /**
     * 保存数据结构节点属性
     */
    @ApiOperation(value = "保存数据结构节点属性")
    @ApiImplicitParams({@ApiImplicitParam(name = "dsnaList", value = "数据结构节点属性对象[List<SysDataStructNodeAttributeVO>]", paramType = "body", dataType = "List<SysDataStructNodeAttributeVO>", required = true)})
    @RequestMapping(value = "saveDataStructNodeAttributes", method = RequestMethod.POST)
    public ResponseResult saveDataStructNodeAttributes(@RequestBody List<SysDataStructNodeAttribute> dsnaList) throws Exception {
        dataStructService.saveDataStructNodeAttributes(dsnaList);

        ResponseResult result = new ResponseResult();
        result.setCode(EnumResultType.SUCCESS.toString());
        result.setInfo(ApplicationConstant.SAVE_SUCCESS);

        return result;
    }

//    /**
//     * 获取菜单树
//     */
//    @ApiOperation(value = "获取菜单树")
//    @ApiImplicitParams({@ApiImplicitParam(name = "userid", value = "数据结构编码", paramType = "query", required = true)})
//    @RequestMapping(value = "getMenuTree", method = RequestMethod.GET)
//    public ResponseResult getMenuTree(@RequestParam(value = "userid") String userid) throws Exception {
//        String json = dataStructService.getMenuTree(userid);
//        return new  ResponseResult("S",json);
//    }

}

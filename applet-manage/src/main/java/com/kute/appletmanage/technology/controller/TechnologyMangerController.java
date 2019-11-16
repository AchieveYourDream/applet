package com.kute.appletmanage.technology.controller;

import com.github.pagehelper.PageInfo;
import com.kute.appletcore.entity.AppTechnologyAttribute;
import com.kute.appletcore.entity.AppTechnologyNode;
import com.kute.appletcore.enumeration.EnumResultType;
import com.kute.appletcore.util.ApplicationConstant;
import com.kute.appletcore.vo.ResponseResult;
import com.kute.appletmanage.technology.service.TechnologyMangerService;
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
 * @Name: 工艺管理
 * @Description: 工艺管理
 */
@RestController
@RequestMapping("/app/system/technology/")
@Api(value = "TechnologyMangerController", tags = " 系统模块-工艺管理")
public class TechnologyMangerController {

    @Autowired
    private TechnologyMangerService technologyMangerService;

    /**
     * 获取工艺节点树
     */
    @ApiOperation(value = "获取工艺节点树")
    @RequestMapping(value = "getTechnologyNodeTree", method = RequestMethod.GET)
    public ResponseResult getTechnologyNodeTree() throws Exception {
        String tree = technologyMangerService.getTechnologyNodeTree();

        ResponseResult result = new ResponseResult();
        result.setCode(EnumResultType.SUCCESS.toString());
        result.setData(tree);

        return result;
    }

    /**
     * 获取工艺节点信息
     */
    @ApiOperation(value = "获取工艺节点信息")
    @ApiImplicitParam(name = "nodeCode", value = "工艺节点编码", paramType = "query", required = true)
    @RequestMapping(value = "getTechnologyNodeInfo", method = RequestMethod.GET)
    public ResponseResult getTechnologyNodeInfo(@RequestParam(value = "nodeCode") String nodeCode) throws Exception {
        AppTechnologyNode appTechnologyNode = technologyMangerService.getTechnologyNodeInfo(nodeCode);

        ResponseResult result = new ResponseResult();
        result.setCode(EnumResultType.SUCCESS.toString());
        result.setData(appTechnologyNode);

        return result;
    }

    /**
     * 检查工艺节点编码是否存在
     */
    @ApiOperation(value = "检查工艺节点编码是否存在")
    @ApiImplicitParam(name = "nodeCode", value = "工艺节点编码", paramType = "query", required = true)
    @RequestMapping(value = "checkTechnologyNodeCode", method = RequestMethod.GET)
    public boolean checkTechnologyNodeCode(
            @RequestParam(value = "nodeCode") String nodeCode ) throws Exception {

        AppTechnologyNode appTechnologyNode = technologyMangerService.getTechnologyNodeInfo(nodeCode);

        if (appTechnologyNode == null) {
            return  true;
        } else {
            return  false;
        }

    }

    /**
     * 新建工艺节点
     */
    @ApiOperation(value = "新建工艺节点")
    @ApiImplicitParams({@ApiImplicitParam(name = "appTechnologyNode", value = "工艺节点对象[SysTechnologyNode]", paramType = "body", dataType = "SysTechnologyNode", required = true)})
    @RequestMapping(value = "addTechnologyNode", method = RequestMethod.POST)
    public ResponseResult addTechnologyNode(AppTechnologyNode appTechnologyNode) throws Exception {
        technologyMangerService.addTechnologyNode(appTechnologyNode);

        ResponseResult result = new ResponseResult();
        result.setCode(EnumResultType.SUCCESS.toString());
        result.setInfo(ApplicationConstant.SAVE_SUCCESS);

        return result;
    }

    /**
     * 编辑工艺节点
     */
    @ApiOperation(value = "编辑工艺节点")
    @ApiImplicitParams({@ApiImplicitParam(name = "appTechnologyNode", value = "数据据结节点对象[SysTechnologyNode]", paramType = "body", dataType = "SysTechnologyNode", required = true)})
    @RequestMapping(value = "editTechnologyNode", method = RequestMethod.POST)
    public ResponseResult editTechnologyNode(AppTechnologyNode appTechnologyNode) throws Exception {
        technologyMangerService.editTechnologyNode(appTechnologyNode);

        ResponseResult result = new ResponseResult();
        result.setCode(EnumResultType.SUCCESS.toString());
        result.setInfo(ApplicationConstant.SAVE_SUCCESS);

        return result;
    }

    /**
     * 删除工艺节点
     */
    @ApiOperation(value = "删除工艺节点")
    @ApiImplicitParam(name = "nodeCode", value = "工艺节点编码", paramType = "query", required = true)
    @RequestMapping(value = "removeTechnologyNode", method = RequestMethod.POST)
    public ResponseResult removeTechnologyNode(@RequestParam(value = "nodeCode") String nodeCode) throws Exception {
        technologyMangerService.removeTechnologyNode(nodeCode);
        ResponseResult result = new ResponseResult();
        result.setCode(EnumResultType.SUCCESS.toString());
        result.setInfo(ApplicationConstant.REMOVE_SUCESS);

        return result;
    }


    /**
     * 获取工艺列表
     */
    @ApiOperation(value = "获取工艺列表")
    @RequestMapping(value = "getTechnologyList", method = RequestMethod.GET)
    public Map getTechnologyList(Integer pageNum, Integer pageSize, String nodeCode, String search) throws Exception {
        Map dataMap = new HashMap();
        PageInfo<AppTechnologyAttribute> list = technologyMangerService.getTechnologyList(pageNum, pageSize, nodeCode, search);

        dataMap.put("total", list.getTotal());
        dataMap.put("rows", list.getList());

        return dataMap;
    }

    /**
     * 获取工艺信息
     */
    @ApiOperation(value = "获取工艺信息")
    @ApiImplicitParams({@ApiImplicitParam(name = "TechnologyId", value = "工艺ID", paramType = "query", required = true)})
    @RequestMapping(value = "getTechnologyInfoByTechnologyId", method = RequestMethod.GET)
    public ResponseResult getTechnologyInfoByTechnologyId(@RequestParam(value = "technologyId") Integer technologyId) throws Exception {
        AppTechnologyAttribute technology = technologyMangerService.getTechnologyInfoByTechnologyAttributeId(technologyId);

        ResponseResult result = new ResponseResult();
        result.setCode(EnumResultType.SUCCESS.toString());
        result.setData(technology);

        return result;
    }


    /**
     * 新增工艺
     */
    @ApiOperation(value = "新增工艺")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "technology", value = "工艺对象[AppTechnology]", paramType = "body", dataType = "AppTechnology", required = true)})
    @RequestMapping(value = "addTechnology", method = RequestMethod.POST)
    public ResponseResult addTechnology(AppTechnologyAttribute technology) throws Exception {
        return technologyMangerService.addTechnology(technology);

    }

    /**
     * 编辑工艺
     */
    @ApiOperation(value = "编辑工艺")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "su", value = "工艺对象[AppTechnology]", paramType = "body", dataType = "AppTechnology", required = true)})
    @RequestMapping(value = "editTechnology", method = RequestMethod.POST)
    public ResponseResult editTechnology(AppTechnologyAttribute technology) throws Exception {

        return technologyMangerService.editTechnology(technology);
    }


    /**
     * 删除工艺
     */
    @ApiOperation(value = "删除工艺")
    @ApiImplicitParams({@ApiImplicitParam(name = "technologyId", value = "工艺id", paramType = "query", required = true)})
    @RequestMapping(value = "removeTechnology", method = RequestMethod.POST)
    public ResponseResult removeTechnology(@RequestParam(value = "technologyId") Integer technologyId) throws Exception {
        technologyMangerService.removeTechnology(technologyId);
        ResponseResult result = new ResponseResult();
        result.setCode(EnumResultType.SUCCESS.toString());
        result.setInfo(ApplicationConstant.REMOVE_SUCESS);

        return result;
    }



    /**
     * 设置工艺默认值
     */
    @ApiOperation(value = "设置工艺默认值")
    @ApiImplicitParams({@ApiImplicitParam(name = "technologyId", value = "工艺id", paramType = "query", required = true),
            @ApiImplicitParam(name = "nodeCode", value = "节点ID", paramType = "query", required = true)

    })
    @RequestMapping(value = "updateTechnologyDefault", method = RequestMethod.POST)
    public ResponseResult updateTechnologyDefault(@RequestParam(value = "technologyId") Integer technologyId,@RequestParam(value = "nodeCode") String nodeCode) throws Exception {
        technologyMangerService.updateTechnologyDefault(technologyId,nodeCode);
        ResponseResult result = new ResponseResult();
        result.setCode(EnumResultType.SUCCESS.toString());
        result.setInfo(ApplicationConstant.REMOVE_SUCESS);

        return result;
    }




}

package com.kute.appletmanage.user.controller;

import com.github.pagehelper.PageInfo;
import com.kute.appletcore.entity.SysUser;
import com.kute.appletcore.enumeration.EnumResultType;
import com.kute.appletcore.util.ApplicationConstant;
import com.kute.appletcore.util.MD5Util;
import com.kute.appletcore.vo.ResponseResult;
import com.kute.appletmanage.user.service.UserService;
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
 * @Name: 用户管理
 * @Description: 用户管理
 */
@RestController
@RequestMapping("/app/system/user/")
@Api(value = "UserController", tags = " 系统模块-用户管理")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 获取用户列表
     */
    @ApiOperation(value = "获取用户列表")
    @RequestMapping(value = "getUserList", method = RequestMethod.GET)
    public Map getUserList(Integer pageNum, Integer pageSize, String search) throws Exception {
        Map dataMap = new HashMap();
        PageInfo<SysUser> list =  userService.getUserList( pageNum,  pageSize,  search);

        dataMap.put("total", list.getTotal());
        dataMap.put("rows", list.getList());

        return dataMap;
    }

    /**
     * 获取用户信息
     */
    @ApiOperation(value = "获取用户信息")
    @ApiImplicitParams({@ApiImplicitParam(name = "userId", value = "用户ID", paramType = "query", required = true)})
    @RequestMapping(value = "getUserInfoByUserId", method = RequestMethod.GET)
    public ResponseResult getUserInfoByUserId(@RequestParam(value = "userName") String userName) throws Exception {
        SysUser su = userService.getUserInfoByUserName(userName);

        ResponseResult result = new ResponseResult();
        result.setCode(EnumResultType.SUCCESS.toString());
        result.setData(su);

        return result;
    }

    /**
     * 检查用户名是否存在
     */
    @ApiOperation(value = "检查用户名是否存在")
    @ApiImplicitParams({@ApiImplicitParam(name = "userName", value = "用户名", paramType = "query", required = true)})
    @RequestMapping(value = "checkUserName", method = RequestMethod.GET)
    public boolean checkUserName(@RequestParam(value = "userName") String userName) throws Exception {
        boolean result;

        SysUser su = userService.getUserInfoByUserName(userName);

        if (su == null) {
            result = true;
        } else {
            result = false;
        }

        return result;
    }

    /**
     * 新增用户
     */
    @ApiOperation(value = "新增用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "su", value = "用户对象[SysUser]", paramType = "body", dataType = "SysUser", required = true)})
    @RequestMapping(value = "addUser", method = RequestMethod.POST)
    public ResponseResult addUser( SysUser su) throws Exception {
        su.setPassword(MD5Util.MD5("123456"));
        if(su.getHeadPortrait()==null || su.getHeadPortrait().equals("")){
            su.setHeadPortrait("default.png");
        }
        userService.addUser(su);
        ResponseResult result = new ResponseResult();
        result.setCode(EnumResultType.SUCCESS.toString());
        result.setInfo(ApplicationConstant.SAVE_SUCCESS);

        return result;
    }

    /**
     * 编辑用户
     */
    @ApiOperation(value = "编辑用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "su", value = "用户对象[SysUser]", paramType = "body", dataType = "SysUser", required = true)})
    @RequestMapping(value = "editUser", method = RequestMethod.POST)
    public ResponseResult editUser( SysUser su) throws Exception {
        if(su.getHeadPortrait()==null || su.getHeadPortrait().equals("")){
            su.setHeadPortrait("default.png");
        }
        userService.editUser(su);
        ResponseResult result = new ResponseResult();
        result.setCode(EnumResultType.SUCCESS.toString());
        result.setInfo(ApplicationConstant.SAVE_SUCCESS);
        return result;
    }

    /**
     * 修改用户状态
     */
    @ApiOperation(value = "修改用户状态")
    @RequestMapping(value = "updateUserStatus", method = RequestMethod.POST)
    public ResponseResult updateUserStatus(@RequestParam String  userName,@RequestParam String userState) throws Exception {
        userService.updateUserStatus(userName, userState);
        ResponseResult result = new ResponseResult();
        result.setCode(EnumResultType.SUCCESS.toString());
        result.setInfo(ApplicationConstant.SAVE_SUCCESS);

        return result;
    }

    /**
     * 删除用户
     */
    @ApiOperation(value = "删除用户")
    @ApiImplicitParams({@ApiImplicitParam(name = "user_id", value = "用户id", paramType = "query", required = true)})
    @RequestMapping(value = "removeUser", method = RequestMethod.POST)
    public ResponseResult removeUser(@RequestParam(value = "userName") String userName) throws Exception {
        userService.removeUser(userName);
        ResponseResult result = new ResponseResult();
        result.setCode(EnumResultType.SUCCESS.toString());
        result.setInfo(ApplicationConstant.REMOVE_SUCESS);

        return result;
    }


    /**
     * 重置密码
     */
    @ApiOperation(value = "重置密码")
    @RequestMapping(value = "resetPassword", method = RequestMethod.POST)
    public ResponseResult resetPassword(@RequestParam String  userName) throws Exception {
        userService.resetPassword(userName);
        ResponseResult result = new ResponseResult();
        result.setCode(EnumResultType.SUCCESS.toString());
        result.setInfo(ApplicationConstant.SAVE_SUCCESS);
        return result;
    }

}

//package com.kute.appletmanage.user.controller;
//
//import com.kute.appletcore.entity.SysUser;
//import com.kute.appletcore.entity.SysUserRole;
//import com.kute.appletcore.enumeration.EnumResultType;
//import com.kute.appletcore.util.ApplicationConstant;
//import com.kute.appletcore.util.MD5Util;
//import com.kute.appletcore.vo.ResponseResult;
//import com.kute.appletcore.vo.SysUserRoleVO;
//import com.kute.appletcore.vo.SysUserVO;
//import com.kute.appletmanage.user.service.UserService;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiImplicitParam;
//import io.swagger.annotations.ApiImplicitParams;
//import io.swagger.annotations.ApiOperation;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Map;
//
///**
// * @Name: 用户管理
// * @Description: 用户管理
// */
//@RestController
//@RequestMapping("/app/system/user/")
//@Api(value = "UserController", tags = " 系统模块-用户管理")
//public class UserController {
//
//    @Autowired
//    private UserService userService;
//
//    /**
//     * 获取用户列表
//     */
//    @ApiOperation(value = "获取用户列表")
//    @RequestMapping(value = "getUserList", method = RequestMethod.GET)
//    public ResponseResult getUserList() throws Exception {
//        List<SysUserVO> list = userService.getUserList();
//
//        ResponseResult result = new ResponseResult();
//        result.setCode(EnumResultType.SUCCESS.toString());
//        result.setData(list);
//
//        return result;
//    }
//
//    /**
//     * 获取用户信息
//     */
//    @ApiOperation(value = "获取用户信息")
//    @ApiImplicitParams({@ApiImplicitParam(name = "userId", value = "用户ID", paramType = "query", required = true)})
//    @RequestMapping(value = "getUserInfoByUserId", method = RequestMethod.GET)
//    public ResponseResult getUserInfoByUserId(@RequestParam(value = "userId") String userId) throws Exception {
//        SysUser su = userService.getUserInfoByUserId(userId);
//
//        ResponseResult result = new ResponseResult();
//        result.setCode(EnumResultType.SUCCESS.toString());
//        result.setData(su);
//
//        return result;
//    }
//
//    /**
//     * 检查用户名是否存在
//     */
//    @ApiOperation(value = "检查用户名是否存在")
//    @ApiImplicitParams({@ApiImplicitParam(name = "userName", value = "用户名", paramType = "query", required = true)})
//    @RequestMapping(value = "checkUserName", method = RequestMethod.GET)
//    public boolean checkUserName(@RequestParam(value = "userName") String userName) throws Exception {
//        boolean result;
//
//        SysUser su = userService.getUserInfoByUserName(userName);
//
//        if (su == null) {
//            result = true;
//        } else {
//            result = false;
//        }
//
//        return result;
//    }
//
//    /**
//     * 新增用户
//     */
//    @ApiOperation(value = "新增用户")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "su", value = "用户对象[SysUser]", paramType = "body", dataType = "SysUser", required = true)})
//    @RequestMapping(value = "addUser", method = RequestMethod.POST)
//    public ResponseResult addUser( SysUser su) throws Exception {
//        su.setPassword(MD5Util.MD5("123456"));
////        su.setUser_type("1");
//        userService.addUser(su);
//        ResponseResult result = new ResponseResult();
//        result.setCode(EnumResultType.SUCCESS.toString());
//        result.setInfo(ApplicationConstant.SAVE_SUCCESS);
//
//        return result;
//    }
//
//    /**
//     * 编辑用户
//     */
//    @ApiOperation(value = "编辑用户")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "su", value = "用户对象[SysUser]", paramType = "body", dataType = "SysUser", required = true)})
//    @RequestMapping(value = "editUser", method = RequestMethod.POST)
//    public ResponseResult editUser( SysUser su) throws Exception {
//
//        userService.editUser(su);
//        ResponseResult result = new ResponseResult();
//        result.setCode(EnumResultType.SUCCESS.toString());
//        result.setInfo(ApplicationConstant.SAVE_SUCCESS);
//        return result;
//    }
//
//    /**
//     * 修改用户状态
//     */
//    @ApiOperation(value = "修改用户状态")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "body", value = "用户ID和用户状态[{\"userId\":\"\",\"userStatus\":\"\"}]", paramType = "body", required = true)})
//    @RequestMapping(value = "updateUserStatus", method = RequestMethod.POST)
//    public ResponseResult updateUserStatus( Map<String, String> body) throws Exception {
//        userService.updateUserStatus(body.get("userId"), body.get("userStatus"));
//
//        ResponseResult result = new ResponseResult();
//        result.setCode(EnumResultType.SUCCESS.toString());
//        result.setInfo(ApplicationConstant.SAVE_SUCCESS);
//
//        return result;
//    }
//
//    /**
//     * 修改用户皮肤
//     */
//    @ApiOperation(value = "修改用户皮肤")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "body", value = "用户ID和皮肤[{\"userId\":\"\",\"skin\":\"\"}]", paramType = "body", required = true)})
//    @RequestMapping(value = "updateUserSkin", method = RequestMethod.POST)
//    public ResponseResult updateUserSkin( Map<String, String> body) throws Exception {
//        userService.updateUserSkin(body.get("userId"), body.get("skin"));
//
//        ResponseResult result = new ResponseResult();
//        result.setCode(EnumResultType.SUCCESS.toString());
//        result.setInfo(ApplicationConstant.SAVE_SUCCESS);
//
//        return result;
//    }
//
//    /**
//     * 获取用户角色信息
//     */
//    @ApiOperation(value = "获取用户角色信息")
//    @ApiImplicitParams({@ApiImplicitParam(name = "userId", value = "用户ID", paramType = "query", required = true)})
//    @RequestMapping(value = "getUserRoleList", method = RequestMethod.GET)
//    public ResponseResult getUserRoleList(@RequestParam(value = "userId") String userId) throws Exception {
//        List<SysUserRoleVO> list = userService.getUserRoleList(userId);
//
//        ResponseResult result = new ResponseResult();
//        result.setCode(EnumResultType.SUCCESS.toString());
//        result.setData(list);
//
//        return result;
//    }
//
//    /**
//     * 新增用户角色
//     */
//    @ApiOperation(value = "新增用户角色")
//    @ApiImplicitParams({@ApiImplicitParam(name = "user_id", value = "用户id", paramType = "query", required = false),
//            @ApiImplicitParam(name = "role_id", value = "角色i", paramType = "query", required = false)})
//    @RequestMapping(value = "addUserRole", method = RequestMethod.POST)
//    public ResponseResult addUserRole(@RequestParam(value = "user_id") String user_id, @RequestParam(value = "role_id") String role_id) throws Exception {
//        SysUserRole sur = new SysUserRole();
//        sur.setRole_id(role_id);
//        sur.setUser_id(user_id);
//
//        userService.addUserRole(sur);
//
//        ResponseResult result = new ResponseResult();
//        result.setCode(EnumResultType.SUCCESS.toString());
//        result.setInfo(ApplicationConstant.SAVE_SUCCESS);
//
//        return result;
//    }
//
//    /**
//     * 删除用户
//     */
//    @ApiOperation(value = "删除用户")
//    @ApiImplicitParams({@ApiImplicitParam(name = "user_id", value = "用户id", paramType = "query", required = true)})
//    @RequestMapping(value = "removeUser", method = RequestMethod.POST)
//    public ResponseResult removeUser(@RequestParam(value = "user_id") String user_id) throws Exception {
//        userService.removeUser(user_id);
//        ResponseResult result = new ResponseResult();
//        result.setCode(EnumResultType.SUCCESS.toString());
//        result.setInfo(ApplicationConstant.REMOVE_SUCESS);
//
//        return result;
//    }
//
//
//    /**
//     * 删除用户角色
//     */
//    @ApiOperation(value = "删除用户角色")
//
//    @ApiImplicitParams({@ApiImplicitParam(name = "user_id", value = "用户id", paramType = "query", required = false),
//            @ApiImplicitParam(name = "role_id", value = "角色i", paramType = "query", required = false)})
//    @RequestMapping(value = "removeUserRole", method = RequestMethod.POST)
//    public ResponseResult removeUserRole(@RequestParam(value = "user_id") String user_id, @RequestParam(value = "role_id") String role_id) throws Exception {
//        userService.removeUserRole(user_id, role_id);
//
//        ResponseResult result = new ResponseResult();
//        result.setCode(EnumResultType.SUCCESS.toString());
//        result.setInfo(ApplicationConstant.REMOVE_SUCESS);
//
//        return result;
//    }
//
//}

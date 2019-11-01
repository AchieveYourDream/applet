package com.kute.appletmanage.security.controller;

import com.kute.appletcore.vo.ResponseResult;
import com.kute.appletmanage.security.service.SecurityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Name: 安全
 * @Description: 安全
 * @CreatedBy: zoran
 * @CreateDate: 2018-04-20
 * @LastUpdatedBy: zoran
 * @LastUpdateDate 2018-04-20
 */
@RestController
@Api(value = "SecurityController", tags = "  安全模块")
public class SecurityController {

    @Autowired
    private SecurityService securityService;

    /**
     * 登录
     */
    @SuppressWarnings("rawtypes")
    @ApiOperation(value = "登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "login_username", value = "用户", paramType = "query", dataType = "string", required = true),
            @ApiImplicitParam(name = "login_password", value = "密码", paramType = "query", dataType = "string", required = true)}
            )
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseResult login( String  login_username,  String  login_password) throws Exception {
        return securityService.login(login_username,login_password);
    }

    /**
     * 获取菜单树
     */
    @RequestMapping(value = "/app/getMenuTree", method = RequestMethod.POST)
    public  ResponseResult getMenuTree(String  username) throws Exception {

        return securityService.getMenuTree(username);
    }

//    /**
//     * 获取图形验证码
//     */
//    @ApiOperation(value = "获取验证码")
//    @RequestMapping(value = "/getImageVerificationCode", method = RequestMethod.GET)
//    public ResponseResult getImageVerificationCode() throws Exception {
//        Map<String, String> map = securityService.getImageVerificationCode();
//
//        ResponseResult result = new ResponseResult();
//        result.setCode(EnumResultType.SUCCESS.toString());
//        result.setData(map);
//
//        return result;
//    }

//    @ApiOperation(value = "验证token并返回新token")
//    @RequestMapping(value = "/verifyToken", method = RequestMethod.POST)
//    public ResponseResult verifyToken(@RequestBody Map<String, String> map) throws Exception {
//        String username = map.get("username").toString();
//        String token = map.get("token").toString();
//        token = token.replaceAll(" ", "+");
//        token = token.replaceAll("%3D", "=");
//        token = token.replaceAll("%2F", "/");
//        return securityService.verifyToken(username, token);
//    }
//
//    @ApiOperation(value = "修改密码")
//    @ApiImplicitParams({@ApiImplicitParam(name = "username", value = "用户id", paramType = "query", required = true),
//            @ApiImplicitParam(name = "oldPassword", value = "原密码", paramType = "query", required = true),
//            @ApiImplicitParam(name = "newPassword", value = "新密码", paramType = "query", required = true)})
//    @RequestMapping(value = "/updatePassword", method = RequestMethod.POST)
//    public ResponseResult updatePassword(@RequestParam(value = "username") String username, @RequestParam(value = "oldPassword") String oldPassword, @RequestParam(value = "newPassword") String newPassword) throws Exception {
//        return securityService.changePassword(username, oldPassword, newPassword);
//    }
//
//    @ApiOperation("重置密码")
//    @ApiImplicitParams({@ApiImplicitParam(name = "username", value = "用户id", paramType = "query", required = true)})
//    @RequestMapping(value = "/resetPassword", method = RequestMethod.POST)
//    public ResponseResult resetPassword(@RequestParam(value = "username") String username) throws Exception {
//        return securityService.resetPassword(username);
//    }
//
//
//    /**
//     * 发送短信验证码
//     */
//    @ApiOperation(value = " 发送短信验证码")
//    @ApiImplicitParam(name = "username", value = "用户名", required = true, dataType = "string", paramType = "query")
//    @RequestMapping(value = "SendSmsVerificationCode", method = RequestMethod.GET)
//    public ResponseResult SendSmsVerificationCode(String username) throws Exception {
//        return securityService.SendSmsVerificationCode(username);
//    }

}

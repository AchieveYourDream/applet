package com.kute.appletmanage.security.service;

import com.kute.appletcore.vo.ResponseResult;

import java.util.Map;

/**
 * @ClaseName
 * @Auther 王斌
 * @Date
 **/
public interface SecurityService {

    ResponseResult login(String  login_username,String  login_password) throws Exception;

    Map<String, String> getImageVerificationCode();

    ResponseResult  getMenuTree(String username) throws Exception;
}

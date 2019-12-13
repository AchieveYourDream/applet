package com.kute.appletweb.pay.controller;

import com.github.pagehelper.PageInfo;
import com.kute.appletcore.entity.SysFabric;
import com.kute.appletweb.pay.service.PayService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClaseName
 * @Auther 王斌
 * @Date
 **/
@RestController
@RequestMapping(value="/api/pay/")
public class payController {


    @Autowired
    private PayService payService;

    /**
     * 微信支付接口回调
     */
    @ApiOperation(value = "微信支付接口回调")
    @RequestMapping(value = "notifyWeiXinPay", method = RequestMethod.POST)
    public void notifyWeiXinPay(HttpServletRequest request, HttpServletResponse response) throws Exception {
         payService.notifyWeiXinPay( request,  response);
    }

}

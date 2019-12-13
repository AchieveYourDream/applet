package com.kute.appletweb.pay.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface PayService {

  /** 
  * @Description: 微信支付接口回调
  * @Author: 王斌
  * @Date: 2019/12/11 
  */ 
    void notifyWeiXinPay(HttpServletRequest request, HttpServletResponse response) throws IOException;
}

package com.kute.appletweb.pay.impl;

import cn.hutool.core.date.SystemClock;
import cn.hutool.http.HttpUtil;
import com.kute.appletcore.dao.AppMemberMapper;
import com.kute.appletcore.entity.AppMember;
import com.kute.appletcore.util.IpUtil;
import com.kute.appletcore.util.JsonUtil;
import com.kute.appletcore.util.RandomUtil;
import com.kute.appletcore.util.weixin.WxChatXmlUtil;
import com.kute.appletcore.vo.OrderHeadVO;
import com.kute.appletweb.order.dao.OrderWebMapper;
import com.kute.appletweb.pay.service.PayService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @ClaseName
 * @Auther 王斌
 * @Date
 **/
@Service
@Transactional(rollbackFor = Exception.class)
public class PayServiceImpl implements PayService {
    private static Logger log = LoggerFactory.getLogger(PayServiceImpl.class);
    //小程序appid
    @Value("${wx.appid}")
    private String wxAppId;
    //小程序secret
    @Value("${wx.secret}")
    private String wxSecret;
    //小程序mch_id
    @Value("${wx.mchId}")
    private String mchId;
    //小程序key
    @Value("${wx.key}")
    private String wxkey;
    //小程序key
    @Value("${wx.payUrl}")
    private String payUrl;
    //小程序回调地址
    @Value("${wx.notify}")
    private String notify;

    @Autowired
    AppMemberMapper appMemberMapper;
    @Autowired
    OrderWebMapper orderWebMapper;

    /**
     * @Description: 获得请求微信支付参数
     * @Author: 王斌
     * @Date: 2019/12/10
     */

    public Map<String, Object> wxPay(OrderHeadVO order, HttpServletRequest request) throws Exception {

        // 组装微信支付参数
        SortedMap<String, Object> params = new TreeMap<>();
        params.put("appid", wxAppId);
        params.put("mch_id", mchId);
        params.put("nonce_str", RandomUtil.generateRandomCode("letter", 32)); // 随机字符串
        params.put("out_trade_no", order.getPackagecode()); // 商户订单编号
        params.put("body", order.getPackagecode() + "【" + order.getMemberName() + "】"); //
        params.put("total_fee", order.getPayPrice().multiply(new BigDecimal(100)).intValue());// 支付金额
        params.put("notify_url", notify);// 回调地址
        params.put("trade_type", "JSAPI");// 交易类型APP
        params.put("spbill_create_ip", IpUtil.getIpAddr(request));

        // 根据登录获得openid
        //查询有没有会员信息
        AppMember member = appMemberMapper.selectByPrimaryKey(order.getMemberId());
        params.put("openid", member.getOpenId());

        // 签名
        WxChatXmlUtil wxChatXmlUtil = new WxChatXmlUtil();
        String sign = wxChatXmlUtil.createSign(params, wxkey);
        params.put("sign", sign);
        String xml = wxChatXmlUtil.recursionMapToXml(params);

        String response = HttpUtil.post(payUrl, xml);
        Map<String, String> resultMap = wxChatXmlUtil.xml2ToMap(response);
        if ("FAIL".equals(resultMap.get("return_code"))) {
            throw new Exception("支付失败," + resultMap.get("return_msg"));
        } else if ("SUCCESS".equals(resultMap.get("return_code"))) {
            // 返回数据
            if ("FAIL".equals(resultMap.get("result_code"))) {
                throw new Exception("支付失败," + resultMap.get("err_code_des"));
            } else if ("SUCCESS".equals(resultMap.get("result_code"))) {
                SortedMap<String, Object> resultObj = new TreeMap<>();
                resultObj.put("appId", wxAppId);
                resultObj.put("timeStamp", SystemClock.now() / 1000);
                resultObj.put("nonceStr", RandomUtil.generateRandomCode("letter", 32));
                resultObj.put("package", "prepay_id=" + resultMap.get("prepay_id"));
                resultObj.put("signType", "MD5");

                // 签名
                String paySign = wxChatXmlUtil.createSign(params, wxkey);
                resultObj.put("paySign", paySign);
                return resultObj;
            }
        }
        throw new Exception("下单失败");
    }

    /**
     * @Description: 回调方法
     * @Author: 王斌
     * @Date: 2019/12/11
     */
    public void notifyWeiXinPay(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Map<String, String> resultMap = null;
        WxChatXmlUtil wxChatXmlUtil = new WxChatXmlUtil();
        InputStream inStream = request.getInputStream();
        ByteArrayOutputStream outSteam = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        while ((len = inStream.read(buffer)) != -1) {
            outSteam.write(buffer, 0, len);
        }
        String resultXml = new String(outSteam.toByteArray(), "utf-8");
        resultMap = wxChatXmlUtil.xml2ToMap(resultXml);
        outSteam.close();
        inStream.close();
        log.info("支付回调返回参数：" + JsonUtil.getJSONFromMap(resultMap));
        if (resultMap.get("return_code").equals("FAIL")) {
            // 总单号
            String out_trade_no = resultMap.get("out_trade_no");
            System.out.println("订单" + out_trade_no + "支付失败");
            log.info("订单" + out_trade_no + "支付失败");

            response.getWriter().write("<SUCCESS>OK</SUCCESS>");
        } else if (resultMap.get("return_code").equals("SUCCESS")) {
            // 总单号
            String out_trade_no = resultMap.get("out_trade_no");
            System.out.println("订单" + out_trade_no + "支付成功");
            log.info("订单" + out_trade_no + "支付成功");
            // 业务处理 更新并提交订单
            orderWebMapper.updateOrderPayState(out_trade_no, JsonUtil.getJSONFromMap(resultMap));

            response.getWriter().write("<SUCCESS>OK</SUCCESS>");
        }
    }
}

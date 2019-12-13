package com.kute.appletcore.util.weixin;

import com.kute.appletcore.util.http.HttpClientConstant;
import com.kute.appletcore.util.http.HttpClientRequest;
import com.kute.appletcore.util.http.HttpClientResponse;
import com.kute.appletcore.util.http.HttpClientUtil;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClaseName
 * @Auther 王斌
 * @Date
 **/
public class  WeChatUtil {

    //小程序appid
    @Value("${wx.appid}")
    private String wxAppId;
    //小程序secret
    @Value("${wx.secret}")
    private String wxSecret;
    //小程序mch_id
    @Value("${wx.mchId}")
    private String mchId;


    /**
     * @Description: 获取openid发起微信支付
     * @Author: 王斌
     * @Date: 2019/12/10
     */
    public Map getOpenId(String code) throws  Exception {
        Map map=new HashMap();
        //小程序 access_token获取
        HttpClientRequest requestGet = new HttpClientRequest();
//      System.out.println("https://api.weixin.qq.com/sns/jscode2session?appid="+measureAppid+"&secret="+measureSecret+"&js_code="+code+"&grant_type=authorization_code");
        requestGet.setRequestUrl("https://api.weixin.qq.com/sns/jscode2session?appid="+wxAppId+"&secret="+wxSecret+"&js_code="+code+"&grant_type=authorization_code");
        requestGet.setRequestMehtod(HttpClientConstant.REQUEST_METHOD_GET);

        HttpClientResponse responeGet = HttpClientUtil.sendHttpRequest(requestGet);
        if ("Y".equals(responeGet.getResponseCode())) {
            JSONObject jsonObject = JSONObject.fromObject(responeGet.getResponseData());
            System.out.println(jsonObject.get("errcode"));
            if(jsonObject.get("openid")!=null && !jsonObject.get("openid").equals("")) {
                map.put("code","S");
                map.put("info",jsonObject.getString("openid"));
                return map;
            }else{
                map.put("code","E");
                map.put("info",jsonObject.getString("errmsg"));
            }
        }else{
            map.put("code","E");
            map.put("info","获取小程序oppid失败");
        }
        return map;
    }
}

package com.kute.appletcore.util.submail;


import com.kute.appletcore.util.http.HttpClientConstant;
import com.kute.appletcore.util.http.HttpClientRequest;
import com.kute.appletcore.util.http.HttpClientResponse;
import com.kute.appletcore.util.http.HttpClientUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * 赛邮工具类
 */
@SuppressWarnings("all")
public class SubmailUtil {

	/**
	 * 发送短信
	 * @param telephone 收件人手机号
	 * @param vars 文本变量[JSON字符串]
	 * @param appId 短信应用ID
	 * @param appKey 短信应用秘钥
	 * @param templateId 短信模板ID
	 * @param apiUrl API的地址
	 */
	public static HttpClientResponse sendSMS(String telephone, String vars, String appId, String appKey,
											 String templateId, String apiUrl) throws Exception {
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("appid", appId);
		paramMap.put("signature", appKey);
		paramMap.put("project", templateId);
		paramMap.put("to", telephone);
		paramMap.put("vars", vars);
		
		HttpClientRequest requestPost = new HttpClientRequest();
		requestPost.setRequestUrl(apiUrl);
		requestPost.setRequestMehtod(HttpClientConstant.REQUEST_METHOD_POST);
		requestPost.setRequestHeaders(null);
		requestPost.setRequestBody(null);
		requestPost.setRequestParams(paramMap);
		requestPost.setContentType(HttpClientConstant.CONTENT_TYPE_FORM);
		
		HttpClientResponse responePost = HttpClientUtil.sendHttpRequest(requestPost);
		
		return responePost;
	}
	
//	public static void main(String[] args) throws Exception {
//		String memebrTel="15908931375";
//		String  memberName="王斌";
//		String vars = "{\"name\":\"" + memberName + "\"}";
//		String appId = "12858";
//		String appKey = "5e1f6aa019d2dd869b5a8bb1c887f413";
//		String templateId = "wpZqS4";
//		String apiUrl = "https://api.mysubmail.com/message/xsend";
//		SubmailUtil.sendSMS(memebrTel, vars, appId, appKey, templateId, apiUrl);

//	}

}

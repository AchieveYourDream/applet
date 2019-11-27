package com.kute.appletcore.util.http;

import com.google.common.collect.Lists;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;

import javax.net.ssl.*;
import java.io.IOException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.List;
import java.util.Map;

/**
 * HttpClient工具类
 */
@SuppressWarnings("all")
public class HttpClientUtil {
	
	private final static Logger logger = LoggerFactory.getLogger(HttpClientUtil.class);
	
	/**
	 * 发起HTTP请求
	 * @param request HTTP请求封装类
	 */
	public static HttpClientResponse sendHttpRequest(HttpClientRequest request) {
		HttpClientResponse response = new HttpClientResponse();

		// HttpClient对象
		CloseableHttpClient httpClient = null;

		// HTTP响应对象
		CloseableHttpResponse httpResponse = null;

		logger.info("==========ThirdParty HttpClientRequest Begin==========");
		
		try {
			logger.info("RequestUrl=" + request.getRequestUrl());
			logger.info("RequestMethod=" + request.getRequestMehtod());
			logger.info("ContentType=" + request.getContentType());
			
			// 判断请求协议
			String prococol = HttpClientConstant.HTTP_PROTOCOL;
			if (request.getRequestUrl().contains(HttpClientConstant.HTTPS_PROTOCOL)) {
				prococol = HttpClientConstant.HTTPS_PROTOCOL;
			}
			
			// 初始化HttpClient对象
			httpClient = createHttpClient(prococol);
			
			// 设置请求和传输超时时间
			RequestConfig requestConfig = RequestConfig.custom()
					.setConnectTimeout(HttpClientConstant.CONNECT_TIMEOUT)
					.setSocketTimeout(HttpClientConstant.SOCKET_TIMEOUT).build();

			if (HttpClientConstant.REQUEST_METHOD_GET.equals(request.getRequestMehtod())) {
				// 初始化GET请求
				HttpGet httpGet = new HttpGet(request.getRequestUrl());
				// 设置超时时间
				httpGet.setConfig(requestConfig);
				
				// 请求头
				Map<String, String> headerMap = request.getRequestHeaders();
				if (headerMap != null && headerMap.size() > 0) {
					for (Map.Entry<String, String> entry : headerMap.entrySet()) {
						httpGet.setHeader(entry.getKey(), entry.getValue());
					}
				}
				
				// 执行GET请求，返回Response对象
				httpResponse = httpClient.execute(httpGet);
			} else if (HttpClientConstant.REQUEST_METHOD_POST.equals(request.getRequestMehtod())) {
				// 初始化POST请求
				HttpPost httpPost = new HttpPost(request.getRequestUrl());
				// 设置超时时间
				httpPost.setConfig(requestConfig);
				
				// 请求头
				Map<String, String> headerMap = request.getRequestHeaders();
				if (headerMap != null && headerMap.size() > 0) {
					for (Map.Entry<String, String> entry : headerMap.entrySet()) {
						httpPost.setHeader(entry.getKey(), entry.getValue());
					}
				}
				
				if (HttpClientConstant.CONTENT_TYPE_FORM.equals(request.getContentType())) {
					Map<String, String> paramMap = request.getRequestParams();
					if (paramMap != null && paramMap.size() > 0) {
						logger.info("RequestParamsSize=" + paramMap.size());
						
						List<NameValuePair> paramList = Lists.newArrayList();
						for (Map.Entry<String, String> entry : paramMap.entrySet()) {
							logger.info(entry.getKey() + "=" + entry.getValue());
							
							paramList.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
						}
						httpPost.setEntity(new UrlEncodedFormEntity(paramList, Consts.UTF_8));
					}
				} else if (HttpClientConstant.CONTENT_TYPE_TEXT.equals(request.getContentType())) {
					logger.info("RequestBody=" + request.getRequestBody());
					
					StringEntity entity = new StringEntity(request.getRequestBody(), HttpClientConstant.DEFAULT_CHARSET);    
					entity.setContentEncoding(HttpClientConstant.DEFAULT_CHARSET);    
					entity.setContentType(HttpClientConstant.CONTENT_TYPE_TEXT);    
					httpPost.setEntity(entity);
				} else if (HttpClientConstant.CONTENT_TYPE_JSON.equals(request.getContentType())) {
					logger.info("RequestBody=" + request.getRequestBody());
					
					StringEntity entity = new StringEntity(request.getRequestBody(), HttpClientConstant.DEFAULT_CHARSET);    
					entity.setContentEncoding(HttpClientConstant.DEFAULT_CHARSET);    
					entity.setContentType(HttpClientConstant.CONTENT_TYPE_JSON);    
					httpPost.setEntity(entity);
				} else if (HttpClientConstant.CONTENT_TYPE_XML.equals(request.getContentType())) {
					logger.info("RequestBody=" + request.getRequestBody());
					
					StringEntity entity = new StringEntity(request.getRequestBody(), HttpClientConstant.DEFAULT_CHARSET);    
					entity.setContentEncoding(HttpClientConstant.DEFAULT_CHARSET);    
					entity.setContentType(HttpClientConstant.CONTENT_TYPE_XML);    
					httpPost.setEntity(entity);
				}
				
				// 执行POST请求，返回Response对象
				httpResponse = httpClient.execute(httpPost);
			} 

			// 获取响应状态行
			StatusLine statusLine = httpResponse.getStatusLine();
			// 获取响应状态码
			int statusCode = statusLine.getStatusCode();
			
			logger.info("statusCode=" + statusCode);

			if (statusCode == HttpStatus.OK.value()) { // 200:请求成功
				// 获取响应消息体
				HttpEntity entity = httpResponse.getEntity();
				// 获取消息体文本
				String body = EntityUtils.toString(entity, HttpClientConstant.DEFAULT_CHARSET);
				
				logger.info("ResponseBody=" + body);
				
				response.setResponseCode("Y");
				response.setResponseData(body);
			} else {
				// 获取响应消息体
				HttpEntity entity = httpResponse.getEntity();
				// 获取消息体文本
				String body = EntityUtils.toString(entity, HttpClientConstant.DEFAULT_CHARSET);

				logger.info("ResponseBody=" + body);
				
				response.setResponseCode("N");
				response.setResponseData(statusCode + ":" + HttpStatus.valueOf(statusCode).name());
			}
		} catch (Exception e) {

			e.printStackTrace();
			
			response.setResponseCode("N");
			response.setResponseData("服务器内部发生异常:" + e.getMessage());
		} finally {
			if (httpResponse != null) {
				try {
					httpResponse.close();
				} catch (IOException e) {

					e.printStackTrace();

					response.setResponseCode("N");
					response.setResponseData("关闭HttpResponse异常！");
				}
			}
			if (httpClient != null) {
				try {
					httpClient.close();
				} catch (IOException e) {

					e.printStackTrace();

					response.setResponseCode("N");
					response.setResponseData("关闭HttpClient异常！");
				}
			}
		}
		
		logger.info("==========ThirdParty HttpClientRequest End==========");

		return response;
	}
	
	/**
	 * 根据请求协议创建Httpclient对象
	 * @param protocol 请求协议[http/https]
	 */
	private static CloseableHttpClient createHttpClient(String protocol) throws Exception {
		CloseableHttpClient httpClient = null;
		if (HttpClientConstant.HTTP_PROTOCOL.equals(protocol)) {
			httpClient = HttpClients.createDefault();
		} else if(HttpClientConstant.HTTPS_PROTOCOL.equals(protocol)) {
			SSLContext sslcontext = SSLContext.getInstance("TLS");
			sslcontext.init(null, new TrustManager[] { new TrustAnyTrustManager() },
					new SecureRandom());
			SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslcontext,
					new HostnameVerifier() {
						@Override
						public boolean verify(String paramString, SSLSession paramSSLSession) {
							return true;
						}
					});
			httpClient = HttpClients.custom().setSSLSocketFactory(sslsf).build();
		}
		return httpClient;
	}
	
	/**
     * 自定义静态私有类：信任管理器
     */
	private static class TrustAnyTrustManager implements X509TrustManager {
		public void checkClientTrusted(X509Certificate[] chain, String authType)
				throws CertificateException {
		}

		public void checkServerTrusted(X509Certificate[] chain, String authType)
				throws CertificateException {
		}

		public X509Certificate[] getAcceptedIssuers() {
			return new X509Certificate[] {};
		}
	}
	
//	public static void main(String[] args) throws Exception {
//		// GET
//		HttpClientRequest requestGet = new HttpClientRequest();
//		requestGet.setRequestUrl("https://xls.magicmanufactory.com:7778/tsp-api/api/public/test/testQueryParameter?name=aizheng");
//		requestGet.setRequestMehtod(HttpClientConstant.REQUEST_METHOD_GET);
//		requestGet.setRequestHeaders(null);
//		requestGet.setRequestBody(null);
//		requestGet.setRequestParams(null);
//		requestGet.setContentType(null);
//		
//		HttpClientResponse responeGet = sendHttpRequest(requestGet);
//		System.out.println(responeGet.getResponseCode());
//		System.out.println(responeGet.getResponseData());
//		System.out.println("--------------------------------------------------");
//		
		// POST
//		String json = "{\"token\":\"0DAB4E29DEB3477E9FB2CC73C0F1D358\",\"data\":\"{\"SerType\":\"GetAll\",\"dataJson\":\"{\"ItemCode\":\"SS0005\",\"WhsCode\":\"SS0005\"}\",\"DocType\":\"OMS_Style\"}\",\"message\":\"\",\"status\":-1}";
//
//		HttpClientRequest requestPost = new HttpClientRequest();
//		requestPost.setRequestUrl("http://nena.3322.org:8081/api/Interact");
//		requestPost.setRequestMehtod(HttpClientConstant.REQUEST_METHOD_POST);
//		requestPost.setRequestHeaders(null);
//		requestPost.setRequestBody(json);
//		requestPost.setRequestParams(null);
//		requestPost.setContentType(HttpClientConstant.CONTENT_TYPE_JSON);
//
//		HttpClientResponse responePost = sendHttpRequest(requestPost);
//		System.out.println(responePost.getResponseCode());
//		System.out.println(responePost.getResponseData());
//		System.out.println("--------------------------------------------------");
//		
//		// HEADER
//		Map<String, String> headerMap = new HashMap<String, String>();
//		headerMap.put("TSPSSOTOken", "TimeSharePlatformTenantSSOToken367bd463597b4a2ab23a808088adb75020170907163023");
//		
//		HttpClientRequest requestHeader = new HttpClientRequest();
//		requestHeader.setRequestUrl("https://xls.magicmanufactory.com:7778/tsp-api/api/private/test/testToken?name=aizheng");
//		requestHeader.setRequestMehtod(HttpClientConstant.REQUEST_METHOD_GET);
//		requestHeader.setRequestHeaders(headerMap);
//		requestHeader.setRequestBody(null);
//		requestHeader.setRequestParams(null);
//		requestHeader.setContentType(null);
//		
//		HttpClientResponse responeHeader = sendHttpRequest(requestHeader);
//		System.out.println(responeHeader.getResponseCode());
//		System.out.println(responeHeader.getResponseData());
//		System.out.println("--------------------------------------------------");
//	    Map<String,String> map=new HashMap<String,String>();
//		map.put("return_number","KTC2MSW000190401002");
//		map.put("status", "Y");
//		HttpClientUtil clien=new HttpClientUtil();
//		HttpClientRequest requestPost = new HttpClientRequest();
//		requestPost.setRequestUrl("https://xls.magicmanufactory.com:7778//spmtm/warehousReturn/updateReturnAmount");
//		requestPost.setRequestMehtod(HttpClientConstant.REQUEST_METHOD_POST);
//		requestPost.setRequestHeaders(null);
//		requestPost.setRequestBody(null);
//		requestPost.setRequestParams(map);
//		requestPost.setContentType(HttpClientConstant.CONTENT_TYPE_FORM);
//		
//		HttpClientResponse responePost = clien.sendHttpRequest(requestPost);
//		if(responePost.getResponseCode().equals("Y")){
//		    JSONObject jsStr = JSONObject.fromObject(responePost.getResponseData());
//		   String  result_code =jsStr.getString("result_code");
//		    if(result_code.equals("Y")){
//			System.out.println("操作成功");
//		    }else{
//			 System.out.println(jsStr.getString("result_info"));
//		    }
//		}else{
//		    throw new Exception("调用小酷传递退货单状态失败");
//		}
		
//	}
}

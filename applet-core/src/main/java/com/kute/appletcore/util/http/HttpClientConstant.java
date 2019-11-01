package com.kute.appletcore.util.http;

@SuppressWarnings("all")
public class HttpClientConstant {

	// 默认字符集
	public static final String DEFAULT_CHARSET = "UTF-8";
	
	// HTTP协议
	public static final String HTTP_PROTOCOL = "http";
	// HTTPS协议
	public static final String HTTPS_PROTOCOL = "https";
	
	// 连接超时时间:1分钟
	public static final int CONNECT_TIMEOUT = 60000;
	// 数据传输超时时间:10分钟
	public static final int SOCKET_TIMEOUT = 600000;
	
	// 表单提交，默认值，以键值对形式[key1=val1&key2=val2&...keyn=valn]提交数据
	public static final String CONTENT_TYPE_FORM = "application/x-www-form-urlencoded;charset=utf-8";
	// TEXT，以纯文本形式提交数据
	public static final String CONTENT_TYPE_TEXT = "text/plain;charset=utf-8";
	// JSON，以JSON字符串形式提交数据
	public static final String CONTENT_TYPE_JSON = "application/json;charset=utf-8";
	// XML,以XML字符串形式提交数据
	public static final String CONTENT_TYPE_XML = "application/xml;charset=utf-8";
	
	// HTTP请求方法:查询
	public static final String REQUEST_METHOD_GET = "GET";
	// HTTP请求方法:修改
	public static final String REQUEST_METHOD_POST = "POST";
	// HTTP请求方法:新增
	public static final String REQUEST_METHOD_PUT = "PUT";
	// HTTP请求方法:删除
	public static final String REQUEST_METHOD_DELETE = "DELETE";
	
}

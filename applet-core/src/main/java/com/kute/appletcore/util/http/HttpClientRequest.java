package com.kute.appletcore.util.http;

import java.util.Map;

@SuppressWarnings("all")
public class HttpClientRequest {

	private String requestUrl;

	private String requestMehtod;

	private Map<String, String> requestHeaders;

	private Map<String, String> requestParams;

	private String requestBody;

	private String contentType;

	public String getRequestUrl() {
		return requestUrl;
	}

	public void setRequestUrl(String requestUrl) {
		this.requestUrl = requestUrl;
	}

	public String getRequestMehtod() {
		return requestMehtod;
	}

	public void setRequestMehtod(String requestMehtod) {
		this.requestMehtod = requestMehtod;
	}

	public Map<String, String> getRequestHeaders() {
		return requestHeaders;
	}

	public void setRequestHeaders(Map<String, String> requestHeaders) {
		this.requestHeaders = requestHeaders;
	}

	public String getRequestBody() {
		return requestBody;
	}

	public void setRequestBody(String requestBody) {
		this.requestBody = requestBody;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public Map<String, String> getRequestParams() {
		return requestParams;
	}

	public void setRequestParams(Map<String, String> requestParams) {
		this.requestParams = requestParams;
	}

}

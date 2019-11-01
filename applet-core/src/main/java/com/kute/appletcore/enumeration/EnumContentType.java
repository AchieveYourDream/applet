package com.kute.appletcore.enumeration;

public enum EnumContentType {
	
	TEXT("text/plain;charset=UTF-8"),
	HTML("text/html;charset=UTF-8"),
	XML("text/xml;charset=UTF-8"),
	JSON("application/json;charset=UTF-8");
	
	private String contentType;

	EnumContentType(String contentType) {
		this.contentType = contentType;
	}
	
	public String toString() {
		return contentType;
	}
	
}

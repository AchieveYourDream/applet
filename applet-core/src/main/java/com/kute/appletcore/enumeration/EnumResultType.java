package com.kute.appletcore.enumeration;

public enum EnumResultType {
	
	SUCCESS("S"),
	ERROR("E"),
	WARN("W");
	
	private String resultType;

	EnumResultType(String resultType) {
		this.resultType = resultType;
	}
	
	public String toString() {
		return resultType;
	}
	
}

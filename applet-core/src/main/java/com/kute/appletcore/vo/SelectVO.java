package com.kute.appletcore.vo;

import org.apache.ibatis.type.Alias;

@Alias("SelectVO")
public class SelectVO {
    public String code;
    public String name;

    public String getCode() {
	return code;
    }

    public void setCode(String code) {
	this.code = code;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

}

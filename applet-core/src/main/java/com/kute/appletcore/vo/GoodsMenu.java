package com.kute.appletcore.vo;

import java.util.List;

public class GoodsMenu {
    private   String code;
    private   String name;
    private   boolean type=false;

    public boolean isType() {
        return type;
    }

    public void setType(boolean type) {
        this.type = type;
    }

    private   List<GoodsMenu> list;

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

    public List<GoodsMenu> getList() {
        return list;
    }

    public void setList(List<GoodsMenu> list) {
        this.list = list;
    }
}

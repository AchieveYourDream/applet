package com.kute.appletcore.vo;

import com.kute.appletcore.entity.AppTechnologyAttribute;
import com.kute.appletcore.entity.AppTechnologyNode;

import java.util.List;

/**
 * @ClaseName
 * @Auther 王斌
 * @Date
 **/
public class AppTechnologyNodeVO extends AppTechnologyNode {

    private List<AppTechnologyAttribute> list;

    public List<AppTechnologyAttribute> getList() {
        return list;
    }

    public void setList(List<AppTechnologyAttribute> list) {
        this.list = list;
    }
}

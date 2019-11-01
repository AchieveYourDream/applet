package com.kute.appletcore.vo;


import com.kute.appletcore.entity.SysLovColumn;
import com.kute.appletcore.entity.SysLovDefine;

import java.util.List;

/**
 * @Name:
 * @Description:
 * @CreatedBy: zoran
 * @CreateDate: 2018-04-18
 * @LastUpdatedBy: zoran
 * @LastUpdateDate 2018-04-18
 */
public class SysLovVO {

    private SysLovDefine sld;

    private List<SysLovColumn> slcList;

    public SysLovDefine getSld() {
        return sld;
    }

    public void setSld(SysLovDefine sld) {
        this.sld = sld;
    }

    public List<SysLovColumn> getSlcList() {
        return slcList;
    }

    public void setSlcList(List<SysLovColumn> slcList) {
        this.slcList = slcList;
    }

}

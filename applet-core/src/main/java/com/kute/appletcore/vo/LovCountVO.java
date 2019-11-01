package com.kute.appletcore.vo;

import com.kute.appletcore.entity.SysLovColumn;
import org.apache.ibatis.type.Alias;

import java.util.List;


@Alias("LovCountVO")
public class LovCountVO {
    private List<SysLovColumn> slcList;

    private String returnValueColumn;
    private String returnTextColumn;
    private String dataStr;

    public List<SysLovColumn> getSlcList() {
        return slcList;
    }

    public void setSlcList(List<SysLovColumn> slcList) {
        this.slcList = slcList;
    }

    public String getReturnValueColumn() {
        return returnValueColumn;
    }

    public void setReturnValueColumn(String returnValueColumn) {
        this.returnValueColumn = returnValueColumn;
    }

    public String getReturnTextColumn() {
        return returnTextColumn;
    }

    public void setReturnTextColumn(String returnTextColumn) {
        this.returnTextColumn = returnTextColumn;
    }

    public String getDataStr() {
        return dataStr;
    }

    public void setDataStr(String dataStr) {
        this.dataStr = dataStr;
    }


}

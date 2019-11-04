package com.kute.appletcore.vo;

import com.kute.appletcore.entity.SysParameterDefine;

import java.io.Serializable;

/**
 * @Name:
 * @Description:
 */
public class SysParameterDefineVO extends SysParameterDefine implements Serializable {

    private String elementTypeName;
    private String ddtText;
    private String dsText;
    private String lovText;

    private String parameterValue;


    public String getElementTypeName() {
        return elementTypeName;
    }

    public void setElementTypeName(String elementTypeName) {
        this.elementTypeName = elementTypeName;
    }

    public String getDdtText() {
        return ddtText;
    }

    public void setDdtText(String ddtText) {
        this.ddtText = ddtText;
    }

    public String getDsText() {
        return dsText;
    }

    public void setDsText(String dsText) {
        this.dsText = dsText;
    }

    public String getLovText() {
        return lovText;
    }

    public void setLovText(String lovText) {
        this.lovText = lovText;
    }

    public String getParameterValue() {
        return parameterValue;
    }

    public void setParameterValue(String parameterValue) {
        this.parameterValue = parameterValue;
    }
}

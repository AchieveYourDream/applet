package com.kute.appletcore.vo;


import com.kute.appletcore.entity.AppInformation;

import java.util.List;

public class InformationVO {
    private String chineseName;
    private String englishName;
   private List<AppInformation> list;
    private String nodeCode;

    public String getChineseName() {
        return chineseName;
    }

    public void setChineseName(String chineseName) {
        this.chineseName = chineseName;
    }

    public String getEnglishName() {
        return englishName;
    }

    public void setEnglishName(String englishName) {
        this.englishName = englishName;
    }

    public List<AppInformation> getList() {
        return list;
    }

    public void setList(List<AppInformation> list) {
        this.list = list;
    }

    public String getNodeCode() {
        return nodeCode;
    }

    public void setNodeCode(String nodeCode) {
        this.nodeCode = nodeCode;
    }
}

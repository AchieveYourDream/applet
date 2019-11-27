package com.kute.appletcore.vo;

/**
 * @ClaseName
 * @Auther 王斌
 * @Date
 **/
public class AppStitchWorkPositionVO {

    /**
     * id
     */
    private Integer id;

    /**
     * 位置名称
     */
    private String positionName;

    /**
     * 品类编码
     */
    private String categoryCode;

    private boolean state;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }
}


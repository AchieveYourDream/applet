package com.kute.appletcore.entity;

public class AppStitchWorkPosition {
    /**
     * id
     */
    private Integer id;

    /**
     * 位置名称
     */
    private String positionName;

    /**
     * 图片地址
     */
    private String positionImg;

    /**
     * 描述
     */
    private String description;

    /**
     * 工厂编码
     */
    private String factoryCode;

    /**
     * 品类编码
     */
    private String categoryCode;

    /**
     * id
     * @return id id
     */
    public Integer getId() {
        return id;
    }

    /**
     * id
     * @param id id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 位置名称
     * @return position_name 位置名称
     */
    public String getPositionName() {
        return positionName;
    }

    /**
     * 位置名称
     * @param positionName 位置名称
     */
    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    /**
     * 图片地址
     * @return position_img 图片地址
     */
    public String getPositionImg() {
        return positionImg;
    }

    /**
     * 图片地址
     * @param positionImg 图片地址
     */
    public void setPositionImg(String positionImg) {
        this.positionImg = positionImg;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 工厂编码
     * @return factory_code 工厂编码
     */
    public String getFactoryCode() {
        return factoryCode;
    }

    /**
     * 工厂编码
     * @param factoryCode 工厂编码
     */
    public void setFactoryCode(String factoryCode) {
        this.factoryCode = factoryCode;
    }

    /**
     * 品类编码
     * @return category_code 品类编码
     */
    public String getCategoryCode() {
        return categoryCode;
    }

    /**
     * 品类编码
     * @param categoryCode 品类编码
     */
    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }
}
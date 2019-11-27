package com.kute.appletcore.entity;

public class AppStitchWork {
    /**
     * id
     */
    private Integer id;

    /**
     * 刺绣名称
     */
    private String stitchWorkName;

    /**
     * 工厂编码
     */
    private String factoryCode;

    /**
     * 描述
     */
    private String description;

    /**
     * 图片地址
     */
    private String stitchWorkImg;

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
     * 刺绣名称
     * @return stitchWork_name 刺绣名称
     */
    public String getStitchWorkName() {
        return stitchWorkName;
    }

    /**
     * 刺绣名称
     * @param stitchWorkName 刺绣名称
     */
    public void setStitchWorkName(String stitchWorkName) {
        this.stitchWorkName = stitchWorkName;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 图片地址
     * @return stitchWork_img 图片地址
     */
    public String getStitchWorkImg() {
        return stitchWorkImg;
    }

    /**
     * 图片地址
     * @param stitchWorkImg 图片地址
     */
    public void setStitchWorkImg(String stitchWorkImg) {
        this.stitchWorkImg = stitchWorkImg;
    }
}
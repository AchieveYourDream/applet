package com.kute.appletcore.entity;

public class AppTechnologyAttribute {
    /**
     * 
     */
    private Integer id;

    /**
     * 工艺节点编码
     */
    private String nodeCode;

    /**
     * 工艺名称
     */
    private String technologyName;

    /**
     * 工厂编码
     */
    private String factoryCode;

    /**
     * 描述
     */
    private String description;

    /**
     * 是否默认
     */
    private String isDefault;

    /**
     * 是否造物可用
     */
    private String isZw;

    /**
     * 图片
     */
    private String technologyImg;

    /**
     * 价格
     */
    private String technologyPrice;

    /**
     * 款式
     */
    private String technologyStyle;

    /**
     * 
     * @return id 
     */
    public Integer getId() {
        return id;
    }

    /**
     * 
     * @param id 
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 工艺节点编码
     * @return node_code 工艺节点编码
     */
    public String getNodeCode() {
        return nodeCode;
    }

    /**
     * 工艺节点编码
     * @param nodeCode 工艺节点编码
     */
    public void setNodeCode(String nodeCode) {
        this.nodeCode = nodeCode;
    }

    /**
     * 工艺名称
     * @return technology_name 工艺名称
     */
    public String getTechnologyName() {
        return technologyName;
    }

    /**
     * 工艺名称
     * @param technologyName 工艺名称
     */
    public void setTechnologyName(String technologyName) {
        this.technologyName = technologyName;
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
     * 描述
     * @return description 描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 描述
     * @param description 描述
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 是否默认
     * @return is_default 是否默认
     */
    public String getIsDefault() {
        return isDefault;
    }

    /**
     * 是否默认
     * @param isDefault 是否默认
     */
    public void setIsDefault(String isDefault) {
        this.isDefault = isDefault;
    }

    /**
     * 是否造物可用
     * @return is_zw 是否造物可用
     */
    public String getIsZw() {
        return isZw;
    }

    /**
     * 是否造物可用
     * @param isZw 是否造物可用
     */
    public void setIsZw(String isZw) {
        this.isZw = isZw;
    }

    /**
     * 图片
     * @return technology_img 图片
     */
    public String getTechnologyImg() {
        return technologyImg;
    }

    /**
     * 图片
     * @param technologyImg 图片
     */
    public void setTechnologyImg(String technologyImg) {
        this.technologyImg = technologyImg;
    }

    /**
     * 价格
     * @return technology_price 价格
     */
    public String getTechnologyPrice() {
        return technologyPrice;
    }

    /**
     * 价格
     * @param technologyPrice 价格
     */
    public void setTechnologyPrice(String technologyPrice) {
        this.technologyPrice = technologyPrice;
    }

    /**
     * 款式
     * @return technology_style 款式
     */
    public String getTechnologyStyle() {
        return technologyStyle;
    }

    /**
     * 款式
     * @param technologyStyle 款式
     */
    public void setTechnologyStyle(String technologyStyle) {
        this.technologyStyle = technologyStyle;
    }
}
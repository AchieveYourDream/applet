package com.kute.appletcore.entity;

public class SysFabric {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 面料号
     */
    private String code;

    /**
     * 分类
     */
    private String category;

    /**
     * 颜色
     */
    private String color;

    /**
     * 成分
     */
    private String component;

    /**
     * 品牌
     */
    private String brand;

    /**
     * 纱织
     */
    private String yarn;

    /**
     * 花型
     */
    private String flower;

    /**
     * Y启用，N停用,R删除
     */
    private String status;

    /**
     * 相似面料号
     */
    private String similar;

    /**
     * 比例
     */
    private String proportion;

    /**
     * 图片名称
     */
    private String imageName;

    /**
     * 图片地址
     */
    private String imagePath;

    /**
     * 替换面料
     */
    private String replacecode;

    /**
     * 库存
     */
    private Integer repertory;

    /**
     * 库存面料号
     */
    private String stockcode;

    /**
     * 创建时间
     */
    private String createDate;

    /**
     * 修改时间
     */
    private String lastUpdateDate;


    /**
     * 主键
     * @return id 主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 主键
     * @param id 主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 面料号
     * @return code 面料号
     */
    public String getCode() {
        return code;
    }

    /**
     * 面料号
     * @param code 面料号
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 分类
     * @return category 分类
     */
    public String getCategory() {
        return category;
    }

    /**
     * 分类
     * @param category 分类
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * 颜色
     * @return color 颜色
     */
    public String getColor() {
        return color;
    }

    /**
     * 颜色
     * @param color 颜色
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * 成分
     * @return component 成分
     */
    public String getComponent() {
        return component;
    }

    /**
     * 成分
     * @param component 成分
     */
    public void setComponent(String component) {
        this.component = component;
    }

    /**
     * 品牌
     * @return brand 品牌
     */
    public String getBrand() {
        return brand;
    }

    /**
     * 品牌
     * @param brand 品牌
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * 纱织
     * @return yarn 纱织
     */
    public String getYarn() {
        return yarn;
    }

    /**
     * 纱织
     * @param yarn 纱织
     */
    public void setYarn(String yarn) {
        this.yarn = yarn;
    }

    /**
     * 花型
     * @return flower 花型
     */
    public String getFlower() {
        return flower;
    }

    /**
     * 花型
     * @param flower 花型
     */
    public void setFlower(String flower) {
        this.flower = flower;
    }

    /**
     * Y启用，N停用,R删除
     * @return status Y启用，N停用,R删除
     */
    public String getStatus() {
        return status;
    }

    /**
     * Y启用，N停用,R删除
     * @param status Y启用，N停用,R删除
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 相似面料号
     * @return similar 相似面料号
     */
    public String getSimilar() {
        return similar;
    }

    /**
     * 相似面料号
     * @param similar 相似面料号
     */
    public void setSimilar(String similar) {
        this.similar = similar;
    }

    /**
     * 比例
     * @return proportion 比例
     */
    public String getProportion() {
        return proportion;
    }

    /**
     * 比例
     * @param proportion 比例
     */
    public void setProportion(String proportion) {
        this.proportion = proportion;
    }

    /**
     * 图片名称
     * @return image_name 图片名称
     */
    public String getImageName() {
        return imageName;
    }

    /**
     * 图片名称
     * @param imageName 图片名称
     */
    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    /**
     * 图片地址
     * @return image_path 图片地址
     */
    public String getImagePath() {
        return imagePath;
    }

    /**
     * 图片地址
     * @param imagePath 图片地址
     */
    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    /**
     * 替换面料
     * @return replacecode 替换面料
     */
    public String getReplacecode() {
        return replacecode;
    }

    /**
     * 替换面料
     * @param replacecode 替换面料
     */
    public void setReplacecode(String replacecode) {
        this.replacecode = replacecode;
    }

    /**
     * 库存
     * @return repertory 库存
     */
    public Integer getRepertory() {
        return repertory;
    }

    /**
     * 库存
     * @param repertory 库存
     */
    public void setRepertory(Integer repertory) {
        this.repertory = repertory;
    }

    /**
     * 库存面料号
     * @return stockcode 库存面料号
     */
    public String getStockcode() {
        return stockcode;
    }

    /**
     * 库存面料号
     * @param stockcode 库存面料号
     */
    public void setStockcode(String stockcode) {
        this.stockcode = stockcode;
    }

    /**
     * 创建时间
     * @return create_date 创建时间
     */
    public String getCreateDate() {
        return createDate;
    }

    /**
     * 创建时间
     * @param createDate 创建时间
     */
    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    /**
     * 修改时间
     * @return last_update_date 修改时间
     */
    public String getLastUpdateDate() {
        return lastUpdateDate;
    }

    /**
     * 修改时间
     * @param lastUpdateDate 修改时间
     */
    public void setLastUpdateDate(String lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }
}
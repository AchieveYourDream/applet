package com.kute.appletcore.entity;

public class AppLining {
    /**
     * id
     */
    private Integer id;

    /**
     * 品类
     */
    private String category;

    /**
     * 衬类型编码
     */
    private String liningCode;

    /**
     * 衬类型名称
     */
    private String liningName;
    /**
     * 品类名称
     */
    private String categoryName;

    /**
    * @Description: 显示顺序
    * @Author: 王斌
    * @Date: 2019/12/10
    */
    private Integer displayOrder;

    public Integer getDisplayOrder() {
        return displayOrder;
    }

    public void setDisplayOrder(Integer displayOrder) {
        this.displayOrder = displayOrder;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

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
     * 品类
     * @return category 品类
     */
    public String getCategory() {
        return category;
    }

    /**
     * 品类
     * @param category 品类
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * 衬类型编码
     * @return lining_code 衬类型编码
     */
    public String getLiningCode() {
        return liningCode;
    }

    /**
     * 衬类型编码
     * @param liningCode 衬类型编码
     */
    public void setLiningCode(String liningCode) {
        this.liningCode = liningCode;
    }

    /**
     * 衬类型名称
     * @return lining_name 衬类型名称
     */
    public String getLiningName() {
        return liningName;
    }

    /**
     * 衬类型名称
     * @param liningName 衬类型名称
     */
    public void setLiningName(String liningName) {
        this.liningName = liningName;
    }
}
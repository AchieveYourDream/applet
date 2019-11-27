package com.kute.appletcore.entity;

import java.math.BigDecimal;

public class OrderTechnology {
    /**
     * 
     */
    private Integer id;

    /**
     * 订单id
     */
    private Integer orderDetailId;

    /**
     * 工艺id
     */
    private Integer technologyId;



    /**
     * 工艺名称
     */
    private String technologyName;

    /**
     * 内容
     */
    private String content;


    /**
     * 工厂编码
     */
    private String factoryCode;

    /**
     * 价格
     */
    private BigDecimal price;


    public String getTechnologyName() {
        return technologyName;
    }

    public void setTechnologyName(String technologyName) {
        this.technologyName = technologyName;
    }

    public String getFactoryCode() {
        return factoryCode;
    }

    public void setFactoryCode(String factoryCode) {
        this.factoryCode = factoryCode;
    }

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
     * 订单id
     * @return order_detail_id 订单id
     */
    public Integer getOrderDetailId() {
        return orderDetailId;
    }

    /**
     * 订单id
     * @param orderDetailId 订单id
     */
    public void setOrderDetailId(Integer orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    /**
     * 工艺id
     * @return technology_id 工艺id
     */
    public Integer getTechnologyId() {
        return technologyId;
    }

    /**
     * 工艺id
     * @param technologyId 工艺id
     */
    public void setTechnologyId(Integer technologyId) {
        this.technologyId = technologyId;
    }

    /**
     * 内容
     * @return content 内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 内容
     * @param content 内容
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 价格
     * @return price 价格
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * 价格
     * @param price 价格
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
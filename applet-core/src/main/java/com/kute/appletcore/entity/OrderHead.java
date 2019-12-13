package com.kute.appletcore.entity;

import java.math.BigDecimal;
import java.util.Date;

public class OrderHead {
    /**
     * 主键
     */
    private Integer headId;

    /**
     * 总单编码
     */
    private String packagecode;

    /**
     * 下单用户ID
     */
    private String memberId;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 订单类型
     */
    private Integer orderType;

    /**
     * 量体方式
     */
    private String sizecategoryId;

    /**
     * 订单状态
     */
    private String payStatus;

    /**
     * 订单金额
     */
    private BigDecimal orderPrice;

    /**
     * 订单实际金额
     */
    private BigDecimal orderRealityPrice;

    /**
     * 支付方式
     */
    private String payType;

    /**
     * 支付时间
     */
    private Date payDate;

    /**
     * 支付价格
     */
    private BigDecimal payPrice;

    /**
     * 
     */
    private String memberName;

    /**
     * 
     */
    private String memberTel;

    /**
     * 省
     */
    private String province;

    /**
     * 市
     */
    private String city;

    /**
     * 县
     */
    private String county;

    /**
     * 街道
     */
    private String street;

    /**
     * 流水号
     */
    private String payNum;

    /**
     * 主键
     * @return head_id 主键
     */
    public Integer getHeadId() {
        return headId;
    }

    /**
     * 主键
     * @param headId 主键
     */
    public void setHeadId(Integer headId) {
        this.headId = headId;
    }

    /**
     * 总单编码
     * @return packagecode 总单编码
     */
    public String getPackagecode() {
        return packagecode;
    }

    /**
     * 总单编码
     * @param packagecode 总单编码
     */
    public void setPackagecode(String packagecode) {
        this.packagecode = packagecode;
    }

    /**
     * 下单用户ID
     * @return member_id 下单用户ID
     */
    public String getMemberId() {
        return memberId;
    }

    /**
     * 下单用户ID
     * @param memberId 下单用户ID
     */
    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    /**
     * 创建时间
     * @return create_date 创建时间
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 创建时间
     * @param createDate 创建时间
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 订单类型
     * @return order_type 订单类型
     */
    public Integer getOrderType() {
        return orderType;
    }

    /**
     * 订单类型
     * @param orderType 订单类型
     */
    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    /**
     * 量体方式
     * @return sizecategory_id 量体方式
     */
    public String getSizecategoryId() {
        return sizecategoryId;
    }

    /**
     * 量体方式
     * @param sizecategoryId 量体方式
     */
    public void setSizecategoryId(String sizecategoryId) {
        this.sizecategoryId = sizecategoryId;
    }

    /**
     * 订单状态
     * @return pay_status 订单状态
     */
    public String getPayStatus() {
        return payStatus;
    }

    /**
     * 订单状态
     * @param payStatus 订单状态
     */
    public void setPayStatus(String payStatus) {
        this.payStatus = payStatus;
    }

    /**
     * 订单金额
     * @return order_price 订单金额
     */
    public BigDecimal getOrderPrice() {
        return orderPrice;
    }

    /**
     * 订单金额
     * @param orderPrice 订单金额
     */
    public void setOrderPrice(BigDecimal orderPrice) {
        this.orderPrice = orderPrice;
    }

    /**
     * 订单实际金额
     * @return order_reality_price 订单实际金额
     */
    public BigDecimal getOrderRealityPrice() {
        return orderRealityPrice;
    }

    /**
     * 订单实际金额
     * @param orderRealityPrice 订单实际金额
     */
    public void setOrderRealityPrice(BigDecimal orderRealityPrice) {
        this.orderRealityPrice = orderRealityPrice;
    }

    /**
     * 支付方式
     * @return pay_type 支付方式
     */
    public String getPayType() {
        return payType;
    }

    /**
     * 支付方式
     * @param payType 支付方式
     */
    public void setPayType(String payType) {
        this.payType = payType;
    }

    /**
     * 支付时间
     * @return pay_date 支付时间
     */
    public Date getPayDate() {
        return payDate;
    }

    /**
     * 支付时间
     * @param payDate 支付时间
     */
    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }

    /**
     * 支付价格
     * @return pay_price 支付价格
     */
    public BigDecimal getPayPrice() {
        return payPrice;
    }

    /**
     * 支付价格
     * @param payPrice 支付价格
     */
    public void setPayPrice(BigDecimal payPrice) {
        this.payPrice = payPrice;
    }

    /**
     * 
     * @return member_name 
     */
    public String getMemberName() {
        return memberName;
    }

    /**
     * 
     * @param memberName 
     */
    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    /**
     * 
     * @return member_tel 
     */
    public String getMemberTel() {
        return memberTel;
    }

    /**
     * 
     * @param memberTel 
     */
    public void setMemberTel(String memberTel) {
        this.memberTel = memberTel;
    }

    /**
     * 省
     * @return province 省
     */
    public String getProvince() {
        return province;
    }

    /**
     * 省
     * @param province 省
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * 市
     * @return city 市
     */
    public String getCity() {
        return city;
    }

    /**
     * 市
     * @param city 市
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * 县
     * @return county 县
     */
    public String getCounty() {
        return county;
    }

    /**
     * 县
     * @param county 县
     */
    public void setCounty(String county) {
        this.county = county;
    }

    /**
     * 街道
     * @return street 街道
     */
    public String getStreet() {
        return street;
    }

    /**
     * 街道
     * @param street 街道
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * 流水号
     * @return pay_num 流水号
     */
    public String getPayNum() {
        return payNum;
    }

    /**
     * 流水号
     * @param payNum 流水号
     */
    public void setPayNum(String payNum) {
        this.payNum = payNum;
    }
}
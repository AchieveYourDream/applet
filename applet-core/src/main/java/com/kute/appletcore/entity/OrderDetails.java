package com.kute.appletcore.entity;

import java.math.BigDecimal;

public class OrderDetails {
    /**
     * 主键
     */
    private Integer lineId;

    /**
     * 商品名称
     */
    private String clothName;

    /**
     * 服装品类
     */
    private String clothId;

    /**
     * 着装风格
     */
    private String clothStyle;

    /**
     * 数量
     */
    private BigDecimal amount;

    /**
     * 原价
     */
    private BigDecimal price;

    /**
     * 面料号
     */
    private String fabricCode;

    /**
     * 长短款
     */
    private Integer style;

    /**
     * 实际金额
     */
    private Double actualAmount;

    /**
     * 号型
     */
    private String size;

    /**
     * 衬类型
     */
    private String liningType;

    /**
     * 工艺费
     */
    private BigDecimal processPrice;

    /**
     * 工艺实际价格
     */
    private BigDecimal processActualPrice;

    /**
     * 工艺编码
     */
    private String technologyCode;

    /**
     * 订单状态
     */
    private String status;

    /**
     * 是否删除
     */
    private String isDelete;

    /**
     * 优惠后价格
     */
    private BigDecimal discountPrice;

    /**
     * 客户指定零售价
     */
    private BigDecimal priceRetail;

    /**
     * 红包金额
     */
    private BigDecimal bonusPrice;

    /**
     * 礼品卡金额
     */
    private BigDecimal giftCardPrice;

    /**
     * 订单头id
     */
    private Integer infoId;

    /**
     * 主键
     * @return line_id 主键
     */
    public Integer getLineId() {
        return lineId;
    }

    /**
     * 主键
     * @param lineId 主键
     */
    public void setLineId(Integer lineId) {
        this.lineId = lineId;
    }

    /**
     * 商品名称
     * @return cloth_name 商品名称
     */
    public String getClothName() {
        return clothName;
    }

    /**
     * 商品名称
     * @param clothName 商品名称
     */
    public void setClothName(String clothName) {
        this.clothName = clothName;
    }

    /**
     * 服装品类
     * @return cloth_id 服装品类
     */
    public String getClothId() {
        return clothId;
    }

    /**
     * 服装品类
     * @param clothId 服装品类
     */
    public void setClothId(String clothId) {
        this.clothId = clothId;
    }

    /**
     * 着装风格
     * @return cloth_style 着装风格
     */
    public String getClothStyle() {
        return clothStyle;
    }

    /**
     * 着装风格
     * @param clothStyle 着装风格
     */
    public void setClothStyle(String clothStyle) {
        this.clothStyle = clothStyle;
    }

    /**
     * 数量
     * @return amount 数量
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * 数量
     * @param amount 数量
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    /**
     * 原价
     * @return price 原价
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * 原价
     * @param price 原价
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * 面料号
     * @return fabric_code 面料号
     */
    public String getFabricCode() {
        return fabricCode;
    }

    /**
     * 面料号
     * @param fabricCode 面料号
     */
    public void setFabricCode(String fabricCode) {
        this.fabricCode = fabricCode;
    }

    /**
     * 长短款
     * @return style 长短款
     */
    public Integer getStyle() {
        return style;
    }

    /**
     * 长短款
     * @param style 长短款
     */
    public void setStyle(Integer style) {
        this.style = style;
    }

    /**
     * 实际金额
     * @return actual_amount 实际金额
     */
    public Double getActualAmount() {
        return actualAmount;
    }

    /**
     * 实际金额
     * @param actualAmount 实际金额
     */
    public void setActualAmount(Double actualAmount) {
        this.actualAmount = actualAmount;
    }

    /**
     * 号型
     * @return size 号型
     */
    public String getSize() {
        return size;
    }

    /**
     * 号型
     * @param size 号型
     */
    public void setSize(String size) {
        this.size = size;
    }

    /**
     * 衬类型
     * @return lining_type 衬类型
     */
    public String getLiningType() {
        return liningType;
    }

    /**
     * 衬类型
     * @param liningType 衬类型
     */
    public void setLiningType(String liningType) {
        this.liningType = liningType;
    }

    /**
     * 工艺费
     * @return process_price 工艺费
     */
    public BigDecimal getProcessPrice() {
        return processPrice;
    }

    /**
     * 工艺费
     * @param processPrice 工艺费
     */
    public void setProcessPrice(BigDecimal processPrice) {
        this.processPrice = processPrice;
    }

    /**
     * 工艺实际价格
     * @return process_actual_price 工艺实际价格
     */
    public BigDecimal getProcessActualPrice() {
        return processActualPrice;
    }

    /**
     * 工艺实际价格
     * @param processActualPrice 工艺实际价格
     */
    public void setProcessActualPrice(BigDecimal processActualPrice) {
        this.processActualPrice = processActualPrice;
    }

    /**
     * 工艺编码
     * @return technology_code 工艺编码
     */
    public String getTechnologyCode() {
        return technologyCode;
    }

    /**
     * 工艺编码
     * @param technologyCode 工艺编码
     */
    public void setTechnologyCode(String technologyCode) {
        this.technologyCode = technologyCode;
    }

    /**
     * 订单状态
     * @return status 订单状态
     */
    public String getStatus() {
        return status;
    }

    /**
     * 订单状态
     * @param status 订单状态
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 是否删除
     * @return is_delete 是否删除
     */
    public String getIsDelete() {
        return isDelete;
    }

    /**
     * 是否删除
     * @param isDelete 是否删除
     */
    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }

    /**
     * 优惠后价格
     * @return discount_price 优惠后价格
     */
    public BigDecimal getDiscountPrice() {
        return discountPrice;
    }

    /**
     * 优惠后价格
     * @param discountPrice 优惠后价格
     */
    public void setDiscountPrice(BigDecimal discountPrice) {
        this.discountPrice = discountPrice;
    }

    /**
     * 客户指定零售价
     * @return price_retail 客户指定零售价
     */
    public BigDecimal getPriceRetail() {
        return priceRetail;
    }

    /**
     * 客户指定零售价
     * @param priceRetail 客户指定零售价
     */
    public void setPriceRetail(BigDecimal priceRetail) {
        this.priceRetail = priceRetail;
    }

    /**
     * 红包金额
     * @return bonus_price 红包金额
     */
    public BigDecimal getBonusPrice() {
        return bonusPrice;
    }

    /**
     * 红包金额
     * @param bonusPrice 红包金额
     */
    public void setBonusPrice(BigDecimal bonusPrice) {
        this.bonusPrice = bonusPrice;
    }

    /**
     * 礼品卡金额
     * @return gift_card_price 礼品卡金额
     */
    public BigDecimal getGiftCardPrice() {
        return giftCardPrice;
    }

    /**
     * 礼品卡金额
     * @param giftCardPrice 礼品卡金额
     */
    public void setGiftCardPrice(BigDecimal giftCardPrice) {
        this.giftCardPrice = giftCardPrice;
    }

    /**
     * 订单头id
     * @return info_id 订单头id
     */
    public Integer getInfoId() {
        return infoId;
    }

    /**
     * 订单头id
     * @param infoId 订单头id
     */
    public void setInfoId(Integer infoId) {
        this.infoId = infoId;
    }
}
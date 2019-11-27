package com.kute.appletcore.vo;

import com.kute.appletcore.entity.OrderHead;

import java.math.BigDecimal;
import java.util.Date;

public class OrderDetailsVO  extends OrderHead {
    /**
     * 主键
     */
    private Integer lineId;
    /**
     * @Description: 订单头ID
     * @Author: 王斌
     * @Date: 2019/11/20
     */

    private Integer headId;

    /**
     * 订单ID
     */
    private String orderId;

    /**
     * 服装品类
     */
    private String clothId;

    /**
    * @Description: 服装名称
    * @Author: 王斌
    * @Date: 2019/11/21
    */
    private String  clothName;
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
     * 交货日期
     */
    private String deliveryDate;

    /**
     * 物流编号
     */
    private String deliveryCode;

    /**
     * 发货日期
     */
    private String finalDeliveryDate;

    /**
     * 订单状态
     */
    private String status;

    /**
     * 系统单号
     */
    private String syscode;

    /**
     * 入库时间
     */
    private String warehouseDate;

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
     * 开始生产时间
     */
    private Date startProductionDate;

    /**
     * 推送工厂时间
     */
    private Date pushFactoryDate;

    /**
     * 推送工厂状态
     */
    private String pushFactoryState;

    /**
     * 推送工厂信息
     */
    private String pushFactoryMessage;

    /**
     * 红包金额
     */
    private BigDecimal bonusPrice;

    /**
     * 礼品卡金额
     */
    private BigDecimal giftCardPrice;


    public String getClothName() {
        return clothName;
    }

    public void setClothName(String clothName) {
        this.clothName = clothName;
    }

    public Integer getHeadId() {
        return headId;
    }

    public void setHeadId(Integer headId) {
        this.headId = headId;
    }

    public Integer getLineId() {
        return lineId;
    }

    public void setLineId(Integer lineId) {
        this.lineId = lineId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getClothId() {
        return clothId;
    }

    public void setClothId(String clothId) {
        this.clothId = clothId;
    }

    public String getClothStyle() {
        return clothStyle;
    }

    public void setClothStyle(String clothStyle) {
        this.clothStyle = clothStyle;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getFabricCode() {
        return fabricCode;
    }

    public void setFabricCode(String fabricCode) {
        this.fabricCode = fabricCode;
    }

    public Integer getStyle() {
        return style;
    }

    public void setStyle(Integer style) {
        this.style = style;
    }

    public Double getActualAmount() {
        return actualAmount;
    }

    public void setActualAmount(Double actualAmount) {
        this.actualAmount = actualAmount;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getLiningType() {
        return liningType;
    }

    public void setLiningType(String liningType) {
        this.liningType = liningType;
    }

    public BigDecimal getProcessPrice() {
        return processPrice;
    }

    public void setProcessPrice(BigDecimal processPrice) {
        this.processPrice = processPrice;
    }

    public BigDecimal getProcessActualPrice() {
        return processActualPrice;
    }

    public void setProcessActualPrice(BigDecimal processActualPrice) {
        this.processActualPrice = processActualPrice;
    }

    public String getTechnologyCode() {
        return technologyCode;
    }

    public void setTechnologyCode(String technologyCode) {
        this.technologyCode = technologyCode;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getDeliveryCode() {
        return deliveryCode;
    }

    public void setDeliveryCode(String deliveryCode) {
        this.deliveryCode = deliveryCode;
    }

    public String getFinalDeliveryDate() {
        return finalDeliveryDate;
    }

    public void setFinalDeliveryDate(String finalDeliveryDate) {
        this.finalDeliveryDate = finalDeliveryDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSyscode() {
        return syscode;
    }

    public void setSyscode(String syscode) {
        this.syscode = syscode;
    }

    public String getWarehouseDate() {
        return warehouseDate;
    }

    public void setWarehouseDate(String warehouseDate) {
        this.warehouseDate = warehouseDate;
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }

    public BigDecimal getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(BigDecimal discountPrice) {
        this.discountPrice = discountPrice;
    }

    public BigDecimal getPriceRetail() {
        return priceRetail;
    }

    public void setPriceRetail(BigDecimal priceRetail) {
        this.priceRetail = priceRetail;
    }

    public Date getStartProductionDate() {
        return startProductionDate;
    }

    public void setStartProductionDate(Date startProductionDate) {
        this.startProductionDate = startProductionDate;
    }

    public Date getPushFactoryDate() {
        return pushFactoryDate;
    }

    public void setPushFactoryDate(Date pushFactoryDate) {
        this.pushFactoryDate = pushFactoryDate;
    }

    public String getPushFactoryState() {
        return pushFactoryState;
    }

    public void setPushFactoryState(String pushFactoryState) {
        this.pushFactoryState = pushFactoryState;
    }

    public String getPushFactoryMessage() {
        return pushFactoryMessage;
    }

    public void setPushFactoryMessage(String pushFactoryMessage) {
        this.pushFactoryMessage = pushFactoryMessage;
    }

    public BigDecimal getBonusPrice() {
        return bonusPrice;
    }

    public void setBonusPrice(BigDecimal bonusPrice) {
        this.bonusPrice = bonusPrice;
    }

    public BigDecimal getGiftCardPrice() {
        return giftCardPrice;
    }

    public void setGiftCardPrice(BigDecimal giftCardPrice) {
        this.giftCardPrice = giftCardPrice;
    }
}
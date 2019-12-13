package com.kute.appletcore.entity;

import java.math.BigDecimal;
import java.util.Date;

public class OrderInfo {
    /**
     * 主键
     */
    private Integer infoId;

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
     * 实际金额
     */
    private Double actualAmount;

    /**
     * 衬类型
     */
    private String liningType;

    /**
     * 是否删除
     */
    private String isDelete;

    /**
     * 总单号
     */
    private String packagecode;

    /**
     * 系统单号
     */
    private String syscode;

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
     * 开始生产时间
     */
    private Date startProductionDate;

    /**
     * 订单ID
     */
    private String orderId;

    /**
     * 交货日期
     */
    private Date deliveryDate;

    /**
     * 物流编号
     */
    private String deliveryCode;

    /**
     * 入库时间
     */
    private String warehouseDate;

    /**
     * 发货日期
     */
    private Date finalDeliveryDate;

    /**
     * 红包金额
     */
    private BigDecimal bonusPrice;

    /**
     * 礼品卡金额
     */
    private BigDecimal giftCardPrice;

    /*
    * @Description: 订单品类
    * @Author: 王斌
    * @Date: 2019/12/13
    */
    private String clothCategory;

    public String getClothCategory() {
        return clothCategory;
    }

    public void setClothCategory(String clothCategory) {
        this.clothCategory = clothCategory;
    }

    /**
     * 主键
     * @return info_id 主键
     */
    public Integer getInfoId() {
        return infoId;
    }

    /**
     * 主键
     * @param infoId 主键
     */
    public void setInfoId(Integer infoId) {
        this.infoId = infoId;
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
     * 总单号
     * @return packagecode 总单号
     */
    public String getPackagecode() {
        return packagecode;
    }

    /**
     * 总单号
     * @param packagecode 总单号
     */
    public void setPackagecode(String packagecode) {
        this.packagecode = packagecode;
    }

    /**
     * 系统单号
     * @return syscode 系统单号
     */
    public String getSyscode() {
        return syscode;
    }

    /**
     * 系统单号
     * @param syscode 系统单号
     */
    public void setSyscode(String syscode) {
        this.syscode = syscode;
    }

    /**
     * 推送工厂时间
     * @return push_factory_date 推送工厂时间
     */
    public Date getPushFactoryDate() {
        return pushFactoryDate;
    }

    /**
     * 推送工厂时间
     * @param pushFactoryDate 推送工厂时间
     */
    public void setPushFactoryDate(Date pushFactoryDate) {
        this.pushFactoryDate = pushFactoryDate;
    }

    /**
     * 推送工厂状态
     * @return push_factory_state 推送工厂状态
     */
    public String getPushFactoryState() {
        return pushFactoryState;
    }

    /**
     * 推送工厂状态
     * @param pushFactoryState 推送工厂状态
     */
    public void setPushFactoryState(String pushFactoryState) {
        this.pushFactoryState = pushFactoryState;
    }

    /**
     * 推送工厂信息
     * @return push_factory_message 推送工厂信息
     */
    public String getPushFactoryMessage() {
        return pushFactoryMessage;
    }

    /**
     * 推送工厂信息
     * @param pushFactoryMessage 推送工厂信息
     */
    public void setPushFactoryMessage(String pushFactoryMessage) {
        this.pushFactoryMessage = pushFactoryMessage;
    }

    /**
     * 开始生产时间
     * @return start_production_date 开始生产时间
     */
    public Date getStartProductionDate() {
        return startProductionDate;
    }

    /**
     * 开始生产时间
     * @param startProductionDate 开始生产时间
     */
    public void setStartProductionDate(Date startProductionDate) {
        this.startProductionDate = startProductionDate;
    }

    /**
     * 订单ID
     * @return order_id 订单ID
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * 订单ID
     * @param orderId 订单ID
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    /**
     * 交货日期
     * @return delivery_date 交货日期
     */
    public Date getDeliveryDate() {
        return deliveryDate;
    }

    /**
     * 交货日期
     * @param deliveryDate 交货日期
     */
    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    /**
     * 物流编号
     * @return delivery_code 物流编号
     */
    public String getDeliveryCode() {
        return deliveryCode;
    }

    /**
     * 物流编号
     * @param deliveryCode 物流编号
     */
    public void setDeliveryCode(String deliveryCode) {
        this.deliveryCode = deliveryCode;
    }

    /**
     * 入库时间
     * @return warehouse_date 入库时间
     */
    public String getWarehouseDate() {
        return warehouseDate;
    }

    /**
     * 入库时间
     * @param warehouseDate 入库时间
     */
    public void setWarehouseDate(String warehouseDate) {
        this.warehouseDate = warehouseDate;
    }

    /**
     * 发货日期
     * @return final_delivery_date 发货日期
     */
    public Date getFinalDeliveryDate() {
        return finalDeliveryDate;
    }

    /**
     * 发货日期
     * @param finalDeliveryDate 发货日期
     */
    public void setFinalDeliveryDate(Date finalDeliveryDate) {
        this.finalDeliveryDate = finalDeliveryDate;
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
}
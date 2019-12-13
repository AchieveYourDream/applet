package com.kute.appletcore.vo;

import java.io.Serializable;
import java.util.List;

/**
 * @Description: 订单提交版型匹配实体类
 */
public class OrdersBean implements Serializable {
    private String orderDate;//下单时间
    private String customerOrdersNo; //订单号

    private String contractSerialNumber;//系统单号

    private String createman;//创建人

    private String operatorName;// 量体人员名称

    private String customerName;//客户名称

    private String ownedStore; //下单门店

    private String height;

    private String weight;

    private String gender;// 客户性别

    private String fabrics;

    private String isKgl;// 是否客供料

    private String product; // 产品

    private String money;// 产品金额


    private String locking; // 订单是否锁定 0：正常 1：锁定

    private List<OrdersDetailBean> details;


    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getCustomerOrdersNo() {
        return customerOrdersNo;
    }

    public void setCustomerOrdersNo(String customerOrdersNo) {
        this.customerOrdersNo = customerOrdersNo;
    }

    public String getContractSerialNumber() {
        return contractSerialNumber;
    }

    public void setContractSerialNumber(String contractSerialNumber) {
        this.contractSerialNumber = contractSerialNumber;
    }

    public String getCreateman() {
        return createman;
    }

    public void setCreateman(String createman) {
        this.createman = createman;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getOwnedStore() {
        return ownedStore;
    }

    public void setOwnedStore(String ownedStore) {
        this.ownedStore = ownedStore;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getFabrics() {
        return fabrics;
    }

    public void setFabrics(String fabrics) {
        this.fabrics = fabrics;
    }

    public String getIsKgl() {
        return isKgl;
    }

    public void setIsKgl(String isKgl) {
        this.isKgl = isKgl;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getLocking() {
        return locking;
    }

    public void setLocking(String locking) {
        this.locking = locking;
    }

    public List<OrdersDetailBean> getDetails() {
        return details;
    }

    public void setDetails(List<OrdersDetailBean> details) {
        this.details = details;
    }
}

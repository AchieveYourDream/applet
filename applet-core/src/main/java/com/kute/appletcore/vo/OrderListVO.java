package com.kute.appletcore.vo;

/**
 * @ClaseName
 * @Auther 王斌
 * @Date
 **/
public class OrderListVO {


     private String  infoId;
     private String   packagecode;
     private String   actualAmount;
     private String   price;
     private String   fabricCode;
     private String   amount;
     private String   payStatus;
     private String   detailModelOne;
     private String   fabricName;


    public String getInfoId() {
        return infoId;
    }

    public void setInfoId(String infoId) {
        this.infoId = infoId;
    }

    public String getPackagecode() {
        return packagecode;
    }

    public void setPackagecode(String packagecode) {
        this.packagecode = packagecode;
    }

    public String getActualAmount() {
        return actualAmount;
    }

    public void setActualAmount(String actualAmount) {
        this.actualAmount = actualAmount;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getFabricCode() {
        return fabricCode;
    }

    public void setFabricCode(String fabricCode) {
        this.fabricCode = fabricCode;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(String payStatus) {
        this.payStatus = payStatus;
    }

    public String getDetailModelOne() {
        return detailModelOne;
    }

    public void setDetailModelOne(String detailModelOne) {
        this.detailModelOne = detailModelOne;
    }

    public String getFabricName() {
        return fabricName;
    }

    public void setFabricName(String fabricName) {
        this.fabricName = fabricName;
    }
}

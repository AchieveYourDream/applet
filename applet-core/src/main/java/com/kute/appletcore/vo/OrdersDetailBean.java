package com.kute.appletcore.vo;

import java.io.Serializable;

/**
 * @Description: 订单提交版型匹配实体类
 */
public class OrdersDetailBean implements Serializable {
	private String model;  //0

	private String categories;//品类

	private String interliningType;//衬类型

	private String quantity;//数量

	private String versionStyle;//H

	private String clothingStyle;//H

	private String clothingSize;//尺寸

	private String ordersProcess; //工艺


	private String embroidery; //刺绣

	private String price;// 价格

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getCategories() {
		return categories;
	}

	public void setCategories(String categories) {
		this.categories = categories;
	}

	public String getInterliningType() {
		return interliningType;
	}

	public void setInterliningType(String interliningType) {
		this.interliningType = interliningType;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getVersionStyle() {
		return versionStyle;
	}

	public void setVersionStyle(String versionStyle) {
		this.versionStyle = versionStyle;
	}

	public String getClothingStyle() {
		return clothingStyle;
	}

	public void setClothingStyle(String clothingStyle) {
		this.clothingStyle = clothingStyle;
	}

	public String getClothingSize() {
		return clothingSize;
	}

	public void setClothingSize(String clothingSize) {
		this.clothingSize = clothingSize;
	}

	public String getOrdersProcess() {
		return ordersProcess;
	}

	public void setOrdersProcess(String ordersProcess) {
		this.ordersProcess = ordersProcess;
	}

	public String getEmbroidery() {
		return embroidery;
	}

	public void setEmbroidery(String embroidery) {
		this.embroidery = embroidery;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
}

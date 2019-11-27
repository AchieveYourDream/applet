package com.kute.appletcore.entity;

import java.math.BigDecimal;

public class OrderStitchWork {
    /**
     * 
     */
    private Integer id;

    /**
     * 
     */
    private Integer orderDetailId;

    /**
     * 
     */
    private Integer positionId;

    /**
     * 
     */
    private Integer colorId;

    /**
     * 
     */
    private Integer fontId;

    /**
     * 
     */
    private Integer sizeId;

    /**
     * 
     */
    private Integer iconId;


    /**
     *
     */
    private String orderDetailName;

    /**
     *
     */
    private String positionName;

    /**
     *
     */
    private String colorName;

    /**
     *
     */
    private String fontName;

    /**
     *
     */
    private String sizeName;

    /**
     *
     */
    private String iconName;



    /**
     * 
     */
    private String content;

    /**
     * 
     */
    private BigDecimal price;

    public String getOrderDetailName() {
        return orderDetailName;
    }

    public void setOrderDetailName(String orderDetailName) {
        this.orderDetailName = orderDetailName;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }

    public String getFontName() {
        return fontName;
    }

    public void setFontName(String fontName) {
        this.fontName = fontName;
    }

    public String getSizeName() {
        return sizeName;
    }

    public void setSizeName(String sizeName) {
        this.sizeName = sizeName;
    }

    public String getIconName() {
        return iconName;
    }

    public void setIconName(String iconName) {
        this.iconName = iconName;
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
     * 
     * @return order_detail_id 
     */
    public Integer getOrderDetailId() {
        return orderDetailId;
    }

    /**
     * 
     * @param orderDetailId 
     */
    public void setOrderDetailId(Integer orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    /**
     * 
     * @return position_id 
     */
    public Integer getPositionId() {
        return positionId;
    }

    /**
     * 
     * @param positionId 
     */
    public void setPositionId(Integer positionId) {
        this.positionId = positionId;
    }

    /**
     * 
     * @return color_id 
     */
    public Integer getColorId() {
        return colorId;
    }

    /**
     * 
     * @param colorId 
     */
    public void setColorId(Integer colorId) {
        this.colorId = colorId;
    }

    /**
     * 
     * @return font_id 
     */
    public Integer getFontId() {
        return fontId;
    }

    /**
     * 
     * @param fontId 
     */
    public void setFontId(Integer fontId) {
        this.fontId = fontId;
    }

    /**
     * 
     * @return size_id 
     */
    public Integer getSizeId() {
        return sizeId;
    }

    /**
     * 
     * @param sizeId 
     */
    public void setSizeId(Integer sizeId) {
        this.sizeId = sizeId;
    }

    /**
     * 
     * @return icon_id 
     */
    public Integer getIconId() {
        return iconId;
    }

    /**
     * 
     * @param iconId 
     */
    public void setIconId(Integer iconId) {
        this.iconId = iconId;
    }

    /**
     * 
     * @return content 
     */
    public String getContent() {
        return content;
    }

    /**
     * 
     * @param content 
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 
     * @return price 
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * 
     * @param price 
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
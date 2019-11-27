package com.kute.appletcore.entity;

import java.math.BigDecimal;

public class AppSize {
    /**
     * id
     */
    private Integer sizeId;

    /**
     * 身材类型
     */
    private String bodyType;

    /**
     * 胸围
     */
    private BigDecimal chestCircle;

    /**
     * 组合码
     */
    private String comboCode;

    /**
     * 删除标志
     */
    private String deleteFlag;

    /**
     * 后衣长
     */
    private BigDecimal hYiChang;

    /**
     * 臀围
     */
    private BigDecimal hipCircle;

    /**
     * 肩宽
     */
    private BigDecimal jianWidth;

    /**
     * 腰围
     */
    private BigDecimal waistCircle;

    /**
     * 欧洲码
     */
    private String eurCode;

    /**
     * 前衣长
     */
    private BigDecimal qYiChang;

    /**
     * 袖长
     */
    private BigDecimal xiuChang;

    /**
     * 袖肥
     */
    private BigDecimal xiuFei;

    /**
     * 袖扣
     */
    private BigDecimal xiuKou;

    /**
     * 所属大类
     */
    private String categoryId;

    /**
    * @Description: 大类名称
    * @Author: 王斌
    * @Date: 2019/11/18
    */

    private String categoryName;
    /**
     * 身高
     */
    private BigDecimal height;

    /**
     * 中国码
     */
    private String cnCode;

    /**
     * 创建时间
     */
    private String createDate;

    /**
     * 修改时间
     */
    private String updateDate;

    /**
     * id
     * @return size_Id id
     */
    public Integer getSizeId() {
        return sizeId;
    }

    /**
     * id
     * @param sizeId id
     */
    public void setSizeId(Integer sizeId) {
        this.sizeId = sizeId;
    }

    /**
     * 身材类型
     * @return body_type 身材类型
     */
    public String getBodyType() {
        return bodyType;
    }

    /**
     * 身材类型
     * @param bodyType 身材类型
     */
    public void setBodyType(String bodyType) {
        this.bodyType = bodyType;
    }

    /**
     * 胸围
     * @return chest_circle 胸围
     */
    public BigDecimal getChestCircle() {
        return chestCircle;
    }

    /**
     * 胸围
     * @param chestCircle 胸围
     */
    public void setChestCircle(BigDecimal chestCircle) {
        this.chestCircle = chestCircle;
    }

    /**
     * 组合码
     * @return combo_code 组合码
     */
    public String getComboCode() {
        return comboCode;
    }

    /**
     * 组合码
     * @param comboCode 组合码
     */
    public void setComboCode(String comboCode) {
        this.comboCode = comboCode;
    }

    /**
     * 删除标志
     * @return delete_flag 删除标志
     */
    public String getDeleteFlag() {
        return deleteFlag;
    }

    /**
     * 删除标志
     * @param deleteFlag 删除标志
     */
    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    /**
     * 后衣长
     * @return h_yi_chang 后衣长
     */
    public BigDecimal gethYiChang() {
        return hYiChang;
    }

    /**
     * 后衣长
     * @param hYiChang 后衣长
     */
    public void sethYiChang(BigDecimal hYiChang) {
        this.hYiChang = hYiChang;
    }

    /**
     * 臀围
     * @return hip_circle 臀围
     */
    public BigDecimal getHipCircle() {
        return hipCircle;
    }

    /**
     * 臀围
     * @param hipCircle 臀围
     */
    public void setHipCircle(BigDecimal hipCircle) {
        this.hipCircle = hipCircle;
    }

    /**
     * 肩宽
     * @return jian_width 肩宽
     */
    public BigDecimal getJianWidth() {
        return jianWidth;
    }

    /**
     * 肩宽
     * @param jianWidth 肩宽
     */
    public void setJianWidth(BigDecimal jianWidth) {
        this.jianWidth = jianWidth;
    }

    /**
     * 腰围
     * @return waist_circle 腰围
     */
    public BigDecimal getWaistCircle() {
        return waistCircle;
    }

    /**
     * 腰围
     * @param waistCircle 腰围
     */
    public void setWaistCircle(BigDecimal waistCircle) {
        this.waistCircle = waistCircle;
    }

    /**
     * 欧洲码
     * @return eur_code 欧洲码
     */
    public String getEurCode() {
        return eurCode;
    }

    /**
     * 欧洲码
     * @param eurCode 欧洲码
     */
    public void setEurCode(String eurCode) {
        this.eurCode = eurCode;
    }

    /**
     * 前衣长
     * @return q_yi_chang 前衣长
     */
    public BigDecimal getqYiChang() {
        return qYiChang;
    }

    /**
     * 前衣长
     * @param qYiChang 前衣长
     */
    public void setqYiChang(BigDecimal qYiChang) {
        this.qYiChang = qYiChang;
    }

    /**
     * 袖长
     * @return xiu_chang 袖长
     */
    public BigDecimal getXiuChang() {
        return xiuChang;
    }

    /**
     * 袖长
     * @param xiuChang 袖长
     */
    public void setXiuChang(BigDecimal xiuChang) {
        this.xiuChang = xiuChang;
    }

    /**
     * 袖肥
     * @return xiu_fei 袖肥
     */
    public BigDecimal getXiuFei() {
        return xiuFei;
    }

    /**
     * 袖肥
     * @param xiuFei 袖肥
     */
    public void setXiuFei(BigDecimal xiuFei) {
        this.xiuFei = xiuFei;
    }

    /**
     * 袖扣
     * @return xiu_kou 袖扣
     */
    public BigDecimal getXiuKou() {
        return xiuKou;
    }

    /**
     * 袖扣
     * @param xiuKou 袖扣
     */
    public void setXiuKou(BigDecimal xiuKou) {
        this.xiuKou = xiuKou;
    }

    /**
     * 所属大类
     * @return category_id 所属大类
     */
    public String getCategoryId() {
        return categoryId;
    }

    /**
     * 所属大类
     * @param categoryId 所属大类
     */
    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * 身高
     * @return height 身高
     */
    public BigDecimal getHeight() {
        return height;
    }

    /**
     * 身高
     * @param height 身高
     */
    public void setHeight(BigDecimal height) {
        this.height = height;
    }

    /**
     * 中国码
     * @return cn_code 中国码
     */
    public String getCnCode() {
        return cnCode;
    }

    /**
     * 中国码
     * @param cnCode 中国码
     */
    public void setCnCode(String cnCode) {
        this.cnCode = cnCode;
    }

    /**
     * 创建时间
     * @return create_date 创建时间
     */
    public String getCreateDate() {
        return createDate;
    }

    /**
     * 创建时间
     * @param createDate 创建时间
     */
    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    /**
     * 修改时间
     * @return update_date 修改时间
     */
    public String getUpdateDate() {
        return updateDate;
    }

    /**
     * 修改时间
     * @param updateDate 修改时间
     */
    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }
}
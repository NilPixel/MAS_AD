package com.example.zheng.steward.db.model;

public class OrderDetailListContent {

    private String lendingNo;       //贷款编号

    private String applyName;       //申请人姓名

    private String sex;             //性别

    private String phoneNumber;     //手机号码

    private String productName;     //产品名称

    private String applyDate;       //申请日期

    private String applyAmtShow;    //展示的申请金额

    private String passedAmtShow;   //展示的审核通过金额

    private String merchantFeeShow; //展示的商户手续费

    private String periods;         //期数

    private String salesName;       //销售员姓名

    private String store;           //所属门店

    private String applyStatus;     //申请状态

    private String buybackStatus;   //回购状态

    private Boolean showStatusDesc; //是否展示状态描述

    private String auditDate;       //审核时间

    private Boolean buybackFun;     //是否允许全额回购 当buybackStatus为””时判断这个属性

    private String buybackType;     //回购类型 “全额回购” “部分回购”

    public String getLendingNo() {
        return lendingNo;
    }

    public void setLendingNo(String lendingNo) {
        this.lendingNo = lendingNo;
    }

    public String getApplyName() {
        return applyName;
    }

    public void setApplyName(String applyName) {
        this.applyName = applyName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(String applyDate) {
        this.applyDate = applyDate;
    }

    public String getApplyAmtShow() {
        return applyAmtShow;
    }

    public void setApplyAmtShow(String applyAmtShow) {
        this.applyAmtShow = applyAmtShow;
    }

    public String getPassedAmtShow() {
        return passedAmtShow;
    }

    public void setPassedAmtShow(String passedAmtShow) {
        this.passedAmtShow = passedAmtShow;
    }

    public String getMerchantFeeShow() {
        return merchantFeeShow;
    }

    public void setMerchantFeeShow(String merchantFeeShow) {
        this.merchantFeeShow = merchantFeeShow;
    }

    public String getPeriods() {
        return periods;
    }

    public void setPeriods(String periods) {
        this.periods = periods;
    }

    public String getSalesName() {
        return salesName;
    }

    public void setSalesName(String salesName) {
        this.salesName = salesName;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public String getApplyStatus() {
        return applyStatus;
    }

    public void setApplyStatus(String applyStatus) {
        this.applyStatus = applyStatus;
    }

    public String getBuybackStatus() {
        return buybackStatus;
    }

    public void setBuybackStatus(String buybackStatus) {
        this.buybackStatus = buybackStatus;
    }

    public Boolean getShowStatusDesc() {
        return showStatusDesc;
    }

    public void setShowStatusDesc(Boolean showStatusDesc) {
        this.showStatusDesc = showStatusDesc;
    }

    public String getAuditDate() {
        return auditDate;
    }

    public void setAuditDate(String auditDate) {
        this.auditDate = auditDate;
    }

    public Boolean getBuybackFun() {
        return buybackFun;
    }

    public void setBuybackFun(Boolean buybackFun) {
        this.buybackFun = buybackFun;
    }

    public String getBuybackType() {
        return buybackType;
    }

    public void setBuybackType(String buybackType) {
        this.buybackType = buybackType;
    }
}

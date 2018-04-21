package com.example.zheng.steward.db.model;

import org.litepal.crud.DataSupport;

import java.io.Serializable;

public class OrderManagerListItem extends DataSupport implements Serializable {

    private String lendingNo;               //贷款编号
    private String applyName;               //申请人姓名
    private String applyDate;               //申请时间
    private String store;                   //所属门店
    private String applyStatus;             //订单状态

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

    public String getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(String applyDate) {
        this.applyDate = applyDate;
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
}

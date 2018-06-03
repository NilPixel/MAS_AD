package com.example.zheng.steward.model.request;

public class OrderDetailRequest {

    private String lendingNo; // 贷款编号

    public OrderDetailRequest(String lendingNo) {
        this.lendingNo = lendingNo;
    }

    public String getLendingNo() {
        return lendingNo;
    }

    public void setLendingNo(String lendingNo) {
        this.lendingNo = lendingNo;
    }
}

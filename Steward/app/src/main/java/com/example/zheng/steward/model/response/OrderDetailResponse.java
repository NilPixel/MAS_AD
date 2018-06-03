package com.example.zheng.steward.model.response;

import com.example.zheng.steward.db.model.OrderDetailListContent;

public class OrderDetailResponse {

    private String code;            //操作代码，0操作成功

    private String desc;            //操作描述，即操作代码的中文描述

    private OrderDetailListContent result;  //详情

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public OrderDetailListContent getResult() {
        return result;
    }

    public void setResult(OrderDetailListContent result) {
        this.result = result;
    }
}

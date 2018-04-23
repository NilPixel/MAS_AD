package com.example.zheng.steward.model.response;

import com.example.zheng.steward.db.model.OrderManagerListItem;

import java.util.ArrayList;

public class OrderManagerListResponse {

    private String code;            //操作代码，0操作成功

    private String desc;            //操作描述，即操作代码的中文描述

    private int page;               //商户名称

    private int total;              //总页数

    private int records;            //总条数

    private ArrayList<OrderManagerListItem> result; //行数据，JSON对象数组。无数据时为null

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

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getRecords() {
        return records;
    }

    public void setRecords(int records) {
        this.records = records;
    }

    public ArrayList<OrderManagerListItem> getResult() {
        return result;
    }

    public void setResult(ArrayList<OrderManagerListItem> result) {
        this.result = result;
    }
}

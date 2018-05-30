package com.example.zheng.steward.model.response;

import com.example.zheng.steward.db.model.NewsPagerListItem;
import com.example.zheng.steward.db.model.OrderManagerListItem;

import java.util.ArrayList;

/**
 * 消息列表返回数据
 */
public class NewsPagerListResponse {

    private String code;            //操作代码，0操作成功

    private String desc;            //操作描述，即操作代码的中文描述

    private int page;               //当前页码，从1开始。

    private int total;              //总页数

    private int records;            //总条数

    private ArrayList<NewsPagerListItem> rows; //行数据，JSON对象数组。无数据时为null

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

    public ArrayList<NewsPagerListItem> getRows() {
        return rows;
    }

    public void setRows(ArrayList<NewsPagerListItem> rows) {
        this.rows = rows;
    }
}

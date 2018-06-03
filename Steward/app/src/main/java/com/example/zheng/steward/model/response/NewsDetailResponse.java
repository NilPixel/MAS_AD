package com.example.zheng.steward.model.response;

import com.example.zheng.steward.db.model.NewsDetailContent;

public class NewsDetailResponse {

    private String code;                    //操作代码，0操作成功

    private String desc;                    //操作描述，即操作代码的中文描述

    private NewsDetailContent detailInfo;   // 返回内容，JSON对象。无数据时为null。

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

    public NewsDetailContent getDetailInfo() {
        return detailInfo;
    }

    public void setDetailInfo(NewsDetailContent detailInfo) {
        this.detailInfo = detailInfo;
    }
}

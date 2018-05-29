package com.example.zheng.steward.model.request;

public class NewsPagerListRequest {

    private String currentPage; // 当前页码，从1开始。
    private String msgType; // 消息类型。0：资讯；1：回购提醒；2：逾期提醒；5:申请&放款；选“全部”时请传空字符串。

    public NewsPagerListRequest(String currentPage, String msgType) {
        this.currentPage = currentPage;
        this.msgType = msgType;
    }

    public String getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(String currentPage) {
        this.currentPage = currentPage;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }
}

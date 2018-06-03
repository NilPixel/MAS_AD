package com.example.zheng.steward.model.request;

public class NewsDetailRequest {
    private String msgId;  // 消息ID

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    public NewsDetailRequest(String msgId) {
        this.msgId = msgId;
    }
}

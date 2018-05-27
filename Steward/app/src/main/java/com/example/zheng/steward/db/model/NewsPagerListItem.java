package com.example.zheng.steward.db.model;

public class NewsPagerListItem {
    private String msgId;                   //消息ID
    private String msgTitle;                //消息标题。
    private String msgContent;              //消息正文。
    private String msgType;                 //消息类型。0：资讯；1：回购提醒；2：逾期提醒；5:申请&放款；
    private String sentTime;                //推送时间（消息发布时间）。
    private String msgStatus;               //消息是否已读。0：未读；1：已读

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    public String getMsgTitle() {
        return msgTitle;
    }

    public void setMsgTitle(String msgTitle) {
        this.msgTitle = msgTitle;
    }

    public String getMsgContent() {
        return msgContent;
    }

    public void setMsgContent(String msgContent) {
        this.msgContent = msgContent;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public String getSentTime() {
        return sentTime;
    }

    public void setSentTime(String sentTime) {
        this.sentTime = sentTime;
    }

    public String getMsgStatus() {
        return msgStatus;
    }

    public void setMsgStatus(String msgStatus) {
        this.msgStatus = msgStatus;
    }
}

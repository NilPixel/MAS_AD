package com.example.zheng.steward.db.model;

public class NewsDetailContent {

    private String msgId;               // 消息id

    private String msgTitle;            // 消息标题。

    private String msgContent;          // 消息正文。

    private String msgType;             // 消息类型。0：资讯；1：回购提醒；2：逾期提醒；5:申请&放款；

    private String sentTime;            // 推送时间（消息发布时间）。

    private String msgStatus;           // 消息是否已读。0：未读；1：已读

    private String imgUrl;              // 图片链接

    private String appUrl;              // 跳转链接

    private String loanId;              // 贷款编号，用于查看放款件详情。

    private String ext;                 // 附加字段

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

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getAppUrl() {
        return appUrl;
    }

    public void setAppUrl(String appUrl) {
        this.appUrl = appUrl;
    }

    public String getLoanId() {
        return loanId;
    }

    public void setLoanId(String loanId) {
        this.loanId = loanId;
    }

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }
}

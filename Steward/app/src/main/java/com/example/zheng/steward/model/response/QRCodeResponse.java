package com.example.zheng.steward.model.response;

/**
 * Created by jarvis on 2018/4/11.
 */

public class QRCodeResponse {

    private String code;               //操作代码

    private String detailInfo;      //用于么么贷APP扫的临时二维码的code

    private String desc;            //描述信息

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDetailInfo() {
        return detailInfo;
    }

    public void setDetailInfo(String detailInfo) {
        this.detailInfo = detailInfo;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}

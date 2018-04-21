package com.example.zheng.steward.model.response;

/**
 * Created by jarvis on 2018/4/1.
 */

public class HomeDataResponse {

    private String code;            //操作代码

    private String merchantCode;    //商户code

    private String merchantName;    //商户名称

    private int role;               //角色 0对应商户1对应地区2对应门店 3营业员

    private double monthAmount;     //月交易额

    private double totalAmount;     //总交易额

    private int totalApply;         //进件总数

    private int monthApply;         //月进件总数

    private String url;             //图片链接地址（据产品经理说图片都一样，所以只返回一个）

    private String avatarUrl;       //头像地址

    private String fullname;        //姓名

    private String desc;            //描述信息

    private String storeCode;       //门店code

    private String storeName;       //门店名称

    private boolean customerPortraitFunc;//客户画像功能是否开启

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMerchantCode() {
        return merchantCode;
    }

    public void setMerchantCode(String merchantCode) {
        this.merchantCode = merchantCode;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public double getMonthAmount() {
        return monthAmount;
    }

    public void setMonthAmount(double monthAmount) {
        this.monthAmount = monthAmount;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public int getTotalApply() {
        return totalApply;
    }

    public void setTotalApply(int totalApply) {
        this.totalApply = totalApply;
    }

    public int getMonthApply() {
        return monthApply;
    }

    public void setMonthApply(int monthApply) {
        this.monthApply = monthApply;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getStoreCode() {
        return storeCode;
    }

    public void setStoreCode(String storeCode) {
        this.storeCode = storeCode;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public boolean isCustomerPortraitFunc() {
        return customerPortraitFunc;
    }

    public void setCustomerPortraitFunc(boolean customerPortraitFunc) {
        this.customerPortraitFunc = customerPortraitFunc;
    }
}

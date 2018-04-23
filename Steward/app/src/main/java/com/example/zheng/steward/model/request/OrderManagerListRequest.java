package com.example.zheng.steward.model.request;

public class OrderManagerListRequest {

    private Integer page;
    private Integer pageLength;
    private String sortMethod;
    private String param;
    private String sellerNo;
    private String store;
    private String applyStatus;

    public OrderManagerListRequest(Integer page, Integer pageLength, String sortMethod, String param, String sellerNo, String store, String applyStatus) {
        this.page = page;
        this.pageLength = pageLength;
        this.sortMethod = sortMethod;
        this.param = param;
        this.sellerNo = sellerNo;
        this.store = store;
        this.applyStatus = applyStatus;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageLength() {
        return pageLength;
    }

    public void setPageLength(Integer pageLength) {
        this.pageLength = pageLength;
    }

    public String getSortMethod() {
        return sortMethod;
    }

    public void setSortMethod(String sortMethod) {
        this.sortMethod = sortMethod;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    public String getSellerNo() {
        return sellerNo;
    }

    public void setSellerNo(String sellerNo) {
        this.sellerNo = sellerNo;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public String getApplyStatus() {
        return applyStatus;
    }

    public void setApplyStatus(String applyStatus) {
        this.applyStatus = applyStatus;
    }
}

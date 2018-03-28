package com.example.zheng.steward.model.request;


/**
 * Created by AMing on 15/12/24.
 * Company RongCloud
 */
public class LoginRequest {

    private String userName;
    private String password;
    private Boolean encrypt;

    public LoginRequest(String userName, String password, Boolean encrypt) {
        this.userName = userName;
        this.password = password;
        this.encrypt = encrypt;
    }

    public Boolean getEncrypt() {
        return encrypt;
    }

    public void setEncrypt(Boolean encrypt) {
        this.encrypt = encrypt;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

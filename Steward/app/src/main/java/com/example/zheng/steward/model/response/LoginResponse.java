package com.example.zheng.steward.model.response;


/**
 * Created by AMing on 15/12/24.
 * Company RongCloud
 */
public class LoginResponse {

    private String code;

    private String desc;

    private Token userToken;

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Token getUserToken() {
        return userToken;
    }

    public void setUserToken(Token userToken) {
        this.userToken = userToken;
    }

    public static class Token {

        private String token;

        private long expireTime;

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public long getExpireTime() {
            return expireTime;
        }

        public void setExpireTime(long expireTime) {
            this.expireTime = expireTime;
        }
    }
}
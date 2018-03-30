package com.example.zheng.steward.model.cache;

import com.example.zheng.steward.app.AppConst;
import com.example.zheng.steward.db.DBManager;
import com.example.zheng.steward.utils.SPUtils;
import com.example.zheng.steward.utils.UIUtils;

/**
 * Created by zheng on 2018/2/2.
 * 用户缓存
 */

public class UserCache {
    public static String getId() {
        return SPUtils.getInstance(UIUtils.getContext()).getString(AppConst.User.ID, "");
    }

    public static String getUserName() {
        return SPUtils.getInstance(UIUtils.getContext()).getString(AppConst.User.USERNAME, "");
    }

    public static String getToken() {
        return SPUtils.getInstance(UIUtils.getContext()).getString(AppConst.User.TOKEN, "");
    }

    public static void save(long expireTime, String userName, String token) {
        SPUtils.getInstance(UIUtils.getContext()).putLong(AppConst.User.EXPIRETIME, expireTime);
        SPUtils.getInstance(UIUtils.getContext()).putString(AppConst.User.USERNAME, userName);
        SPUtils.getInstance(UIUtils.getContext()).putString(AppConst.User.TOKEN, token);
    }

    public static void clear() {
        SPUtils.getInstance(UIUtils.getContext()).remove(AppConst.User.EXPIRETIME);
        SPUtils.getInstance(UIUtils.getContext()).remove(AppConst.User.USERNAME);
        SPUtils.getInstance(UIUtils.getContext()).remove(AppConst.User.TOKEN);
        DBManager.getInstance().deleteAllUserInfo();
    }
}

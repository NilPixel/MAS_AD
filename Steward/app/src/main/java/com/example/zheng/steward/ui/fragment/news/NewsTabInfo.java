package com.example.zheng.steward.ui.fragment.news;

import android.os.Bundle;

/**
 * 数据封装中classz用于通过反射获取Fragment的名字,然后再通过Fragment.instantiate(mContext,classz.getName())来获取相应的Fragment对象
 */
public class NewsTabInfo {

    public String mTitle;
    public Class mClazz;
    public Bundle mBundle;

    public NewsTabInfo(String title, Class clazz, Bundle bundle) {

        mTitle = title;
        mClazz = clazz;
        mBundle = bundle;
    }
}

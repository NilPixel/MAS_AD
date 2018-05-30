package com.example.zheng.steward.ui.adapter;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.zheng.steward.ui.fragment.news.NewsTabInfo;

import java.util.ArrayList;

public class NewsPagerAdapter extends FragmentPagerAdapter {

    private Context mContext;
    private ArrayList<NewsTabInfo> mTabInfos;

    public NewsPagerAdapter(FragmentManager fm, Context context, ArrayList<NewsTabInfo> tabInfos) {
        super(fm);
        mContext = context;
        mTabInfos = tabInfos;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = Fragment.instantiate(mContext, mTabInfos.get(position).mClazz.getName());
        Bundle bundle = new Bundle();

        switch (position) {
            case 0:
                bundle.putString("msgType","");
                break;
            case 1:
                bundle.putString("msgType","0");
                break;
            case 2:
                bundle.putString("msgType","1");
                break;
            case 3:
                bundle.putString("msgType","2");
                break;
            case 4:
                bundle.putString("msgType","5");
                break;
            default:
                break;
        }
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getCount() {
        return mTabInfos.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTabInfos.get(position).mTitle;
    }
}

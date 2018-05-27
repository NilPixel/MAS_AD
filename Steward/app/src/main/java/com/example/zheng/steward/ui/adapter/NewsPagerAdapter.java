package com.example.zheng.steward.ui.adapter;

import android.content.Context;
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
        return Fragment.instantiate(mContext, mTabInfos.get(position).mClazz.getName());
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

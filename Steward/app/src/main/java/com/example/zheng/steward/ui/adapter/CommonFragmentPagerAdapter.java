package com.example.zheng.steward.ui.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.zheng.steward.ui.base.BaseFragment;

import java.util.List;

/**
 * Created by jarvis on 2018/3/31.
 * 通用的ViewPager适配器(FragmentPagerAdapter)
 */

public class CommonFragmentPagerAdapter extends FragmentPagerAdapter {

    public static int MAIN_VIEW_PAGER = 1;//主页的ViewPager

    private int mViewPagerType = 0;
    public String[] mainViewPagerTitle = null;
    private List<BaseFragment> mFragments;

    public CommonFragmentPagerAdapter(FragmentManager fm, List<BaseFragment> fragments) {
        super(fm);
        mFragments = fragments;
    }

    //根据传入的viewPagerType，在getTitle中返回不同的标题信息
    public CommonFragmentPagerAdapter(FragmentManager fm, List<BaseFragment> fragments, int viewPagerType) {
        this(fm, fragments);
        mViewPagerType = viewPagerType;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments != null ? mFragments.size() : 0;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return super.getPageTitle(position);
    }
}

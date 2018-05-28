package com.example.zheng.steward.ui.fragment;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.zheng.steward.MainActivity;
import com.example.zheng.steward.R;
import com.example.zheng.steward.app.AppConst;
import com.example.zheng.steward.ui.adapter.NewsPagerAdapter;
import com.example.zheng.steward.ui.base.BaseFragment;
import com.example.zheng.steward.ui.base.BasePresenter;
import com.example.zheng.steward.ui.fragment.news.NewsPagerFragment;
import com.example.zheng.steward.ui.fragment.news.NewsTabInfo;
import com.example.zheng.steward.ui.presenter.NewsFgPresenter;
import com.example.zheng.steward.utils.SPUtils;
import com.example.zheng.steward.utils.UIUtils;
import com.ogaclejapan.smarttablayout.SmartTabLayout;

import java.util.ArrayList;

import butterknife.Bind;

import static android.view.View.GONE;

/**
 * Created by zheng on 2018/3/30.
 * 消息fragment
 */

public class NewsFragment extends BaseFragment {

    private static final String TAG = "NewsFragment";

    /**
     * 工具栏上的title
     */
    @Bind(R.id.tvToolbarTitle)
    public TextView mToolbarTitle;

    /**
     * 扫描二维码按钮
     */
    @Bind(R.id.ibScanMenu)
    public Button mScanBtn;

    /**
     * tab
     */
    @Bind(R.id.newsTab)
    public SmartTabLayout mNewsTab;

    /**
     * viewPager
     */
    @Bind(R.id.newsViewPager)
    ViewPager mViewPager;

    protected ArrayList<NewsTabInfo> mNewsTabInfos = new ArrayList<>(5);

    @Override
    public void initView(View rootView) {
        super.initView(rootView);
        mScanBtn.setVisibility(GONE);
        mToolbarTitle.setText(SPUtils.getInstance(UIUtils.getContext()).getString(AppConst.Merchant.MERCHANT_NAME, ""));
        mToolbarTitle.setGravity(Gravity.CENTER);
    }

    @Override
    public void initData() {
        super.initData();
        //初始化ViewPager和SmartTabLayout用到的数据
        initNewsTabInfos();
        //初始化SmartTablayout和ViewPager
        initNewsTablayoutAndViewPager();
    }

    private void initNewsTabInfos() {

        //初始化Adapter需要使用的数据,标题,创建的Fragment对象,传递的参数
        Bundle bundle = new Bundle();
        bundle.putString("args","消息");
        // Fragment fragment = Fragment.instantiate(mContext, NewsPagerFragment.class.getName());
//        NewsPagerFragment fragment = new NewsPagerFragment();
        mNewsTabInfos.add(new NewsTabInfo("全部", NewsPagerFragment.class, bundle));
        mNewsTabInfos.add(new NewsTabInfo("资讯", NewsPagerFragment.class,null));
        mNewsTabInfos.add(new NewsTabInfo("申请提醒", NewsPagerFragment.class,null));
        mNewsTabInfos.add(new NewsTabInfo("逾期提醒", NewsPagerFragment.class,null));
        mNewsTabInfos.add(new NewsTabInfo("回购提醒", NewsPagerFragment.class,null));
    }

    private void initNewsTablayoutAndViewPager() {
        mViewPager.setAdapter(new NewsPagerAdapter(getChildFragmentManager(), getContext(), mNewsTabInfos));
        mNewsTab.setViewPager(mViewPager);
    }

    @Override
    protected BasePresenter createPresenter() {
        return new NewsFgPresenter((MainActivity) getActivity());
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.tab_news;
    }
}

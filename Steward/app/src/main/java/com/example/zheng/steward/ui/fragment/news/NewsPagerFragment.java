package com.example.zheng.steward.ui.fragment.news;

import android.app.Fragment;

import com.example.zheng.steward.R;
import com.example.zheng.steward.ui.base.BaseFragment;
import com.example.zheng.steward.ui.base.BasePresenter;

public class NewsPagerFragment extends BaseFragment {

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.tab_news_pager;
    }
}

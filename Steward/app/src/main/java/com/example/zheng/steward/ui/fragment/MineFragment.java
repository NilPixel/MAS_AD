package com.example.zheng.steward.ui.fragment;

import com.example.zheng.steward.R;
import com.example.zheng.steward.ui.base.BaseFragment;
import com.example.zheng.steward.ui.base.BasePresenter;

/**
 * Created by zheng on 2018/3/30.
 * 我的fragment
 */

public class MineFragment extends BaseFragment {

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.tab_mine;
    }
}

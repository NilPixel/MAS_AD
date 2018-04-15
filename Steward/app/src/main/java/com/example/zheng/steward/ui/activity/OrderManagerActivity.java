package com.example.zheng.steward.ui.activity;

import com.example.zheng.steward.R;
import com.example.zheng.steward.ui.base.BaseActivity;
import com.example.zheng.steward.ui.base.BasePresenter;

/**
 * 订单管理
 */

public class OrderManagerActivity extends BaseActivity {

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_order_manager;
    }
}

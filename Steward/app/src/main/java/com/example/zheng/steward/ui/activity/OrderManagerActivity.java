package com.example.zheng.steward.ui.activity;

import android.view.Gravity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.zheng.steward.R;
import com.example.zheng.steward.app.AppConst;
import com.example.zheng.steward.ui.base.BaseActivity;
import com.example.zheng.steward.ui.base.BasePresenter;
import com.example.zheng.steward.utils.SPUtils;
import com.example.zheng.steward.utils.UIUtils;

import butterknife.Bind;

import static android.view.View.GONE;
import static android.view.View.INVISIBLE;
import static android.view.View.VISIBLE;

/**
 * 订单管理
 */

public class OrderManagerActivity extends BaseActivity {

    /**
     * 返回按钮
     */
    @Bind(R.id.naviBack)
    ImageButton naviBackBtn;

    /**
     * 页面标题
     */
    @Bind(R.id.tvToolbarTitle)
    TextView titleTextView;

    /**
     * 扫码按钮
     */
    @Bind(R.id.ibScanMenu)
    ImageButton qrScanBtn;


    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_order_manager;
    }

    @Override
    public void initView() {
        super.initView();
        naviBackBtn.setVisibility(VISIBLE);
        qrScanBtn.setVisibility(GONE);
        titleTextView.setText("订单管理");
        titleTextView.setGravity(Gravity.CENTER);
    }

    @Override
    public void initListener() {
        super.initListener();
        naviBackBtn.setOnClickListener(view -> backBtnClicked());
    }

    /**
     * 工具栏返回按钮点击事件
     */
    private void backBtnClicked() {
        finish();
        overridePendingTransition(R.anim.left_in,R.anim.right_out);
    }

}

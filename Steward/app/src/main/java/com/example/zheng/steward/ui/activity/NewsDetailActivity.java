package com.example.zheng.steward.ui.activity;

import android.view.Gravity;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.zheng.steward.R;
import com.example.zheng.steward.ui.base.BaseActivity;
import com.example.zheng.steward.ui.base.BasePresenter;

import butterknife.Bind;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

public class NewsDetailActivity extends BaseActivity {

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
    Button qrScanBtn;

    @Override
    public void initView() {
        super.initView();
        naviBackBtn.setVisibility(VISIBLE);
        qrScanBtn.setVisibility(GONE);
        titleTextView.setText("消息详情");
        titleTextView.setGravity(Gravity.CENTER);
    }

    @Override
    public void initListener() {
        super.initListener();
        naviBackBtn.setOnClickListener(view -> backBtnClicked());
    }

    void backBtnClicked() {
        finish();
        overridePendingTransition(R.anim.left_in,R.anim.right_out);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        backBtnClicked();
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_news_detail;
    }
}

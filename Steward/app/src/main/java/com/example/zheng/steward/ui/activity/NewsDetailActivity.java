package com.example.zheng.steward.ui.activity;

import android.content.Intent;
import android.view.Gravity;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.zheng.steward.R;
import com.example.zheng.steward.ui.base.BaseActivity;
import com.example.zheng.steward.ui.presenter.NewsDetailPresenter;
import com.example.zheng.steward.ui.view.INewsDetailView;

import butterknife.Bind;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

public class NewsDetailActivity extends BaseActivity<INewsDetailView, NewsDetailPresenter> implements INewsDetailView {

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

    /**
     * 消息标题
     */
    @Bind(R.id.news_detail_title)
    TextView newsTitle;

    /**
     * 消息时间
     */
    @Bind(R.id.news_detail_time)
    TextView newsTime;

    /**
     * 消息内容
     */
    @Bind(R.id.news_detail_content)
    TextView newsContent;

    /**
     * 消息内容
     */
    @Bind(R.id.go_to_see_btn)
    Button goToSeeBtn;

    /**
     * 贷款编号
     */
    private String lendingNo;

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
        goToSeeBtn.setOnClickListener(v -> goToSeeBtnClicked());
    }

    @Override
    public void initData() {
        super.initData();
        String msgId = getIntent().getStringExtra("msgId");
        mPresenter.getMsgDetail(msgId);
    }

    void backBtnClicked() {
        finish();
        overridePendingTransition(R.anim.left_in,R.anim.right_out);
    }

    void goToSeeBtnClicked() {
        Intent intent = new Intent(this, NewsDetailActivity.class);
        intent.putExtra("lendingNo", lendingNo);

        startActivity(intent);
        overridePendingTransition(R.anim.right_in, R.anim.left_out);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        backBtnClicked();
    }

    @Override
    protected NewsDetailPresenter createPresenter() {
        return new NewsDetailPresenter(this);
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_news_detail;
    }

    @Override
    public TextView getNewsTitle() {
        return newsTitle;
    }

    @Override
    public TextView getNewsTime() {
        return newsTime;
    }

    @Override
    public TextView getNewsContent() {
        return newsContent;
    }

    @Override
    public void setLendingNo(String lendingNo) {
        this.lendingNo = lendingNo;
    }
}

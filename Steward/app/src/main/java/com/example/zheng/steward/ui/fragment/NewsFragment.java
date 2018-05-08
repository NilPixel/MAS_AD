package com.example.zheng.steward.ui.fragment;

import android.view.Gravity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.zheng.steward.R;
import com.example.zheng.steward.app.AppConst;
import com.example.zheng.steward.ui.base.BaseFragment;
import com.example.zheng.steward.ui.base.BasePresenter;
import com.example.zheng.steward.utils.SPUtils;
import com.example.zheng.steward.utils.UIUtils;

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
    public ImageButton mScanBtn;

    @Override
    public void initView(View rootView) {
        super.initView(rootView);
        mScanBtn.setVisibility(GONE);
        mToolbarTitle.setText(SPUtils.getInstance(UIUtils.getContext()).getString(AppConst.Merchant.MERCHANT_NAME, ""));
        mToolbarTitle.setGravity(Gravity.CENTER);
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.tab_news;
    }
}

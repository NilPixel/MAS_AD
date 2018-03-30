package com.example.zheng.steward.ui.fragment;

import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.zheng.steward.R;
import com.example.zheng.steward.ui.base.BaseFragment;
import com.example.zheng.steward.ui.base.BasePresenter;
import com.example.zheng.steward.widget.MyGridView;

import butterknife.Bind;

/**
 * Created by zheng on 2018/3/30.
 * 首页fragment
 */

public class HomeFragment extends BaseFragment {

    /**
     * 扫描二维码按钮
     */
    @Bind(R.id.qr_scan_btn)
    MenuItem qrScanItem;

    /**
     * 切换当月数据和累计数据的按钮
     */
    @Bind(R.id.view_cumulative_btn)
    Button mCumulativeBtn;

    /**
     * 查看当月或累计金额标签
     */
    @Bind(R.id.current_or_total_apply)
    TextView currentOrTotalApplyText;

    /**
     * 查看当月或累计进件数标签
     */
    @Bind(R.id.current_or_total_into)
    TextView currentOrTotalIntoText;

    /**
     * 当月或累计金额
     */
    @Bind(R.id.current_or_total_money)
    TextView currentOrTotalMoneyText;

    /**
     * 当月或累计进件数
     */
    @Bind(R.id.current_or_total_order)
    TextView currentOrTotalOrderText;

    /**
     * 券码验证按钮
     */
    @Bind(R.id.code_verification_btn)
    Button mVerificationBtn;

    /**
     * 开始分期按钮
     */
    @Bind(R.id.stages_btn)
    Button mstagesBtn;

    /**
     * 订单入口GridView
     */
    @Bind(R.id.order_interface_gridview)
    MyGridView mInterfaceGridView;

    /**
     * 新手须知按钮
     */
    @Bind(R.id.new_guidelines)
    ImageButton newGuidelinesBtn;

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected int provideContentViewId() {
        return 0;
    }
}

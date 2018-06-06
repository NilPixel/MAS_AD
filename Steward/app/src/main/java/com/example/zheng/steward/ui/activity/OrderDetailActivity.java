package com.example.zheng.steward.ui.activity;

import android.view.Gravity;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.example.zheng.steward.R;
import com.example.zheng.steward.db.model.OrderDetailListItem;
import com.example.zheng.steward.db.model.OrderManagerListItem;
import com.example.zheng.steward.ui.adapter.OrderDetailListAdapter;
import com.example.zheng.steward.ui.adapter.OrderManagerListAdapter;
import com.example.zheng.steward.ui.base.BaseActivity;
import com.example.zheng.steward.ui.base.BasePresenter;
import com.example.zheng.steward.ui.presenter.OrderDetailPresenter;
import com.example.zheng.steward.ui.view.INewsDetailView;
import com.example.zheng.steward.ui.view.IOrderDetailView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.Bind;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

public class OrderDetailActivity extends BaseActivity<IOrderDetailView, OrderDetailPresenter> implements IOrderDetailView {

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
     * 详情列表
     */
    @Bind(R.id.order_detail_list)
    ListView orderDetailListView;

    /**
     * listView适配器
     */
    private OrderDetailListAdapter listAdapter;

    /**
     * listView数据源
     */
    private List<String> orderDetailList = new ArrayList<>(Arrays.asList("lendingNo","applyName","sex","phoneNumber","productName","applyDate","applyAmtShow","passedAmtShow","merchantFeeShow","periods","salesName","applyStatus"));

    @Override
    public void initView() {
        super.initView();
        naviBackBtn.setVisibility(VISIBLE);
        qrScanBtn.setVisibility(GONE);
        titleTextView.setText("订单详情");
        titleTextView.setGravity(Gravity.CENTER);
    }

    @Override
    public void initData() {
        super.initData();
        String lendingNo = getIntent().getStringExtra("lendingNo");
        listAdapter = new OrderDetailListAdapter(this, R.layout.order_detail_item, orderDetailList);
        mPresenter.getOrderDetail(lendingNo);
    }

    @Override
    public void initListener() {
        super.initListener();
        naviBackBtn.setOnClickListener(view -> backBtnClicked());
    }

    @Override
    protected OrderDetailPresenter createPresenter() {
        return new OrderDetailPresenter(this);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        backBtnClicked();
    }

    /**
     * 工具栏返回按钮点击事件
     */
    private void backBtnClicked() {
        finish();
        overridePendingTransition(R.anim.left_in,R.anim.right_out);
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_order_detail;
    }

    @Override
    public OrderDetailListAdapter getAdapter() {
        return listAdapter;
    }

    @Override
    public List<String> getDataArrayList() {
        return orderDetailList;
    }

    @Override
    public ListView getOrderList() {
        return orderDetailListView;
    }
}

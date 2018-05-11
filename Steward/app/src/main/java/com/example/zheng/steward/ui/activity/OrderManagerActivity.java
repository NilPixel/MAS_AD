package com.example.zheng.steward.ui.activity;

import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.zheng.steward.R;
import com.example.zheng.steward.app.AppConst;
import com.example.zheng.steward.db.model.OrderManagerListItem;
import com.example.zheng.steward.ui.adapter.OrderManagerListAdapter;
import com.example.zheng.steward.ui.base.BaseActivity;
import com.example.zheng.steward.ui.base.BasePresenter;
import com.example.zheng.steward.ui.presenter.OrderManagerPresenter;
import com.example.zheng.steward.ui.view.IOrderManagerView;
import com.example.zheng.steward.utils.SPUtils;
import com.example.zheng.steward.utils.UIUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

import static android.view.View.GONE;
import static android.view.View.INVISIBLE;
import static android.view.View.VISIBLE;

/**
 * 订单管理
 */

public class OrderManagerActivity extends BaseActivity<IOrderManagerView, OrderManagerPresenter> implements IOrderManagerView {

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
     * 订单列表
     */
    @Bind(R.id.order_manager_list)
    ListView orderListView;

    /**
     * listView数据源
     */
    private List<OrderManagerListItem> orderList = new ArrayList<OrderManagerListItem>();

    /**
     * listView适配器
     */
    private OrderManagerListAdapter listAdapter;

    @Override
    protected OrderManagerPresenter createPresenter() {
        return new OrderManagerPresenter(this);
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
    public void initData() {
        super.initData();
        listAdapter = new OrderManagerListAdapter(OrderManagerActivity.this, R.layout.order_manager_item, orderList);
        mPresenter.getOrderListData();
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

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        backBtnClicked();
    }

    @Override
    public OrderManagerListAdapter getAdapter() {
        return listAdapter;
    }

    @Override
    public List<OrderManagerListItem> getDataArrayList() {
        return orderList;
    }

    @Override
    public ListView getOrderList() {
        return orderListView;
    }
}

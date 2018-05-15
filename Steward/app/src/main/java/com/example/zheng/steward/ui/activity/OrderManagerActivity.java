package com.example.zheng.steward.ui.activity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.example.zheng.steward.R;
import com.example.zheng.steward.db.model.OrderManagerListItem;
import com.example.zheng.steward.ui.adapter.OrderManagerListAdapter;
import com.example.zheng.steward.ui.base.BaseActivity;
import com.example.zheng.steward.ui.presenter.OrderManagerPresenter;
import com.example.zheng.steward.ui.view.IOrderManagerView;



import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import cn.bingoogolapple.refreshlayout.BGANormalRefreshViewHolder;
import cn.bingoogolapple.refreshlayout.BGARefreshLayout;
import cn.bingoogolapple.refreshlayout.BGARefreshViewHolder;

import static android.view.View.GONE;
import static android.view.View.INVISIBLE;
import static android.view.View.VISIBLE;

/**
 * 订单管理
 */

public class OrderManagerActivity extends BaseActivity<IOrderManagerView, OrderManagerPresenter> implements IOrderManagerView, BGARefreshLayout.BGARefreshLayoutDelegate {

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
     * 上拉、下拉刷新控件
     */
    @Bind(R.id.order_manager_refresher)
    BGARefreshLayout mRefreshLayout;

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

    @SuppressLint("ResourceType")
    public void initRefreshLayout() {
        // 为BGARefreshLayout 设置代理
        mRefreshLayout.setDelegate(this);
        // 设置下拉刷新和上拉加载更多的风格     参数1：应用程序上下文，参数2：是否具有上拉加载更多功能
        BGARefreshViewHolder refreshViewHolder = new BGANormalRefreshViewHolder(this, true);
        // 设置下拉刷新和上拉加载更多的风格
        mRefreshLayout.setRefreshViewHolder(refreshViewHolder);


        // 为了增加下拉刷新头部和加载更多的通用性，提供了以下可选配置选项  -------------START
        // 设置正在加载更多时不显示加载更多控件
        // mRefreshLayout.setIsShowLoadingMoreView(false);
        // 设置正在加载更多时的文本
        refreshViewHolder.setLoadingMoreText("上拉加载更多");
        // 设置整个加载更多控件的背景颜色资源 id
//        refreshViewHolder.setLoadMoreBackgroundColorRes(Color.WHITE);
//        // 设置整个加载更多控件的背景 drawable 资源 id
//        refreshViewHolder.setLoadMoreBackgroundDrawableRes(loadMoreBackgroundDrawableRes);
//        // 设置下拉刷新控件的背景颜色资源 id
//        refreshViewHolder.setRefreshViewBackgroundColorRes(refreshViewBackgroundColorRes);
//        // 设置下拉刷新控件的背景 drawable 资源 id
//        refreshViewHolder.setRefreshViewBackgroundDrawableRes(refreshViewBackgroundDrawableRes);
        // 设置自定义头部视图（也可以不用设置）     参数1：自定义头部视图（例如广告位）， 参数2：上拉加载更多是否可用
//        mRefreshLayout.setCustomHeaderView(mBanner, false);
        // 可选配置  -------------END
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

    @Override
    public BGARefreshLayout getRefresher() {
        return mRefreshLayout;
    }

    @Override
    public void onBGARefreshLayoutBeginRefreshing(BGARefreshLayout refreshLayout) {
        mPresenter.getOrderListData();
    }

    @Override
    public boolean onBGARefreshLayoutBeginLoadingMore(BGARefreshLayout refreshLayout) {
        mPresenter.getOrderListData();
        return true;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}

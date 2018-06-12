package com.example.zheng.steward.ui.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.baiiu.filter.DropDownMenu;
import com.baiiu.filter.interfaces.OnFilterDoneListener;
import com.example.zheng.steward.R;
import com.example.zheng.steward.db.model.OrderManagerListItem;
import com.example.zheng.steward.model.dropMenuEntity.FilterUrl;
import com.example.zheng.steward.ui.adapter.DropMenuAdapter;
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
import static android.view.View.VISIBLE;

/**
 * 订单管理
 */

public class OrderManagerActivity extends BaseActivity<IOrderManagerView, OrderManagerPresenter> implements IOrderManagerView, BGARefreshLayout.BGARefreshLayoutDelegate, AdapterView.OnItemClickListener, OnFilterDoneListener {

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
     * 条件筛选控件
     */
    @Bind(R.id.dropDownMenu)
    DropDownMenu mDropDownMenu;

    /**
     * 条件筛选控件
     */
    @Bind(R.id.mFilterContentView)
    TextView mFilterContentView;

    private Integer currentPage = 1;
    private String[] headers = new String[] {"订单状态", "销售筛选", "申请时间"};

    private String status[] = {"全部", "审批中", "待用户确认", "等待放款", "放款处理中", "放款成功", "待补件", "退件", "取消件"};// 订单状态选择菜单
    private String sellers[] = {"不限", "18岁以下", "18-22岁", "23-26岁", "27-35岁", "35岁以上"};

    private List<View> popupViews = new ArrayList<>();

    private ListView statusView; // 订单状态筛选view
    private ListView sellerView; // 销售筛选view


    private int constellationPosition = 0;//  选中群体样式列表的序列号

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
        initRefreshLayout();
        initDropDownMenu();
    }

    private void initDropDownMenu() {
       mDropDownMenu.setMenuAdapter(new DropMenuAdapter(this, headers, this));
    }

    @Override
    public void initData() {
        super.initData();
        listAdapter = new OrderManagerListAdapter(OrderManagerActivity.this, R.layout.order_manager_item, orderList);
        mPresenter.getOrderListData(currentPage);
    }

    @Override
    public void initListener() {
        super.initListener();
        naviBackBtn.setOnClickListener(view -> backBtnClicked());
        orderListView.setOnItemClickListener(this);
    }

    @SuppressLint("ResourceType")
    public void initRefreshLayout() {
        // 为BGARefreshLayout 设置代理
        mRefreshLayout.setDelegate(this);
        // 设置下拉刷新和上拉加载更多的风格     参数1：应用程序上下文，参数2：是否具有上拉加载更多功能
        BGARefreshViewHolder refreshViewHolder = new BGANormalRefreshViewHolder(this, true);



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
        // 设置下拉刷新和上拉加载更多的风格
        mRefreshLayout.setRefreshViewHolder(refreshViewHolder);
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
        currentPage = 1;
        mPresenter.getOrderListData(currentPage);
    }

    @Override
    public boolean onBGARefreshLayoutBeginLoadingMore(BGARefreshLayout refreshLayout) {
        currentPage += 1;
        mPresenter.getOrderListData(currentPage);
        return true;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        OrderManagerListItem item = orderList.get(position);
        Intent intent = new Intent(this, OrderDetailActivity.class);
        intent.putExtra("lendingNo", item.getLendingNo());

        startActivity(intent);
        overridePendingTransition(R.anim.right_in, R.anim.left_out);
    }

    @Override
    public void onFilterDone(int position, String positionTitle, String urlValue) {
        mDropDownMenu.setPositionIndicatorText(FilterUrl.instance().position, FilterUrl.instance().positionTitle);
        mDropDownMenu.close();
        mFilterContentView.setText(FilterUrl.instance()
                .toString());
    }
}

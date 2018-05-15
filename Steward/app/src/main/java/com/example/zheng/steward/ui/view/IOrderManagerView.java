package com.example.zheng.steward.ui.view;

import android.widget.ListView;

import com.example.zheng.steward.db.model.OrderManagerListItem;
import com.example.zheng.steward.ui.adapter.OrderManagerListAdapter;

import java.util.List;

import cn.bingoogolapple.refreshlayout.BGARefreshLayout;

public interface IOrderManagerView {
    OrderManagerListAdapter getAdapter();

    List<OrderManagerListItem> getDataArrayList();

    ListView getOrderList();

    BGARefreshLayout getRefresher();

}

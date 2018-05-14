package com.example.zheng.steward.ui.view;

import android.widget.ListView;

import com.example.zheng.steward.db.model.OrderManagerListItem;
import com.example.zheng.steward.ui.adapter.OrderManagerListAdapter;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;

import java.util.ArrayList;
import java.util.List;

public interface IOrderManagerView {
    OrderManagerListAdapter getAdapter();

    List<OrderManagerListItem> getDataArrayList();

    ListView getOrderList();

    TwinklingRefreshLayout getRefresher();

}

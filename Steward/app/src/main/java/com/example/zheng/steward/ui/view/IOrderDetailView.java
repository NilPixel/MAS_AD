package com.example.zheng.steward.ui.view;

import android.widget.ListView;

import com.example.zheng.steward.db.model.OrderDetailListItem;
import com.example.zheng.steward.ui.adapter.OrderDetailListAdapter;

import java.util.List;

public interface IOrderDetailView {

    OrderDetailListAdapter getAdapter();

    List<String> getDataArrayList();

    ListView getOrderList();
}

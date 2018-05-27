package com.example.zheng.steward.ui.view;

import android.widget.ListView;

import com.example.zheng.steward.db.model.NewsPagerListItem;
import com.example.zheng.steward.db.model.OrderManagerListItem;
import com.example.zheng.steward.ui.adapter.NewsPagerListAdapter;

import java.util.List;

import cn.bingoogolapple.refreshlayout.BGARefreshLayout;

public interface INewsPagerFgView {

    NewsPagerListAdapter getAdapter();

    List<NewsPagerListItem> getDataArrayList();

    ListView getNewsList();

    BGARefreshLayout getRefresher();
}

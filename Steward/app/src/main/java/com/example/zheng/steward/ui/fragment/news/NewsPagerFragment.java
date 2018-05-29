package com.example.zheng.steward.ui.fragment.news;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.ListView;

import com.example.zheng.steward.MainActivity;
import com.example.zheng.steward.R;
import com.example.zheng.steward.db.model.NewsPagerListItem;
import com.example.zheng.steward.ui.adapter.NewsPagerListAdapter;
import com.example.zheng.steward.ui.base.BaseFragment;
import com.example.zheng.steward.ui.presenter.NewsPagerFgPresenter;
import com.example.zheng.steward.ui.view.INewsPagerFgView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import cn.bingoogolapple.refreshlayout.BGANormalRefreshViewHolder;
import cn.bingoogolapple.refreshlayout.BGARefreshLayout;
import cn.bingoogolapple.refreshlayout.BGARefreshViewHolder;

public class NewsPagerFragment extends BaseFragment<INewsPagerFgView, NewsPagerFgPresenter>  implements INewsPagerFgView, BGARefreshLayout.BGARefreshLayoutDelegate {

    /**
     * 消息列表
     */
    @Bind(R.id.news_pager_list)
    ListView newsListView;

    /**
     * 上拉、下拉刷新控件
     */
    @Bind(R.id.news_pager_refresher)
    BGARefreshLayout mRefreshLayout;

    private Integer currentPage = 1;

    /**
     * listView数据源
     */
    private List<NewsPagerListItem> newsList = new ArrayList<>();

    /**
     * listView适配器
     */
    private NewsPagerListAdapter listAdapter;

    public String msgType;

    @Override
    public void initView(View rootView) {
        super.initView(rootView);
        initRefreshLayout();
    }

    @SuppressLint("ResourceType")
    private void initRefreshLayout() {
        // 为BGARefreshLayout 设置代理
        mRefreshLayout.setDelegate(this);
        // 设置下拉刷新和上拉加载更多的风格     参数1：应用程序上下文，参数2：是否具有上拉加载更多功能
        BGARefreshViewHolder refreshViewHolder = new BGANormalRefreshViewHolder(getContext(), true);



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

    @Override
    public void initData() {
        super.initData();
//        msgType = getArguments().getString("msgType");
        listAdapter = new NewsPagerListAdapter(getContext(), R.layout.news_pager_item, newsList);
        mRefreshLayout.beginRefreshing();
    }

    @Override
    protected NewsPagerFgPresenter createPresenter() {
        return new NewsPagerFgPresenter((MainActivity)getActivity());
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.tab_news_pager;
    }

    @Override
    public void onBGARefreshLayoutBeginRefreshing(BGARefreshLayout refreshLayout) {
        currentPage = 1;
        mPresenter.loadNewsData(currentPage, msgType);
    }

    @Override
    public boolean onBGARefreshLayoutBeginLoadingMore(BGARefreshLayout refreshLayout) {
        currentPage += 1;
        mPresenter.loadNewsData(currentPage, msgType);
        return true;
    }

    @Override
    public NewsPagerListAdapter getAdapter() {
        return listAdapter;
    }

    @Override
    public List<NewsPagerListItem> getDataArrayList() {
        return newsList;
    }

    @Override
    public ListView getNewsList() {
        return newsListView;
    }

    @Override
    public BGARefreshLayout getRefresher() {
        return mRefreshLayout;
    }
}

package com.example.zheng.steward.ui.presenter;

import android.widget.ListView;

import com.example.zheng.steward.R;
import com.example.zheng.steward.api.ApiRetrofit;
import com.example.zheng.steward.app.AppConst;
import com.example.zheng.steward.db.model.NewsPagerListItem;
import com.example.zheng.steward.db.model.OrderManagerListItem;
import com.example.zheng.steward.model.exception.ServerException;
import com.example.zheng.steward.ui.activity.LoginActivity;
import com.example.zheng.steward.ui.adapter.NewsPagerListAdapter;
import com.example.zheng.steward.ui.adapter.OrderManagerListAdapter;
import com.example.zheng.steward.ui.base.BaseActivity;
import com.example.zheng.steward.ui.base.BasePresenter;
import com.example.zheng.steward.ui.view.INewsPagerFgView;
import com.example.zheng.steward.utils.LogUtils;
import com.example.zheng.steward.utils.NumberUtils;
import com.example.zheng.steward.utils.SPUtils;
import com.example.zheng.steward.utils.UIUtils;

import java.util.List;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class NewsPagerFgPresenter extends BasePresenter<INewsPagerFgView> {

    public NewsPagerFgPresenter(BaseActivity context) {
        super(context);
    }

    public void loadNewsData(Integer currentPage, String msgType) {
        requestNewsData(currentPage, msgType);
    }

    private void requestNewsData(Integer currentPage, String msgType) {
        mContext.showWaitingDialog(UIUtils.getString(R.string.please_wait));
        ApiRetrofit.getInstance()
                .getNewsPagerListData(currentPage.toString(), msgType)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(newsListDataResponse -> {
                    mContext.hideWaitingDialog();

                    String code = newsListDataResponse.getCode();
                    if (AppConst.ResponseCode.SUCCESS.equals(code)) {
                        List<NewsPagerListItem> data = getView().getDataArrayList();

                        if (currentPage == 1) {
                            data.clear();
                            data.addAll(newsListDataResponse.getRows());
                            getView().getRefresher().endRefreshing();
                        } else {
                            data.addAll(newsListDataResponse.getRows());
                            getView().getRefresher().endLoadingMore();
                        }

                        if (data.size() >= newsListDataResponse.getRecords()) {
                            UIUtils.showToast("没有更多数据");
                        }
                        NewsPagerListAdapter adapter = getView().getAdapter();
                        ListView listView = getView().getNewsList();
                        listView.setAdapter(adapter);
                    } else {
                        if (AppConst.ResponseCode.TOKEN_EXPIRE.equals(code)) {
                            mContext.jumpToActivityAndClearTask(LoginActivity.class, R.anim.bottom_in, R.anim.top_out);
                            mContext.finish();
                        }
                        newsDataRequestError(new ServerException(newsListDataResponse.getDesc() + code));
                    }
                }, this::newsDataRequestError);
    }

    private void newsDataRequestError(Throwable throwable) {
        LogUtils.e(throwable.getLocalizedMessage());
        UIUtils.showToast(throwable.getLocalizedMessage());
    }
}

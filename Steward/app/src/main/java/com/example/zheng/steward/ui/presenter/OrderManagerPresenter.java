package com.example.zheng.steward.ui.presenter;

import android.widget.ListView;

import com.example.zheng.steward.R;
import com.example.zheng.steward.api.ApiRetrofit;
import com.example.zheng.steward.app.AppConst;
import com.example.zheng.steward.db.model.OrderManagerListItem;
import com.example.zheng.steward.model.exception.ServerException;
import com.example.zheng.steward.ui.adapter.OrderManagerListAdapter;
import com.example.zheng.steward.ui.base.BaseActivity;
import com.example.zheng.steward.ui.base.BasePresenter;
import com.example.zheng.steward.ui.view.IOrderManagerView;
import com.example.zheng.steward.utils.LogUtils;
import com.example.zheng.steward.utils.UIUtils;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;

import java.util.List;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class OrderManagerPresenter extends BasePresenter<IOrderManagerView> {

    public OrderManagerPresenter(BaseActivity context) {
        super(context);
    }

    public void getOrderListData() {

        mContext.showWaitingDialog(UIUtils.getString(R.string.please_wait));
        ApiRetrofit.getInstance().getOrderListData(1, 15,"DESC","", "", "", "")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(listResponse -> {
                    String code = listResponse.getCode();
                    mContext.hideWaitingDialog();
                    if (AppConst.ResponseCode.SUCCESS.equals(code)) {
                        List<OrderManagerListItem> data = getView().getDataArrayList();
                        data.addAll(listResponse.getResult());

                        OrderManagerListAdapter adapter = getView().getAdapter();
                        ListView listView = getView().getOrderList();
                        listView.setAdapter(adapter);

                        TwinklingRefreshLayout refreshLayout = getView().getRefresher();
                        refreshLayout.finishRefreshing();
                    } else {
                        loginError(new ServerException(listResponse.getDesc() + code));
                    }
                }, this::loginError);
    }

    private void loginError(Throwable throwable) {
        LogUtils.e(throwable.getLocalizedMessage());
        UIUtils.showToast(throwable.getLocalizedMessage());
        mContext.hideWaitingDialog();
    }
}

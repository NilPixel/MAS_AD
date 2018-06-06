package com.example.zheng.steward.ui.presenter;

import android.widget.ListView;
import android.widget.TextView;

import com.example.zheng.steward.R;
import com.example.zheng.steward.api.ApiRetrofit;
import com.example.zheng.steward.app.AppConst;
import com.example.zheng.steward.db.model.OrderDetailListContent;
import com.example.zheng.steward.db.model.OrderDetailListItem;
import com.example.zheng.steward.db.model.OrderManagerListItem;
import com.example.zheng.steward.model.exception.ServerException;
import com.example.zheng.steward.ui.activity.LoginActivity;
import com.example.zheng.steward.ui.adapter.OrderDetailListAdapter;
import com.example.zheng.steward.ui.adapter.OrderManagerListAdapter;
import com.example.zheng.steward.ui.base.BaseActivity;
import com.example.zheng.steward.ui.base.BasePresenter;
import com.example.zheng.steward.ui.view.IOrderDetailView;
import com.example.zheng.steward.utils.BeanToMapUtil;
import com.example.zheng.steward.utils.LogUtils;
import com.example.zheng.steward.utils.TimeUtils;
import com.example.zheng.steward.utils.UIUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class OrderDetailPresenter extends BasePresenter<IOrderDetailView> {

    public OrderDetailPresenter(BaseActivity context) {
        super(context);
    }

    public void getOrderDetail(String lendingNo) {

        mContext.showWaitingDialog(UIUtils.getString(R.string.please_wait));
        ApiRetrofit.getInstance().getOrderDetailData(lendingNo)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(detailResponse -> {
                    String code = detailResponse.getCode();
                    mContext.hideWaitingDialog();
                    if (AppConst.ResponseCode.SUCCESS.equals(code)) {

                        OrderDetailListAdapter adapter = getView().getAdapter();
                        adapter.contentResult = detailResponse.getResult();
                        ListView listView = getView().getOrderList();

                        listView.setAdapter(adapter);
                    } else {
                        if (AppConst.ResponseCode.TOKEN_EXPIRE.equals(code)) {
                            mContext.jumpToActivityAndClearTask(LoginActivity.class, R.anim.bottom_in, R.anim.top_out);
                            mContext.finish();
                        }
                        getDetailDataError(new ServerException(detailResponse.getDesc() + code));
                    }
                }, this::getDetailDataError);
    }

    private void getDetailDataError(Throwable throwable) {
        LogUtils.e(throwable.getLocalizedMessage());
        UIUtils.showToast(throwable.getLocalizedMessage());
        mContext.hideWaitingDialog();
    }
}

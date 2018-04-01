package com.example.zheng.steward.ui.presenter;

import com.example.zheng.steward.MainActivity;
import com.example.zheng.steward.R;
import com.example.zheng.steward.api.ApiRetrofit;
import com.example.zheng.steward.app.AppConst;
import com.example.zheng.steward.model.cache.UserCache;
import com.example.zheng.steward.model.exception.ServerException;
import com.example.zheng.steward.ui.base.BaseActivity;
import com.example.zheng.steward.ui.base.BasePresenter;
import com.example.zheng.steward.ui.view.IHomeFgView;
import com.example.zheng.steward.utils.LogUtils;
import com.example.zheng.steward.utils.SPUtils;
import com.example.zheng.steward.utils.UIUtils;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by zheng on 2018/3/30.
 */

public class HomeFgPresenter extends BasePresenter<IHomeFgView> {

    public HomeFgPresenter(BaseActivity context) {
        super(context);
    }

    public void loadHomeData() {
        requestHomeData();
    }

    private void requestHomeData() {
        ApiRetrofit.getInstance()
                .getHomeData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(homeDataResponse -> {
                    int code = homeDataResponse.getCode();
                    mContext.hideWaitingDialog();
                    if (code == AppConst.ResponseCode.SUCCESS) {
                        SPUtils.getInstance(UIUtils.getContext()).putString(AppConst.Merchant.MERCHANT_CODE, homeDataResponse.getMerchantCode());
                        SPUtils.getInstance(UIUtils.getContext()).putString(AppConst.Merchant.MERCHANT_NAME, homeDataResponse.getMerchantName());
                    } else {
                        homeDataRequestError(new ServerException(homeDataResponse.getDesc() + code));
                    }
                }, this::homeDataRequestError);
    }

    private void homeDataRequestError(Throwable throwable) {
        LogUtils.e(throwable.getLocalizedMessage());
        UIUtils.showToast(throwable.getLocalizedMessage());
        mContext.hideWaitingDialog();
    }

}

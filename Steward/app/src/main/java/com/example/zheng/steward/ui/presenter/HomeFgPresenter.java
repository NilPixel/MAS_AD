package com.example.zheng.steward.ui.presenter;

import com.example.zheng.steward.MainActivity;
import com.example.zheng.steward.R;
import com.example.zheng.steward.api.ApiRetrofit;
import com.example.zheng.steward.app.AppConst;
import com.example.zheng.steward.model.cache.UserCache;
import com.example.zheng.steward.model.exception.ServerException;
import com.example.zheng.steward.ui.activity.LoginActivity;
import com.example.zheng.steward.ui.base.BaseActivity;
import com.example.zheng.steward.ui.base.BasePresenter;
import com.example.zheng.steward.ui.view.IHomeFgView;
import com.example.zheng.steward.utils.LogUtils;
import com.example.zheng.steward.utils.NumberUtils;
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
                    String code = homeDataResponse.getCode();
                    if (AppConst.ResponseCode.SUCCESS.equals(code)) {
                        SPUtils.getInstance(UIUtils.getContext()).putString(AppConst.Merchant.MERCHANT_CODE, homeDataResponse.getMerchantCode());
                        SPUtils.getInstance(UIUtils.getContext()).putString(AppConst.Merchant.MERCHANT_NAME, homeDataResponse.getMerchantName());

                        getView().getSumTextView().setText(String.valueOf(homeDataResponse.getMonthAmount()));
                        getView().getOrderNumTextView().setText(String.valueOf(homeDataResponse.getMonthApply()));
                        getView().getToolBarTitleTextView().setText(homeDataResponse.getMerchantName());

                        SPUtils.getInstance(UIUtils.getContext()).putString(AppConst.Merchant.MONTH_AMOUNT, String.valueOf(homeDataResponse.getMonthAmount()));
                        SPUtils.getInstance(UIUtils.getContext()).putString(AppConst.Merchant.TOTAL_AMOUNT, NumberUtils.convertToTenThousand(homeDataResponse.getTotalAmount()));
                        SPUtils.getInstance(UIUtils.getContext()).putString(AppConst.Merchant.MONTH_APPLY, String.valueOf(homeDataResponse.getMonthApply()));
                        SPUtils.getInstance(UIUtils.getContext()).putString(AppConst.Merchant.TOTAL_APPLY, String.valueOf(homeDataResponse.getTotalApply()));
                    } else {
                        if (AppConst.ResponseCode.TOKEN_EXPIRE.equals(code)) {
                            mContext.jumpToActivityAndClearTask(LoginActivity.class, R.anim.bottom_in, R.anim.top_out);
                            mContext.finish();
                        }
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

package com.example.zheng.steward.ui.presenter;

import com.example.zheng.steward.R;
import com.example.zheng.steward.api.ApiRetrofit;
import com.example.zheng.steward.app.AppConst;
import com.example.zheng.steward.model.exception.ServerException;
import com.example.zheng.steward.ui.activity.LoginActivity;
import com.example.zheng.steward.ui.base.BaseActivity;
import com.example.zheng.steward.ui.base.BasePresenter;
import com.example.zheng.steward.ui.view.INewsPagerFgView;
import com.example.zheng.steward.utils.LogUtils;
import com.example.zheng.steward.utils.NumberUtils;
import com.example.zheng.steward.utils.SPUtils;
import com.example.zheng.steward.utils.UIUtils;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class NewsPagerFgPresenter extends BasePresenter<INewsPagerFgView> {

    public NewsPagerFgPresenter(BaseActivity context) {
        super(context);
    }

    public void loadNewsData(Integer currentPage) {
        requestNewsData(currentPage);
    }

    private void requestNewsData(Integer currentPage) {
        ApiRetrofit.getInstance()
                .getHomeData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(homeDataResponse -> {
                    String code = homeDataResponse.getCode();
                    if (AppConst.ResponseCode.SUCCESS.equals(code)) {

                    } else {
                        if (AppConst.ResponseCode.TOKEN_EXPIRE.equals(code)) {
                            mContext.jumpToActivityAndClearTask(LoginActivity.class, R.anim.bottom_in, R.anim.top_out);
                            mContext.finish();
                        }
                        newsDataRequestError(new ServerException(homeDataResponse.getDesc() + code));
                    }
                }, this::newsDataRequestError);
    }

    private void newsDataRequestError(Throwable throwable) {
        LogUtils.e(throwable.getLocalizedMessage());
        UIUtils.showToast(throwable.getLocalizedMessage());
    }
}

package com.example.zheng.steward.ui.presenter;

import android.text.TextUtils;

import com.example.zheng.steward.MainActivity;
import com.example.zheng.steward.R;
import com.example.zheng.steward.api.ApiRetrofit;
import com.example.zheng.steward.app.AppConst;
import com.example.zheng.steward.model.cache.UserCache;
import com.example.zheng.steward.model.exception.ServerException;
import com.example.zheng.steward.ui.base.BaseActivity;
import com.example.zheng.steward.ui.base.BasePresenter;
import com.example.zheng.steward.ui.view.ILoginAtView;
import com.example.zheng.steward.utils.EncryptUtils;
import com.example.zheng.steward.utils.LogUtils;
import com.example.zheng.steward.utils.UIUtils;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import static io.rong.imlib.statistics.UserData.phone;

/**
 * Created by jarvis on 2018/3/22.
 */

public class LoginAtPresenter extends BasePresenter<ILoginAtView> {

    public LoginAtPresenter(BaseActivity context) {
        super(context);
    }

    public void login() {
        String userName = getView().getEtUserName().getText().toString().trim();
        String pwd = getView().getEtPwd().getText().toString().trim();

        if (TextUtils.isEmpty(userName)) {
            UIUtils.showToast(UIUtils.getString(R.string.username_not_empty));
            return;
        }
        if (TextUtils.isEmpty(pwd)) {
            UIUtils.showToast(UIUtils.getString(R.string.password_not_empty));
            return;
        }

        mContext.showWaitingDialog(UIUtils.getString(R.string.please_wait));
        ApiRetrofit.getInstance().login(userName, EncryptUtils.md5Encrypt(pwd), true)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(loginResponse -> {
                    int code = loginResponse.getCode();
                    mContext.hideWaitingDialog();
                    if (code == AppConst.ResponseCode.SUCCESS) {
                        UserCache.save(loginResponse.getUserToken().getExpireTime(), userName, loginResponse.getUserToken().getToken());
                        mContext.jumpToActivityAndClearTask(MainActivity.class, R.anim.bottom_in, R.anim.top_out);
                        mContext.finish();
                    } else {
                        loginError(new ServerException(loginResponse.getDesc() + code));
                    }
                }, this::loginError);
    }

    private void loginError(Throwable throwable) {
        LogUtils.e(throwable.getLocalizedMessage());
        UIUtils.showToast(throwable.getLocalizedMessage());
        mContext.hideWaitingDialog();
    }

}

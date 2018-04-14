package com.example.zheng.steward.ui.presenter;

import android.graphics.Bitmap;

import com.example.zheng.steward.R;
import com.example.zheng.steward.api.ApiRetrofit;
import com.example.zheng.steward.app.AppConst;
import com.example.zheng.steward.model.exception.ServerException;
import com.example.zheng.steward.ui.activity.LoginActivity;
import com.example.zheng.steward.ui.base.BaseActivity;
import com.example.zheng.steward.ui.base.BasePresenter;
import com.example.zheng.steward.ui.view.IQRCodeFgView;
import com.example.zheng.steward.utils.LogUtils;
import com.example.zheng.steward.utils.NumberUtils;
import com.example.zheng.steward.utils.SPUtils;
import com.example.zheng.steward.utils.UIUtils;
import com.jwsd.libzxing.QRCodeManager;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by jarvis on 2018/4/11.
 */

public class QRCodeFgPresenter extends BasePresenter<IQRCodeFgView> {

    public QRCodeFgPresenter(BaseActivity context) {
        super(context);
    }

    public void loadQRCodeString() {
        requestQRCodeString();
    }

    private void requestQRCodeString() {
        mContext.showWaitingDialog(UIUtils.getString(R.string.please_wait));
        ApiRetrofit.getInstance()
                .getQRCodeString()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(qrCodeResponse -> {
                    int code = qrCodeResponse.getCode();
                    if (code == AppConst.ResponseCode.SUCCESS) {
                        Bitmap bitmap = QRCodeManager.getInstance().createQRCode(qrCodeResponse.getDetailInfo(), 300, 300);
                        mContext.hideWaitingDialog();
                        getView().getQrTitleTxView().setText(SPUtils.getInstance(UIUtils.getContext()).getString(AppConst.Merchant.MERCHANT_NAME, ""));
                        getView().getQRCodeView().setImageBitmap(bitmap);

                    } else {
                        mContext.hideWaitingDialog();
                        if (code == AppConst.ResponseCode.TOKEN_EXPIRE) {
                            mContext.jumpToActivityAndClearTask(LoginActivity.class, R.anim.bottom_in, R.anim.top_out);
                            mContext.finish();
                        }
                        qrCodeRequestError(new ServerException(qrCodeResponse.getDesc() + code));
                    }
                }, this::qrCodeRequestError);
    }

    private void qrCodeRequestError(Throwable throwable) {
        LogUtils.e(throwable.getLocalizedMessage());
        UIUtils.showToast(throwable.getLocalizedMessage());
        mContext.hideWaitingDialog();
    }
}

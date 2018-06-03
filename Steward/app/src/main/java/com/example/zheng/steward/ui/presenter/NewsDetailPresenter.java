package com.example.zheng.steward.ui.presenter;

import android.widget.ListView;
import android.widget.TextView;

import com.example.zheng.steward.R;
import com.example.zheng.steward.api.ApiRetrofit;
import com.example.zheng.steward.app.AppConst;
import com.example.zheng.steward.db.model.OrderManagerListItem;
import com.example.zheng.steward.model.exception.ServerException;
import com.example.zheng.steward.ui.activity.LoginActivity;
import com.example.zheng.steward.ui.adapter.OrderManagerListAdapter;
import com.example.zheng.steward.ui.base.BaseActivity;
import com.example.zheng.steward.ui.base.BasePresenter;
import com.example.zheng.steward.ui.view.INewsDetailView;
import com.example.zheng.steward.utils.LogUtils;
import com.example.zheng.steward.utils.TimeUtils;
import com.example.zheng.steward.utils.UIUtils;

import java.util.List;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class NewsDetailPresenter extends BasePresenter<INewsDetailView> {

    public NewsDetailPresenter(BaseActivity context) {
        super(context);
    }

    public void getMsgDetail(String msgId) {

        mContext.showWaitingDialog(UIUtils.getString(R.string.please_wait));
        ApiRetrofit.getInstance().getNewsDetailData(msgId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(detailResponse -> {
                    String code = detailResponse.getCode();
                    mContext.hideWaitingDialog();
                    if (AppConst.ResponseCode.SUCCESS.equals(code)) {

                        TextView newsTitle = getView().getNewsTitle();
                        newsTitle.setText(detailResponse.getDetailInfo().getMsgTitle());

                        TextView newsTime = getView().getNewsTime();
                        newsTime.setText(TimeUtils.getDateToString(Long.parseLong(detailResponse.getDetailInfo().getSentTime()), "yyyy-MM-dd HH:mm"));


                        TextView newsContent = getView().getNewsContent();
                        newsContent.setText(detailResponse.getDetailInfo().getMsgContent());

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

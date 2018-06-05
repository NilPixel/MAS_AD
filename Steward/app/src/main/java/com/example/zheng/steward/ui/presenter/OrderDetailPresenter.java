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
                        List<OrderDetailListItem> data = getView().getDataArrayList();
                        try {
                            data.addAll(getOrderDetailListData(detailResponse.getResult()));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        OrderDetailListAdapter adapter = getView().getAdapter();
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

    private ArrayList<OrderDetailListItem> getOrderDetailListData(OrderDetailListContent content) throws Exception {

        Map<String, String> contentMap = BeanToMapUtil.bean2Map(content);

        ArrayList<OrderDetailListItem> data = new ArrayList<>();

        for (String key : contentMap.keySet()) {
            switch (key) {
                case "lendingNo":
                    OrderDetailListItem lendingNoItem = new OrderDetailListItem();
                    lendingNoItem.setTitle("贷款编号:");
                    lendingNoItem.setContent(contentMap.get(key));
                    data.add(lendingNoItem);
                    break;
                case "applyName":
                    OrderDetailListItem applyNameItem = new OrderDetailListItem();
                    applyNameItem.setTitle("申请人姓名:");
                    applyNameItem.setContent(contentMap.get(key));
                    data.add(applyNameItem);
                    break;
                case "sex":
                    OrderDetailListItem sexItem = new OrderDetailListItem();
                    sexItem.setTitle("性别:");
                    sexItem.setContent(contentMap.get(key));
                    data.add(sexItem);
                    break;
                case "phoneNumber":
                    OrderDetailListItem phoneNumberItem = new OrderDetailListItem();
                    phoneNumberItem.setTitle("手机号码:");
                    phoneNumberItem.setContent(contentMap.get(key));
                    data.add(phoneNumberItem);
                    break;
                case "productName":
                    OrderDetailListItem productNameItem = new OrderDetailListItem();
                    productNameItem.setTitle("商品名称:");
                    productNameItem.setContent(contentMap.get(key));
                    data.add(productNameItem);
                    break;
                case "applyDate":
                    OrderDetailListItem applyDateItem = new OrderDetailListItem();
                    applyDateItem.setTitle("申请日期:");
                    applyDateItem.setContent(contentMap.get(key));
                    data.add(applyDateItem);
                    break;
                case "applyAmtShow":
                    OrderDetailListItem applyAmtShowItem = new OrderDetailListItem();
                    applyAmtShowItem.setTitle("申请金额:");
                    applyAmtShowItem.setContent(contentMap.get(key));
                    data.add(applyAmtShowItem);
                    break;
                case "passedAmtShow":
                    OrderDetailListItem passedAmtShowItem = new OrderDetailListItem();
                    passedAmtShowItem.setTitle("审核通过金额:");
                    passedAmtShowItem.setContent(contentMap.get(key));
                    data.add(passedAmtShowItem);
                    break;
                case "merchantFeeShow":
                    OrderDetailListItem merchantFeeShowItem = new OrderDetailListItem();
                    merchantFeeShowItem.setTitle("商户手续费:");
                    merchantFeeShowItem.setContent(contentMap.get(key));
                    data.add(merchantFeeShowItem);
                    break;
                case "periods":
                    OrderDetailListItem periodsItem = new OrderDetailListItem();
                    periodsItem.setTitle("期数:");
                    periodsItem.setContent(contentMap.get(key));
                    data.add(periodsItem);
                    break;
                case "salesName":
                    OrderDetailListItem salesNameItem = new OrderDetailListItem();
                    salesNameItem.setTitle("销售人员:");
                    salesNameItem.setContent(contentMap.get(key));
                    data.add(salesNameItem);
                    break;
                case "applyStatus":
                    OrderDetailListItem applyStatusItem = new OrderDetailListItem();
                    applyStatusItem.setTitle("订单状态:");
                    applyStatusItem.setContent(contentMap.get(key));
                    data.add(applyStatusItem);
                    break;
                    default:break;
            }
        }

        return data;
    }
}

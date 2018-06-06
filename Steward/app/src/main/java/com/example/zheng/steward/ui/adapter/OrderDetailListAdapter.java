package com.example.zheng.steward.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.zheng.steward.R;
import com.example.zheng.steward.db.model.OrderDetailListContent;
import com.example.zheng.steward.db.model.OrderDetailListItem;
import com.example.zheng.steward.utils.StringUtils;

import java.util.List;

public class OrderDetailListAdapter extends ArrayAdapter {

    private final int resourceId;

    public OrderDetailListContent contentResult;

    public OrderDetailListAdapter(@NonNull Context context, int resource, @NonNull List<String> objects) {
        super(context, resource, objects);
        resourceId = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        String listItem = (String) getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceId, null);//实例化一个对象

        TextView title = view.findViewById(R.id.order_detail_item_title);
        TextView content = view.findViewById(R.id.order_detail_item_content);

        if (!StringUtils.isEmpty(listItem)) {
            switch (listItem) {
                case "lendingNo":
                    title.setText("贷款编号:");
                    content.setText(contentResult.getLendingNo());
                    break;
                case "applyName":
                    title.setText("申请人姓名:");
                    content.setText(contentResult.getApplyName());
                    break;
                case "sex":
                    title.setText("性别:");
                    content.setText(contentResult.getSex());
                    break;
                case "phoneNumber":
                    title.setText("手机号码:");
                    content.setText(contentResult.getPhoneNumber());
                    break;
                case "productName":
                    title.setText("商品名称:");
                    content.setText(contentResult.getProductName());
                    break;
                case "applyDate":
                    title.setText("申请日期:");
                    content.setText(contentResult.getApplyDate());
                    break;
                case "applyAmtShow":
                    title.setText("申请金额:");
                    content.setText(contentResult.getApplyAmtShow());
                    break;
                case "passedAmtShow":
                    title.setText("审核通过金额:");
                    content.setText(contentResult.getPassedAmtShow());
                    break;
                case "merchantFeeShow":
                    title.setText("商户手续费:");
                    content.setText(contentResult.getMerchantFeeShow());
                    break;
                case "periods":
                    title.setText("期数:");
                    content.setText(contentResult.getPeriods());
                    break;
                case "salesName":
                    title.setText("销售人员:");
                    content.setText(contentResult.getSalesName());
                    break;
                case "applyStatus":
                    title.setText("订单状态:");
                    content.setText(contentResult.getApplyStatus());
                    break;
                default:break;
            }
        }
        return view;
    }
}

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
import com.example.zheng.steward.db.model.OrderManagerListItem;

import java.util.List;

public class OrderManagerListAdapter extends ArrayAdapter {

    private final int resourceId;

    public OrderManagerListAdapter(@NonNull Context context, int resource, @NonNull List<OrderManagerListItem> objects) {
        super(context, resource, objects);
        resourceId = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        OrderManagerListItem listItem = (OrderManagerListItem) getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceId, null);//实例化一个对象

        TextView lendingNo = view.findViewById(R.id.order_manager_lendingNo);
        lendingNo.setText(listItem.getLendingNo());

        TextView applyName = view.findViewById(R.id.order_manager_name);
        applyName.setText(listItem.getApplyName());

        TextView time = view.findViewById(R.id.order_manager_time);
        time.setText(listItem.getApplyDate());

        TextView storeName = view.findViewById(R.id.order_manager_storeName);
        storeName.setText(listItem.getStore());

        TextView orderStatus = view.findViewById(R.id.order_manager_orderStatus);
        orderStatus.setText(listItem.getApplyStatus());

        return view;
    }
}

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
import com.example.zheng.steward.db.model.OrderDetailListItem;
import com.example.zheng.steward.db.model.OrderManagerListItem;

import java.util.List;

public class OrderDetailListAdapter extends ArrayAdapter {

    private final int resourceId;

    public OrderDetailListAdapter(@NonNull Context context, int resource, @NonNull List<OrderDetailListItem> objects) {
        super(context, resource, objects);
        resourceId = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        OrderDetailListItem listItem = (OrderDetailListItem) getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceId, null);//实例化一个对象

        TextView title = view.findViewById(R.id.order_detail_item_title);
        title.setText(listItem.getTitle());

        TextView content = view.findViewById(R.id.order_detail_item_content);
        content.setText(listItem.getContent());

        return view;
    }
}

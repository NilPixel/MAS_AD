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
import com.example.zheng.steward.db.model.NewsPagerListItem;
import com.example.zheng.steward.utils.TimeUtils;

import java.util.List;

public class NewsPagerListAdapter extends ArrayAdapter {

    private final int resourceId;

    public NewsPagerListAdapter(@NonNull Context context, int resource, @NonNull List<NewsPagerListItem> objects) {
        super(context, resource, objects);
        resourceId = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        NewsPagerListItem listItem = (NewsPagerListItem) getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceId, null);//实例化一个对象

        TextView msgTitle = view.findViewById(R.id.new_item_title);
        msgTitle.setText(listItem.getMsgTitle());

        TextView msgContent = view.findViewById(R.id.new_item_content);
        msgContent.setText(listItem.getMsgContent());

        TextView time = view.findViewById(R.id.new_item_time);
        time.setText(TimeUtils.getDateToString(Long.parseLong(listItem.getSentTime()), "yyyy-MM-dd HH:mm"));

        return view;
    }
}

package com.example.zheng.steward.ui.fragment;

import android.app.Dialog;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.zheng.steward.MainActivity;
import com.example.zheng.steward.R;
import com.example.zheng.steward.ui.presenter.QRCodeFgPresenter;
import com.example.zheng.steward.ui.view.IQRCodeFgView;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by jarvis on 2018/4/8.
 */

public class QRCodeFragment extends DialogFragment implements IQRCodeFgView {

    @Bind(R.id.qr_code_image)
    ImageView qrImageView;

    @Bind(R.id.qr_title_text)
    TextView qrTitleText;

    QRCodeFgPresenter qrCodeFgPresenter;    //present对象

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        View rootView = inflater.inflate(R.layout.qr_code, container);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        qrCodeFgPresenter = new QRCodeFgPresenter((MainActivity) getActivity());
        qrCodeFgPresenter.attachView(this);
        qrCodeFgPresenter.loadQRCodeString();
    }

    @Override
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {
            DisplayMetrics dm = new DisplayMetrics();
            getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);
            dialog.getWindow().setLayout((int) (dm.widthPixels * 0.9), ViewGroup.LayoutParams.WRAP_CONTENT);
        }
    }

    @Override
    public ImageView getQRCodeView() {
        return qrImageView;
    }

    @Override
    public TextView getQrTitleTxView() {
        return qrTitleText;
    }
}

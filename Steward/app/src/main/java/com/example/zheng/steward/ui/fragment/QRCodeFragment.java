package com.example.zheng.steward.ui.fragment;

import android.app.Dialog;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.zheng.steward.R;
import com.jwkj.libzxing.QRCodeManager;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by jarvis on 2018/4/8.
 */

public class QRCodeFragment extends DialogFragment {

    @Bind(R.id.qr_code_image)
    ImageView qrImageView;

    String qrString;    //二维码内容

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.qr_code, container);
        ButterKnife.bind(this, rootView);
        return rootView;
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

    public String getQrString() {
        return qrString;
    }

    public void setQrString(String qrString) {
        this.qrString = qrString;
        Bitmap bitmap = QRCodeManager.getInstance().createQRCode(qrString, 300, 300);
//        qrImageView.setImageBitmap(bitmap);
    }
}

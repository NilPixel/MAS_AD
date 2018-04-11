package com.example.zheng.steward.ui.view;

import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by jarvis on 2018/4/11.
 */

public interface IQRCodeFgView {

    //获取二维码展示view
    ImageView getQRCodeView();

    //获取二维码页展示标题textView
    TextView getQrTitleTxView();

}

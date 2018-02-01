package com.example.zheng.steward.ui.base;

import android.support.v7.app.AppCompatActivity;

import com.example.zheng.steward.widget.CustomDialog;

import butterknife.Bind;
import me.drakeet.materialdialog.MaterialDialog;

/**
 * Created by zheng on 2018/2/1.
 */

public abstract class BaseActivity<V, T extends BasePresenter<V>> extends AppCompatActivity {

    protected T mPresenter;
    private CustomDialog mDialogWaiting;
    private MaterialDialog mMaterialDialog;

    //以下是所有Activity中可能会出现的控件


}

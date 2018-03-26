package com.example.zheng.steward.ui.activity;

import android.graphics.Color;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;

import com.example.zheng.steward.R;
import com.example.zheng.steward.ui.base.BaseActivity;
import com.example.zheng.steward.ui.presenter.LoginAtPresenter;
import com.example.zheng.steward.ui.view.ILoginAtView;
import com.example.zheng.steward.utils.ColorUtils;
import com.example.zheng.steward.utils.UIUtils;

import butterknife.Bind;

/**
 * Created by jarvis on 2018/3/24.
 */

public class LoginActivity extends BaseActivity<ILoginAtView, LoginAtPresenter> implements ILoginAtView {

    /**
     * 用户名
     */
    @Bind(R.id.et_username)
    EditText userNameEt;

    /**
     * 密码
     */
    @Bind(R.id.et_pwd)
    EditText pwdEt;

    /**
     * 登录按钮
     */
    @Bind(R.id.btn_login)
    Button loginBtn;


    TextWatcher watcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            loginBtn.setEnabled(canLogin());
            loginBtnChangeBgColor(canLogin());
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    @Override
    protected LoginAtPresenter createPresenter() {
        return new LoginAtPresenter(this);
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_login;
    }

    @Override
    public void initListener() {
        pwdEt.addTextChangedListener(watcher);
        userNameEt.addTextChangedListener(watcher);
        pwdEt.setOnFocusChangeListener((v, hasFocus) -> {
            if (hasFocus) {
//                mVLinePwd.setBackgroundColor(UIUtils.getColor(R.color.green0));
            } else {
//                mVLinePwd.setBackgroundColor(UIUtils.getColor(R.color.line));
            }
        });
        userNameEt.setOnFocusChangeListener((v, hasFocus) -> {
            if (hasFocus) {
//                mVLinePhone.setBackgroundColor(UIUtils.getColor(R.color.green0));
            } else {
//                mVLinePhone.setBackgroundColor(UIUtils.getColor(R.color.line));
            }
        });

        loginBtn.setOnClickListener(v -> mPresenter.login());
    }

    private boolean canLogin() {
        int pwdLength = pwdEt.getText().toString().trim().length();
        int userNameLength = userNameEt.getText().toString().trim().length();
        if (pwdLength > 0 && userNameLength > 0) {
            return true;
        }
        return false;
    }

    /**
     * 登录按钮根据是否能点击登录改变背景色
     * @param isCanLogin
     */
    private void loginBtnChangeBgColor(boolean isCanLogin) {
        if (isCanLogin) {
            loginBtn.setBackgroundColor(Color.parseColor("#07cedf"));
        } else {
            loginBtn.setBackgroundColor(Color.parseColor("#9E929C"));
        }
    }

    @Override
    public EditText getEtUserName() {
        return userNameEt;
    }

    @Override
    public EditText getEtPwd() {
        return pwdEt;
    }
}

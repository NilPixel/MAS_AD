package com.example.zheng.steward.ui.activity;

import android.Manifest;
import android.content.Intent;
import android.os.Handler;
import android.text.TextUtils;

import com.example.zheng.steward.MainActivity;
import com.example.zheng.steward.R;
import com.example.zheng.steward.model.cache.UserCache;
import com.example.zheng.steward.ui.base.BaseActivity;
import com.example.zheng.steward.ui.base.BasePresenter;
import com.example.zheng.steward.utils.StringUtils;


import kr.co.namee.permissiongen.PermissionGen;

/**
 * Created by zheng on 2018/2/6.
 * 启动页
 */

public class SplashActivity extends BaseActivity {

    @Override
    public void init() {
//        PermissionGen.with(this)
//                .addRequestCode(100)
//                .permissions(
//                        //电话通讯录
//                        Manifest.permission.GET_ACCOUNTS,
//                        Manifest.permission.READ_PHONE_STATE,
//                        //位置
//                        Manifest.permission.ACCESS_FINE_LOCATION,
//                        Manifest.permission.ACCESS_COARSE_LOCATION,
//                        Manifest.permission.ACCESS_FINE_LOCATION,
//                        //相机、麦克风
//                        Manifest.permission.RECORD_AUDIO,
//                        Manifest.permission.WAKE_LOCK,
//                        Manifest.permission.CAMERA,
//                        //存储空间
//                        Manifest.permission.WRITE_EXTERNAL_STORAGE,
//                        Manifest.permission.WRITE_SETTINGS
//                )
//                .request();
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent;
                if (!StringUtils.isEmpty(UserCache.getToken())) {
                    intent = new Intent(SplashActivity.this, MainActivity.class);
                } else {
                    intent = new Intent(SplashActivity.this, LoginActivity.class);
                }
                startActivity(intent);
                overridePendingTransition(R.anim.right_in,R.anim.left_out);
                finish();
            }
        }, 2000);
    }

    @Override
    public void initListener() {

    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_splash;
    }
}

package com.example.zheng.steward.ui.activity;

import android.Manifest;
import android.content.Intent;
import android.text.TextUtils;
import android.view.animation.AlphaAnimation;

import com.example.zheng.steward.MainActivity;
import com.example.zheng.steward.R;
import com.example.zheng.steward.model.cache.UserCache;
import com.example.zheng.steward.ui.base.BaseActivity;
import com.example.zheng.steward.ui.base.BasePresenter;
import com.example.zheng.steward.utils.UIUtils;
import com.jaeger.library.StatusBarUtil;

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
//        if (!TextUtils.isEmpty(UserCache.getToken())) {
//            Intent intent = new Intent(this, MainActivity.class);
//            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
//            jumpToActivity(intent);
//            finish();
//        }
    }

    @Override
    public void initView() {
        StatusBarUtil.setColor(this, UIUtils.getColor(R.color.black));

//        AlphaAnimation alphaAnimation = new AlphaAnimation(0, 1);
//        alphaAnimation.setDuration(1000);
//        mRlButton.startAnimation(alphaAnimation);
    }

    @Override
    public void initListener() {
        super.initListener();
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

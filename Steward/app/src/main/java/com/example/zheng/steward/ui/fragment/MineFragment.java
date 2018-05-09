package com.example.zheng.steward.ui.fragment;

import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.zheng.steward.R;
import com.example.zheng.steward.app.AppConst;
import com.example.zheng.steward.ui.base.BaseFragment;
import com.example.zheng.steward.ui.base.BasePresenter;
import com.example.zheng.steward.utils.SPUtils;
import com.example.zheng.steward.utils.UIUtils;

import butterknife.Bind;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

/**
 * Created by zheng on 2018/3/30.
 * 我的fragment
 */

public class MineFragment extends BaseFragment {

    private static final String TAG = "NewsFragment";

    /**
     * 工具栏上的title
     */
    @Bind(R.id.tvToolbarTitle)
    public TextView mToolbarTitle;

    /**
     * 扫描二维码按钮
     */
    @Bind(R.id.ibScanMenu)
    public Button mScanBtn;

    /**
     * 设置按钮
     */
    @Bind(R.id.id_setting)
    public Button mSettingBtn;

    /**
     * 占位图片
     */
    @Bind(R.id.id_placeHolder_image)
    public ImageView mPlaceHolderImage;

    @Override
    public void initView(View rootView) {
        super.initView(rootView);
        mPlaceHolderImage.setVisibility(VISIBLE);
        mScanBtn.setVisibility(GONE);
        mSettingBtn.setVisibility(VISIBLE);
        mToolbarTitle.setText("我的账号");
        mToolbarTitle.setGravity(Gravity.CENTER);
    }

    @Override
    public void initListener() {
        super.initListener();

        mScanBtn.setOnClickListener(view -> scanButtonClicked());
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.tab_mine;
    }

    void scanButtonClicked() {

    }
}

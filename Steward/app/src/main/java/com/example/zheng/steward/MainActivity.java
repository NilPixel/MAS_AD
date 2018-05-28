package com.example.zheng.steward;

import android.graphics.Color;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.example.zheng.steward.app.AppConst;
import com.example.zheng.steward.ui.adapter.CommonFragmentPagerAdapter;
import com.example.zheng.steward.ui.base.BaseActivity;
import com.example.zheng.steward.ui.base.BaseFragment;
import com.example.zheng.steward.ui.base.BasePresenter;
import com.example.zheng.steward.ui.fragment.FragmentFactory;
import com.example.zheng.steward.utils.SPUtils;
import com.example.zheng.steward.utils.UIUtils;
import com.example.zheng.steward.widget.MyViewPager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.Bind;

public class MainActivity extends BaseActivity {

    private static final String TAG = "MainActivity";

    private List<BaseFragment> mFragmentList = new ArrayList<>(3);

    /**
     * 三个tab页的容器ViewPager
     */
    @Bind(R.id.tab_viewpager)
    MyViewPager mViewPager;

    /**
     * 底部tabbar三个LinearLayout
     */
    @Bind(R.id.tabbar_home)
    LinearLayout mTabbarHome;

    @Bind(R.id.tabbar_news)
    LinearLayout mTabbarNews;

    @Bind(R.id.tabbar_mine)
    LinearLayout mTabbarMine;

    /**
     * 底部三个imageButton
     */

    @Bind(R.id.tabbar_home_btn)
    ImageButton mHomeImageBtn;

    @Bind(R.id.tabbar_news_btn)
    ImageButton mNewsImageBtn;

    @Bind(R.id.tabbar_mine_btn)
    ImageButton mMineImageBtn;

    /**
     * 底部三个button的text
     */
    @Bind(R.id.tabbar_home_text)
    TextView mHomeText;

    @Bind(R.id.tabbar_news_text)
    TextView mNewsText;

    @Bind(R.id.tabbar_mine_text)
    TextView mMineText;

    /**
     * 将所有的图片切换为未选择状态
     */
    private void resetImage() {
        mHomeImageBtn.setImageResource(R.mipmap.ic_tabbar_home_unselected);
        mNewsImageBtn.setImageResource(R.mipmap.ic_tabbar_news_unselected);
        mMineImageBtn.setImageResource(R.mipmap.ic_tabbar_mine_unselected);
    }

    /**
     * 将所有文字切换为未选择状态
     */
    private void resetTextColor() {
        mHomeText.setTextColor(Color.parseColor("#AAADB7"));
        mNewsText.setTextColor(Color.parseColor("#AAADB7"));
        mMineText.setTextColor(Color.parseColor("#AAADB7"));
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_main;
    }

    /**
     * 初始化view
     */
    @Override
    public void initView() {

        //设置ViewPager的最大缓存页面
        mViewPager.setOffscreenPageLimit(2);
        // 设置viewPager不可以左右滑动
        mViewPager.setScroll(false);

        mFragmentList.add(FragmentFactory.getInstance().getHomeFragment());
        mFragmentList.add(FragmentFactory.getInstance().getNewsFragment());
        mFragmentList.add(FragmentFactory.getInstance().getMineFragment());

        mViewPager.setAdapter(new CommonFragmentPagerAdapter(getSupportFragmentManager(), mFragmentList));
    }

    /**
     * tab点击事件
     */
    @Override
    public void initListener() {
        mTabbarHome.setOnClickListener(v -> tabClicked(v));
        mTabbarNews.setOnClickListener(v -> tabClicked(v));
        mTabbarMine.setOnClickListener(v -> tabClicked(v));
    }

    public void tabClicked(View v) {
        //重置图片和文字的选择状态
        resetImage();
        resetTextColor();

        //点击事件切换viewPager
        switch (v.getId()) {
            case R.id.tabbar_home:
                mViewPager.setCurrentItem(0, false);
                mHomeImageBtn.setImageResource(R.mipmap.ic_tabbar_home_selected);
                mHomeText.setTextColor(Color.parseColor("#07CDEF"));
                break;
            case R.id.tabbar_news:
                mViewPager.setCurrentItem(1, false);
                mNewsImageBtn.setImageResource(R.mipmap.ic_tabbar_news_selected);
                mNewsText.setTextColor(Color.parseColor("#07CDEF"));
                break;
            case R.id.tabbar_mine:
                mViewPager.setCurrentItem(2, false);
                mMineImageBtn.setImageResource(R.mipmap.ic_tabbar_mine_selected);
                mMineText.setTextColor(Color.parseColor("#07CDEF"));
                break;
            default:
                break;
        }
    }
}

package com.example.zheng.steward;

import android.graphics.Color;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    
    private static final String TAG = "MainActivity";

    /**
     * viewPager
     */
    private ViewPager mViewPager;

    /**
     * viewPager适配器
     */
    private PagerAdapter mAdapter;
    
    /**
     * 存放三个tab view的数组
     */
    private List<View> mViews = new ArrayList<View>();

    /**
     * 底部tabbar三个LinearLayout
     */
    private LinearLayout mTabbarHome;
    private LinearLayout mTabbarNews;
    private LinearLayout mTabbarMine;

    /**
     * 底部三个imageButton
     */
    private ImageButton mHomeImageBtn;
    private ImageButton mNewsImageBtn;
    private ImageButton mMineImageBtn;

    /**
     *底部三个button的text
     */
    private TextView mHomeText;
    private TextView mNewsText;
    private TextView mMineText;
    
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        initViews();
        initEvents();
    }

    /**
     * 初始化view
     */
    private void initViews() {
        mViewPager = (ViewPager)findViewById(R.id.tab_viewpager);

        //tabs
        mTabbarHome = (LinearLayout)findViewById(R.id.tabbar_home);
        mTabbarNews = (LinearLayout)findViewById(R.id.tabbar_news);
        mTabbarMine = (LinearLayout)findViewById(R.id.tabbar_mine);

        //imageButton
        mHomeImageBtn = (ImageButton)findViewById(R.id.tabbar_home_btn);
        mNewsImageBtn = (ImageButton)findViewById(R.id.tabbar_news_btn);
        mMineImageBtn = (ImageButton)findViewById(R.id.tabbar_mine_btn);

        //textView
        mHomeText = (TextView)findViewById(R.id.tabbar_home_text);
        mNewsText = (TextView)findViewById(R.id.tabbar_news_text);
        mMineText= (TextView)findViewById(R.id.tabbar_mine_text);

        LayoutInflater mInflater = LayoutInflater.from(this);

        //将layout转换成对应的view
        View tabHome = mInflater.inflate(R.layout.tab_home,null);
        View tabNews = mInflater.inflate(R.layout.tab_news,null);
        View tabMine = mInflater.inflate(R.layout.tab_mine,null);

        mViews.add(tabHome);
        mViews.add(tabNews);
        mViews.add(tabMine);
        
        mAdapter = new PagerAdapter() {

            /**
             * 销毁view
             * @param container
             * @param position
             * @param object
             */
            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView(mViews.get(position));
            }

            /**
             * 添加view
             * @param container
             * @param position
             * @return
             */
            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                View view = mViews.get(position);
                container.addView(view);
                return view;
            }

            @Override
            public int getCount() {
                return mViews.size();
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }
        };
        
        mViewPager.setAdapter(mAdapter);
    }

    /**
     * tab点击事件
     */
    private void initEvents() {
        mTabbarHome.setOnClickListener(this);
        mTabbarNews.setOnClickListener(this);
        mTabbarMine.setOnClickListener(this);
        
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                
            }

            @Override
            public void onPageSelected(int position) {
                //重置图片和文字的选择状态
                resetImage();
                resetTextColor();
                //设置选中状态
                switch (position) {
                    case 0:
                        mHomeImageBtn.setImageResource(R.mipmap.ic_tabbar_home_selected);
                        mHomeText.setTextColor(Color.parseColor("#07CDEF"));
                        break;
                    case 1:
                        mNewsImageBtn.setImageResource(R.mipmap.ic_tabbar_news_selected);
                        mNewsText.setTextColor(Color.parseColor("#07CDEF"));
                        break;
                    case 2:
                        mMineImageBtn.setImageResource(R.mipmap.ic_tabbar_mine_selected);
                        mMineText.setTextColor(Color.parseColor("#07CDEF"));
                        break;
                    default:break;
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        
    }

    @Override
    public void onClick(View v) {
        //点击事件切换viewPager
        switch (v.getId()) {
            case R.id.tabbar_home:
                mViewPager.setCurrentItem(0, false);
                break;
            case R.id.tabbar_news:
                mViewPager.setCurrentItem(1, false);
                break;
            case R.id.tabbar_mine:
                mViewPager.setCurrentItem(2, false);
                break;
            default:break;
        }
    }

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
    
    /**
     * 添加右侧扫描二维码菜单按钮
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.actionbar_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    /**
     * 菜单点击事件
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.qr_scan_btn:
                Log.d(TAG, "onOptionsItemSelected: 扫码按钮点击");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}

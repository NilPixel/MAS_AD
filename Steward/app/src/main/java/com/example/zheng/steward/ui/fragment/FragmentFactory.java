package com.example.zheng.steward.ui.fragment;

import com.example.zheng.steward.ui.fragment.news.AllFragment;
import com.example.zheng.steward.ui.fragment.news.ApplyRemindFragment;
import com.example.zheng.steward.ui.fragment.news.BuyBackFragment;
import com.example.zheng.steward.ui.fragment.news.MessageFragment;
import com.example.zheng.steward.ui.fragment.news.OverDueFragment;

/**
 * Created by zheng on 2018/3/30.
 * 主界面3个tab的Fragment工厂
 */

public class FragmentFactory {

    static FragmentFactory mInstance;

    private FragmentFactory() {
    }

    public static FragmentFactory getInstance() {
        if (mInstance == null) {
            synchronized (FragmentFactory.class) {
                if (mInstance == null) {
                    mInstance = new FragmentFactory();
                }
            }
        }
        return mInstance;
    }

    private HomeFragment mHomeFragment;
    private NewsFragment mNewsFragment;
    private MineFragment mMineFragment;

    private AllFragment mAllFragment;
    private MessageFragment mMessageFragment;
    private ApplyRemindFragment mApplyRemindFragment;

    private OverDueFragment mOverDueFragment;
    private BuyBackFragment mBuyBackFragment;

    public HomeFragment getHomeFragment() {
        if (mHomeFragment == null) {
            synchronized (FragmentFactory.class) {
                if (mHomeFragment == null) {
                    mHomeFragment = new HomeFragment();
                }
            }
        }
        return mHomeFragment;
    }

    public NewsFragment getNewsFragment() {
        if (mNewsFragment == null) {
            synchronized (FragmentFactory.class) {
                if (mNewsFragment == null) {
                    mNewsFragment = new NewsFragment();
                }
            }
        }
        return mNewsFragment;
    }

    public MineFragment getMineFragment() {
        if (mMineFragment == null) {
            synchronized (FragmentFactory.class) {
                if (mMineFragment == null) {
                    mMineFragment = new MineFragment();
                }
            }
        }
        return mMineFragment;
    }

    public AllFragment getAllFragment() {
        if (mAllFragment == null) {
            synchronized (FragmentFactory.class) {
                if (mAllFragment == null) {
                    mAllFragment = new AllFragment();
                }
            }
        }
        return mAllFragment;
    }

    public MessageFragment getMessageFragment() {
        if (mMessageFragment == null) {
            synchronized (FragmentFactory.class) {
                if (mMessageFragment == null) {
                    mMessageFragment = new MessageFragment();
                }
            }
        }
        return mMessageFragment;
    }

    public ApplyRemindFragment getApplyRemindFragment() {
        if (mApplyRemindFragment == null) {
            synchronized (FragmentFactory.class) {
                if (mApplyRemindFragment == null) {
                    mApplyRemindFragment = new ApplyRemindFragment();
                }
            }
        }
        return mApplyRemindFragment;
    }

    public OverDueFragment getOverDueFragment() {
        if (mOverDueFragment == null) {
            synchronized (FragmentFactory.class) {
                if (mOverDueFragment == null) {
                    mOverDueFragment = new OverDueFragment();
                }
            }
        }
        return mOverDueFragment;
    }

    public BuyBackFragment getBuyBackFragment() {
        if (mBuyBackFragment == null) {
            synchronized (FragmentFactory.class) {
                if (mBuyBackFragment == null) {
                    mBuyBackFragment = new BuyBackFragment();
                }
            }
        }
        return mBuyBackFragment;
    }
}

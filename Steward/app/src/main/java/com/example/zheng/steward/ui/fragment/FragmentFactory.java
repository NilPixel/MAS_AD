package com.example.zheng.steward.ui.fragment;

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
    private NewsFragment mNewsFragment;
    private MineFragment mMineFragment;

    private HomeFragment mHomeFragment;
    private NewsFragment mNewsFragment;

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

    public NewsFragment getMessageFragment() {
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
        if (mMineFragment == null) {
            synchronized (FragmentFactory.class) {
                if (mMineFragment == null) {
                    mMineFragment = new MineFragment();
                }
            }
        }
        return mMineFragment;
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
}

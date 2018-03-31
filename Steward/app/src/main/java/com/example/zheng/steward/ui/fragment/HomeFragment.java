package com.example.zheng.steward.ui.fragment;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.example.zheng.steward.MainActivity;
import com.example.zheng.steward.R;
import com.example.zheng.steward.ui.base.BaseFragment;
import com.example.zheng.steward.ui.presenter.HomeFgPresenter;
import com.example.zheng.steward.widget.MyGridView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.Bind;

/**
 * Created by zheng on 2018/3/30.
 * 首页fragment
 */

public class HomeFragment extends BaseFragment {

    private static final String TAG = "HomeFragment";

    /**
     * 切换当月数据和累计数据的按钮
     */
    @Bind(R.id.view_cumulative_btn)
    Button mCumulativeBtn;

    /**
     * 查看当月或累计金额标签
     */
    @Bind(R.id.current_or_total_apply)
    TextView currentOrTotalApplyText;

    /**
     * 查看当月或累计进件数标签
     */
    @Bind(R.id.current_or_total_into)
    TextView currentOrTotalIntoText;

    /**
     * 当月或累计金额
     */
    @Bind(R.id.current_or_total_money)
    TextView currentOrTotalMoneyText;

    /**
     * 当月或累计进件数
     */
    @Bind(R.id.current_or_total_order)
    TextView currentOrTotalOrderText;

    /**
     * 券码验证按钮
     */
    @Bind(R.id.code_verification_btn)
    Button mVerificationBtn;

    /**
     * 开始分期按钮
     */
    @Bind(R.id.stages_btn)
    Button mStagesBtn;

    /**
     * 订单入口GridView
     */
    @Bind(R.id.order_interface_gridview)
    MyGridView mInterfaceGridView;

    /**
     * 新手须知按钮
     */
    @Bind(R.id.new_guidelines)
    ImageButton newGuidelinesBtn;

    /**
     * 初始化gridView数据源
     */
    private String[] from = {"image", "title"};
    private int[] to = {R.id.order_interface_image, R.id.order_interface_title};

    /**
     * 查看累计按钮状态标志位
     */
    private Integer cumulativeBtnStatus = 0;

    @Override
    protected HomeFgPresenter createPresenter() {
        return new HomeFgPresenter((MainActivity) getActivity());
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.tab_home;
    }

    @Override
    public void initView(View rootView) {
        super.initView(rootView);
    }

    @Override
    public void initData() {
        super.initData();
    }

    /**
     * 初始化各按钮的点击监听事件
     */
    @Override
    public void initListener() {
        mCumulativeBtn.setOnClickListener(view -> cumulativeButtonClicked());
        mVerificationBtn.setOnClickListener(view -> verificationBtnClicked());

        mStagesBtn.setOnClickListener(view -> startStageBtnClicked());
        newGuidelinesBtn.setOnClickListener(view -> newGuidelinesBtnClicked());

        SimpleAdapter adapter = new SimpleAdapter(getActivity(), getList(), R.layout.interface_gridview_item, from, to);
        mInterfaceGridView.setAdapter(adapter);
        mInterfaceGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        Log.d(TAG, "onItemClick: 申请件查询");
                        break;
                    case 1:
                        Log.d(TAG, "onItemClick: 待放款件查询");
                        break;
                    case 2:
                        Log.d(TAG, "onItemClick: 放款件查询");
                        break;
                    case 3:
                        Log.d(TAG, "onItemClick: 逾期件查询");
                        break;
                    case 4:
                        Log.d(TAG, "onItemClick: 优惠券查询");
                        break;
                    case 5:
                        Log.d(TAG, "onItemClick: 客户画像");
                        break;
                    default:
                        Log.d(TAG, "onItemClick: 无效点击");
                        break;
                }
            }
        });
    }

    /**
     * 初始化gridView数据源
     * @return
     */
    private List<Map<String, Object>> getList() {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

        String[] titles = new String[] {"申请件查询", "待放款件查询", "放款件查询", "逾期件查询", "优惠券查询", "客户画像"};
        Integer[] images = new Integer[] {R.mipmap.ic_apply_query, R.mipmap.ic_for_lending, R.mipmap.ic_lended, R.mipmap.ic_overdue, R.mipmap.ic_coupon, R.mipmap.ic_customer};

        for (int i = 0; i < images.length; i++) {
            Map<String, Object> map = new HashMap<>();
            map.put("title", titles[i]);
            map.put("image", images[i]);
            list.add(map);
        }
        return list;
    }

    /**
     * 查看金额按钮点击事件
     */
    private void cumulativeButtonClicked() {
        if (cumulativeBtnStatus == 0) {
            currentMonthAction();
        } else if (cumulativeBtnStatus == 1) {
            cumulativeAction();
        }
    }

    /**
     * 查看当月动作
     */
    private void currentMonthAction() {
        cumulativeBtnStatus = 1;
        mCumulativeBtn.setBackgroundResource(R.mipmap.ic_view_current_month);
        currentOrTotalApplyText.setText("累计申请金额（万元）");
        currentOrTotalIntoText.setText("累计进件数 (笔）");
    }

    /**
     * 查看累计动作
     */
    private void cumulativeAction() {
        cumulativeBtnStatus = 0;
        mCumulativeBtn.setBackgroundResource(R.mipmap.ic_view_cumulative);
        currentOrTotalApplyText.setText("当月申请金额（元）");
        currentOrTotalIntoText.setText("当月进件数 (笔）");
    }

    /**
     * 券码验证按钮点击事件
     */
    private void verificationBtnClicked() {
        Log.d(TAG, "codeVerificationBtnClicked: 券码验证按钮点击");
    }

    /**
     * 开始分期按钮点击事件
     */
    private void startStageBtnClicked() {
        Log.d(TAG, "startStageBtnClicked: 开始分期按钮点击");
    }

    /**
     * 新手须知按钮点击事件
     */
    private void newGuidelinesBtnClicked() {
        Log.d(TAG, "newGuidelinesBtnClicked: 新手须知按钮点击");
    }
}

package com.joaye.hixgo.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.RadioGroup;

import com.joaye.hixgo.R;
import com.joaye.hixgo.fragments.BaseFragment;
import com.joaye.hixgo.fragments.FragmentCart;
import com.joaye.hixgo.fragments.FragmentCategory;
import com.joaye.hixgo.fragments.FragmentHomePage;
import com.joaye.hixgo.fragments.FragmentUserInfo;
import com.joaye.hixgo.views.adapters.MainFragmentPageAdapter;
import com.joaye.hixgo.views.widgets.HixgoMainViewPager;

import java.util.ArrayList;

/**
 * Created by xuyanjun on 15/10/22.
 */
public class MainActivity extends BaseActivity {

    private FragmentHomePage mFragmentHomePage;
    private FragmentCategory mFragmentCategory;
    private FragmentCart mFragmentCart;
    private FragmentUserInfo mFragmentUserInfo;
    private ArrayList<BaseFragment> mFragmentList;
    private RadioGroup mRadio_tab;
    private HixgoMainViewPager mViewPager;
    private MainFragmentPageAdapter mFragmentPageAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFragmentHomePage = new FragmentHomePage();
        mFragmentCategory = new FragmentCategory();
        mFragmentCart = new FragmentCart();
        mFragmentUserInfo = new FragmentUserInfo();
        mFragmentList = new ArrayList<>(4);
        mFragmentList.add(mFragmentHomePage);
        mFragmentList.add(mFragmentCategory);
        mFragmentList.add(mFragmentCart);
        mFragmentList.add(mFragmentUserInfo);
        mFragmentPageAdapter = new MainFragmentPageAdapter(getSupportFragmentManager(), mFragmentList);
        mViewPager.setAdapter(mFragmentPageAdapter);
        mRadio_tab.check(R.id.activity_main_bottom_bar_radio_home);
    }
    @Override
    public void findViews() {
//        mLayout_fragmentContainer = (FrameLayout) findViewById(R.id.activity_main_fragment_container);
        mRadio_tab = (RadioGroup) findViewById(R.id.activity_main_bottom_bar_layout);
        mRadio_tab.setOnCheckedChangeListener((radioGroup, checkedId) -> {
            if (checkedId == R.id.activity_main_bottom_bar_radio_home) {
                mViewPager.setCurrentItem(0, false);
            } else if (checkedId == R.id.activity_main_bottom_bar_radio_category) {
                mViewPager.setCurrentItem(1, false);
            } else if (checkedId == R.id.activity_main_bottom_bar_radio_cart) {
                mViewPager.setCurrentItem(2, false);
            } else if (checkedId == R.id.activity_main_bottom_bar_radio_user_info) {
                mViewPager.setCurrentItem(3, false);
            }
        });

        mViewPager = (HixgoMainViewPager) findViewById(R.id.activity_main_viewpager);
        mViewPager.setOffscreenPageLimit(4);
        findViewById(R.id.activity_main_top_bar).setOnClickListener(v -> startActivity(new Intent(MainActivity.this, LoginActivity.class)));

    }
}

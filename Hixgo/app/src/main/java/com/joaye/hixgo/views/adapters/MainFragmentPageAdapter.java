package com.joaye.hixgo.views.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.joaye.hixgo.fragments.BaseFragment;

import java.util.ArrayList;

/**
 * Created by xuyanjun on 15/10/23.
 * 首页Tab页ViewPager Adapter
 */
public class MainFragmentPageAdapter extends FragmentPagerAdapter {

    public MainFragmentPageAdapter(FragmentManager fm, ArrayList<BaseFragment> fragmentList) {
        super(fm);
        this.mFragmentList = fragmentList;
    }

    private ArrayList<BaseFragment> mFragmentList;

    @Override
    public Fragment getItem(int position) {
        return mFragmentList == null ? null : mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList == null ? 0 : mFragmentList.size();
    }
}

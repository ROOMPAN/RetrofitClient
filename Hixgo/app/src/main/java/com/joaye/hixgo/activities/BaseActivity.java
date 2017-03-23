package com.joaye.hixgo.activities;

import android.support.v4.app.FragmentActivity;

/**
 * Created by xuyanjun on 15/10/22.
 */
public class BaseActivity extends FragmentActivity implements IFaceActivity {

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        findViews();
        bindListener();
    }

    @Override
    public void findViews() {

    }

    @Override
    public void bindListener() {

    }
}

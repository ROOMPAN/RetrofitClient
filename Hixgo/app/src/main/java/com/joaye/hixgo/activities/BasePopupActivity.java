package com.joaye.hixgo.activities;

import android.support.v4.app.FragmentActivity;
import android.view.Gravity;
import android.widget.RelativeLayout;

/**
 * Created by xuyanjun on 15/10/28.
 * 从底下弹出的Activity父类
 */
public class BasePopupActivity extends FragmentActivity implements IFaceActivity {


    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        getWindow().setLayout(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        getWindow().setGravity(Gravity.BOTTOM);
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

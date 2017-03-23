package com.joaye.hixgo.activities;

import android.widget.Button;

import com.joaye.hixgo.R;

import me.imid.swipebacklayout.lib.SwipeBackLayout;
import me.imid.swipebacklayout.lib.app.SwipeBackActivity;

/**
 * Created by xuyanjun on 15/10/24.
 */
public class BaseSwipeBackActivity extends SwipeBackActivity implements IFaceActivity {

    private SwipeBackLayout mSwipeBackLayout;
    protected Button mBtn_right;

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        mSwipeBackLayout = getSwipeBackLayout();
        mSwipeBackLayout.setEdgeTrackingEnabled(SwipeBackLayout.EDGE_LEFT);
        mBtn_right = (Button) findViewById(R.id.topbar_right_btn);
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

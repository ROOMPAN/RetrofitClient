package com.joaye.hixgo.views.widgets;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by xuyanjun on 15/10/23.
 */
public class HixgoMainViewPager extends ViewPager {

    public HixgoMainViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public HixgoMainViewPager(Context context) {
        super(context);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return false;
    }
}

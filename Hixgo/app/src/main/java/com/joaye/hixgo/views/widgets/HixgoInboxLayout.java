package com.joaye.hixgo.views.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.joaye.hixgo.R;

/**
 * Created by xuyanjun on 15/10/29.
 * 仿考拉海购支付页面: 点击不同Title，Title动画弹到最上方后展示Title相应的内容
 * 思路:
 * 外层Layout继承FrameLayout, 里面必须有两个Layout，一个为存放Titles的Layout，另一个为固定的ContentLayout盖在TitleLayout上方，
 * 内容用Fragment展示，方便业务逻辑管理
 * 点击某条Title后播放动画把此Title位移到顶部，ContentLayout替换相应的Fragment
 */
public class HixgoInboxLayout extends FrameLayout {

    private LinearLayout mLayout_titles;
    private FrameLayout mLayout_content;
    public HixgoInboxLayout(Context context) {
        super(context);
    }

    public HixgoInboxLayout(Context context, AttributeSet attrs){
        super(context, attrs);
    }

    public HixgoInboxLayout(Context context, AttributeSet attrs, int defStyleAttr){
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        mLayout_content = (FrameLayout) findViewById(R.id.inbox_layout_content);
        mLayout_titles = (LinearLayout) findViewById(R.id.inbox_layout_titles);
    }
}

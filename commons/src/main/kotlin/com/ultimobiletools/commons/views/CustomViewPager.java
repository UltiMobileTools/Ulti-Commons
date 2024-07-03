package com.ultimobiletools.commons.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.duolingo.open.rtlviewpager.RtlViewPager;

public class CustomViewPager extends RtlViewPager {

    public CustomViewPager(Context context) {
        super(context);
    }

    public CustomViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        try {
            return super.onInterceptTouchEvent(ev);
        } catch (Exception ignored) {
            return false;
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        try {
            return super.onTouchEvent(ev);
        } catch (Exception ignored) {
            return false;
        }
    }
}

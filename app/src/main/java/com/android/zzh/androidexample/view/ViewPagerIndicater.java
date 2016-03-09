package com.android.zzh.androidexample.view;

import android.content.Context;
import android.graphics.LinearGradient;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import com.android.zzh.androidexample.adapter.ViewPagerAdapter;

import java.util.Arrays;
import java.util.List;

/**
 * Created by zzh on 16/3/8.
 */
public class ViewPagerIndicater extends LinearLayout {




    public ViewPagerIndicater(Context context) {
        this(context,null);
    }

    public ViewPagerIndicater(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ViewPagerIndicater(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public ViewPagerIndicater(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }
}

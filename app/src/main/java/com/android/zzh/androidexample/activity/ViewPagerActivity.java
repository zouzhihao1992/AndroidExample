package com.android.zzh.androidexample.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.android.zzh.androidexample.Fragment.VpSimpleFragment;
import com.android.zzh.androidexample.R;
import com.android.zzh.androidexample.view.ViewPagerIndicater;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zzh on 16/3/8.
 */
public class ViewPagerActivity extends FragmentActivity{
    private ViewPager viewPager;
    private ViewPagerIndicater viewPagerIndicater;


    private List<String> mTitles = Arrays.asList("短信","收藏","推荐");
    private List<VpSimpleFragment> mContents = new ArrayList<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewpager_activity);

    }
}

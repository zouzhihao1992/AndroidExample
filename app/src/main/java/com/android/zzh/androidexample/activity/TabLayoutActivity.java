package com.android.zzh.androidexample.activity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.android.zzh.androidexample.R;
import com.android.zzh.androidexample.adapter.ViewPagerAdapter;

/**
 * Created by zzh on 16/2/14.
 */
public class TabLayoutActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private Toolbar toolbar;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab_layout);
        toolbar = (Toolbar)findViewById(R.id.tablayout_toolbar);
        toolbar.setTitle("TabLayout"); //必须在setSupportAction()之前调用才有效果。
        setSupportActionBar(toolbar);

        tabLayout = (TabLayout)findViewById(R.id.tabs);
        for (int i = 0;i < 3;i++){
            tabLayout.addTab(tabLayout.newTab());
        }

        ViewPager viewPager = (ViewPager)findViewById(R.id.tab_layout_viewpager);
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(),3);
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

    }

}

package com.android.zzh.androidexample.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.android.zzh.androidexample.Fragment.ViewPagerFragment;

/**
 * Created by zzh on 16/2/15.
 */
public class ViewPagerAdapter extends FragmentPagerAdapter {

    private int mCount;
    public ViewPagerAdapter(FragmentManager fm,int count){
        super(fm);
        mCount =count;
    }

    @Override
    public Fragment getItem(int position) {
        ViewPagerFragment fragment = new ViewPagerFragment(position+"");
        return fragment;
    }

    @Override
    public int getCount() {
        return mCount;
    }

    @Override
    public CharSequence getPageTitle(int position) {
            return position+"";  //必须实现这个方法，不然tabs中没有标题。即使在添加tabs时设置了title。
    }
}

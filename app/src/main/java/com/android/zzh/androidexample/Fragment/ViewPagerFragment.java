package com.android.zzh.androidexample.Fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.TextViewCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.zzh.androidexample.R;

/**
 * Created by zzh on 16/2/15.
 */
public class ViewPagerFragment extends Fragment {

    private String mContent = "hehe";
    private View view;
    public ViewPagerFragment(String content){
        mContent = content;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.view_pager_fragment,container,false);
        TextView textView = (TextView)view.findViewById(R.id.viewPagerFragmentTextView);
        textView.setText(mContent);
        return view;
    }
}

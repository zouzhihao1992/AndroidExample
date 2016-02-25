package com.android.zzh.androidexample.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.zzh.androidexample.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zzh on 16/2/15.
 */
public class RecyclerViewAdapterStagger extends RecyclerViewAdapter {

    private List<Integer> mHeights;


    public RecyclerViewAdapterStagger(Context context, List<String> datas) {
       super(context,datas);
        mHeights = new ArrayList<>();
        for (int i = 0; i < mDatas.size(); i++) {
            mHeights.add((int) (100 + Math.random() * 300));
        }
    }


    @Override
    public void onBindViewHolder(final RecyclerViewAdapter.RecyclerViewViewHodler holder, final int position) {
        ViewGroup.LayoutParams lp = holder.itemView.getLayoutParams();
        lp.height = mHeights.get(position);
        holder.itemView.setLayoutParams(lp);
        holder.tv.setText(mDatas.get(position));
        setupItemEvent(holder);

    }


}



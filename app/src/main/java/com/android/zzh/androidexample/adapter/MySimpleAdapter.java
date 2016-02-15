package com.android.zzh.androidexample.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.zzh.androidexample.R;

import java.util.List;

/**
 * Created by zzh on 16/2/15.
 */
public class MySimpleAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private LayoutInflater mInflater;
    private Context mContext;
    private List<String> mDatas;

    public MySimpleAdapter(Context context, List<String> datas){
        this.mContext = context;
        this.mDatas = datas;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_single_textview,parent,false);
        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.tv.setText(mDatas.get(position));
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }
}

class MyViewHolder extends RecyclerView.ViewHolder
{
    TextView tv;
    public MyViewHolder(View itemView) {
        super(itemView);
        tv = (TextView)itemView.findViewById(R.id.textview_item);
    }
}

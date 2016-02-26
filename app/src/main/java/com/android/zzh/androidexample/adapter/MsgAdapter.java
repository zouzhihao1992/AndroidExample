package com.android.zzh.androidexample.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.zzh.androidexample.R;
import com.android.zzh.androidexample.other.Msg;

import java.util.List;

/**
 * Created by zzh on 16/2/26.
 */
public class MsgAdapter extends ArrayAdapter<Msg> {

    int resourceID;
    public MsgAdapter(Context context, int resource,List<Msg> list) {

        super(context, resource,list);
        resourceID = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Msg msg = getItem(position);
        View view = null;
        MsgAdapter.ViewHolder viewHolder;
        if (convertView != null){
            view = LayoutInflater.from(getContext()).inflate(R.layout.item_listview_chat,null);
            viewHolder = new ViewHolder();
            viewHolder.leftLayout = (LinearLayout) view.findViewById(R.id.left_layout);
        }
        return view;
    }

    class ViewHolder{
        public TextView leftTextView;
        public TextView rightTextView;
        LinearLayout leftLayout;
        LinearLayout rightLayout;
    }
}

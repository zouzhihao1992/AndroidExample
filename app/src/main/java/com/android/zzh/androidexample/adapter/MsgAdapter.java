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
        if (convertView == null){
            view = LayoutInflater.from(getContext()).inflate(resourceID,null);
            viewHolder = new ViewHolder();
            viewHolder.leftTextView = (TextView)view.findViewById(R.id.left_msg);
            viewHolder.rightTextView = (TextView)view.findViewById(R.id.right_msg);
            viewHolder.leftLayout = (LinearLayout)view.findViewById(R.id.left_layout);
            viewHolder.rightLayout = (LinearLayout)view.findViewById(R.id.right_layout);
            view.setTag(viewHolder);
        }else{
            view = convertView;
            viewHolder = (ViewHolder)view.getTag();
        }

        if(msg.getType() == Msg.TYPE_RECEIVED){
            viewHolder.leftLayout.setVisibility(View.VISIBLE);
            viewHolder.rightLayout.setVisibility(View.GONE);
            viewHolder.leftTextView.setText(msg.getContent());
        }else{
            viewHolder.rightLayout.setVisibility(View.VISIBLE);
            viewHolder.leftLayout.setVisibility(View.GONE);
            viewHolder.rightTextView.setText(msg.getContent());
        }
        return view;
    }

    class ViewHolder{
         LinearLayout leftLayout;
         LinearLayout rightLayout;
         TextView leftTextView;
         TextView rightTextView;

    }
}

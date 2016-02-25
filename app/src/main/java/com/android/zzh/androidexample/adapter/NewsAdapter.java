package com.android.zzh.androidexample.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.android.zzh.androidexample.R;
import com.android.zzh.androidexample.other.News;

import java.util.List;

/**
 * Created by zzh on 16/2/24.
 */
public class NewsAdapter extends ArrayAdapter<News> {

    private int resourceId;
    public NewsAdapter(Context context, int resource,List<News> list) {
        super(context, resource,list);
        resourceId = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        News news = getItem(position);
        View view;
        ViewHolder viewHolder;
        if (convertView == null){
            view = LayoutInflater.from(getContext()).inflate(resourceId,null);

            viewHolder = new ViewHolder();
            viewHolder.textView = (TextView) view.findViewById(R.id.news_title);
            view.setTag(viewHolder);
        }else{
            view = convertView;
            viewHolder =(ViewHolder)view.getTag();
        }
        viewHolder.textView.setText(news.getTitle());
        return view;
    }

    class ViewHolder{
        TextView textView;
    }
}

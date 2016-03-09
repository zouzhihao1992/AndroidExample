package com.android.zzh.androidexample.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;

import com.android.zzh.androidexample.R;

import java.util.zip.Inflater;

/**
 * Created by zzh on 16/2/26.
 */
public class LoadView extends ListView implements AbsListView.OnScrollListener {

    private View footer;
    private int totalItemCount;
    private int lastVisibleItem;
    boolean isLoading = false;
    private LoadListener mLoadListener;

    public LoadView(Context context) {
        super(context);
        initView(context);
    }

    public LoadView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public LoadView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    public LoadView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initView(context);
    }
    void initView(Context context){
        footer = LayoutInflater.from(context).inflate(R.layout.footer_layout,null);
        footer.setVisibility(View.GONE);
        this.addFooterView(footer);
        this.setOnScrollListener(this);
    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {

        if(lastVisibleItem == totalItemCount && scrollState == SCROLL_STATE_IDLE){
            if (!isLoading){
                footer.setVisibility(View.VISIBLE);
                isLoading = true;
                mLoadListener.onload();
            }

        }
    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        this.lastVisibleItem = firstVisibleItem + visibleItemCount;
        this.totalItemCount = totalItemCount;
    }

    public interface LoadListener{
        public void onload();
    }
    public void setOnLoadListener(LoadListener loadListener){
        mLoadListener = loadListener;
    }
    public void LoadComplete(){
        isLoading = false;
        footer.setVisibility(View.GONE);
    }
}

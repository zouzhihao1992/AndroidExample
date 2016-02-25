package com.android.zzh.androidexample.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;

import com.android.zzh.androidexample.R;
import com.android.zzh.androidexample.adapter.RecyclerViewAdapter;
import com.android.zzh.androidexample.other.DividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zzh on 16/2/15.
 */
public class CoordinatorLayoutActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private FloatingActionButton fab;
    private CoordinatorLayout coordinatorLayout;
    ListView listView;
    RecyclerView recyclerView;
    private List<String> mDatas;
    private RecyclerViewAdapter adapter;
    CollapsingToolbarLayout collapsingToolbarLayout;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.coordinator_layout);
        coordinatorLayout = (CoordinatorLayout)findViewById(R.id.CoordinatorLayout);
        collapsingToolbarLayout = (CollapsingToolbarLayout)findViewById(R.id.collapsingToolbarLayout);
        collapsingToolbarLayout.setTitle("CoordinatorLayout");
        fab = (FloatingActionButton)findViewById(R.id.fab_coordinatorlayoutactivity);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(coordinatorLayout,"hello",Snackbar.LENGTH_LONG).setAction("知道了", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                }).show();
            }
        });
        initDatas();
        toolbar = (Toolbar) findViewById(R.id.toolbar_coordinatorLayout);
        setSupportActionBar(toolbar);

        recyclerView = (RecyclerView)findViewById(R.id.recyclerview_coordinator_layout);
        adapter = new RecyclerViewAdapter(this,mDatas);
        recyclerView.setAdapter(adapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        //设置Recyclerview的item的分隔线
        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL_LIST));

    }

        private void initDatas(){
        mDatas = new ArrayList<String>();
        for(int i ='A'; i <= 'z';i++){
            mDatas.add(""+(char)i);
        }
    }


}

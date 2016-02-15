package com.android.zzh.androidexample.activity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.SimpleAdapter;

import com.android.zzh.androidexample.R;
import com.android.zzh.androidexample.adapter.MySimpleAdapter;
import com.android.zzh.androidexample.other.DividerItemDecoration;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by zzh on 16/2/15.
 */
public class RecyclerViewListView extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<String> mDatas;
    private MySimpleAdapter adapter;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recyclerview_listview);
        initDatas();
        recyclerView = (RecyclerView)findViewById(R.id.recyclerView_ListView);
        adapter = new MySimpleAdapter(this,mDatas);

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

package com.android.zzh.androidexample.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.android.zzh.androidexample.R;
import com.android.zzh.androidexample.adapter.RecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zzh on 16/2/15.
 */
public class RecyclerViewActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<String> mDatas;
    private RecyclerViewAdapter adapter;
    private Toolbar toolbar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recyclerview);
        initDatas();
        toolbar = (Toolbar)findViewById(R.id.toolbar_recycleview);
        setSupportActionBar(toolbar);
        recyclerView = (RecyclerView)findViewById(R.id.recyclerView_ListView);
        adapter = new RecyclerViewAdapter(this,mDatas);

        recyclerView.setAdapter(adapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);

        recyclerView.setItemAnimator(new DefaultItemAnimator());
        //设置Recyclerview的item的分隔线
         //recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL_LIST));
        adapter.setOnItemClickListener(new RecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void OnItemClick(View view, int position) {
                Toast.makeText(RecyclerViewActivity.this,"onItemClick"+position,Toast.LENGTH_LONG).show();
            }

            @Override
            public void OnItenLongClick(View view, int position) {
                Toast.makeText(RecyclerViewActivity.this,"onLongItemClick"+position,Toast.LENGTH_LONG).show();

            }
        });
    }

    private void initDatas(){
        mDatas = new ArrayList<String>();
        for(int i ='A'; i <= 'z';i++){
            mDatas.add(""+(char)i);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_listview :
                recyclerView.setLayoutManager(new LinearLayoutManager(this));
                break;
            case R.id.action_gridview :
                recyclerView.setLayoutManager(new GridLayoutManager(this,3));
                break;
            case R.id.action_hor_gridview :
                recyclerView.setLayoutManager(new StaggeredGridLayoutManager(5,StaggeredGridLayoutManager.HORIZONTAL));
                break;
            case R.id.action_staggered :
                Intent intent = new Intent(RecyclerViewActivity.this,RecyclerViewStaggerActivity.class);
                startActivity(intent);
                break;
            case R.id.action_add :
                adapter.addData(1);

                break;
            case R.id.action_delete:
                adapter.deleteDate(1);
                break;
            default:
                break;
        }
        return true;
    }





}

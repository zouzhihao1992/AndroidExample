package com.android.zzh.androidexample.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.android.zzh.androidexample.R;
import com.android.zzh.androidexample.view.LoadView;

import java.util.ArrayList;
import java.util.List;

import java.util.logging.LogRecord;

/**
 * Created by zzh on 16/2/26.
 */
public class ListViewPageActivity extends AppCompatActivity implements LoadView.LoadListener {
    private Toolbar toolbar;
    private LoadView listView;
    private List<String> list;
    private ArrayAdapter<String> adapter;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_activity);
        toolbar = (Toolbar) findViewById(R.id.toolbar_listview);
        setSupportActionBar(toolbar);

        listView = (LoadView)findViewById(R.id.listview_test);
        listView.setOnLoadListener(this);
        list = new ArrayList<String>();
        for (int i = 'A'; i < 'Z'; i++) {
            list.add("" + (char) i);
        }
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list);
        listView.setAdapter(adapter);



    }

    private void getLoadDate(){
        for (int i = 'A'; i <= 'H'; i++) {
            list.add("" + (char) i);
        }
    }
    @Override
    public void onload() {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                getLoadDate();
                adapter.notifyDataSetChanged();
                listView.LoadComplete();
            }
        },2000);


    }

}

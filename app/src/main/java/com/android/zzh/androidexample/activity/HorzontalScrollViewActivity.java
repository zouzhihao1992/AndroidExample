package com.android.zzh.androidexample.activity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.android.zzh.androidexample.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zzh on 16/3/1.
 */
public class HorzontalScrollViewActivity extends AppCompatActivity {
    private String[] lists = {"你好","你好","你好","你好","你好","你好","你好","你好","你好"
            ,"你好","你好","你好","你好","你好","你好"};

    ListView listView1;
    ListView listView2;
    ListView listView3;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.horizontal_scroll_view);
        listView1 = (ListView)findViewById(R.id.ListView1_HorizontalScrollView);
        listView2 = (ListView)findViewById(R.id.ListView2_HorizontalScrollView);
        listView3 = (ListView)findViewById(R.id.ListView3_HorizontalScrollView);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,lists);
        listView1.setAdapter(arrayAdapter);
        listView2.setAdapter(arrayAdapter);
        listView3.setAdapter(arrayAdapter);
    }
}

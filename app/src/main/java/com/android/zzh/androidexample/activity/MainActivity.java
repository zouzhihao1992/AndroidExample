package com.android.zzh.androidexample.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.android.zzh.androidexample.R;

/**
 * Created by zzh on 16/2/14.
 */
public class MainActivity extends AppCompatActivity {
    private final static String[] names ={"TextInputLayout","TabLayout","NavigationView","CoordinaryLayout"};
    private ListView listView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        Toolbar toolbar = (Toolbar)findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);

        listView = (ListView)findViewById(R.id.mainListView);

        listView.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,names));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:  //TextInputLayout
                        startActivity(new Intent(MainActivity.this,TextInputLayoutActivity.class));
                        break;
                    case 1: //TabLayout
                        startActivity(new Intent(MainActivity.this,TabLayoutActivity.class));
                        break;
                    case 2:
                        startActivity(new Intent(MainActivity.this,NavigationViewActivity.class));
                        break;
                }
            }
        });
    }
}

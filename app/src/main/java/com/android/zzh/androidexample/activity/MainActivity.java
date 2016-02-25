package com.android.zzh.androidexample.activity;

import android.app.ListActivity;
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
    private final static String[] names ={"CommonViewActivity","TabLayout","NavigationView","CoordinaryLayout"
    ,"RecyclerViewActivity","FragmentActivity","ListViewActivity"};
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
                        startActivity(new Intent(MainActivity.this,CommonViewActivity.class));
                        break;
                    case 1: //TabLayout
                        startActivity(new Intent(MainActivity.this,TabLayoutActivity.class));
                        break;
                    case 2:
                        startActivity(new Intent(MainActivity.this,NavigationViewActivity.class));
                        break;
                    case 3:
                        startActivity(new Intent(MainActivity.this, CoordinatorLayoutActivity.class));
                        break;
                    case 4:
                        startActivity(new Intent(MainActivity.this,RecyclerViewActivity.class));
                        break;
                    case 5:
                        startActivity(new Intent(MainActivity.this,FragmentActivity.class));
                        break;
                    case 6:
                        Intent intent = new Intent(MainActivity.this, ListViewActivity.class);
                        intent.putExtra("type",ListViewActivity.SIMPLE_ARRAYADAPTER);
                        startActivity(intent);
                        break;
                }
            }
        });
    }
}

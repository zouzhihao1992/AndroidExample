package com.android.zzh.androidexample.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.zzh.androidexample.R;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zzh on 16/2/25.
 */
public class ListViewActivity extends AppCompatActivity {
    public static final int SIMPLE_ARRAYADAPTER = 0;
    public static final int CUSTOM_ARRAYADAPTER = 1;
    ListView listView;
    private Toolbar toolbar;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_activity);

        toolbar  = (Toolbar) findViewById(R.id.toolbar_listview);
        setSupportActionBar(toolbar);

        listView = (ListView) findViewById(R.id.listview_test);
        List<String> list = new ArrayList<String>();
        for (int i = 'A'; i < 'z'; i++) {
            list.add("" + (char) i);
        }
        Intent intent = getIntent();
        int type = intent.getIntExtra("type", 0);
        switch (type) {
            case SIMPLE_ARRAYADAPTER:
                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);
                listView.setAdapter(arrayAdapter);
                break;
            case CUSTOM_ARRAYADAPTER:
                List<Msg> msgs = new ArrayList<>();
                for (int i = 'A'; i < 'z'; i++) {
                    msgs.add(new Msg("" + (char) i,R.drawable.toolbarimg));
                }
                listView.setAdapter(new MyAdapter(ListViewActivity.this,R.layout.listview_item_arrayadapter,msgs));
                break;
            default:
                break;

        }
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ListViewActivity.this,""+position,Toast.LENGTH_LONG).show();
            }
        });

    }

    class MyAdapter extends ArrayAdapter<Msg>{
        private int resourceID;
        public MyAdapter(Context context, int resource, List<Msg> list) {
            super(context, resource,list);
            resourceID = resource;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            Msg msg;
            View view = null;
            MyAdapter.ViewHolder viewHolder;
            msg = getItem(position);
            if (convertView == null){

                view = LayoutInflater.from(getContext()).inflate(resourceID,null);
                viewHolder = new ViewHolder();
                viewHolder.imageView =(ImageView) view.findViewById(R.id.ImageView_listview_arrayadapter);
                viewHolder.textView = (TextView) view.findViewById(R.id.TextView_ImageView_Description);
                view.setTag(viewHolder);
            }else{
                view = convertView;
                viewHolder = (MyAdapter.ViewHolder)convertView.getTag();
            }

            viewHolder.imageView.setImageResource(msg.getImageRes());
            viewHolder.textView.setText(msg.getDescription());

            return view;
        }
        class ViewHolder{
            ImageView imageView;
            TextView textView;
        }
    }

    class Msg{
        private int ImageRes;
        private String description;
        public Msg(String des,int res){
            description = des;
            ImageRes = res;
        }

        public int getImageRes() {
            return ImageRes;
        }



        public String getDescription() {
            return description;
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_listview,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_custom_arrayadapter:
                Intent intent = new Intent(this,ListViewActivity.class);
                intent.putExtra("type",ListViewActivity.CUSTOM_ARRAYADAPTER);
                startActivity(intent);
                finish();
                break;
            case R.id.action_simple_arrayadapter:
                Intent intent2 = new Intent(this,ListViewActivity.class);
                intent2.putExtra("type",ListViewActivity.SIMPLE_ARRAYADAPTER);
                startActivity(intent2);
                finish();
        }
        return true;
    }
}

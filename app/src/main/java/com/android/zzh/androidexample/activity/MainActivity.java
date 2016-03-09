package com.android.zzh.androidexample.activity;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.android.zzh.androidexample.R;

/**
 * Created by zzh on 16/2/14.
 */
public class MainActivity extends AppCompatActivity {
    private final static String[] names ={"CommonViewActivity","TabLayout","NavigationView","CoordinaryLayout"
    ,"RecyclerViewActivity","FragmentActivity","ListViewActivity","ListViewChatActivity","listViewPageActivity",
    "TouchEventActivity","CircleView","ScrollActivity","HorizontalActivity","CustomViewActivity","AIDL_Activity"
    ,"DrawableActivity","ShaderActivity","XMLshadeActivity","ColorFilterActivity"};
    public final static int CustomViewActivity = 13;
    public final static int AIDL_ACTIVITY = 14;
    public final static int DRAWABLE_ACTIVITY = 15;
    public final static int SHADER_ACTIVITY = 16;
    public final static int XML_ACTIVITY = 17;
    public final static int COLORFILTERACTIVITY = 18;
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
                    case 7:
                        Intent intent2 = new Intent(MainActivity.this,listViewChatActivity.class);
                        startActivity(intent2);
                        break;
                    case 8:
                        startActivity(new Intent(MainActivity.this,ListViewPageActivity.class));
                        break;
                    case 9:
                        startActivity(new Intent(MainActivity.this,TouchEventActivity.class));
                        break;
                    case 10:
                        startActivity(new Intent(MainActivity.this,CircleViewActivity.class));
                        break;
                    case 11:
                        startActivity(new Intent(MainActivity.this,ScrollActivity.class));
                        break;
                    case 12:
                        startActivity(new Intent(MainActivity.this,HorzontalScrollViewActivity.class));
                        break;
                    case CustomViewActivity:
                        startActivity(new Intent(MainActivity.this,CustomViewActivity.class));
                        break;
                    case AIDL_ACTIVITY:
                        startActivity(new Intent(MainActivity.this,AIDLActivity.class));
                        break;
                    case DRAWABLE_ACTIVITY:
                        startActivity(new Intent(MainActivity.this,DrawableActivity.class));
                        break;
                    case SHADER_ACTIVITY:
                        startActivity(new Intent(MainActivity.this,ShaderActivity.class));
                        break;
                    case XML_ACTIVITY:
                        startActivity(new Intent(MainActivity.this,XMLShapeActivity.class));
                        break;
                    case COLORFILTERACTIVITY:
                        startActivity(new Intent(MainActivity.this,ColorFilterActivity.class));
                        break;
                    default:
                        break;


                }
            }
        });
    }
}

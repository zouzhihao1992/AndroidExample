package com.android.zzh.androidexample.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.android.zzh.androidexample.R;
import com.android.zzh.androidexample.view.MyViewGroup;


/**
 * Created by zzh on 16/2/27.
 */
public class TouchEventActivity extends AppCompatActivity implements View.OnTouchListener{

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_touch_activity);
        MyViewGroup myViewGroup = (MyViewGroup)findViewById(R.id.MyViewGroup);
        myViewGroup.setOnTouchListener(this);
        getWindow().getDecorView().setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.d("zzh","DecorView onTouch" + event.getAction());
                return false;
            }
        });
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        Log.d("zzh","MyViewGroup onTouch");
        return false;
    }
}

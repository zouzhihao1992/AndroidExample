package com.android.zzh.androidexample.activity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.android.zzh.androidexample.R;
import com.android.zzh.androidexample.drawable.RoundRectImageDrawable;

/**
 * Created by zzh on 16/3/7.
 */
public class DrawableActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drawable_activity);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.toolbarimg);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            findViewById(R.id.ImageView1_drawable_avtivity).setBackground(new RoundRectImageDrawable(bitmap));
        }
    }
}

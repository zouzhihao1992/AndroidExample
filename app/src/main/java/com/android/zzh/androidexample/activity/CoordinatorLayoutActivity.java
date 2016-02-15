package com.android.zzh.androidexample.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.android.zzh.androidexample.R;

/**
 * Created by zzh on 16/2/15.
 */
public class CoordinatorLayoutActivity extends AppCompatActivity {
    private Toolbar toolbar;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.coordinator_layout);
        toolbar = (Toolbar) findViewById(R.id.CoordinatorLayout);
        setSupportActionBar(toolbar);
    }
}

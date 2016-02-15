package com.android.zzh.androidexample.activity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.android.zzh.androidexample.R;

/**
 * Created by zzh on 16/2/15.
 */
public class NavigationViewActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    NavigationView navigationView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigationview_activity);
        drawerLayout = (DrawerLayout) findViewById(R.id.navigationDrawerLayout);
        navigationView = (NavigationView) findViewById(R.id.navigationView);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });
    }


}

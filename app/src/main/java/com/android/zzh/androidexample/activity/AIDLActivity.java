package com.android.zzh.androidexample.activity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.PersistableBundle;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.android.zzh.androidexample.R;
import com.javaexample.zzh.aidlserver.AidlTest;
import com.javaexample.zzh.aidlserver.Person;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by zzh on 16/3/6.
 */
public class AIDLActivity extends AppCompatActivity implements View.OnClickListener, ServiceConnection {

    private Intent intent;
    private AidlTest aidlTest;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aidl_activity);
        findViewById(R.id.button_aidl_start).setOnClickListener(this);
        findViewById(R.id.button_aidl_stop).setOnClickListener(this);
        findViewById(R.id.button_aidl_bind).setOnClickListener(this);
        findViewById(R.id.button_aidl_unbind).setOnClickListener(this);
        intent  = new Intent();
        intent.setComponent(new ComponentName("com.javaexample.zzh.aidlserver","com.javaexample.zzh.aidlserver.RemoteService"));
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.button_aidl_start:
                startService(intent);
                break;
            case R.id.button_aidl_stop:
                stopService(intent);
                break;
            case R.id.button_aidl_bind:
                bindService(intent,this,Context.BIND_AUTO_CREATE);
                break;
            case R.id.button_aidl_unbind:
                unbindService(this);
                break;
        }
    }

    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {
        Log.d("zzh","bind success");
        List<Person> arrayList = null;
        aidlTest = AidlTest.Stub.asInterface(service);
        try {
            arrayList = aidlTest.add(new Person(23,"zzh"));
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        Log.d("zzh",arrayList.toString());
    }

    @Override
    public void onServiceDisconnected(ComponentName name) {
        Log.d("zzh","unbind success");
    }
}

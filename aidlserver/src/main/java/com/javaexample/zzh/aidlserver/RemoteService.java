package com.javaexample.zzh.aidlserver;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zzh on 16/3/6.
 */
public class RemoteService extends Service {

    private ArrayList<Person> persons;
    @Override
    public void onCreate() {
        super.onCreate();
        persons = new ArrayList<>();
        Log.d("zzh","service onCreate");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("zzh","service onDestroy");
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {

        return new AidlTest.Stub() {
            @Override
            public List<Person> add(Person person) throws RemoteException {
                persons.add(person);
                return  persons;
            }
        };
    }
}

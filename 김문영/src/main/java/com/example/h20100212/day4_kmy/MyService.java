package com.example.h20100212.day4_kmy;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by 20100212 on 2015-12-07.
 */
public class MyService extends Service implements Runnable {

    public static final String TAG = "MyService";

    private int count = 0;

    public void onCreate(){
        super.onCreate();

        Thread myThread = new Thread(this);
        myThread.start();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    public void run() {
        while(true){
            try{
                Log.i(TAG, "my service called #" + count);
                count++;

                Thread.sleep(5000);
            }catch(Exception ex){
                Log.e(TAG, ex.toString());
            }
        }
    }
}

package com.example.h20100212.day4_kmy;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by 20100212 on 2015-12-07.
 */
public class MySMSBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("MySMSBroadcastReceiver", "onReceive");

        if (intent.getAction().equals("")){
            Log.d("MySMSBroadcastReceiver", "onReceive");

            abortBroadcast();

            Intent myIntent = new Intent(context, MainActivity.class);
            myIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(myIntent);

        }
    }
}

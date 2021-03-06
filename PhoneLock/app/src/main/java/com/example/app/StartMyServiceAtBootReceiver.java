package com.example.app;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by fahad on 4/17/2014.
 */
public class StartMyServiceAtBootReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if (Intent.ACTION_BOOT_COMPLETED.equals(intent.getAction())) {
            //Start the Filter Service upon receiving launch intent
            Intent serviceIntent = new Intent(context, FilterService.class);
            context.startService(serviceIntent);
        }
    }
}

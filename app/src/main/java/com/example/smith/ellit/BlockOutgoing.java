package com.example.smith.ellit;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class BlockOutgoing extends BroadcastReceiver
{
    String number;
    private static final String TAG = "BlockOutgoing";
    @Override
    public void onReceive(Context context, Intent intent)
    {
//        Log.d("12280", "asdasNumber is-->> " + number);
        number = intent.getStringExtra(Intent.EXTRA_PHONE_NUMBER);
        if(number.equals("851")) {
            setResultData(null);
            Toast.makeText(context, "Outgoing Call Blocked. Because number " + number + " is not safe" , 5000).show();
        } else {
            // Do not thing
        }
        Log.e(TAG, "number: " + number );
    }
}

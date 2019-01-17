package com.example.smith.ellit;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.Toast;

import com.android.internal.telephony.ITelephony;
import com.example.smith.ellit.model.ContactDTO;
import com.example.smith.ellit.model.DataDTO;
import com.example.smith.ellit.util.ContactsOperationActivity;
import com.example.smith.ellit.util.Util;

import java.lang.reflect.Method;
import java.util.List;

public class BlockIncoming extends BroadcastReceiver {
    private static final String TAG = "BlockIncoming";
    String incommingNumber;
    String incno1= "851";
    Util util = new Util();
    ContactsOperationActivity  contactsOperationActivity = new ContactsOperationActivity();

    public void onReceive(Context context, Intent intent) {
        Bundle bundle = intent.getExtras();

        if (null == bundle)
            return;
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        try {

            // Java reflection to gain access to TelephonyManager's
            // ITelephony getter
            TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
            Log.i(TAG, "Get getTeleService...");
            Class c = Class.forName(tm.getClass().getName());
            Method m = c.getDeclaredMethod("getITelephony");
            m.setAccessible(true);
            com.android.internal.telephony.ITelephony telephonyService = (ITelephony) m.invoke(tm);
            Bundle b = intent.getExtras();
            incommingNumber = b.getString(TelephonyManager.EXTRA_INCOMING_NUMBER);
//            Log.i(TAG, incommingNumber);
            Log.i(TAG, "incommingNumber: " + incommingNumber);
//            Boolean isTrustNumber = checkTrustNumber(incommingNumber, context);
            if (incommingNumber.equals(incno1)) {
                telephonyService = (ITelephony) m.invoke(tm);
//                telephonyService.silenceRinger();
                telephonyService.endCall();
                Toast.makeText(context, "Ingoing Call Blocked. Because number " + incommingNumber + " is not safe" , 5000).show();
                Log.i(TAG, "BYE BYE BYE");
            } else {

                telephonyService.answerRingingCall();
                Log.i(TAG, "HELLO HELLO HELLO");
            }
            contactsOperationActivity.getAllContacts(context);

        } catch (Exception e) {
            e.printStackTrace();
            Log.e(TAG,
                    "FATAL ERROR: could not connect to telephony subsystem");
            Log.e(TAG, "Exception object: " + e);
        }

    }

    private Boolean checkTrustNumber (String incommingNumber, Context context) {
        List<ContactDTO> contactList = contactsOperationActivity.getAllContacts(context);
        for (int i = 0; i < contactList.size(); i++) {
            List<DataDTO> dataDTO = contactList.get(i).getPhoneList();
            for(int j=0; j < dataDTO.size(); i++) {
                if (dataDTO.get(j).equals(incommingNumber)) {
                    return true;
                }
            }

        }
        return false;
    }


}

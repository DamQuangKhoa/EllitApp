package com.example.smith.ellit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class GetCallingNumber extends AppCompatActivity {
    private static final String TAG = "GetCallingNumber";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_calling_number);

        Log.e(TAG, "onCreate: " + 5 );
    }
}

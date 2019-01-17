package com.example.smith.ellit;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends BaseActivity implements
        View.OnClickListener {

    private static final String TAG = "MainActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Buttons
        findViewById(R.id.btnTest).setOnClickListener(this);
        findViewById(R.id.nav_home).setOnClickListener(this);
        findViewById(R.id.nav_notify).setOnClickListener(this);



    }

    public void startContact() {
        startActivity(new Intent(MainActivity.this, ContactActivity.class));
    }

    @Override
    public void onClick(View v) {
        Log.e(TAG, "onClick: ");
        int i = v.getId();
        if (i == R.id.btnTest) {
            Toast.makeText(this, "home", Toast.LENGTH_SHORT).show();
        } else if (i == R.id.nav_bookmark) {
            Toast.makeText(this, "bookmark", Toast.LENGTH_SHORT).show();
        } else if (i == R.id.nav_notify) {
            Toast.makeText(this, "notify", Toast.LENGTH_SHORT).show();
        }
    }
}


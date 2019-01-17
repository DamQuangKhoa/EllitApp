package com.example.smith.ellit;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LandingActivity extends  BaseActivity implements
        View.OnClickListener {

    private static final String TAG = "Landing";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.landing);
        Log.e(TAG, "onCreate: "+"helllo " );

        // Buttons
        findViewById(R.id.btn_start).setOnClickListener(this);
        findViewById(R.id.btn_login).setOnClickListener(this);
    }
    public void startApp(){
        startActivity( new Intent(LandingActivity.this,ContactActivity.class));
    }
    public void signIn(){
        startActivity( new Intent(LandingActivity.this,SignUpActivity.class));
    }
    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.btn_start) {
            startApp();
        } else if (i == R.id.btn_login) {
            signIn();
        }
    }
}


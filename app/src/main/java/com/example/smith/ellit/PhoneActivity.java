package com.example.smith.ellit;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class PhoneActivity extends BaseActivity implements
        View.OnClickListener {

    private static final String TAG = "PhoneActivity";
    RecyclerView mRecyclerView;
    MessageAdapter messageAdapter;
    List<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone);
        mRecyclerView = (RecyclerView) findViewById(R.id.list_view);
        list = new ArrayList<>();



    }

    @Override
    public void onClick(View v) {

    }
}


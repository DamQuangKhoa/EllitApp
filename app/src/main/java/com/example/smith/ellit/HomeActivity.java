package com.example.smith.ellit;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends BaseActivity implements
        View.OnClickListener {

    private static final String TAG = "HomeActivity";
    RecyclerView mRecyclerView;
    MessageAdapter messageAdapter;
    List<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView) findViewById(R.id.list_view);
        list = new ArrayList<>();

        list.add("Ted Mobsy");
        list.add("Barney Synten");
        list.add("Alvin Boss");
        list.add("Sandy");

        messageAdapter = new MessageAdapter(list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(messageAdapter);

    }

    @Override
    public void onClick(View v) {

    }
}


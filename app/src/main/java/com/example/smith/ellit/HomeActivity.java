package com.example.smith.ellit;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.smith.ellit.model.Contact;
import com.example.smith.ellit.model.Message;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends BaseActivity implements
        View.OnClickListener {

    private static final String TAG = "HomeActivity";
    RecyclerView mRecyclerView;
    MessageAdapter messageAdapter;
    List<Message> list;
    String[] names = {"Ted Mobsy","Barney Stingson","Alvin Boss"};
    String[] date = {"05/09/2018","05/10/2018","05/11/2018"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView) findViewById(R.id.list_view);
        list = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            list.add(new Message(names[i],date[i] ,"KING855 ONLINE LIVE CASINO ,Sport test spam",11+i));
        }



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


package com.example.smith.ellit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.smith.ellit.model.Contact;

import java.util.ArrayList;
import java.util.List;

public class ContactActivity extends AppCompatActivity {

        RecyclerView mRecyclerView;
        ContactAdapter contactAdapter;
        List<Contact> list;
        String[] names = {"Ted Mobsy","Barney Stingson","Alvin Boss","Sandy Moutain","Tang Hu Xian"};
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_contact);
            mRecyclerView = (RecyclerView) findViewById(R.id.contact_list);
            list = new ArrayList<>();
            for (int i = 0; i < 5; i++) {
                list.add(new Contact(names[i], "Singapore","090169758"+i));
            }

            contactAdapter = new ContactAdapter(list);
            LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
            layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

            mRecyclerView.setLayoutManager(layoutManager);
            mRecyclerView.setAdapter(contactAdapter);

        }
}

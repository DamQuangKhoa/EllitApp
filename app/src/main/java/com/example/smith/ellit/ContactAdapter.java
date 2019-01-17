package com.example.smith.ellit;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.smith.ellit.model.Contact;

import java.util.ArrayList;
import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.RecyclerViewHolder>{

    private static final String TAG = "HomeActivity";
    private List<Contact> data = new ArrayList<>();

    public ContactAdapter(List<Contact> data) {
        this.data = data;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.contact_item, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder:" + position);
        Contact tmp =(Contact) data.get(position);
        holder.txtUserName.setText(tmp.name);
        holder.txtCountry.setText(tmp.country);
        holder.txtNumber.setText(tmp.number);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        TextView txtUserName,txtNumber,txtCountry;
        public RecyclerViewHolder(View itemView) {
            super(itemView);
            txtUserName = (TextView) itemView.findViewById(R.id.author);
            txtCountry = (TextView) itemView.findViewById(R.id.country);
            txtNumber = (TextView) itemView.findViewById(R.id.number);

        }
    }
}
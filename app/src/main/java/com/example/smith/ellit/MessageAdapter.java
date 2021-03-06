package com.example.smith.ellit;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.smith.ellit.R;
import com.example.smith.ellit.model.Message;

import java.util.ArrayList;
import java.util.List;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.RecyclerViewHolder>{

    private static final String TAG = "HomeActivity";
    private List<Message> data = new ArrayList<>();

    public MessageAdapter(List<Message> data) {
        this.data = data;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.message_item, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder:" + position);
        Message tmp = data.get(position);

        holder.txtUserName.setText(tmp.name);
        holder.txtDate.setText(tmp.date);
        holder.txtContent.setText(tmp.content);
        holder.txtCount.setText(tmp.count + " Spam reports" );
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        TextView txtUserName,txtDate,txtContent,txtCount;
        public RecyclerViewHolder(View itemView) {
            super(itemView);
            txtUserName = (TextView) itemView.findViewById(R.id.author);
            txtDate = (TextView) itemView.findViewById(R.id.txtDate);
            txtContent = (TextView) itemView.findViewById(R.id.txtContent);
            txtCount = (TextView) itemView.findViewById(R.id.txtCount);

        }
    }
}
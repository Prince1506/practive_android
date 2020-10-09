package com.example.app_pract.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.app_pract.MainActivity;
import com.example.app_pract.R;
import com.example.app_pract.activities.DetailActivity;
import com.example.app_pract.constants.KeyConstant;

import java.util.ArrayList;
import java.util.List;

public class MainListAdapter extends RecyclerView.Adapter<MainListAdapter.MyViewHolder> {

    private final MainActivity mainActivity;
    List<String> ids;
    public MainListAdapter(ArrayList<String> ids, MainActivity mainActivity) {
        this.mainActivity = mainActivity;
        this.ids = ids;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_main_list, parent, false);
        return new MainListAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, final int position) {
        myViewHolder.mainListIds.setText(""+ids.get(position));

        myViewHolder.mainListIds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = ids.get(position);
                Intent myIntent = new Intent(mainActivity, DetailActivity.class);
                myIntent.putExtra(KeyConstant.KEY_ID, ids.get(position));
                mainActivity.startActivity(myIntent);
            }
        });
    }


    @Override
    public int getItemCount() {
        return ids.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView mainListIds;

        public MyViewHolder(View itemView) {
            super(itemView);
            mainListIds = (TextView) itemView.findViewById(R.id.tv_main_list_ids);
        }

    }
}

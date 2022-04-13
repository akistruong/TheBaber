package com.example.thebaber.Adapter;

import android.app.Activity;
import android.app.ActivityOptions;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.thebaber.Models.BaberTask;
import com.example.thebaber.R;
import com.example.thebaber.StaffActivityPackage.DetailTask;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListTaskAdapter extends RecyclerView.Adapter<ListTaskAdapter.ListTaskViewHolder> {
    List<BaberTask> mList;
    Context context;

    public ListTaskAdapter(List<BaberTask> mList, Context context) {
        this.mList = mList;
        this.context = context;
    }

    @NonNull
    @Override
    public ListTaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_task,parent,false);
        return new ListTaskViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListTaskViewHolder holder, int position) {
       BaberTask task = mList.get(position);
        if(task==null)
        {
            return;
        }
        handleSelect(holder);
        holder.btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String _id = task.get_id();
                Intent intent = new Intent(context, DetailTask.class);
                intent.putExtra("Task",task);
                Bundle anim = ActivityOptions.makeCustomAnimation(context,R.anim.slide_in_left,R.anim.slide_out_right).toBundle();
                context.startActivity(intent,anim);
            }
        });
    }

    @Override
    public int getItemCount() {
        if(mList!=null)
        {
           return mList.size();
        }
        return 0;
    }

    public class ListTaskViewHolder extends  RecyclerView.ViewHolder
    {
        TextView textView;
        Button btnClick;
        public ListTaskViewHolder(@NonNull View itemView) {
            super(itemView);
//            textView = itemView.findViewById(R.id.select_service_staff);
            btnClick = itemView.findViewById(R.id.btnUpdateTask);
        }
    }
    void handleSelect(ListTaskViewHolder holder)
    {



    }


}

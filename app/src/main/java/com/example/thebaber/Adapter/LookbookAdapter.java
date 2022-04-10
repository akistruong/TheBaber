package com.example.thebaber.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.thebaber.Models.Lookbook;

import java.util.List;

public class LookbookAdapter extends RecyclerView.Adapter<LookbookAdapter.LookbookAdapterViewHolder> {
    List<Lookbook> mList;
    Context context;

    public LookbookAdapter(List<Lookbook> mList, Context context) {
        this.mList = mList;
        this.context = context;
    }

    @NonNull
    @Override
    public LookbookAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(context).inflate()
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull LookbookAdapterViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class LookbookAdapterViewHolder extends RecyclerView.ViewHolder
    {

        public LookbookAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
        }

    }

}

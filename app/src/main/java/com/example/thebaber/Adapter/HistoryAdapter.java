package com.example.thebaber.Adapter;

import static android.content.ContentValues.TAG;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.thebaber.Fragments.HistoryUser;
import com.example.thebaber.Models.BaberTask;
import com.example.thebaber.R;

import java.util.Date;
import java.util.List;

public class HistoryAdapter extends RecyclerView.Adapter <HistoryAdapter.HistoryViewHolder> {
    List<BaberTask> mList;
    Context context;

    public HistoryAdapter(List<BaberTask> mList, Context context) {
        this.mList = mList;
        this.context = context;
    }
    @NonNull
    @Override

    public HistoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.history_item,parent,false);
        return new HistoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryViewHolder holder, int position) {
        BaberTask history = mList.get(position);
        if(history==null)
        {
            return;
        }
        holder.mDate.setText(FormatDate(history.getDate()));
        holder.mRating.setRating(history.getReviewStars());
    }

    @Override
    public int getItemCount() {
        if(mList !=null)
        {
            return mList.size();
        }
        return 0;
    }

    public  class HistoryViewHolder extends RecyclerView.ViewHolder
    {
        TextView mPrice,mService,mDate;
        RatingBar mRating;
        public HistoryViewHolder(@NonNull View itemView) {
            super(itemView);
            mPrice = itemView.findViewById(R.id.txt_history_price);
            mService = itemView.findViewById(R.id.txt_history_service);
            mDate = itemView.findViewById(R.id.txt_history_date);
            mRating = itemView.findViewById(R.id.history_rating);
        }
    }
    String FormatDate(Date date)
    {
        String Ngay = String.valueOf(date.getDate());
        String Thang = String.valueOf(date.getMonth()+1);
        String Nam = String.valueOf(date.getYear()-1900);

        return Ngay+"-"+Thang+"-"+Nam;
    }

}

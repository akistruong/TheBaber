package com.example.thebaber.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.thebaber.Models.StyleHair;
import com.example.thebaber.R;

import java.util.List;

public class StyleAdapter extends RecyclerView.Adapter<StyleAdapter.StyleViewHolder> {
    Context mContext;
    List<StyleHair> mStyleList;

    public class StyleViewHolder extends  RecyclerView.ViewHolder
    {
        TextView mCardTitle;
        ImageView mCardStyleImg;
        public StyleViewHolder(@NonNull View itemView) {
            super(itemView);
            mCardTitle = itemView.findViewById(R.id.txtCardTitle);
            mCardStyleImg = itemView.findViewById(R.id.bannerIv);
        }
    }
    public void setData(List<StyleHair> styleHairs)
    {
        this.mStyleList = styleHairs;
        notifyDataSetChanged();
    }
    public StyleAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public StyleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item,parent,false);
        return new StyleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StyleViewHolder holder, int position) {
        StyleHair style = mStyleList.get(position);
        if(style==null)
        {
            return;
        }
        holder.mCardTitle.setText(style.getTitle());
        holder.mCardStyleImg.setImageResource(style.getUrl());
    }


    @Override
    public int getItemCount() {
        if(mStyleList!=null)
        {
            return mStyleList.size();
        }
        return 0;
    }
}

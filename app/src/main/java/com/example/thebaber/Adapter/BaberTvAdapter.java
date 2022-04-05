package com.example.thebaber.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.thebaber.Models.PostVideo;
import com.example.thebaber.PlayVideo;
import com.example.thebaber.R;

import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BaberTvAdapter  extends RecyclerView.Adapter<BaberTvAdapter.BaberTvAdapterViewHolder> {
    Context context;
    List<PostVideo> mItems;

    public BaberTvAdapter(Context context, List<PostVideo> mItems) {
        this.context = context;
        this.mItems = mItems;
    }

    @NonNull
    @Override
    public BaberTvAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.baber_tv_item,parent,false);
        return new BaberTvAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BaberTvAdapterViewHolder holder, int position) {
            PostVideo item = mItems.get(position);
            if(item==null)
            {
                return;
            }

            holder.txtBaberTv.setText(item.getTitle());
            Glide.with(context).load(item.getImgUrl()).into(holder.imgBaberTv);
           String uri= extractYTId(item.getUri());
            holder.cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, PlayVideo.class);
                    intent.putExtra("VideoId",uri);
                    context.startActivity(intent);
                }
            });
    }

    @Override
    public int getItemCount() {
        if(mItems!=null)
        {
            return mItems.size();
        }
        return 0;
    }

    public class BaberTvAdapterViewHolder extends  RecyclerView.ViewHolder
    {
        ImageView imgBaberTv;
        TextView txtBaberTv;
        CardView cardView;
        public BaberTvAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            imgBaberTv = itemView.findViewById(R.id.banner_baber_tv);
            txtBaberTv = itemView.findViewById(R.id.title_baber_tv);
            cardView = itemView.findViewById(R.id.baber_tv_card);
        }
    }
    public static String extractYTId(String ytUrl) {
        String pattern = "(?<=youtu.be/|watch\\?v=|/videos/|embed\\/)[^#\\&\\?]*";
        Pattern compiledPattern = Pattern.compile(pattern);
        Matcher matcher = compiledPattern.matcher(ytUrl);
        if(matcher.find()){
            return matcher.group();
        } else {
            return "error";
        }
    }

}

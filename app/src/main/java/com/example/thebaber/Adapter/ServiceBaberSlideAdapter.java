package com.example.thebaber.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.bumptech.glide.Glide;
import com.example.thebaber.Models.ServiceBaber;
import com.example.thebaber.R;

import org.w3c.dom.Text;

import java.util.List;

public class ServiceBaberSlideAdapter extends RecyclerView.Adapter<ServiceBaberSlideAdapter.ServiceBaberSliceViewHolder> {
    List<ServiceBaber> mList;
    ViewPager2 viewPager2;
    Context context;
    public ServiceBaberSlideAdapter(List<ServiceBaber> mList, ViewPager2 viewPager2,Context context) {
        this.mList = mList;
        this.viewPager2 = viewPager2;
        this.context=context;
    }

    @NonNull
    @Override

    public ServiceBaberSliceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.service_item,parent,false);

        return new ServiceBaberSliceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ServiceBaberSliceViewHolder holder, int position) {
        ServiceBaber item = mList.get(position);
        if(item==null)
        {
            return;
        }
        holder.mTitle.setText(item.getTitle());
        holder.mDsc.setText(item.getDsc());
        Glide.with(context).load(item.getUrl()).into(holder.mbanner);
    }

    @Override
    public int getItemCount() {
        if(mList!=null)
        {
            return mList.size();
        }
        return 0;
    }

    public class ServiceBaberSliceViewHolder extends RecyclerView.ViewHolder
    {
        ImageView mbanner;
        TextView   mTitle;
        TextView mDsc;
        public ServiceBaberSliceViewHolder(@NonNull View itemView) {
            super(itemView);
            mbanner = itemView.findViewById(R.id.service_banner);
            mTitle = itemView.findViewById(R.id.txt_title_service);
            mDsc = itemView.findViewById(R.id.txt_dsc_service);
        }

        @Override
        public String toString() {
            return super.toString();
        }
    }

}

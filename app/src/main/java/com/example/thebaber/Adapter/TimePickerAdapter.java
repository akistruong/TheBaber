package com.example.thebaber.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.thebaber.Fragments.ItemClickListener;
import com.example.thebaber.Models.StyleHair;
import com.example.thebaber.PagerAdapter;
import com.example.thebaber.R;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TimePickerAdapter extends RecyclerView.Adapter<TimePickerAdapter.TimePickerViewHolder> {
    Context mContext;
    List<String> times;
    ItemClickListener itemClickListener;
    int selectedPosition= -1;
    public TimePickerAdapter(Context mContext,ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
        this.mContext = mContext;
    }
    public class TimePickerViewHolder extends RecyclerView.ViewHolder{
        RadioButton btnRadio_times;
        public TimePickerViewHolder(@NonNull View itemView) {
            super(itemView);
            btnRadio_times = itemView.findViewById(R.id.btnRadio_times);
        }

        @Override
        public String toString() {
            return super.toString();
        }
    }

    @NonNull
    @Override
    public TimePickerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_timepicker,parent,false);
        return new TimePickerViewHolder(view);
    }
    public void setData(List<String> times)
    {
        this.times = times;
        notifyDataSetChanged();
    }
    @Override
    public void onBindViewHolder(@NonNull TimePickerViewHolder holder, int position) {
        int hours = new Date().getHours();

        String time = times.get(position);
        int getHoursObj = Integer.parseInt(time.split("H")[0]);
        if(time==null)
        {
            return;
        }
       if(getHoursObj<hours)
       {
           holder.btnRadio_times.setEnabled(false);
       }
        holder.btnRadio_times.setText(time);
        holder.btnRadio_times.setChecked(position==selectedPosition);
        holder.btnRadio_times.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b)
                {
                    selectedPosition = holder.getAdapterPosition();
                    itemClickListener.onClick(holder.btnRadio_times.getText().toString());
                }
            }
        });
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return times.size();
    }


}

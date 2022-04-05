package com.example.thebaber.Adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.example.thebaber.Models.StyleHair;
import com.example.thebaber.PagerAdapter;
import com.example.thebaber.R;
import com.example.thebaber.ViewPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class StyleAdapter extends PagerAdapter {
    Context context;
    ArrayList<StyleHair> styles;


    public StyleAdapter( Context context, ArrayList<StyleHair> styles) {
        super();
        this.context = context;
        this.styles = styles;
    }

    @Override
    public int getCount() {
        if(styles!=null)
        {
            return styles.size();
        }
        return 0;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.card_item,container,false);
        ImageView imgView = view.findViewById(R.id.bannerIv);
        TextView txtTitle = view.findViewById(R.id.txtCardTitle);
        TextView txtDsc = view.findViewById(R.id.explore_dsc);
        CardView card = view.findViewById(R.id.style_card);
        //get data
        StyleHair style = styles.get(position);
        Glide.with(context).load(style.getUrl()).into(imgView);
        txtTitle.setText(style.getTitle());
        txtDsc.setText(style.getDsc());
        card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(style.getUriPost()));
                context.startActivity(browserIntent);

            }
        });
        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        ((ViewPager)container).removeView((View)object);
    }
}

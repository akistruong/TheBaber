package com.example.thebaber;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.thebaber.Fragments.ExploreFragment;
import com.example.thebaber.Models.StyleHair;

import java.util.ArrayList;

public class PagerAdapter extends androidx.viewpager.widget.PagerAdapter {
    Context context;
    ArrayList<StyleHair> styles;

    public PagerAdapter(Context context, ArrayList<StyleHair> styles) {
        this.context = context;
        this.styles = styles;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        View view1 = LayoutInflater.from(context).inflate(R.layout.card_item,container,false);
        ImageView imageView = view1.findViewById(R.id.bannerIv);
        TextView textView =view1.findViewById(R.id.txtCardTitle);
        StyleHair style =  styles.get(position);
        int url =style.getUrl();
        String Title = style.getTitle();
        //set data;
        imageView.setImageResource(url);
        textView.setText(Title);
        container.addView(view1,position);
        return view1;
    }

    public PagerAdapter() {
    }

    @Override
    public int getCount() {
        return styles.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);

    }
}

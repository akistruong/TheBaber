package com.example.thebaber.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.thebaber.Adapter.BaberTvAdapter;
import com.example.thebaber.Adapter.ServiceBaberSlideAdapter;
import com.example.thebaber.Models.PostVideo;
import com.example.thebaber.Models.ServiceBaber;
import com.example.thebaber.PlayVideo;
import com.example.thebaber.R;
import com.google.android.flexbox.FlexboxLayoutManager;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

public class HomeUserFragment extends Fragment {


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    RecyclerView rcv_baberTv;
    BaberTvAdapter adapter;
    CardView baber_card;
    ViewPager2 viewPager2;
    Handler sliderHandler = new Handler();
    public HomeUserFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_user, container, false);
        rcv_baberTv = view.findViewById(R.id.rcv_baberTv);
        baber_card =(CardView)view.findViewById(R.id.baber_tv_card);
        viewPager2 = (ViewPager2)view.findViewById(R.id.vpg_service);
        viewPager2.setAdapter(new ServiceBaberSlideAdapter(initServiceData(),viewPager2,getActivity()));
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                sliderHandler.removeCallbacks(sliderHandle);
                sliderHandler.postDelayed(sliderHandle,3000);
            }
        });
        adapter = new BaberTvAdapter(getActivity(),initData());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false);
//        FlexboxLayoutManager flexboxLayoutManager = new FlexboxLayoutManager()
        rcv_baberTv.setLayoutManager(linearLayoutManager);
        rcv_baberTv.setAdapter(adapter);

        return view;
    }
    List<PostVideo> initData()
    {
        List<PostVideo> mPostVides = new ArrayList<>();
        mPostVides.add(new PostVideo("xx","https://https://www.youtube.com/watch?v=BO5iCL7U6Lc&ab_channel=Stevdza-San.com/","https://storage.30shine.com/ResourceWeb/data/images/hanh-trinh-toa-sang/30shine-thay-doi-ngoai-hinh.jpg"));
        mPostVides.add(new PostVideo("asdhaxxsdkash","https://www.youtube.com/watch?v=3bvNAHbSExk&ab_channel=CUKAK","https://storage.30shine.com/ResourceWeb/data/images/hanh-trinh-toa-sang/30shine-thay-doi-ngoai-hinh.jpg"));
        mPostVides.add(new PostVideo("xx","https://www.youtube.com/watch?v=zCJuQYX-sL4&ab_channel=CUKAK","https://storage.30shine.com/ResourceWeb/data/images/hanh-trinh-toa-sang/30shine-thay-doi-ngoai-hinh.jpg"));
        mPostVides.add(new PostVideo("asdh23asdkash","https://www.youtube.com/watch?v=6DM4jW0533A&ab_channel=CUKAK","https://storage.30shine.com/ResourceWeb/data/images/hanh-trinh-toa-sang/30shine-thay-doi-ngoai-hinh.jpg"));
        return mPostVides;
    }
    List<ServiceBaber> initServiceData()
    {
        List<ServiceBaber> mService = new ArrayList<>();
        mService.add(new ServiceBaber("https://images.pexels.com/photos/11297792/pexels-photo-11297792.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260","dasdasd","dasdada"));
        mService.add(new ServiceBaber("https://images.pexels.com/photos/11297792/pexels-photo-11297792.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260","dasdasd","dasdada"));
        mService.add(new ServiceBaber("https://images.pexels.com/photos/11297792/pexels-photo-11297792.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260","dasdasd","dasdada"));
        mService.add(new ServiceBaber("https://images.pexels.com/photos/11297792/pexels-photo-11297792.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260","dasdasd","dasdada"));
        return mService;
    }
    Runnable sliderHandle = new Runnable() {
        @Override
        public void run() {
            viewPager2.setCurrentItem(viewPager2.getCurrentItem()+1);
        }
    };
}
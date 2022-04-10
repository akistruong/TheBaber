package com.example.thebaber.Fragments;

import static com.example.thebaber.Helpers.CloudHelper.initCloud;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Handler;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.thebaber.Adapter.BaberTvAdapter;
import com.example.thebaber.Adapter.ServiceBaberSlideAdapter;
import com.example.thebaber.Helpers.CloudHelper;
import com.example.thebaber.Models.PostVideo;
import com.example.thebaber.Models.ServiceBaber;
import com.example.thebaber.Models.User;
import com.example.thebaber.PlayVideo;
import com.example.thebaber.R;
import com.example.thebaber.UserActivity.UpdateUser;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

import de.hdodenhof.circleimageview.CircleImageView;

public class HomeUserFragment extends Fragment {


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    RecyclerView rcv_baberTv;
    BaberTvAdapter adapter;
    CardView baber_card;
    ViewPager2 viewPager2;
    CircleImageView avt;
    TextView mFullName;
    Handler sliderHandler = new Handler();
    FirebaseAuth mAuth;
    FirebaseFirestore mStore;
    FirebaseUser user;
     UpdateUser UpdateUser;

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
        initView(view);
        handleBaberServiceSlide();
        handleBaberTv();

        return view;
    }

    private void handleBaberServiceSlide() {
        viewPager2.setAdapter(new ServiceBaberSlideAdapter(initServiceData(),viewPager2,getActivity()));
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                sliderHandler.removeCallbacks(sliderHandle);
                sliderHandler.postDelayed(sliderHandle,3000);
            }
        });
    }
    View initView(View view)
    {
        mStore = FirebaseFirestore.getInstance();
        mAuth= FirebaseAuth.getInstance();
        user = FirebaseAuth.getInstance().getCurrentUser();

        Uri uri = user.getPhotoUrl();

        rcv_baberTv = view.findViewById(R.id.rcv_baberTv);
        baber_card =(CardView)view.findViewById(R.id.baber_tv_card);
        viewPager2 = (ViewPager2)view.findViewById(R.id.vpg_service);
        mFullName = view.findViewById(R.id.user_fullName);
        avt =(CircleImageView)view.findViewById(R.id.avt_user);
        mFullName.setText(user.getDisplayName());
        mStore.collection("users").document(user.getUid()).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if(task.isSuccessful())
                {
                    User mUser  = task.getResult().toObject(User.class);
                    if(task.getResult().exists())
                    {
                       Glide.with(getActivity()).load(mUser.getAvtUrl().getUrl()).into(avt);
                       mFullName.setText(mUser.getUserName());
                    }
                }
            }
        });
        return view;
    }

    private void handleBaberTv() {
        adapter = new BaberTvAdapter(getActivity(),initData());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false);
        rcv_baberTv.setLayoutManager(linearLayoutManager);
        rcv_baberTv.setAdapter(adapter);
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
        mService.add(new ServiceBaber("https://storage.30shine.com/ResourceWeb/data/images/Service/cat-xa-5-buoc/cat-xa-tao-kieu-5-buoc-1.jpg","dasdasd","dasdada",null));
        mService.add(new ServiceBaber("https://storage.30shine.com/ResourceWeb/data/images/Service/phuc-hoi/20211217-banner-phuc-hoi.jpg","dasdasd","dasdada",null));
        mService.add(new ServiceBaber("https://storage.30shine.com/ResourceWeb/data/images/Service/massage-co-vai-gay-new/30shine-massage-co-vai-gay-41.jpg","dasdasd","dasdada",null));
        mService.add(new ServiceBaber("https://storage.30shine.com/ResourceWeb/data/images/Service/detox-thai-doc/30shine-5-buoc-detox-thai-doc-da-dau-27.jpg","dasdasd","dasdada",null));
        return mService;
    }
    Runnable sliderHandle = new Runnable() {
        @Override
        public void run() {
            viewPager2.setCurrentItem(viewPager2.getCurrentItem()+1);
        }
    };
}
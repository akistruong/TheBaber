package com.example.thebaber.Fragments;

import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.thebaber.Adapter.StyleAdapter;
import com.example.thebaber.Models.StyleHair;
import com.example.thebaber.PagerAdapter;
import com.example.thebaber.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ExploreFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ExploreFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    ArrayList<StyleHair> Mstyles;
    ViewPager StyleViewPager;
    StyleAdapter styleAdapter;


    public ExploreFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ExploreFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ExploreFragment newInstance(String param1, String param2) {
        ExploreFragment fragment = new ExploreFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }



    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragment_explore, container, false);
        StyleViewPager = v.findViewById(R.id.style_view_pager);
        // Inflate the layout for this fragment
        RecyclerView rcvStyles;
        styleAdapter = new StyleAdapter(getActivity(),getListStyles());
        StyleViewPager.setAdapter(styleAdapter);
        return v;

    }

    private ArrayList<StyleHair> getListStyles() {
        Mstyles =new ArrayList<>();
        Mstyles.add(new StyleHair("https://batdongsanbinhduong24h.com/wp-content/uploads/2019/04/kieu-toc-undercut-dep.jpg","Kiểu Undercut","Tóc Undercut là kiểu tóc được cắt ngắn 2 bên (sides) và phía sau, phần tóc mái được để với độ dài phù hợp với các tạo kiểu đa dạng như uốn, xoăn, phồng phù hợp với sở thích, khuôn mặt mỗi người.","https://clmensstore.com/blog/undercut-la-gi/",null));
        Mstyles.add(new StyleHair("https://cdn.24h.com.vn/upload/3-2021/images/2021-07-30/25-kieu-toc-Mullet-dep-cuc-ngau-sanh-dieu-dan-dau-xu-huong-hien-nay-toc-mullet-5-1627609367-671-width600height760.jpg","Kiểu Mullet","Mullet, là kiểu tóc được ban nhạc hip hop người Mỹ (Beastie Boys) phổ biến, khi nhóm nhạc này phát hành bài hát “Mullet Head”.","http://www.google.com",null));
        Mstyles.add(new StyleHair("https://kynguyenlamdep.com/wp-content/uploads/2020/03/toc-sport-nam-ngan.jpg","Kiểu Sport","Kiểu tóc Sport là là phong cách tóc ngắn gọn gàng, cân đối cho cánh mày râu. Khác với các kiểu tóc Side Part hay kiểu tóc Undercut, kiểu tóc Sport được yêu thích bởi sự đơn giản nhưng lại vô cùng thu hút. Đây cũng là kiểu tóc phù hợp với mọi khuôn mặt và mọi lứa tuổi. Ngay bây giờ, ReviewNao sẽ điểm qua Top 9 kiểu tóc Sport được yêu thích nhất hiện nay.","http://www.google.com",null));


        return Mstyles;
    }


}
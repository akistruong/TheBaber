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
        // Inflate the layout for this fragment
        RecyclerView rcvStyles;
        StyleAdapter pagerAdapter;
        rcvStyles = v.findViewById(R.id.rcv_style_list);
        pagerAdapter = new StyleAdapter(getActivity());
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(),3);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false);
        rcvStyles.setLayoutManager(linearLayoutManager);
        pagerAdapter.setData(getListStyles());
        rcvStyles.setAdapter(pagerAdapter);
        return v;

    }

    private List<StyleHair> getListStyles() {
        Mstyles =new ArrayList<>();
        Mstyles.add(new StyleHair(R.drawable.pexelphoto,"Something"));
        Mstyles.add(new StyleHair(R.drawable.pexelphoto,"dawdawaadada"));
        Mstyles.add(new StyleHair(R.drawable.pexelphoto,"Something"));
        Mstyles.add(new StyleHair(R.drawable.pexelphoto,"dawdawaadada"));
        Mstyles.add(new StyleHair(R.drawable.pexelphoto,"Something"));
        Mstyles.add(new StyleHair(R.drawable.pexelphoto,"dawdawaadada"));
        Mstyles.add(new StyleHair(R.drawable.pexelphoto,"Something"));
        Mstyles.add(new StyleHair(R.drawable.pexelphoto,"dawdawaadada"));
        Mstyles.add(new StyleHair(R.drawable.pexelphoto,"Something"));
        Mstyles.add(new StyleHair(R.drawable.pexelphoto,"dawdawaadada"));
        Mstyles.add(new StyleHair(R.drawable.pexelphoto,"Something"));
        Mstyles.add(new StyleHair(R.drawable.pexelphoto,"dawdawaadada"));

        return Mstyles;
    }


}
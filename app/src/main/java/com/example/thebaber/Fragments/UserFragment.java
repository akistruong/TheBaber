package com.example.thebaber.Fragments;

import static com.example.thebaber.Helpers.CloudHelper.initCloud;
import static com.example.thebaber.MainActivity.mainActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.thebaber.Adapter.UserPagerAdapter;
import com.example.thebaber.AdminScreen;
import com.example.thebaber.Login;
import com.example.thebaber.R;
import com.example.thebaber.SplashScreen;
import com.example.thebaber.UserActivity.UpdateUser;
import com.example.thebaber.UserActivity.UserHistory;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link UserFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class UserFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    ViewPager viewPager;
    NavigationView navigationView;
    UserPagerAdapter adapter;
    FirebaseAuth mAuth;
    public UserFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment UserFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static UserFragment newInstance(String param1, String param2) {
        UserFragment fragment = new UserFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        mAuth = FirebaseAuth.getInstance();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user, container, false);
        navigationView = view.findViewById(R.id.user_navigation);
        adapter = new UserPagerAdapter(getActivity().getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        handleNavigationClick();

        return  view;
    }

    private void handleNavigationClick() {
        HistoryUser historyUser = new HistoryUser();
//            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.user_fragment,historyUser,HistoryUser.class.getSimpleName()).commit();
            navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    if(item.getItemId()==R.id.nav_user_history)
                    {
                        Intent intent = new Intent(getActivity(), UserHistory.class);
                        getActivity().startActivity(intent);
                        getActivity().overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
                    }
                    else if(item.getItemId()==R.id.nav_user_updateInfo)
                    {
                        Intent intent = new Intent(getActivity(), UpdateUser.class);
                        getActivity().startActivity(intent);
                        getActivity().overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
                    }
                    else if(item.getItemId()==R.id.nav_user_logout)
                    {
                        mAuth.signOut();
                        Intent intent = new Intent(getActivity(), SplashScreen.class);
                        getActivity().startActivity(intent);
                        mainActivity.finish();
                    }
                    return false;
                }
            });
    }
}
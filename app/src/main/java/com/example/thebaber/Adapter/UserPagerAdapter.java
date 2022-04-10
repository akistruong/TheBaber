package com.example.thebaber.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.thebaber.Fragments.ExploreFragment;
import com.example.thebaber.Fragments.HistoryUser;
import com.example.thebaber.Fragments.HomeUserFragment;
import com.example.thebaber.Fragments.SetDateFragment;
import com.example.thebaber.Fragments.UserFragment;

public class UserPagerAdapter  extends FragmentStatePagerAdapter {
    public UserPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0:
                return new HistoryUser();
            default:
                return new UserFragment();
        }
    };

    @Override
    public int getCount() {
        return 1;
    }
}

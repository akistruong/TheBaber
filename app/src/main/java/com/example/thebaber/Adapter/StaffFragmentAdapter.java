package com.example.thebaber.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.thebaber.Fragments.ExploreFragment;
import com.example.thebaber.Fragments.HomeUserFragment;
import com.example.thebaber.Fragments.SetDateFragment;
import com.example.thebaber.Fragments.StaffFragments.StaffAccount;
import com.example.thebaber.Fragments.StaffFragments.TaskForStaff;
import com.example.thebaber.Fragments.UserFragment;

public class StaffFragmentAdapter extends FragmentStatePagerAdapter {

    public StaffFragmentAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0:
                return new TaskForStaff();
            case 1:
                return new StaffAccount();

            default:
                return new TaskForStaff();
        }
    }

    @Override
    public int getCount() {
        return 2;
    }
}

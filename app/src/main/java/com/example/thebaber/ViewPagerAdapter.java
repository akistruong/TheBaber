package com.example.thebaber;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.thebaber.Fragments.ExploreFragment;
import com.example.thebaber.Fragments.HomeUserFragment;
import com.example.thebaber.Fragments.SetDateFragment;
import com.example.thebaber.Fragments.UserFragment;

public class ViewPagerAdapter extends FragmentStatePagerAdapter  {

    public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0:
                return new HomeUserFragment();
            case 1:
                return new ExploreFragment();
            case 2 :
                return new SetDateFragment();
            case 3:
                return new UserFragment();
            default:
                return new HomeUserFragment();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }
}

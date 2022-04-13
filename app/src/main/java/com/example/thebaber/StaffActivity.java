package com.example.thebaber;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.thebaber.Adapter.StaffFragmentAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class StaffActivity extends AppCompatActivity {
    StaffFragmentAdapter staffFragmentAdapter;
    ViewPager viewPager;
    BottomNavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff);
        initView();
    }
    void initView()
    {
        viewPager = findViewById(R.id.vpg_staff);
        navigationView = findViewById(R.id.bottom_staff_nav);
        staffFragmentAdapter =new StaffFragmentAdapter(getSupportFragmentManager(),FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPager.setAdapter(staffFragmentAdapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                switch (position)
                {
                    case 0:
                        navigationView.getMenu().findItem(R.id.nav_staff_task).setChecked(true);
                    case 1:
                        navigationView.getMenu().findItem(R.id.nav_staff_account).setChecked(true);

                    default:
                        navigationView.getMenu().findItem(R.id.nav_staff_task).setChecked(true);
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        navigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
               switch (item.getItemId())
               {
                   case R.id.nav_staff_task:
                       viewPager.setCurrentItem(0);
                       break;
                   case R.id.nav_staff_account:
                       viewPager.setCurrentItem(1);
                       break;
                   default:
                       viewPager.setCurrentItem(0);
                       break;
               }
               return true;
            }
        });
    }


}
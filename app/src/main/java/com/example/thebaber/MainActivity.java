package com.example.thebaber;

import static com.example.thebaber.Helpers.CloudHelper.initCloud;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.SharedPreferences;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.example.thebaber.Helpers.CloudHelper;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
   BottomNavigationView navigationView;
    ViewPagerAdapter viewPagerAdapter;
    ViewPager viewPager;
    SharedPreferences prefs = null;
    public static MainActivity mainActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = findViewById(R.id.view_pager);
        navigationView = findViewById(R.id.bottom_nav);
        mainActivity = this;
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPager.setAdapter(viewPagerAdapter);
//        initCloud();
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }
            @Override
            public void onPageSelected(int position) {
                switch (position)
                {
                    case 0:
                        navigationView.getMenu().findItem(R.id.NavHome).setChecked(true);
                    case 1:
                        navigationView.getMenu().findItem(R.id.Nav_Explore).setChecked(true);
                    case 2 :
                        navigationView.getMenu().findItem(R.id.Nav_SetDate).setChecked(true);
                    case 3:
                        navigationView.getMenu().findItem(R.id.Nav_User).setChecked(true);
                    default:
                        navigationView.getMenu().findItem(R.id.NavHome).setChecked(true);
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
                    case R.id.NavHome:
                        viewPager.setCurrentItem(0);
                        break;
                    case R.id.Nav_Explore:
                        viewPager.setCurrentItem(1);
                        break;
                    case R.id.Nav_SetDate:
                        viewPager.setCurrentItem(2);
                        break;
                    case R.id.Nav_User:
                        viewPager.setCurrentItem(3);
                        break;
                    default:
                        viewPager.setCurrentItem(1);
                        break;
                };
                return true;
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

    }
}
package com.tony.dbmovie.ui.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.tony.dbmovie.R;
import com.tony.dbmovie.ui.adapter.CustomFragmentPagerAdapter;

/**
 * Created by bushi on 2018/3/31.
 */

public class HomeActivity extends AppCompatActivity{

    private ViewPager viewPager;
    private BottomNavigationView navigationView;
    private MenuItem item;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        viewPager = findViewById(R.id.container);
        navigationView = findViewById(R.id.tab_layout);
        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.tab_book:
                        viewPager.setCurrentItem(1);
                        break;
                    case R.id.tab_movie:
                        viewPager.setCurrentItem(0);
                        break;
                    case R.id.tab_music:
                        viewPager.setCurrentItem(2);
                        break;
                }
                return false;
            }
        });
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (item != null)
                {
                    item.setChecked(false);
                }else {
                    navigationView.getMenu().getItem(0).setChecked(false);
                }
                item = navigationView.getMenu().getItem(position);
                item.setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        viewPager.setAdapter(new CustomFragmentPagerAdapter(getSupportFragmentManager()));
    }
}

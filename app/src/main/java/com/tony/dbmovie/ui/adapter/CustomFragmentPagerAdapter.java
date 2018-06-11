package com.tony.dbmovie.ui.adapter;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.View;

import com.tony.dbmovie.ui.fragment.BaseFragment;
import com.tony.dbmovie.ui.fragment.MovieBaseFragment;

/**
 * Created by bushi on 2018/3/31.
 */

public class CustomFragmentPagerAdapter extends FragmentPagerAdapter {
    public CustomFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0:
                return  new MovieBaseFragment();
            case 1:
                return  BaseFragment.getInstance("Book");
            case 2:
                return  BaseFragment.getInstance("Music");
        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }
}

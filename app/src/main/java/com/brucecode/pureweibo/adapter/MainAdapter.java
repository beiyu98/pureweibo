package com.brucecode.pureweibo.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.brucecode.pureweibo.base.BaseFragment;

import java.util.List;

/**
 * Created by bruce on 2016/11/29.
 */

public class MainAdapter extends FragmentPagerAdapter {

    private List<BaseFragment> mFragments;

    public MainAdapter(FragmentManager fm, List<BaseFragment> fragments) {
        super(fm);
        mFragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }
}

package com.brucecode.pureweibo.ui.main;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.brucecode.pureweibo.R;
import com.brucecode.pureweibo.adapter.MainAdapter;
import com.brucecode.pureweibo.base.BaseActivity;
import com.brucecode.pureweibo.base.BaseFragment;
import com.brucecode.pureweibo.databinding.MainAtyBinding;
import com.brucecode.pureweibo.ui.main.fragment.MeFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bruce on 2016/11/27.
 */

public class MainAty extends BaseActivity {

    private MainAtyBinding mMainAtyBinding;
    private ViewPager mViewPager;
    private BottomNavigationBar mNavigationBar;

    private MeFragment mMeFragment;
    private MainAdapter mMainAdapter;
    private List<BaseFragment> mFragmentList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mMainAtyBinding = DataBindingUtil.setContentView(this, R.layout.main_aty);
    }

    @Override
    protected void initData() {
        mNavigationBar = mMainAtyBinding.mainBottomNavigationBar;
        mViewPager = mMainAtyBinding.mainViewPager;

        initFragment();

        mMainAdapter = new MainAdapter(getSupportFragmentManager(),mFragmentList);
        mViewPager.setAdapter(mMainAdapter);
        mViewPager.setOffscreenPageLimit(3);
    }

    private void initFragment() {
        mMeFragment = new MeFragment();
        mFragmentList.add(mMeFragment);
        mFragmentList.add(mMeFragment);
        mFragmentList.add(mMeFragment);
        mFragmentList.add(mMeFragment);
    }

    @Override
    protected void initView() {
        mNavigationBar.setMode(BottomNavigationBar.MODE_FIXED);
        mNavigationBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_RIPPLE);

        mNavigationBar.addItem(new BottomNavigationItem(R.mipmap.home, "主页"))
                .addItem(new BottomNavigationItem(R.mipmap.find, "发现"))
                .addItem(new BottomNavigationItem(R.mipmap.message, "消息"))
                .addItem(new BottomNavigationItem(R.mipmap.personal, "个人"))
                .initialise();

        mNavigationBar.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position) {
                mViewPager.setCurrentItem(position);
            }

            @Override
            public void onTabUnselected(int position) {

            }

            @Override
            public void onTabReselected(int position) {

            }
        });
    }

    @Override
    protected void initEvent() {

    }
}

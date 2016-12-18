package com.brucecode.pureweibo.ui.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.brucecode.pureweibo.R;
import com.brucecode.pureweibo.adapter.MainAdapter;
import com.brucecode.pureweibo.base.BaseFragment;
import com.brucecode.pureweibo.ui.main.fragment.find.FindFragment;
import com.brucecode.pureweibo.ui.main.fragment.home.HomeFragment;
import com.brucecode.pureweibo.ui.main.fragment.me.MeFragment;
import com.brucecode.pureweibo.ui.main.fragment.msg.MsgFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bruce on 2016/11/27.
 */

public class MainAty extends AppCompatActivity {

    private MainAdapter mMainAdapter;
    private List<BaseFragment> mFragmentList = new ArrayList<>();

    private BottomNavigationBar mBottomNavigationBar;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_aty);

        mBottomNavigationBar = (BottomNavigationBar) findViewById(R.id.main_bottom_navigation_bar);
        mViewPager = (ViewPager) findViewById(R.id.main_view_pager);

        initData();
        initView();
        initEvent();
    }

    protected void initData() {
        HomeFragment homeFragment = HomeFragment.newInstance();
        FindFragment findFragment = FindFragment.newInstance(null, null);
        MsgFragment msgFragment = MsgFragment.newInstance(null, null);
        MeFragment meFragment = MeFragment.newInstance();

        mFragmentList.clear();
        mFragmentList.add(homeFragment);
        mFragmentList.add(findFragment);
        mFragmentList.add(msgFragment);
        mFragmentList.add(meFragment);
    }

    protected void initView() {
        mMainAdapter = new MainAdapter(getSupportFragmentManager(), mFragmentList);
        mViewPager.setAdapter(mMainAdapter);
        mViewPager.setOffscreenPageLimit(3);

        mBottomNavigationBar.setMode(BottomNavigationBar.MODE_FIXED);
        mBottomNavigationBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_RIPPLE);
        mBottomNavigationBar
                .addItem(new BottomNavigationItem(R.mipmap.home, "主页"))
                .addItem(new BottomNavigationItem(R.mipmap.find, "发现"))
                .addItem(new BottomNavigationItem(R.mipmap.message, "消息"))
                .addItem(new BottomNavigationItem(R.mipmap.personal, "个人"))
                .initialise();
    }

    protected void initEvent() {
        mBottomNavigationBar.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener() {
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
}

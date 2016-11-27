package com.brucecode.pureweibo.ui.login;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.brucecode.pureweibo.R;
import com.brucecode.pureweibo.base.BaseActivity;
import com.brucecode.pureweibo.databinding.SplashAtyBinding;

/**
 * Created by bruce on 2016/11/27.
 */

public class SplashAty extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SplashAtyBinding splashAtyBinding = DataBindingUtil.setContentView(this, R.layout.splash_aty);
    }


    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initEvent() {

    }
}

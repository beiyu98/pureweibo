package com.brucecode.pureweibo.ui.main;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.brucecode.pureweibo.R;
import com.brucecode.pureweibo.base.BaseActivity;
import com.brucecode.pureweibo.databinding.MainAtyBinding;

/**
 * Created by bruce on 2016/11/27.
 */

public class MainAty extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MainAtyBinding mainAtyBinding = DataBindingUtil.setContentView(this, R.layout.main_aty);
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

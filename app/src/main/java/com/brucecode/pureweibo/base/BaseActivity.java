package com.brucecode.pureweibo.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by bruce on 2016/11/27.
 */

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initData();
        initView();
        initEvent();
    }

    protected abstract void initData();

    protected abstract void initView();

    protected abstract void initEvent();
}

package com.brucecode.pureweibo.base;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by bruce on 2016/11/27.
 */

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);

        initData();
        initView();
        initEvent();
    }

    protected abstract void initData();

    protected abstract void initView();

    protected abstract void initEvent();
}

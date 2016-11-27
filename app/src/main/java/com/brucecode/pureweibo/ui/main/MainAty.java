package com.brucecode.pureweibo.ui.main;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.PersistableBundle;

import com.brucecode.pureweibo.R;
import com.brucecode.pureweibo.base.BaseActivity;
import com.brucecode.pureweibo.databinding.MainAtyBinding;

/**
 * Created by bruce on 2016/11/27.
 */

public class MainAty extends BaseActivity {

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);

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

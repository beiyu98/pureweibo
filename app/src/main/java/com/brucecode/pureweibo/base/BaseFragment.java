package com.brucecode.pureweibo.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

/**
 * Created by bruce on 2016/11/27.
 */

public abstract class BaseFragment extends Fragment {


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initData();
        initView();
        initEvent();
    }

    protected abstract void initData();

    protected abstract void initView();

    protected abstract void initEvent();

}

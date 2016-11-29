package com.brucecode.pureweibo.base;

import android.support.v4.app.Fragment;

/**
 * Created by bruce on 2016/11/27.
 */

public abstract class BaseFragment extends Fragment {

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (getUserVisibleHint()){
            initData();
            initView();
            initEvent();
        }
    }

    protected abstract void initData();

    protected abstract void initView();

    protected abstract void initEvent();

}

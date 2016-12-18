package com.brucecode.pureweibo.base;

import android.content.Context;
import android.support.v4.app.Fragment;

/**
 * Created by bruce on 2016/11/27.
 */

public abstract class BaseFragment extends Fragment {

    private static final String TAG = "BaseFragment";

    /**
     * 数据是否加载的标志
     * 防止重复请求数据
     */
    private boolean mIsLoadData=false;

    protected Context mContext;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext=context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mContext=null;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (getUserVisibleHint()&&!mIsLoadData){
            mIsLoadData=true;
            initData();
        }
    }

    protected abstract void initData();

}

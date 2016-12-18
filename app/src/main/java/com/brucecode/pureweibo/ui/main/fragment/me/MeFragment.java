package com.brucecode.pureweibo.ui.main.fragment.me;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.brucecode.pureweibo.R;
import com.brucecode.pureweibo.base.BaseFragment;
import com.brucecode.pureweibo.bean.User;
import com.brucecode.pureweibo.databinding.FragmentMeBinding;
import com.bumptech.glide.Glide;

/**
 * Created by bruce on 2016/11/29.
 */

public class MeFragment extends BaseFragment implements MeFragmentContract.View {

    private static final String TAG = "MeFragment";

    private User mUser;

    private FragmentMeBinding mFragmentMeBinding;

    private MeFragmentContract.Presenter mPresenter;

    private Context mContext;


    public MeFragment() {
    }

    public static MeFragment newInstance() {
        return new MeFragment();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mContext = null;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container
            , @Nullable Bundle savedInstanceState) {
        mFragmentMeBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_me, container, false);
        return mFragmentMeBinding.getRoot();
    }

    @Override
    protected void initData() {
        Log.e(TAG,"initData");
        mPresenter = new MeFragmentPresenter(this);
        mPresenter.loadData(mContext);
    }

    @Override
    public void showData(User user) {
        mUser = user;
        mFragmentMeBinding.setUser(mUser);
        Glide.with(mContext).load(mUser.getAvatar_large()).into(mFragmentMeBinding.meHead);
    }

    @Override
    public void showDataError() {

    }
}

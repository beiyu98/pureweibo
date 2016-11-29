package com.brucecode.pureweibo.ui.main.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.brucecode.pureweibo.R;
import com.brucecode.pureweibo.api.HttpManager;
import com.brucecode.pureweibo.api.service.UserService;
import com.brucecode.pureweibo.base.BaseFragment;
import com.brucecode.pureweibo.bean.User;
import com.brucecode.pureweibo.utils.TokenUtil;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by bruce on 2016/11/29.
 */

public class MeFragment extends BaseFragment {

    private String localUserUID;

    private String access_token;

    private User mUser;

    private com.brucecode.pureweibo.databinding.FragmentMeBinding mDataBinding;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container
            , @Nullable Bundle savedInstanceState) {

        mDataBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_me,container,false);
        mDataBinding.setUser(mUser);
        return mDataBinding.getRoot();
    }

    private void getLocalUserUID() {
        Oauth2AccessToken token = TokenUtil.readToken(getActivity());
        access_token = token.getToken();
        localUserUID = token.getUid();
    }

    @Override
    protected void initData() {
        getLocalUserUID();

        HttpManager.getInstance().createService(UserService.class)
                .getUserInfo(access_token,localUserUID)
                .enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                mUser=response.body();
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initEvent() {

    }
}

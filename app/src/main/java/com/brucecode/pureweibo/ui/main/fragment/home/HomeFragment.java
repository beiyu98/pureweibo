package com.brucecode.pureweibo.ui.main.fragment.home;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.brucecode.pureweibo.R;
import com.brucecode.pureweibo.adapter.WeiboListAdapter;
import com.brucecode.pureweibo.api.HttpManager;
import com.brucecode.pureweibo.api.service.WeiboService;
import com.brucecode.pureweibo.base.BaseFragment;
import com.brucecode.pureweibo.bean.weibo.Statuse;
import com.brucecode.pureweibo.bean.weibo.WeiBo;
import com.brucecode.pureweibo.databinding.FragmentHomeBinding;
import com.brucecode.pureweibo.utils.TokenUtil;
import com.brucecode.pureweibo.widget.SpaceItemDecoration;
import com.orhanobut.logger.Logger;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class HomeFragment extends BaseFragment {

    private static final String TAG = "HomeFragment";

    private FragmentHomeBinding mHomeBinding;
    private WeiboListAdapter mWeiboListAdapter;
    private List<Statuse> mStatuseList = new ArrayList<>();

    public HomeFragment() {
    }

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mHomeBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false);
        return mHomeBinding.getRoot();
    }

    @Override
    protected void initData() {
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        HttpManager.getInstance().createService(HttpManager.BASE_URL, WeiboService.class)
//                .getFriendTimeLine(token)
//                .enqueue(new Callback<String>() {
//                    @Override
//                    public void onResponse(Call<String> call, Response<String> response) {
//                        Log.e(TAG,response.body());
//                    }
//
//                    @Override
//                    public void onFailure(Call<String> call, Throwable t) {
//                        t.printStackTrace();
//                    }
//                });

        mWeiboListAdapter=new WeiboListAdapter(mContext,mStatuseList);

        mHomeBinding.homeRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        mHomeBinding.homeRecyclerView.addItemDecoration(new SpaceItemDecoration(10));
        mHomeBinding.homeRecyclerView.setHasFixedSize(true);
        mHomeBinding.homeRecyclerView.setAdapter(mWeiboListAdapter);

        mHomeBinding.homeSwipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                loadData();
            }
        });
    }


    public void loadData(){
        Oauth2AccessToken oauth2AccessToken = TokenUtil.readToken(mContext);
        String token = oauth2AccessToken.getToken();
        Retrofit retrofit=new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(HttpManager.BASE_URL)
                .build();
        retrofit.create(WeiboService.class)
                .getFriendTimeLine(token,50)
                .enqueue(new Callback<WeiBo>() {
                    @Override
                    public void onResponse(Call<WeiBo> call, Response<WeiBo> response) {
                        WeiBo weiBo=response.body();
                        mStatuseList.clear();
                        mStatuseList.addAll(weiBo.getStatuses());

                        mWeiboListAdapter.notifyDataSetChanged();


                        Logger.d("微博的个数："+mStatuseList.size());
                        mHomeBinding.homeSwipeRefresh.setRefreshing(false);


                    }

                    @Override
                    public void onFailure(Call<WeiBo> call, Throwable t) {
                        t.printStackTrace();
                        mHomeBinding.homeSwipeRefresh.setRefreshing(false);
                    }
                });
    }
}

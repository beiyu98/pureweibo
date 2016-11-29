package com.brucecode.pureweibo.api;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by bruce on 2016/11/29.
 */

public class HttpManager {

    private static final String BASE_URL = "https://api.douban.com/v2/movie/";
    private volatile static HttpManager mInstance;
    private static Retrofit mRetrofit;

    private HttpManager() {
        mRetrofit = new Retrofit.Builder()
                .baseUrl(HttpManager.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

    public static HttpManager getInstance() {
        if (mInstance == null) {
            synchronized (HttpManager.class) {
                mInstance = new HttpManager();
            }
        }
        return mInstance;
    }

    public <T> T createService(Class<T> apiService){
        return mRetrofit.create(apiService);
    }
}

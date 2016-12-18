package com.brucecode.pureweibo.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by bruce on 2016/11/29.
 */

public class HttpManager {
    public static final String BASE_URL = "https://api.weibo.com/";
    private volatile static HttpManager mInstance;
    private static Retrofit mRetrofit;

    private HttpManager() {
    }


    public static HttpManager getInstance() {
        if (mInstance == null) {
            synchronized (HttpManager.class) {
                mInstance = new HttpManager();
            }
        }
        return mInstance;
    }

    public <T> T createService(String baseUrl, Class<T> serviceClazz) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(serviceClazz);
    }
}

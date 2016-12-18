package com.brucecode.pureweibo.api.service;

import com.brucecode.pureweibo.bean.User;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by bruce on 2016/11/29.
 */

public interface UserService {

    @GET("/2/users/show.json")
    Call<User> getUserInfo(@Query("access_token") String access_token,@Query("uid") long uid);
}

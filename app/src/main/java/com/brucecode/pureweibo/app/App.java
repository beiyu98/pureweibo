package com.brucecode.pureweibo.app;

import android.app.Application;
import android.util.Log;

import com.brucecode.pureweibo.utils.TokenUtil;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;

/**
 * Created by bruce on 2016/11/27.
 */

public class App extends Application {

    private static final String TAG = "App";

    private static App mBaseApp;

    public static App getAppContext() {
        return mBaseApp;
    }

    private static Oauth2AccessToken mOauthToken;

    public static Oauth2AccessToken getOauthToken() {
        return mOauthToken;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mBaseApp = this;
        mOauthToken = TokenUtil.readToken(this);
        Log.e(TAG,mOauthToken.getToken().toString());
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }
}

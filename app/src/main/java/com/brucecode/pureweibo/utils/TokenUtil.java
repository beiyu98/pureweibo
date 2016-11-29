package com.brucecode.pureweibo.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.sina.weibo.sdk.auth.Oauth2AccessToken;

/**
 * Created by bruce on 2016/11/29.
 */

public class TokenUtil {
    private static final String PREFERENCES_NAME = "com_weibo_sdk_android";

    private static final String KEY_UID           = "uid";
    private static final String KEY_ACCESS_TOKEN  = "access_token";
    private static final String KEY_EXPIRES_IN    = "expires_in";
    private static final String KEY_REFRESH_TOKEN    = "refresh_token";

    /**
     * 保存token到SharedPreferences
     * @param context
     * @param token
     */
    public static void saveToken(Context context, Oauth2AccessToken token){
        if (null == context || null == token){
            return;
        }

        SharedPreferences sps = context.getSharedPreferences(PREFERENCES_NAME,context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sps.edit();
        editor.putString(KEY_UID,token.getUid());
        editor.putString(KEY_ACCESS_TOKEN,token.getToken());
        editor.putString(KEY_REFRESH_TOKEN,token.getRefreshToken());
        editor.putLong(KEY_EXPIRES_IN,token.getExpiresTime());
        editor.commit();
    }

    /**
     * 从SharedPreferences读取token
     * @param context
     * @return
     */
    public static Oauth2AccessToken readToken(Context context){
        if (null==context){
            return null;
        }

        Oauth2AccessToken token = new Oauth2AccessToken();
        SharedPreferences sps = context.getSharedPreferences(PREFERENCES_NAME,context.MODE_PRIVATE);
        token.setUid(sps.getString(KEY_UID, ""));
        token.setToken(sps.getString(KEY_ACCESS_TOKEN, ""));
        token.setRefreshToken(sps.getString(KEY_REFRESH_TOKEN, ""));
        token.setExpiresTime(sps.getLong(KEY_EXPIRES_IN, 0));

        return token;

    }

    /**
     * 清除token信息
     * @param context
     */
    public static void clearToken(Context context){
        if (null == context){
            return;
        }

        SharedPreferences pref = context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_APPEND);
        SharedPreferences.Editor editor = pref.edit();
        editor.clear();
        editor.commit();
    }
}

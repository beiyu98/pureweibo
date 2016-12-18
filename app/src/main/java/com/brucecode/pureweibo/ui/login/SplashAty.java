package com.brucecode.pureweibo.ui.login;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import com.brucecode.pureweibo.R;
import com.brucecode.pureweibo.app.Constant;
import com.brucecode.pureweibo.base.BaseActivity;
import com.brucecode.pureweibo.databinding.SplashAtyBinding;
import com.brucecode.pureweibo.ui.main.MainAty;
import com.brucecode.pureweibo.utils.TokenUtil;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.auth.WeiboAuthListener;
import com.sina.weibo.sdk.auth.sso.SsoHandler;
import com.sina.weibo.sdk.exception.WeiboException;

/**
 * Created by bruce on 2016/11/27.
 */

public class SplashAty extends BaseActivity {

    private static final String TAG = "SplashAty";

    private AuthInfo mAuthInfo;
    private Oauth2AccessToken mAccessToken;
    private SsoHandler mSsoHandler;

    private SplashAtyBinding mSplashAtyBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mSplashAtyBinding= DataBindingUtil.setContentView(this, R.layout.splash_aty);

        initData();
        initView();
        initEvent();
    }


    protected void initData() {
       checkUserState();
    }


    protected void initView() {

    }

    protected void initEvent() {

    }

    /**
     * 检查用户状态
     */
    private void checkUserState() {
        String access_token = TokenUtil.readToken(this).getToken();
        Log.e(TAG,"access_token:"+access_token);
        if (TextUtils.isEmpty(access_token)) {
           login();
        } else {
            startActivity(new Intent(this, MainAty.class));
            finish();
        }
    }

    private void login() {
        mAuthInfo = new AuthInfo(this, Constant.weiboAppKey, Constant.redirect_uri,Constant.SCOPE);
        mSsoHandler = new SsoHandler(this,mAuthInfo);
        mSsoHandler.authorizeWeb(new AuthListener());
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (mSsoHandler != null) {
            mSsoHandler.authorizeCallBack(requestCode, resultCode, data);
        }
    }

    class AuthListener implements WeiboAuthListener {

        @Override
        public void onComplete(Bundle values) {
            // 从 Bundle 中解析 Token
            mAccessToken = Oauth2AccessToken.parseAccessToken(values);

            if (mAccessToken.isSessionValid()) {
                TokenUtil.saveToken(getApplicationContext(),mAccessToken);
                startActivity(new Intent(SplashAty.this,MainAty.class));
                finish();
            } else {
                String code = values.getString("code");
                Toast.makeText(getApplicationContext(), "wrong:"+code, Toast.LENGTH_LONG).show();
            }
        }

        @Override
        public void onCancel() {
            Toast.makeText(getApplicationContext(),"取消了授权！", Toast.LENGTH_LONG).show();
        }

        @Override
        public void onWeiboException(WeiboException e) {
            Toast.makeText(getApplicationContext(),
                    "Auth exception : " + e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
}

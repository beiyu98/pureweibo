package com.brucecode.pureweibo.app;

/**
 * Created by bruce on 2016/11/29.
 */

public class Constant {

    public static final String weiboAppKey = "1321402940";

    public static final String getWeiboAppSecret = "caa8ff19a5d3ede5f97156e61a66b56b";

    public static final String baseUrl = "https://api.weibo.com/";

    public static final String redirect_uri = "https://api.weibo.com/oauth2/default.html";

    public static final String SCOPE =
            "email,direct_messages_read,direct_messages_write,"
                    + "friendships_groups_read,friendships_groups_write,statuses_to_me_read,"
                    + "follow_app_official_microblog," + "invitation_write";
}

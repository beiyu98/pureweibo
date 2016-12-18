package com.brucecode.pureweibo.utils;

import android.app.Activity;
import android.util.DisplayMetrics;

/**
 * Created by bruce on 2016/12/18.
 */

public class ScreenUtil {
    public static DisplayMetrics getScreenSize(Activity activity){
        DisplayMetrics outMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(outMetrics);
        return outMetrics;
    }
}

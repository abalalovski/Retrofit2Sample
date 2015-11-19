package com.twodwarfs.retrofitoo.utils;

import android.text.TextUtils;
import android.util.Log;

import com.twodwarfs.retrofitoo.BuildConfig;
import com.twodwarfs.retrofitoo.cons.Constants;

/**
 * Created by Aleksandar Balalovski
 * <abalalovski@gmail.com>
 */

public class Logger {

    public static void doLog(Object text) {
        if (BuildConfig.DEBUG && text != null && !TextUtils.isEmpty(text.toString())) {
            Log.i(Constants.TAG, text.toString());
        }
    }

    public static void doLogException(Throwable t) {
        if (BuildConfig.DEBUG && t != null) {
            Log.e(Constants.TAG, "Exception", t);
        }
    }
}

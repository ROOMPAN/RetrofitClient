package com.joaye.hixgo.utils;

import android.util.Log;

import com.joaye.hixgo.BuildConfig;

/**
 * Created by xuyanjun on 15/10/23.
 */
public class L {

    private static String getClassName() {
        String result;
        StackTraceElement thisMethodStack = (new Exception()).getStackTrace()[2];
        result = thisMethodStack.getClassName();
        int lastIndex = result.lastIndexOf(".");
        result = result.substring(lastIndex + 1, result.length());
        return result;
    }

    private static String getInvokeMethodName() {
        StackTraceElement thisMethodStack = (new Exception()).getStackTrace()[2];
        return thisMethodStack.getMethodName();
    }

    public static void d(String msg) {
        if (BuildConfig.DEBUG) {
            Log.d(getClassName(), msg);
        }
    }

    public static void printInVokeMethodName() {
        if (BuildConfig.DEBUG) {
            Log.d(getClassName(), getInvokeMethodName());
        }
    }

}

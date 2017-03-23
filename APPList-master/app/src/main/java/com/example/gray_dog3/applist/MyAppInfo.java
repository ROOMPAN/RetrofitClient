package com.example.gray_dog3.applist;

import android.graphics.drawable.Drawable;

/**
 * Created by gray_dog3 on 16/3/3.
 */
public class MyAppInfo {
    private Drawable image;
    private String packageName;
    private String AppName;

    public MyAppInfo(Drawable image, String appName) {
        this.image = image;
        this.packageName = appName;
    }

    public MyAppInfo() {

    }

    public Drawable getImage() {
        return image;
    }

    public void setImage(Drawable image) {
        this.image = image;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String appName) {
        this.packageName = appName;
    }


//    @Override
//    public String toString() {
//        return "MyAppInfo{" +
//                "image=" + image +
//                ", appName='" + appName + '\'' +

    public String getAppName() {
        return AppName;
    }

    public void setAppName(String appName) {
        AppName = appName;
    }
//                '}';
//    }
}

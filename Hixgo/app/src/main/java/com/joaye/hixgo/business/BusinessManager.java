package com.joaye.hixgo.business;

import com.joaye.hixgo.models.Config;
import com.joaye.hixgo.utils.SharedPreferencesUtils;

/**
 * Created by xuyanjun on 15/11/8.
 */
public class BusinessManager {

    private static BusinessManager mInstance;

    private Config mConfig;

    private String userToken;

    private BusinessManager() {
        restoreData();
    }

    public Config getConfig() {
        return mConfig;
    }

    public void setUserToken(String userToken) {
        this.userToken = userToken;
    }

    public String getUserToken() {
        return userToken;
    }

    private void restoreData() {
        if (SharedPreferencesUtils.constainsKey("config")) {
            mConfig = (Config) SharedPreferencesUtils.getObjectValue("config");
        }
        userToken = SharedPreferencesUtils.getData("token", "", String.class);
    }

    public synchronized static BusinessManager getInstance() {
        if (mInstance == null) {
            mInstance = new BusinessManager();
        }
        return mInstance;
    }

}

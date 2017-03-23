package com.joaye.hixgo;

import android.app.Application;
import android.content.Context;
import android.widget.Toast;
import com.joaye.hixgo.models.Config;
import com.joaye.hixgo.network.HttpClient;
import com.joaye.hixgo.network.NetworkSubscriber;
import com.joaye.hixgo.utils.SharedPreferencesUtils;

/**
 * Created by xuyanjun on 15/10/20.
 */
public class MyApplication extends Application {

    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
        getConfig();
    }

    private void getConfig() {
        HttpClient.getInstance().getConfig(new NetworkSubscriber<Config>() {
            @Override
            public void onNext(Config config) {
                super.onNext(config);
                if (config.isOKCode()) {
                    SharedPreferencesUtils.setObjectData("config", config);
                    if (!SharedPreferencesUtils.constainsKey("token")) {
                        SharedPreferencesUtils.setData("token", config.data.userToken);
                    }
                    Toast.makeText(MyApplication.this, config.data.appUrl, Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    public static Context getContext() {
        return mContext;
    }

}

package com.joaye.hixgo;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Nullable
    private User getStr(@NonNull User user) {
        System.out.println(user.name);
        return null;
    }

    class User {
        public String name;
    }

}

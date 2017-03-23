package com.joaye.hixgo.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.joaye.hixgo.R;

/**
 * Created by xuyanjun on 15/10/25.
 */
public class LoginActivity extends BaseSwipeBackActivity {
    private EditText mEdit_phone;
    private EditText mEdit_pwd;
    private Button mBtn_login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    @Override
    public void bindListener() {
        mBtn_right.setOnClickListener(v -> startActivity(new Intent(LoginActivity.this, RegisterActivity.class)));
        //TODO 外包那边没有写RegisterActivity。
        mBtn_login.setOnClickListener(v -> {
            String phone = mEdit_phone.getText().toString();
            String pwd = mEdit_pwd.getText().toString();

        });
    }

    @Override
    public void findViews() {
        mEdit_phone = (EditText) findViewById(R.id.login_edit_phone);
        mEdit_pwd = (EditText) findViewById(R.id.login_edit_pwd);
        mBtn_login = (Button) findViewById(R.id.login_btn);
    }
}

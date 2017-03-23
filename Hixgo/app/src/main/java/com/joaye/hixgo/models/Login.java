package com.joaye.hixgo.models;

/**
 * Created by xuyanjun on 15/10/24.
 */
public class Login extends BaseObjectEntity<Login.LoginData> {

    public class LoginData {
        public String authCode;
    }

}

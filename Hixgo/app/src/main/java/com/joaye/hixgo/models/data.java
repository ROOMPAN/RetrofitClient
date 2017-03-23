package com.joaye.hixgo.models;

import java.util.List;

/**
 * Created by andy on 2017/1/11.
 */

public class data {

    /**
     * code : 200
     * msg : 登陆成功
     * data : [[{"nickname":"","sex":"1","account_num":null,"profile":"这家伙很懒，什么也没留下","phone":"18949568164"}]]
     */

    private int code;
    private String msg;
    private List<List<DataBean>> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<List<DataBean>> getData() {
        return data;
    }

    public void setData(List<List<DataBean>> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * nickname :
         * sex : 1
         * account_num : null
         * profile : 这家伙很懒，什么也没留下
         * phone : 18949568164
         */

        private String nickname;
        private String sex;
        private Object account_num;
        private String profile;
        private String phone;

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public Object getAccount_num() {
            return account_num;
        }

        public void setAccount_num(Object account_num) {
            this.account_num = account_num;
        }

        public String getProfile() {
            return profile;
        }

        public void setProfile(String profile) {
            this.profile = profile;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }
    }
}

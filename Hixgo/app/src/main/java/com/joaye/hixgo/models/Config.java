package com.joaye.hixgo.models;

import java.io.Serializable;
import java.util.ArrayList;

public class Config extends BaseObjectEntity<Config.ConfigData> implements Serializable {

    public class ConfigData {
        public String apiVersion;              //api接口版本号
        public String updateUrl;                //app更新地址
        public String isMustUpdate;             //是否强制更新(1是 2否)
        public String updateContent;            //更新内容说明
        public String csPhone;                  //客服400电话
        public String indexUrl;                 //首页h5地址
        public String indexAd;                  //首页弹屏广告(预留)
        public String statementUrl;             //免责声明url
        public String searchWords;              //默认搜索关键字
        public String cartCount;                //购物车数量
//      public String orderExpire;            //订单未付款过期时间(分钟)
        public String appUrl;                   //appstore的地址
        public String userToken;                //用户token
//      public ArrayList<PayType> payType;
        public ArrayList<KeyWord> keyWords;     //热门搜索关键字
        public boolean isNeedUpdate;            //是否需要更新(1是 2否)
    }


    public class KeyWord {
        public String keywords;
    }

    public class ModuleUrl {
        public String knowledgeUrl;             //涨健识首页地址
        public String hxgTextUrl;               //享测试首页地址
    }

//    public class PayType {
//      public String key;
//      public String value;
//    }

}
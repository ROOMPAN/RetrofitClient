package com.joaye.hixgo.models;

import java.util.ArrayList;

/**
 * Created by xuyanjun on 15/10/24.
 * 用于data为Array类型的接口
 * 如：
 * {
 * "code": 1,
 * "data": [
 * {
 * "apiVersion": "1",
 * "updateUrl": "http://api.hixgo.com/updateUrl",
 * "isMustUpdate": "1",
 * "updateContent": "优化了客户体验,增加了首页订阅抢购功能",
 * "csPhone": "400123516985",
 * "indexUrl": "http://h5.hixgo.com/index",
 * "indexAd": "http://h5.hixgo.com/advert",
 * "statementUrl": "http://h5.hixgo.com/statement",
 * "searchWords": "美容养颜",
 * "cartCount": "12",
 * "orderExpire":"30",
 * "appStoreUrl": "http://appstore.apple.com/id/10655533",
 * "userToken": "1121454SDFDSFDFD555",
 * "payType": [
 * {
 * "key": "1",
 * "value": "支付宝"
 * },
 * {
 * "key": "2",
 * "value": "微信"
 * }
 * ],
 * "keyWords": [
 * {
 * "keywords": "美容养颜"
 * },
 * {
 * "keywords": "降血压"
 * },
 * {
 * "keywords": "降血脂"
 * }
 * ]
 * }
 * ],
 * "msg": ""
 * }
 */
public class BaseArrayObjectEntity<T> extends BaseEntity {

    public ArrayList<T> data;


}

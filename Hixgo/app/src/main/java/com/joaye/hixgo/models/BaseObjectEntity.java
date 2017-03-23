package com.joaye.hixgo.models;

/**
 * Created by xuyanjun on 15/10/24.
 * 用于data字段为Object的实体类
 * 如：
 * {
 * "code": 1,
 * "data": {"authCode":"x71288sj28sy2ns72jn28"},
 * "msg": ""
 * }
 */
public class BaseObjectEntity<T> extends BaseEntity {

    public T data;

}

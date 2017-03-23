package com.joaye.hixgo.network;

import com.joaye.hixgo.models.AliBean;
import com.joaye.hixgo.models.BaiduBean;
import com.joaye.hixgo.models.BaseMessageEntity;
import com.joaye.hixgo.models.Config;
import com.joaye.hixgo.models.Register;
import com.joaye.hixgo.models.VirtualList;
import com.joaye.hixgo.models.newsBean;

import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Query;
import rx.Observable;

/**
 * 接口定义api
 */

public interface ApiManagerService {

    @GET("common/init")
    Observable<Config> getConfig();

    /**
     * @param mobile
     * @param type   验证码类型(1注册2找回密码3绑定手机号)
     * @return
     */
    @GET("/common/get_code")
    Observable<BaseMessageEntity> getCode(@Query("mobile") String mobile, @Query("type") int type);

    @FormUrlEncoded
    @POST("user/register")
    Observable<Register> register(@Field("mobile") String mobile, @Field("smsCode") String smsCode,
                                  @Field("pwd") String pwd, @Field("os") String os);

    @POST("/category/virtual/list")
    Observable<VirtualList> getVirtualList();

    @FormUrlEncoded
    @POST("news/query")
    Observable<newsBean> getNewData(@Field("q") String q);
   // scope=103&format=json&appid=379020&bk_key=%E5%85%B3%E9%94%AE%E5%AD%97&bk_length=600
   @GET("BaikeLemmaCardApi")
    Observable<BaiduBean>getBaiduData(@Query("scope") String scope,@Query("format") String format,
                                      @Query("appid") String appid,@Query("bk_key") String bk_key,
                                      @Query("bk_length") String bk_length);
    @GET("defaultdials-0.json")
    Observable<AliBean> getList();
}

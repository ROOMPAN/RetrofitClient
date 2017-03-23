package com.joaye.hixgo.network;

import android.text.TextUtils;

import com.joaye.hixgo.BuildConfig;
import com.joaye.hixgo.business.BusinessManager;
import com.joaye.hixgo.models.AliBean;
import com.joaye.hixgo.models.BaseMessageEntity;
import com.joaye.hixgo.models.Config;
import com.joaye.hixgo.models.Register;
import com.joaye.hixgo.models.VirtualList;
import com.joaye.hixgo.models.newsBean;
import com.joaye.hixgo.utils.MobileUtils;
import com.joaye.hixgo.utils.StringUtils;
import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import okio.Buffer;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

//import com.joaye.hixgo.utils.MobileUtils;

/**
 * Created by xuyanjun on 15/10/20.
 */
public class HttpClient {
    private static final String DOMAIN = "http://offlintab.firefoxchina.cn/data/master-ii/";
    private static final String SECRET_KEY = "b4dfc37346bb903f466ff7c7b07b7c58";
    private Retrofit mRetrofit;
    private ApiManagerService mApi;
    private static HttpClient sInstance;

    public synchronized static HttpClient getInstance() {
        if (sInstance == null) {
            sInstance = new HttpClient();
        }
        return sInstance;
    }

    private HttpClient() {
        OkHttpClient client = new OkHttpClient();
        client.interceptors().add(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                Request signRequest = signRequest(addCommonParamter(request));
                long t1 = System.nanoTime();
                System.out.println(String.format("Sending request %s on %s%n%s",
                        request.url(), chain.connection(), request.headers()));
                Response response = chain.proceed(signRequest == null ? request : signRequest);
                long t2 = System.nanoTime();
                System.out.println(String.format("Received response for %s in %.1fms%n%s",
                        response.request().url(), (t2 - t1) / 1e6d, response.headers()));
                return response;
            }
        });
        //设置超时
        client.setConnectTimeout(15, TimeUnit.SECONDS);
        client.setReadTimeout(15, TimeUnit.SECONDS);
        client.setWriteTimeout(15, TimeUnit.SECONDS);
        //错误重连
        client.setRetryOnConnectionFailure(true);
        mRetrofit = new Retrofit.Builder()
                .baseUrl(DOMAIN)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(new RxThreadCallAdapater(Schedulers.io(), AndroidSchedulers.mainThread()))
                .client(client)
                .build();
        mApi = mRetrofit.create(ApiManagerService.class);
    }

    public void getConfig(NetworkSubscriber subscriber) {
        Observable<Config> observable = mApi.getConfig();
        observable.subscribe(subscriber);
    }

    public void getCode(String mobile, int type, NetworkSubscriber subscriber) {
        Observable<BaseMessageEntity> observable = mApi.getCode(mobile, type);
        observable.subscribe(subscriber);
    }

    public void getVirtualList(NetworkSubscriber subscriber) {
        Observable<VirtualList> observable = mApi.getVirtualList();
        observable.subscribe(subscriber);
    }

    public void register(String mobile, String smsCode, String pwd, NetworkSubscriber subscriber) {
        Observable<Register> observable = mApi.register(mobile, smsCode, pwd, "1");
        observable.subscribe(subscriber);
    }

    public void getNewData(String q, NetworkSubscriber subscriber) {
        Observable<newsBean> observable = mApi.getNewData(q);
        observable.subscribe(subscriber);
    }

    // scope=103&format=json&appid=379020&bk_key=%E5%85%B3%E9%94%AE%E5%AD%97&bk_length=600
//    public void getBaiduData(String scope, String format, String appid, String bk_key, String bk_length, NetworkSubscriber subscriber) {
//        Observable<BaiduBean> observable = mApi.getBaiduData(scope, format, appid, bk_key, bk_length);
//        observable.subscribe(subscriber);
//    }

    public void getList(NetworkSubscriber subscriber) {
        Observable<AliBean> observable = mApi.getList();
        observable.subscribe(subscriber);

    }

    /**
     * Request参数签名
     *
     * @param request
     * @return
     */
    private static Request signRequest(Request request) throws IOException {
        Request signRequest = null;
        String needSignStr;
        // 参数签名
        if (request.method().equalsIgnoreCase("GET")) {
            String queryStr = request.uri().getQuery();
            if (!TextUtils.isEmpty(queryStr)) {
                String[] queryArray = queryStr.split("&");
                Arrays.sort(queryArray);
                StringBuilder builder = new StringBuilder();
                for (int i = 0; i < queryArray.length; i++) {
                    builder.append(queryArray[i] + (i == queryArray.length - 1 ? "" : "&"));
                }
                needSignStr = builder.toString() + SECRET_KEY;
            } else {
                needSignStr = SECRET_KEY;
            }
            String sign = StringUtils.MD5(needSignStr);

            signRequest = request.newBuilder().url(request.httpUrl()
                    .newBuilder()
                    //在请求头 添加签名参数
                    //.addQueryParameter("sign", sign)
                    .build())
                    .build();
        } else if (request.method().equalsIgnoreCase("POST")) {
            Buffer buffer = new Buffer();
            request.newBuilder().build().body().writeTo(buffer);
            String queryStr = buffer.readUtf8();
            if (!TextUtils.isEmpty(queryStr)) {
                String[] queryArray = queryStr.split("&");
                Arrays.sort(queryArray);
                StringBuilder builder = new StringBuilder();
                for (int i = 0; i < queryArray.length; i++) {
                    builder.append(queryArray[i] + (i == queryArray.length - 1 ? "" : "&"));
                }
                needSignStr = builder.toString() + SECRET_KEY;
            } else {
                needSignStr = SECRET_KEY;
            }
            String sign = StringUtils.MD5(needSignStr);
            signRequest = request.newBuilder().post(RequestBody.create(request.body().contentType(), queryStr + "&sign=" + sign)).build();
        }
        return signRequest;
    }

    private static Request addCommonParamter(Request request) throws IOException {
        String method = request.method();
        String userToken = BusinessManager.getInstance().getUserToken();
        String deviceId = MobileUtils.getIMEI();
        String os = "1";
        String pushToken = "";
        int versionCode = BuildConfig.VERSION_CODE;
        String versionName = BuildConfig.VERSION_NAME;
        Request commonRequest = null;
        if (method.equalsIgnoreCase("GET")) {
            commonRequest =
                    request.newBuilder().url(
                            request.httpUrl().newBuilder()
                                    //链接中添加固定的请求参数
//                                    .addQueryParameter("userToken", userToken)
//                                    .addQueryParameter("os", os)
//                                    .addQueryParameter("deviceId", deviceId)
//                                    .addQueryParameter("pushToken", pushToken)
                                    .build())
                            .build();
        } else if (method.equalsIgnoreCase("POST")) {
            MediaType contentType = request.body().contentType();
            if (contentType != null && contentType.toString().contains("multipart")) {
                return request;
            } else {
                Buffer buffer = new Buffer();
                request.newBuilder().build().body().writeTo(buffer);
                String queryStr = buffer.readUtf8();
//            queryStr += "&userToken=" + userToken + "&os=" + os + "&pushToken=" + pushToken;
//            commonRequest = request.newBuilder().post(RequestBody.create(request.body().contentType(), queryStr)).build();
                queryStr += (TextUtils.isEmpty(queryStr) ? "" : "&") + "userToken=" + userToken + "&os=" + os + "&deviceId=" + deviceId
                        + "&pushToken=" + pushToken + "&versionCode=" + versionCode + "&versionName=" + versionName;
                commonRequest = request.newBuilder()
                        .url(request.httpUrl().newBuilder()
//                                .addQueryParameter("os", os)
//                                .addQueryParameter("versionCode", versionCode + "")
//                                .addQueryParameter("versionName", versionName)
                                .build())
                        .post(RequestBody.create(contentType, queryStr)).build();
            }
        }
        return commonRequest;
    }

}

package com.github.xiaohu409.wanandroid.mvc.util;

import com.github.xiaohu409.wanandroid.BuildConfig;
import com.github.xiaohu409.wanandroid.mvc.api.ServiceApi;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * retrofit单例
 */
public class RetrofitUtil {

    private static final int timeout = 100;
    private Retrofit retrofit;
    private static RetrofitUtil retrofitUtil;
    private Map<HttpUrl, List<Cookie>> cookieMap;

    private RetrofitUtil() {
        cookieMap = new HashMap<>();
        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .connectTimeout(timeout, TimeUnit.SECONDS)
                .readTimeout(timeout, TimeUnit.SECONDS)
                .writeTimeout(timeout, TimeUnit.SECONDS)
                .cookieJar(new CookieJar() {
                    @Override
                    public void saveFromResponse(@NotNull HttpUrl httpUrl, @NotNull List<Cookie> list) {
                        cookieMap.put(httpUrl, list);
                    }

                    @NotNull
                    @Override
                    public List<Cookie> loadForRequest(@NotNull HttpUrl httpUrl) {
                        List<Cookie> cookies = cookieMap.get(httpUrl);
                        if (cookies == null) {
                            cookies = new ArrayList<>();
                        }
                        return cookies;
                    }
                });

        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);
            builder.addInterceptor(logging);
        }
        retrofit = new Retrofit.Builder()
                .client(builder.build())
                .baseUrl(ServiceApi.IP)
                .addConverterFactory(GsonConverterFactory.create())
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();
    }

    public static RetrofitUtil newInstance() {
        if (retrofitUtil == null) {
            synchronized (RetrofitUtil.class) {
                if (retrofitUtil == null) {
                    retrofitUtil = new RetrofitUtil();
                }
            }
        }
        return retrofitUtil;
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }

    public Map<HttpUrl, List<Cookie>> getCookieMap() {
        return cookieMap;
    }

}

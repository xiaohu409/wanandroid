package com.github.xiaohu409.wanandroid.mvc.api;

import com.github.xiaohu409.wanandroid.mvc.model.bean.BannerBean;
import com.github.xiaohu409.wanandroid.mvc.model.bean.IndexBean;
import com.github.xiaohu409.wanandroid.mvc.model.bean.LoginBean;
import com.github.xiaohu409.wanandroid.mvc.model.bean.LogoutBean;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * 接口
 */
public interface ServiceApi {

    /**
     * IP
     */
    String IP = "https://www.wanandroid.com";

    /**
     * banner
     */
    String banner = "/banner/json";
    @GET(banner)
    Call<BannerBean> getBanner();

    /**
     * index
     */
    String index = "/article/list/{page}/json";
    @GET(index)
    Call<IndexBean> getIndex(@Path("page") int page);


    /**
     * login
     */
    String login = "/user/login";
    @POST(login)
    @FormUrlEncoded
    Call<LoginBean> login(@FieldMap Map<String, Object> param);

    /**
     * logout
     */
    String logout = "/user/logout/json";
    @GET(logout)
    Call<LogoutBean> logout();
}

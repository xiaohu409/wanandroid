package com.github.xiaohu409.wanandroid.mvc.api;

import com.github.xiaohu409.wanandroid.mvc.model.bean.BannerBean;

import retrofit2.Call;
import retrofit2.http.GET;

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

}

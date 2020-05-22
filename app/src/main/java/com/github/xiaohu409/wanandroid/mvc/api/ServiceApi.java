package com.github.xiaohu409.wanandroid.mvc.api;

import com.github.xiaohu409.wanandroid.mvc.model.bean.BannerBean;
import com.github.xiaohu409.wanandroid.mvc.model.bean.IndexBean;

import retrofit2.Call;
import retrofit2.http.GET;
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

}

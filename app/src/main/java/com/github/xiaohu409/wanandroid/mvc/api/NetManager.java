package com.github.xiaohu409.wanandroid.mvc.api;

import com.github.xiaohu409.wanandroid.mvc.util.RetrofitUtil;

import retrofit2.Retrofit;

/**
 * 网络请求
 */
public class NetManager {

    private static NetManager manager;
    private ServiceApi serviceApi;

    private NetManager() {
        Retrofit retrofit = RetrofitUtil.newInstance().getRetrofit();
        serviceApi = retrofit.create(ServiceApi.class);
    }

    public static NetManager newInstance() {
        if (manager == null) {
            synchronized (NetManager.class) {
                if (manager == null) {
                    manager = new NetManager();
                }
            }
        }
        return manager;
    }

    public ServiceApi getServiceApi() {
        return serviceApi;
    }
}

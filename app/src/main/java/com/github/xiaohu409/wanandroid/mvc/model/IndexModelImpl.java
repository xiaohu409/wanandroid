package com.github.xiaohu409.wanandroid.mvc.model;

import com.github.xiaohu409.wanandroid.mvc.api.NetManager;
import com.github.xiaohu409.wanandroid.mvc.api.ServiceApi;
import com.github.xiaohu409.wanandroid.mvc.model.bean.BannerBean;
import com.github.xiaohu409.wanandroid.mvc.model.bean.IndexBean;
import com.github.xiaohu409.wanandroid.mvc.view.BannerView;
import com.github.xiaohu409.wanandroid.mvc.view.IndexView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * 项目名称：
 * 文件名称：BannerModelImpl
 * 文件描述：Bannermodel 实现类
 * 创建作者：hutao
 * 创建日期：2020/5/18
 * 文件版本：1.0
 */
public class IndexModelImpl implements IndexModel {

    @Override
    public void getBanner(final BannerView<BannerBean> view) {
        NetManager.newInstance().getServiceApi().getBanner().enqueue(new Callback<BannerBean>() {
            @Override
            public void onResponse(Call<BannerBean> call, Response<BannerBean> response) {
                view.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<BannerBean> call, Throwable t) {
                view.onFail(t);
            }
        });
    }

    @Override
    public void getIndex(int page, final IndexView<IndexBean> view) {
        view.showLoad();
        NetManager.newInstance().getServiceApi().getIndex(page).enqueue(new Callback<IndexBean>() {
            @Override
            public void onResponse(Call<IndexBean> call, Response<IndexBean> response) {
                view.hideLoad();
                view.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<IndexBean> call, Throwable t) {
                view.hideLoad();
                view.onFail(t);
            }
        });
    }
}

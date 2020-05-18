package com.github.xiaohu409.wanandroid.mvc.model;

import com.github.xiaohu409.wanandroid.mvc.api.NetManager;
import com.github.xiaohu409.wanandroid.mvc.model.bean.BannerBean;
import com.github.xiaohu409.wanandroid.mvc.view.BannerView;

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
public class BannerModelImpl implements BannerModel<BannerBean> {

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
}

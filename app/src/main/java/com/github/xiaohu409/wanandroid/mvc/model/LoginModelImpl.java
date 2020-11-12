package com.github.xiaohu409.wanandroid.mvc.model;

import com.github.xiaohu409.wanandroid.mvc.api.NetManager;
import com.github.xiaohu409.wanandroid.mvc.model.bean.LoginBean;
import com.github.xiaohu409.wanandroid.mvc.model.bean.LogoutBean;
import com.github.xiaohu409.wanandroid.mvc.view.LoginView;

import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * 项目名称：WanAndroid
 * 文件名称：
 * 文件描述：
 * 创建作者：胡涛
 * 创建日期：2020/9/4
 * 文件版本：1.0
 */
public class LoginModelImpl implements LoginModel {

    @Override
    public void login(Map<String, Object> param, final LoginView<LoginBean> view) {
        NetManager.newInstance().getServiceApi().login(param).enqueue(new Callback<LoginBean>() {
            @Override
            public void onResponse(Call<LoginBean> call, Response<LoginBean> response) {
                view.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<LoginBean> call, Throwable t) {
                view.onFail(t);
            }
        });
    }

    @Override
    public void logout(final LoginView<LogoutBean> view) {
        NetManager.newInstance().getServiceApi().logout().enqueue(new Callback<LogoutBean>() {
            @Override
            public void onResponse(Call<LogoutBean> call, Response<LogoutBean> response) {
                view.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<LogoutBean> call, Throwable t) {
                view.onFail(t);
            }
        });
    }
}

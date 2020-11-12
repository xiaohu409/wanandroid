package com.github.xiaohu409.wanandroid.mvc.model;

import com.github.xiaohu409.wanandroid.mvc.model.bean.LoginBean;
import com.github.xiaohu409.wanandroid.mvc.model.bean.LogoutBean;
import com.github.xiaohu409.wanandroid.mvc.view.LoginView;

import java.util.Map;

/**
 * 项目名称：WanAndroid
 * 文件名称：
 * 文件描述：
 * 创建作者：胡涛
 * 创建日期：2020/9/4
 * 文件版本：1.0
 */
public interface LoginModel {

    void login(Map<String, Object> param, LoginView<LoginBean> view);

    void logout(LoginView<LogoutBean> view);
}

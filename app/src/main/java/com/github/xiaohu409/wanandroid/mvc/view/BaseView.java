package com.github.xiaohu409.wanandroid.mvc.view;

/**
 * 项目名称：
 * 文件名称：BaseView
 * 文件描述：view 基类
 * 创建作者：hutao
 * 创建日期：2020/5/18
 * 文件版本：1.0
 */
public interface BaseView<T> {

    void onSuccess(T result);

    void onFail(Throwable info);
}

package com.github.xiaohu409.wanandroid.mvc.model;

import com.github.xiaohu409.wanandroid.mvc.view.BannerView;


/**
 * 项目名称：
 * 文件名称：BannerModel
 * 文件描述：model
 * 创建作者：hutao
 * 创建日期：2020/5/18
 * 文件版本：1.0
 */
public interface BannerModel<T> {

    void getBanner(BannerView<T> view);
}

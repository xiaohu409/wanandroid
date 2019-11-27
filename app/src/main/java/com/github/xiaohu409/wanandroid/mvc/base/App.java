package com.github.xiaohu409.wanandroid.mvc.base;

import android.app.Application;
import android.content.ComponentCallbacks2;

import com.github.xiaohu409.wanandroid.mvc.util.ImageLoaderUtil;
import com.github.xiaohu409.wanandroid.mvc.util.SharePreUtil;
import com.github.xiaohu409.wanandroid.mvc.util.ToastUtil;

/**
 * 项目名称：WanAndroid
 * 文件名称：App.java
 * 文件描述：
 * 创建作者：胡涛
 * 创建日期：2019/11/26
 * 文件版本：1.0
 */
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        ToastUtil.initToastUtil(this);
        SharePreUtil.initSharePreUtil(this);
        ImageLoaderUtil.initImageLoader(this);
    }

    /**
     * 监听退出
     * @param level
     */
    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        if (level == ComponentCallbacks2.TRIM_MEMORY_UI_HIDDEN) {
            //按HOME键或返回键 都会执行
            ToastUtil.showShort("退出了");
        }
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }

}

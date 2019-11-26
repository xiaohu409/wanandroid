package com.github.xiaohu409.wanandroid.mvc.controller;

import android.content.Intent;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;

import com.github.xiaohu409.wanandroid.R;
import com.github.xiaohu409.wanandroid.mvc.base.BaseActivity;

/**
 * 项目名称：
 * 文件名称：SplashActivity.java
 * 文件描述：启动页
 * 创建作者：胡涛
 * 创建日期：2019/11/26
 * 文件版本：1.0
 */
public class SplashActivity extends BaseActivity {

    private static final long delayMillis = 3000;

    @Override
    public int getLayoutId() {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        return R.layout.activity_splash;
    }

    @Override
    public void bindData() {
        skip();
    }

    private void skip() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(activity, MainActivity.class));
                finish();
            }
        }, delayMillis);
    }
}

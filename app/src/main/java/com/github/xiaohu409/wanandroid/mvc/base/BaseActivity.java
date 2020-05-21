package com.github.xiaohu409.wanandroid.mvc.base;

import android.app.Activity;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

/**
 * 项目名称：
 * 文件名称：BaseActivity.java
 * 文件描述：基类
 * 创建作者：胡涛
 * 创建日期：2019/11/26
 * 文件版本：1.0
 */
public abstract class BaseActivity extends AppCompatActivity implements BaseUI, BaseData {

    protected Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        activity = this;
        initUI();
        bindData();
    }

    /**
     * 布局
     * @return
     */
    public abstract int getLayoutId();

    @Override
    public void initUI() {

    }

    @Override
    public void bindData() {

    }


}

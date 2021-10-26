package com.github.xiaohu409.wanandroid.mvc.util;

import android.app.Application;
import android.content.Context;
import android.widget.Toast;

import com.google.android.material.snackbar.BaseTransientBottomBar;

/**
 * 项目名称：
 * 文件名称：
 * 文件描述：
 * 创建作者：胡涛
 * 创建日期：2019/7/23
 * 文件版本：1.0
 */
public class ToastUtil {

    private static Context context;

    /**
     * 初始化ToastUtil
     * @param application
     */
    public static void initToastUtil(Application application) {
        context = application.getApplicationContext();
    }

    /**
     * 显示长时间toast
     * @param msg
     */
    public static void showLong(String msg) {
        showMsg(msg, Toast.LENGTH_LONG);
    }

    /**
     * 显示短时间的toast
     * @param msg
     */
    public static void showShort(String msg) {
        showMsg(msg, Toast.LENGTH_SHORT);
    }

    public static void showMsg(String msg, int duration) {
        if (context == null) {
            throw new IllegalArgumentException("context is null");
        }
        if (msg == null) {
            throw new IllegalArgumentException("msg is null");
        }
        Toast.makeText(context, msg, duration).show();
    }

    /**
     * 释放context
     */
    public static void releaseContext() {
        context = null;
    }
}

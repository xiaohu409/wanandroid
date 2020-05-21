package com.github.xiaohu409.wanandroid.mvc.util;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * 项目名称：WanAndroid
 * 文件名称：
 * 文件描述：
 * 创建作者：胡涛
 * 创建日期：2019/11/26
 * 文件版本：1.0
 */
public class IntentUtil {

    public static void startActivity(Activity activity, Class<?> cls) {
        Intent intent = new Intent(activity, cls);
        activity.startActivity(intent);
    }

    public static void startActivity(Activity activity, Class<?> cls, Bundle data) {
        Intent intent = new Intent(activity, cls);
        intent.putExtras(data);
        activity.startActivity(intent);
    }

    public static void startActivityAndFinish(Activity activity, Class<?> cls) {
        Intent intent = new Intent(activity, cls);
        activity.startActivity(intent);
        activity.finish();
    }
}

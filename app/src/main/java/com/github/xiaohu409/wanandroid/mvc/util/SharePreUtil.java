package com.github.xiaohu409.wanandroid.mvc.util;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

/**
 * 项目名称：ToolUtilDemo
 * 文件名称：
 * 文件描述：
 * 创建作者：胡涛
 * 创建日期：2019/7/23
 * 文件版本：1.0
 */
public class SharePreUtil {

    public static final String FILE_NAME = "SharePreUtil";
    private static SharePreUtil sharePreUtil;

    private static Context context;
    private static String name;
    private final SharedPreferences preferences;

    public static void initSharePreUtil(Application application) {
        initSharePreUtil(application, FILE_NAME);
    }

    public static void initSharePreUtil(Application application, String fileName) {
        context = application.getApplicationContext();
        if (TextUtils.isEmpty(fileName)) {
            throw new IllegalArgumentException("SharePreUtil FileName is null");
        }
        name = fileName;
    }

    private SharePreUtil() {
        if (context == null) {
            throw new IllegalArgumentException("Context is null");
        }
        preferences = context.getSharedPreferences(name, Context.MODE_PRIVATE);
    }

    public static SharePreUtil getInstance() {
        if (sharePreUtil == null) {
            synchronized (SharePreUtil.class) {
                if (sharePreUtil == null) {
                    sharePreUtil = new SharePreUtil();
                }
            }
        }
        return sharePreUtil;
    }

    public <T> void put(String key, T value) {
        SharedPreferences.Editor editor = preferences.edit();
        if (value instanceof Integer) {
            editor.putInt(key,  ((Integer) value).intValue());
        }
        if (value instanceof Float) {
            editor.putFloat(key, ((Float) value).floatValue());
        }
        if (value instanceof Boolean) {
            editor.putBoolean(key, ((Boolean) value).booleanValue());
        }
        if (value instanceof String) {
            editor.putString(key, (String) value);
        }
        editor.apply();
    }

    public int getInt(String key) {
        return preferences.getInt(key, 0);
    }

    public float getFloat(String key) {
        return preferences.getFloat(key, 0);
    }

    public boolean getBoolean(String key) {
        return preferences.getBoolean(key, false);
    }

    public String getString(String key) {
        return preferences.getString(key, "");
    }

    public void remove(String key) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.remove(key);
        editor.apply();
    }

    public void clear() {
        SharedPreferences.Editor editor = preferences.edit();
        editor.clear();
        editor.apply();
    }

    public static void release() {
        sharePreUtil = null;
        context = null;
    }
}

package com.github.xiaohu409.wanandroid.mvc.util;

import android.content.Context;
import android.graphics.drawable.Drawable;

/**
 * 项目名称：
 * 文件名称：DrawableUtil.java
 * 文件描述：
 * 创建作者：胡涛
 * 创建日期：2019/11/26
 * 文件版本：1.0
 */
public class DrawableUtil {

    /**
     * 获取 Drawable
     * @param context
     * @param rId
     * @return
     */
    public static Drawable getDrawable(Context context, int rId) {
        Drawable drawable = context.getResources().getDrawable(rId);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumWidth());
        return drawable;
    }

}

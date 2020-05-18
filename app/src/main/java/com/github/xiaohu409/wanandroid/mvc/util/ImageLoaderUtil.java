package com.github.xiaohu409.wanandroid.mvc.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.bumptech.glide.request.RequestOptions;
import com.github.xiaohu409.wanandroid.R;

import java.security.MessageDigest;


/**
 * 图片加载工具
 */
public class ImageLoaderUtil {

    public static Context context;

    public static void initImageLoader(Context context) {
        ImageLoaderUtil.context = context.getApplicationContext();
    }

    /**
     * 普通图片加载
     */
    public static void displayImage(String imageURL, ImageView imageView) {
        RequestOptions options = new RequestOptions()
                .placeholder(R.drawable.ic_image_black_72dp)
                .error(R.drawable.ic_image_black_72dp);
        Glide.with(context).load(imageURL).apply(options).into(imageView);
    }

    /**
     * 普通图片加载
     */
    public static void displayImageClass(String imageURL, ImageView imageView) {
        RequestOptions options = new RequestOptions()
                .placeholder(R.drawable.ic_image_black_72dp)
                .error(R.drawable.ic_image_black_72dp);
        Glide.with(context).load(imageURL).apply(options).into(imageView);
    }

    /**
     * 圆形图片
     */
    public static void displayImageCircleHead(String imageURL, ImageView imageView) {
        RequestOptions options = RequestOptions
                .circleCropTransform()
                .placeholder(R.drawable.ic_image_black_72dp)
                .error(R.drawable.ic_image_black_72dp)
                .transform(new GlideCircleBorderTransform(4, Color.WHITE));
        Glide.with(context).load(imageURL).apply(options).into(imageView);
    }

    /**
     * 加载drawable
     */
    public static void displayDrawableImage(int imageId, ImageView imageView) {
        RequestOptions options = new RequestOptions()
                .placeholder(R.drawable.ic_image_black_72dp)
                .error(R.drawable.ic_image_black_72dp);
        Glide.with(context).load("drawable://" + imageId).apply(options).into(imageView);
    }

    private static class GlideCircleBorderTransform extends BitmapTransformation {
        private final String ID = getClass().getName();
        private Paint mBorderPaint;
        private float borderWidth;
        private int borderColor;

        public GlideCircleBorderTransform(float borderWidth, int borderColor) {
            this.borderWidth = borderWidth;
            this.borderColor = borderColor;
            mBorderPaint = new Paint();
            mBorderPaint.setColor(borderColor);
            mBorderPaint.setStyle(Paint.Style.STROKE);
            mBorderPaint.setAntiAlias(true);
            mBorderPaint.setStrokeWidth(borderWidth);
            mBorderPaint.setDither(true);
        }

        @Override
        protected Bitmap transform(BitmapPool pool, Bitmap toTransform, int outWidth, int outHeight) {
            return circleCrop(pool, toTransform);
        }

        private Bitmap circleCrop(BitmapPool bitmapPool, Bitmap source) {
            int size = Math.min(source.getWidth(), source.getHeight());
            int x = (source.getWidth() - size) / 2;
            int y = (source.getHeight() - size) / 2;
            Bitmap square = Bitmap.createBitmap(source, x, y, size, size);
            Bitmap result = bitmapPool.get(size, size, Bitmap.Config.ARGB_8888);
            if (result == null) {
                result = Bitmap.createBitmap(size, size, Bitmap.Config.ARGB_8888);
            }

            //画图
            Canvas canvas = new Canvas(result);
            Paint paint = new Paint();
            //设置 Shader
            paint.setShader(new BitmapShader(square, BitmapShader.TileMode.CLAMP, BitmapShader.TileMode.CLAMP));
            paint.setAntiAlias(true);
            float radius = size / 2f;
            //绘制一个圆
            canvas.drawCircle(radius, radius, radius, paint);

            /************************描边*********************/
            //注意：避免出现描边被屏幕边缘裁掉
            float borderRadius = radius - (borderWidth / 2);
            //画边框
            canvas.drawCircle(radius, radius, borderRadius, mBorderPaint);
            return result;
        }

        @Override
        public void updateDiskCacheKey(MessageDigest messageDigest) {
            messageDigest.update(ID.getBytes(CHARSET));
        }

        @Override
        public boolean equals(Object o) {
            return o instanceof GlideCircleBorderTransform;
        }

        @Override
        public int hashCode() {
            return ID.hashCode();
        }

    }
}


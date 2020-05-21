package com.github.xiaohu409.wanandroid.mvc.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

public class BannerImage extends androidx.appcompat.widget.AppCompatImageView {

    private BannerImageCallback bannerImageCallback;

    public BannerImage(Context context) {
        super(context);
    }

    public BannerImage(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public BannerImage(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_MOVE:
//                ToastUtil.showShort("移动了");
                if (bannerImageCallback != null) {
                    bannerImageCallback.onMove(this);
                }
                break;
            case MotionEvent.ACTION_CANCEL:
//                ToastUtil.showShort("取消了");
                if (bannerImageCallback != null) {
                    bannerImageCallback.onCancel(this);
                }
                break;

        }
        return super.onTouchEvent(event);
    }

    public interface BannerImageCallback {
        void onMove(View view);
        void onCancel(View view);
    }

    public void setBannerImageCallback(BannerImageCallback bannerImageCallback) {
        this.bannerImageCallback = bannerImageCallback;
    }
}

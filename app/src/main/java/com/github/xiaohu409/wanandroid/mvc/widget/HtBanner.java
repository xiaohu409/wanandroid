package com.github.xiaohu409.wanandroid.mvc.widget;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.github.xiaohu409.wanandroid.R;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/**
 * 项目名称：WanAndroid
 * 文件名称：
 * 文件描述：
 * 创建作者：胡涛
 * 创建日期：2019/11/27
 * 文件版本：1.0
 */
public class HtBanner extends FrameLayout {

    private ViewPager viewPager;
    private List<ImageItem> mImageItemList;
    private ImageLoader mImageLoader;
    private MHandler handler;
    private static final int BANNER_WHAT = 0x01;
    private long delayTime = 1000;
    private static int currentIndex = 0;
    private HtBannerLifecycle lifecycle;
    //private ImagePagerAdapter pagerAdapter;

    public HtBanner(@NonNull Context context) {
        this(context, null);
    }

    public HtBanner(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public HtBanner(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView() {
        //viewPager = new ViewPager(getContext());
        View view = View.inflate(getContext(), R.layout.ht_banner, this);
        viewPager = view.findViewById(R.id.view_pager_id);
        handler = new MHandler(this);
        lifecycle = new HtBannerLifecycle(this);
    }

    public HtBanner addImageItemList(List<ImageItem> list) {
        if (mImageItemList == null) {
            mImageItemList = new ArrayList<>();
        }
        mImageItemList.addAll(list);
        return this;
    }

    public HtBanner setImageLoader(ImageLoader imageLoader) {
        this.mImageLoader = imageLoader;
        return this;
    }

    public HtBanner addOnPageListener(ViewPager.OnPageChangeListener listener) {
        viewPager.addOnPageChangeListener(listener);
        return this;
    }

    public long getDelayTime() {
        return delayTime;
    }

    public HtBanner setDelayTime(long delayTime) {
        this.delayTime = delayTime;
        return this;
    }

    public void start() {
        ImagePagerAdapter pagerAdapter = new ImagePagerAdapter(getContext(), mImageItemList, mImageLoader);
        viewPager.setAdapter(pagerAdapter);
        pagerAdapter.notifyDataSetChanged();
        handler.sendEmptyMessageDelayed(BANNER_WHAT, delayTime);
        ((LifecycleOwner)getContext()).getLifecycle().addObserver(lifecycle);
    }

    public void stop() {
        if (handler.hasMessages(BANNER_WHAT)) {
            handler.removeMessages(BANNER_WHAT);
        }
        //((LifecycleOwner)getContext()).getLifecycle().removeObserver(lifecycle);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        //return super.onInterceptTouchEvent(ev);
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                stop();
                break;
            case MotionEvent.ACTION_UP:
                start();
                break;
        }
        return super.onInterceptTouchEvent(ev);
    }

    private static class MHandler extends Handler {

        WeakReference<HtBanner> weakReference;
        HtBanner htBanner;
        int count = 0;

        public MHandler(HtBanner htBanner) {
            weakReference = new WeakReference<>(htBanner);
            this.htBanner = weakReference.get();
        }

        @Override
        public void handleMessage(@NonNull Message msg) {
            int what = msg.what;
            switch (what) {
                case BANNER_WHAT:
                    currentIndex = count++ % htBanner.mImageItemList.size();
                    htBanner.viewPager.setCurrentItem(currentIndex);
                    sendEmptyMessageDelayed(BANNER_WHAT, htBanner.getDelayTime());
                    break;
            }
        }
    }

    public static class ImageItem {

        String imageTitle;
        String imageUrl;

        public String getImageTitle() {
            return imageTitle;
        }

        public void setImageTitle(String imageTitle) {
            this.imageTitle = imageTitle;
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }
    }

    public static class ImagePagerAdapter extends PagerAdapter {

        private Context context;
        private List<ImageItem> list;
        private ImageLoader imageLoader;

        public ImagePagerAdapter(Context context, List<ImageItem> list, ImageLoader imageLoader) {
            this.context = context;
            this.list = list;
            this.imageLoader = imageLoader;
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            ImageItem imageItem = list.get(position);
            ImageView imageView = new ImageView(context);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageLoader.displayImage(imageItem.getImageUrl(), imageView);
            container.addView(imageView);
            return imageView;
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            return view == object;
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            container.removeView((View) object);
        }
    }

    public interface ImageLoader {
        void displayImage(String url, ImageView imageView);
    }

    public static class HtBannerLifecycle implements LifecycleObserver {

        WeakReference<HtBanner> weakReference;
        HtBanner htBanner;

        public HtBannerLifecycle(HtBanner htBanner) {
            weakReference = new WeakReference<>(htBanner);
            this.htBanner = weakReference.get();
        }

//        @OnLifecycleEvent(Lifecycle.Event.ON_START)
//        void onStart() {
//            htBanner.start();
//        }
//        @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
//        void onResume() {
//            htBanner.start();
//        }
//
//        @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
//        void onPasue() {
//            htBanner.stop();
//        }

        @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
        void onStop() {
            htBanner.stop();
        }

    }
}

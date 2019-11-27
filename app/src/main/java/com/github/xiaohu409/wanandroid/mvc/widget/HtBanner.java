package com.github.xiaohu409.wanandroid.mvc.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.github.xiaohu409.wanandroid.R;

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

    public void start() {
        ImagePagerAdapter pagerAdapter = new ImagePagerAdapter(getContext(), mImageItemList, mImageLoader);
        viewPager.setAdapter(pagerAdapter);
        pagerAdapter.notifyDataSetChanged();
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
}

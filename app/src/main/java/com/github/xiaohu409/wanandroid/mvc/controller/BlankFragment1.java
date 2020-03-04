package com.github.xiaohu409.wanandroid.mvc.controller;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.github.xiaohu409.wanandroid.R;
import com.github.xiaohu409.wanandroid.mvc.util.ImageLoaderUtil;
import com.github.xiaohu409.wanandroid.mvc.util.ToastUtil;
import com.github.xiaohu409.wanandroid.mvc.widget.HtBanner;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment1 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank_fragment1, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        List<HtBanner.ImageItem> list = new ArrayList<>();
        String url = "https://www.wanandroid.com/blogimgs/fa822a30-00fc-4e0d-a51a-d704af48205c.jpeg";
        for (int i = 0; i < 3; i++) {
            HtBanner.ImageItem imageItem = new HtBanner.ImageItem();
            imageItem.setImageUrl(url);
            list.add(imageItem);
        }
        HtBanner banner = getView().findViewById(R.id.banner_id);
        banner.setDelayTime(4000).addImageItemList(list).setImageLoader(new HtBanner.ImageLoader() {
            @Override
            public void displayImage(String url, ImageView imageView) {
                ImageLoaderUtil.displayImage(url, imageView);
            }
        }).addOnPageListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                ToastUtil.showShort(String.valueOf(position));
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        }).start();

    }
}

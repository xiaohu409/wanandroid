package com.github.xiaohu409.wanandroid.mvc.controller;

import android.widget.ImageView;

import androidx.viewpager.widget.ViewPager;

import com.github.xiaohu409.wanandroid.R;
import com.github.xiaohu409.wanandroid.mvc.base.BaseFragment;
import com.github.xiaohu409.wanandroid.mvc.model.BannerModel;
import com.github.xiaohu409.wanandroid.mvc.model.BannerModelImpl;
import com.github.xiaohu409.wanandroid.mvc.model.bean.BannerBean;
import com.github.xiaohu409.wanandroid.mvc.util.ImageLoaderUtil;
import com.github.xiaohu409.wanandroid.mvc.util.ToastUtil;
import com.github.xiaohu409.wanandroid.mvc.view.BannerView;
import com.github.xiaohu409.wanandroid.mvc.widget.HtBanner;

import java.util.ArrayList;
import java.util.List;

/**
 * 项目名称：
 * 文件名称：BlankFragment1
 * 文件描述：首页
 * 创建作者：hutao
 * 创建日期：2020/5/18
 * 文件版本：1.0
 */
public class BlankFragment1 extends BaseFragment {

    private BannerModel<BannerBean> bannerModel;
    private List<HtBanner.ImageItem> bannerList;
    private HtBanner banner;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_blank_fragment1;
    }

    @Override
    public void initUI() {
        bannerList = new ArrayList<>();
        banner = getView().findViewById(R.id.banner_id);
        banner.setDelayTime(4000).setImageLoader(new HtBanner.ImageLoader() {
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
        });
    }

    @Override
    public void bindData() {
        bannerModel = new BannerModelImpl();
        getBanner();
    }

    private void getBanner() {

        bannerModel.getBanner(new BannerView<BannerBean>() {
            @Override
            public void onSuccess(BannerBean result) {
                if (result == null) {
                    ToastUtil.showShort("获取数据失败");
                    return;
                }
                if (result.getErrorCode() != 0) {
                    ToastUtil.showShort(result.getErrorMsg());
                    return;
                }
                for (BannerBean.DataBean bean : result.getData()) {
                    HtBanner.ImageItem imageItem = new HtBanner.ImageItem();
                    imageItem.setImageTitle(bean.getTitle());
                    imageItem.setImageUrl(bean.getImagePath());
                    bannerList.add(imageItem);
                }
                banner.addImageItemList(bannerList);
                banner.start();
            }

            @Override
            public void onFail(Throwable info) {
                ToastUtil.showShort(info.getMessage());
            }
        });

    }
}

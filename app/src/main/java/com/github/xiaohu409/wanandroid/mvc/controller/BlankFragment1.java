package com.github.xiaohu409.wanandroid.mvc.controller;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.github.xiaohu409.wanandroid.R;
import com.github.xiaohu409.wanandroid.mvc.adapter.IndexRecycleAdapter;
import com.github.xiaohu409.wanandroid.mvc.base.BaseFragment;
import com.github.xiaohu409.wanandroid.mvc.model.IndexModel;
import com.github.xiaohu409.wanandroid.mvc.model.IndexModelImpl;
import com.github.xiaohu409.wanandroid.mvc.model.bean.BannerBean;
import com.github.xiaohu409.wanandroid.mvc.model.bean.IndexBean;
import com.github.xiaohu409.wanandroid.mvc.util.ImageLoaderUtil;
import com.github.xiaohu409.wanandroid.mvc.util.IntentUtil;
import com.github.xiaohu409.wanandroid.mvc.util.ToastUtil;
import com.github.xiaohu409.wanandroid.mvc.view.BannerView;
import com.github.xiaohu409.wanandroid.mvc.view.IndexView;
import com.github.xiaohu409.wanandroid.mvc.widget.HtBanner;
import com.scwang.smart.refresh.footer.ClassicsFooter;
import com.scwang.smart.refresh.header.MaterialHeader;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.OnLoadMoreListener;
import com.scwang.smart.refresh.layout.listener.OnRefreshListener;

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
public class BlankFragment1 extends BaseFragment implements IndexRecycleAdapter.AdapterItemClickCallback {

    private IndexModel indexModel;
    private List<HtBanner.ImageItem> bannerList;
    private HtBanner banner;
    private List<IndexBean.DataBean.DatasBean> indexList;
    private IndexRecycleAdapter indexAdapter;
    private int pageCount;
    private int page = 0;
    private RefreshLayout refreshLayout;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_blank_fragment1;
    }

    @Override
    public void initUI() {
        refreshLayout = getView().findViewById(R.id.refreshLayout);
        refreshLayout.setRefreshHeader(new MaterialHeader(getActivity()));
        refreshLayout.setRefreshFooter(new ClassicsFooter(getActivity()));
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                //refreshlayout.finishRefresh(2000/*,false*/);//传入false表示刷新失败
                indexList.clear();
                page = 0;
                getIndex(page);
                refreshlayout.finishRefresh();
            }
        });
        refreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(RefreshLayout refreshlayout) {
                //refreshlayout.finishLoadMore(2000/*,false*/);//传入false表示加载失败
                if (page <= pageCount) {
                    page++;
                    getIndex(page);
                }
                refreshlayout.finishLoadMore();
            }
        });
        bannerList = new ArrayList<>();
        banner = getView().findViewById(R.id.banner_id);
        banner.setDelayTime(4000).setImageLoader(new HtBanner.ImageLoader() {
            @Override
            public void displayImage(String url, ImageView imageView) {
                ImageLoaderUtil.displayImage(url, imageView);
            }
        });
        banner.setHtBannerClick(new HtBanner.ImagePagerAdapter.HtBannerClick() {
            @Override
            public void onBannerClick(View view, HtBanner.ImageItem imageItem) {
//                ToastUtil.showShort(imageItem.getUrl());
                Bundle data = new Bundle();
                data.putString("url", imageItem.getUrl());
                IntentUtil.startActivity(getActivity(), WebViewActivity.class, data);
            }
        });
        RecyclerView recyclerView = getView().findViewById(R.id.index_rv_id);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        indexList =  new ArrayList<>();
        indexAdapter = new IndexRecycleAdapter(getActivity(), indexList);
        indexAdapter.setItemClickCallback(this);
        recyclerView.setAdapter(indexAdapter);
    }

    @Override
    public void onAdapterClick(View view, IndexBean.DataBean.DatasBean bean) {
        Bundle data = new Bundle();
        data.putString("url", bean.getLink());
        IntentUtil.startActivity(getActivity(), WebViewActivity.class, data);
    }

    @Override
    public void bindData() {
        indexModel = new IndexModelImpl();
        getBanner();
        getIndex(page);
    }

    private void getBanner() {
        indexModel.getBanner(new BannerView<BannerBean>() {
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
                    imageItem.setUrl(bean.getUrl());
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

    /**
     * 获取首页文章列表
     * @param page
     */
    private void getIndex(int page) {
        indexModel.getIndex(page, new IndexView<IndexBean>() {
            @Override
            public void onSuccess(IndexBean result) {
                if (result == null) {
                    ToastUtil.showShort("获取数据失败");
                    return;
                }
                if (result.getErrorCode() != 0) {
                    ToastUtil.showShort(result.getErrorMsg());
                    return;
                }
                IndexBean.DataBean dataBean = result.getData();
                pageCount = dataBean.getPageCount();
                indexList.addAll(dataBean.getDatas());
                indexAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFail(Throwable info) {
                ToastUtil.showShort(info.getMessage());
            }
        });
    }

}

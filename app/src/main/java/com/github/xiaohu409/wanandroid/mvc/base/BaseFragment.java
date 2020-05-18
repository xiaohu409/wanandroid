package com.github.xiaohu409.wanandroid.mvc.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


/**
 * 项目名称：
 * 文件名称：BaseFragment
 * 文件描述：
 * 创建作者：hutao
 * 创建日期：2020/5/18
 * 文件版本：1.0
 */
public abstract class BaseFragment extends Fragment implements BaseUI, BaseData {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(getLayoutId(), container, false);
    }

    /**
     * 布局
     * @return
     */
    public abstract int getLayoutId();

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initUI();
        bindData();
    }
}

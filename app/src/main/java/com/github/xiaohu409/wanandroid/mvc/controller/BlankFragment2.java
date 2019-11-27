package com.github.xiaohu409.wanandroid.mvc.controller;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.github.xiaohu409.wanandroid.R;
import com.github.xiaohu409.wanandroid.mvc.util.ImageLoaderUtil;

/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment2 extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank_fragment2, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ImageView imageView = getView().findViewById(R.id.iv_id);
        ImageLoaderUtil.displayImage("https://www.wanandroid.com/blogimgs/fa822a30-00fc-4e0d-a51a-d704af48205c.jpeg", imageView);
    }
}

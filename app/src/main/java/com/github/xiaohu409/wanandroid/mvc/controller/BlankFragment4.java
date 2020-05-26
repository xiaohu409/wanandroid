package com.github.xiaohu409.wanandroid.mvc.controller;

import android.view.View;
import android.widget.Button;

import com.github.xiaohu409.wanandroid.R;
import com.github.xiaohu409.wanandroid.mvc.base.BaseFragment;
import com.github.xiaohu409.wanandroid.mvc.util.IntentUtil;

/**
 * 个人中心
 */
public class BlankFragment4 extends BaseFragment implements View.OnClickListener {

    @Override
    public int getLayoutId() {
        return R.layout.fragment_blank_fragment4;
    }

    @Override
    public void initUI() {
        Button regBtn = getView().findViewById(R.id.reg_btn_id);
        regBtn.setOnClickListener(this);
        Button loginBtn = getView().findViewById(R.id.login_btn_id);
        loginBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.reg_btn_id:
                IntentUtil.startActivity(getActivity(), RegActivity.class);
                break;
            case R.id.login_btn_id:

                break;
        }
    }

    @Override
    public void bindData() {

    }
}

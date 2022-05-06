package com.github.xiaohu409.wanandroid.mvc.controller;

import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.xiaohu409.wanandroid.R;
import com.github.xiaohu409.wanandroid.mvc.base.BaseFragment;
import com.github.xiaohu409.wanandroid.mvc.model.LoginModel;
import com.github.xiaohu409.wanandroid.mvc.model.LoginModelImpl;
import com.github.xiaohu409.wanandroid.mvc.model.bean.LogoutBean;
import com.github.xiaohu409.wanandroid.mvc.util.IntentUtil;
import com.github.xiaohu409.wanandroid.mvc.util.SharePreUtil;
import com.github.xiaohu409.wanandroid.mvc.util.ToastUtil;
import com.github.xiaohu409.wanandroid.mvc.view.LoginView;

/**
 * 个人中心
 */
public class BlankFragment4 extends BaseFragment implements View.OnClickListener {

    private ImageView headView;
    private TextView nameView;
    private Button regBtn;
    private Button loginBtn;
    private Button logoutBtn;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_blank_fragment4;
    }

    @Override
    public void initUI() {
        headView = getView().findViewById(R.id.head_iv_id);
        headView.setImageResource(R.mipmap.app);
        nameView = getView().findViewById(R.id.username_tv_id);
        regBtn = getView().findViewById(R.id.reg_btn_id);
        regBtn.setOnClickListener(this);
        loginBtn = getView().findViewById(R.id.login_btn_id);
        loginBtn.setOnClickListener(this);
        logoutBtn = getView().findViewById(R.id.logout_btn_id);
        logoutBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.reg_btn_id:
                IntentUtil.startActivity(getActivity(), RegActivity.class);
                break;
            case R.id.login_btn_id:
                IntentUtil.startActivity(getActivity(), LoginActivity.class);
                break;
            case R.id.logout_btn_id:
                logout();
                break;
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        bindData();
    }

    @Override
    public void bindData() {
        String username = SharePreUtil.getInstance().getString("username");
        if (TextUtils.isEmpty(username)) {
            headView.setVisibility(View.GONE);
            nameView.setVisibility(View.GONE);
            regBtn.setVisibility(View.VISIBLE);
            loginBtn.setVisibility(View.VISIBLE);
            logoutBtn.setVisibility(View.GONE);
        }
        else {
            headView.setVisibility(View.VISIBLE);
            nameView.setVisibility(View.VISIBLE);
            nameView.setText(username);
            logoutBtn.setVisibility(View.VISIBLE);

            regBtn.setVisibility(View.GONE);
            loginBtn.setVisibility(View.GONE);
        }
    }

    private void logout() {
        LoginModel loginModel = new LoginModelImpl();
        loginModel.logout(new LoginView<LogoutBean>() {
            @Override
            public void onSuccess(LogoutBean result) {
                if (result == null) {
                    ToastUtil.showShort("获取数据失败");
                    return;
                }
                if (result.getErrorCode() != 0) {
                    ToastUtil.showShort(result.getErrorMsg());
                    return;
                }
                SharePreUtil.getInstance().remove("username");
                bindData();
            }

            @Override
            public void onFail(Throwable info) {

            }

            @Override
            public void showLoad() {

            }

            @Override
            public void hideLoad() {

            }
        });


    }
}

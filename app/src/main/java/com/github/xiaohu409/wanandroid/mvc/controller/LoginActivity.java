package com.github.xiaohu409.wanandroid.mvc.controller;

import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.github.xiaohu409.wanandroid.R;
import com.github.xiaohu409.wanandroid.mvc.base.BaseTitleBarActivity;
import com.github.xiaohu409.wanandroid.mvc.model.LoginModel;
import com.github.xiaohu409.wanandroid.mvc.model.LoginModelImpl;
import com.github.xiaohu409.wanandroid.mvc.model.bean.LoginBean;
import com.github.xiaohu409.wanandroid.mvc.util.IntentUtil;
import com.github.xiaohu409.wanandroid.mvc.util.ToastUtil;
import com.github.xiaohu409.wanandroid.mvc.view.LoginView;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends BaseTitleBarActivity {

    private EditText usernameView;
    private EditText passwordView;
    private Button loginBtn;
    private Button regBtn;
    private LoginModel loginModel;

    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public void initUI() {
        super.initUI();
        usernameView = findViewById(R.id.username_tv_id);
        passwordView = findViewById(R.id.password_tv_id);
        loginBtn = findViewById(R.id.login_btn_id);
        loginBtn.setOnClickListener(this);
        regBtn = findViewById(R.id.reg_btn_id);
        regBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.login_btn_id:
                login();
                break;
            case R.id.reg_btn_id:
                IntentUtil.startActivity(this, RegActivity.class);
                break;
        }
    }

    @Override
    public void bindData() {
        loginModel = new LoginModelImpl();
    }

    /**
     * 登录
     */
    private void login() {
        String username = usernameView.getText().toString();
        String password = passwordView.getText().toString();
        if (TextUtils.isEmpty(username)) {
            ToastUtil.showLong(usernameView.getHint().toString());
            return;
        }
        if (TextUtils.isEmpty(password)) {
            ToastUtil.showLong(passwordView.getHint().toString());
            return;
        }
        Map<String, Object> param = new HashMap<>();
        param.put("username", username);
        param.put("password", password);
        loginModel.login(param, new LoginView<LoginBean>() {
            @Override
            public void onSuccess(LoginBean result) {
                if (result == null) {
                    ToastUtil.showShort("获取数据失败");
                    return;
                }
                if (result.getErrorCode() != 0) {
                    ToastUtil.showShort(result.getErrorMsg());
                    return;
                }
                LoginBean.DataBean dataBean = result.getData();
                ToastUtil.showLong(dataBean.getNickname());
            }

            @Override
            public void onFail(Throwable info) {

            }
        });
    }
}
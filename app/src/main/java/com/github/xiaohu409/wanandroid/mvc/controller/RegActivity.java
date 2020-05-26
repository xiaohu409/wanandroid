package com.github.xiaohu409.wanandroid.mvc.controller;

import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.github.xiaohu409.wanandroid.R;
import com.github.xiaohu409.wanandroid.mvc.base.BaseTitleBarActivity;
import com.github.xiaohu409.wanandroid.mvc.util.ToastUtil;

/**
 * 注册
 */
public class RegActivity extends BaseTitleBarActivity {

    private EditText usernameView;
    private EditText passwordView;
    private EditText repasswordView;

    @Override
    public int getLayoutId() {
        return R.layout.activity_reg;
    }

    @Override
    public void initUI() {
        super.initUI();
        setTitle("注册");
        usernameView = findViewById(R.id.username_tv_id);
        passwordView = findViewById(R.id.password_tv_id);
        repasswordView = findViewById(R.id.reppassword_tv_id);
        Button regBtn = findViewById(R.id.reg_btn_id);
        regBtn.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.reg_btn_id:
                reg();
                break;
        }
    }

    /**
     * 注册
     */
    private void reg() {
        String username = usernameView.getText().toString();
        String password = passwordView.getText().toString();
        String repassword = repasswordView.getText().toString();
        if (TextUtils.isEmpty(username)) {
            ToastUtil.showShort(usernameView.getHint().toString());
            return;
        }
        if (TextUtils.isEmpty(password)) {
            ToastUtil.showShort(passwordView.getHint().toString());
            return;
        }
        if (TextUtils.isEmpty(repassword)) {
            ToastUtil.showShort(repasswordView.getHint().toString());
            return;
        }
        if (!password.equals(repassword)) {
            ToastUtil.showShort("密码与确认密码不一致,请重新输入密码");
            return;
        }

    }
}

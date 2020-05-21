package com.github.xiaohu409.wanandroid.mvc.base;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.xiaohu409.wanandroid.R;

/**
 * 项目名称：
 * 文件名称：BaseTitleBarActivity
 * 文件描述：
 * 创建作者：hutao
 * 创建日期：2020/5/21
 * 文件版本：1.0
 */
public abstract class BaseTitleBarActivity extends BaseActivity implements View.OnClickListener {

    private TextView titleView;

    @Override
    public void initUI() {
        ImageView backView = findViewById(R.id.back_iv_id);
        backView.setOnClickListener(this);
        titleView = findViewById(R.id.title_tv_id);
    }

    public void setTitle(String title) {
        titleView.setText(title);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back_iv_id:
                finish();
                break;
        }
    }
}

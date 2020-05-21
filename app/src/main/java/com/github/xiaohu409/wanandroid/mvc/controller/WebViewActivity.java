package com.github.xiaohu409.wanandroid.mvc.controller;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.github.xiaohu409.wanandroid.R;
import com.github.xiaohu409.wanandroid.mvc.base.BaseActivity;
import com.github.xiaohu409.wanandroid.mvc.base.BaseTitleBarActivity;

/**
 * 项目名称：
 * 文件名称：WebViewActivity
 * 文件描述：
 * 创建作者：hutao
 * 创建日期：2020/5/21
 * 文件版本：1.0
 */
public class WebViewActivity extends BaseTitleBarActivity {

    private WebView webView;

    @Override
    public int getLayoutId() {
        return R.layout.activity_web_view;
    }

    @Override
    public void initUI() {
        super.initUI();
        webView = findViewById(R.id.web_view_id);
        webView.setWebViewClient(new WebViewClient() {


        });
        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onReceivedTitle(WebView view, String title) {
                //super.onReceivedTitle(view, title);
                setTitle(title);
            }
        });
        webView.getSettings().setJavaScriptEnabled(true);
    }

    @Override
    public void bindData() {
        if (webView != null) {
            Intent intent = getIntent();
            Bundle bundle = intent.getExtras();
            String url = bundle.getString("url");
            webView.loadUrl(url);
        }
    }
}

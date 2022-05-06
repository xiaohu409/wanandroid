package com.github.xiaohu409.wanandroid.mvc.base;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

/**
 * 项目名称：
 * 文件名称：BaseActivity.java
 * 文件描述：基类
 * 创建作者：胡涛
 * 创建日期：2019/11/26
 * 文件版本：1.0
 */
public abstract class BaseActivity extends AppCompatActivity implements BaseUI, BaseData, BasePermission {

    public static final int REQUEST_PERMISSION_CAMERA = 0x01;
    public static final int REQUEST_PERMISSION_GALLERY = 0x02;
    public static final int REQUEST_PERMISSION_CALL = 0x03;
    public static final int REQUEST_PERMISSION_LOCATION = 0x04;
    public static final int REQUEST_PERMISSION_BLUETOOTH = 0x05;

    protected Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        activity = this;
        initUI();
        bindData();
    }

    /**
     * 布局
     * @return
     */
    public abstract int getLayoutId();

    @Override
    public void initUI() {

    }

    @Override
    public void bindData() {

    }

    /**
     * 权限回调
     * @param requestCode
     * @param permissions
     * @param grantResults
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case REQUEST_PERMISSION_CAMERA:
                if (hasAllPermission(grantResults)) {
                    grantedPermission(REQUEST_PERMISSION_CAMERA);
                }
                else {
                    deniedPermission(REQUEST_PERMISSION_CAMERA);
                }
                break;
            case REQUEST_PERMISSION_GALLERY:
                if (hasAllPermission(grantResults)) {
                    grantedPermission(REQUEST_PERMISSION_GALLERY);
                }
                else {
                    deniedPermission(REQUEST_PERMISSION_GALLERY);
                }
                break;
            case REQUEST_PERMISSION_CALL:
                if (hasAllPermission(grantResults)) {
                    grantedPermission(REQUEST_PERMISSION_CALL);
                }
                else {
                    deniedPermission(REQUEST_PERMISSION_CALL);
                }
                break;
            case REQUEST_PERMISSION_BLUETOOTH:
                if (hasAllPermission(grantResults)) {
                    grantedPermission(REQUEST_PERMISSION_BLUETOOTH);
                }
                else {
                    deniedPermission(REQUEST_PERMISSION_BLUETOOTH);
                }
                break;
            case REQUEST_PERMISSION_LOCATION:
                if (hasAllPermission(grantResults)) {
                    grantedPermission(REQUEST_PERMISSION_LOCATION);
                }
                else {
                    deniedPermission(REQUEST_PERMISSION_LOCATION);
                }
                break;
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    /**
     * 是否有权限
     */
    private boolean hasAllPermission(int[] grantResults) {
        for (int grantResult : grantResults) {
            if (grantResult == PackageManager.PERMISSION_DENIED) {
                return false;
            }
        }
        return true;
    }

    /**
     * 授予权限
     * @param type
     */
    @Override
    public void grantedPermission(int type) {

    }

    /**
     * 拒绝权限
     * @param type
     */
    @Override
    public void deniedPermission(int type) {

    }
}

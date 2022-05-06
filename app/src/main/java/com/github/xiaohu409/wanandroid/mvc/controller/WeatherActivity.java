package com.github.xiaohu409.wanandroid.mvc.controller;

import android.Manifest;
import android.os.Build;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationListener;
import com.github.xiaohu409.wanandroid.R;
import com.github.xiaohu409.wanandroid.mvc.base.BaseTitleBarActivity;
import com.github.xiaohu409.wanandroid.mvc.util.LocationUtil;
import com.github.xiaohu409.wanandroid.mvc.util.ToastUtil;

/**
 * 天气
 */
public class WeatherActivity extends BaseTitleBarActivity {

    @Override
    public int getLayoutId() {
        return R.layout.activity_weather;
    }

    @Override
    public void initUI() {
        super.initUI();
        setTitle("天气");

    }

    @Override
    public void bindData() {
        super.bindData();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(new String[] {
                    Manifest.permission.ACCESS_COARSE_LOCATION,
                    Manifest.permission.ACCESS_FINE_LOCATION
            }, REQUEST_PERMISSION_LOCATION);
        }
        else {
            location();
        }
    }

    @Override
    public void grantedPermission(int type) {
        location();
    }

    @Override
    public void deniedPermission(int type) {
        ToastUtil.showShort("拒绝了权限");
    }

    /**
     * 定位
     */
    private void location() {
        LocationUtil.startLocation(getApplicationContext(), new AMapLocationListener() {
            @Override
            public void onLocationChanged(AMapLocation aMapLocation) {
                ToastUtil.showShort(aMapLocation.getAddress());
            }
        });
    }
}
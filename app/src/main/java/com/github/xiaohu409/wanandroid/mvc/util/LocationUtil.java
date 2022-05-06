package com.github.xiaohu409.wanandroid.mvc.util;

import android.content.Context;

import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;

public class LocationUtil {

    /**
     * 定位
     * @param context
     * @param listener
     */
    public static void startLocation(Context context, AMapLocationListener listener) {
        try {

            AMapLocationClient.updatePrivacyShow(context,true,true);
            AMapLocationClient.updatePrivacyAgree(context,true);
            //定位选项
            AMapLocationClientOption  mLocationOption = new AMapLocationClientOption();
            mLocationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
            mLocationOption.setOnceLocation(true);
            //定位客户端
            AMapLocationClient mLocationClient = new AMapLocationClient(context);
            mLocationClient.setLocationListener(listener);
            mLocationClient.setLocationOption(mLocationOption);
            mLocationClient.stopLocation();
            mLocationClient.startLocation();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

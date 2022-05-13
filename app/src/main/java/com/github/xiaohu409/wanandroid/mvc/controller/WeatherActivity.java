package com.github.xiaohu409.wanandroid.mvc.controller;

import android.Manifest;
import android.os.Build;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.RelativeSizeSpan;
import android.text.style.SubscriptSpan;
import android.text.style.SuperscriptSpan;
import android.widget.TextView;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationListener;
import com.github.xiaohu409.wanandroid.R;
import com.github.xiaohu409.wanandroid.mvc.api.NetManager;
import com.github.xiaohu409.wanandroid.mvc.api.ServiceApi;
import com.github.xiaohu409.wanandroid.mvc.base.BaseTitleBarActivity;
import com.github.xiaohu409.wanandroid.mvc.model.weatherbean.RainBean;
import com.github.xiaohu409.wanandroid.mvc.model.weatherbean.RealWeatherBean;
import com.github.xiaohu409.wanandroid.mvc.model.weatherbean.SkyconEnum;
import com.github.xiaohu409.wanandroid.mvc.util.LocationUtil;
import com.github.xiaohu409.wanandroid.mvc.util.ToastUtil;

import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * 天气显示
 */
public class WeatherActivity extends BaseTitleBarActivity {

    private TextView tempView;
    private TextView skyconView;
    private TextView airView;
    private TextView rainView;

    @Override
    public int getLayoutId() {
        return R.layout.activity_weather;
    }

    @Override
    public void initUI() {
        super.initUI();
        setTitle(getString(R.string.weather));
        tempView = findViewById(R.id.temp_tv_id);
        skyconView = findViewById(R.id.skycon_tv_id);
        airView = findViewById(R.id.air_tv_id);
        rainView = findViewById(R.id.rain_tv_id);
    }

    @Override
    public void bindData() {
        super.bindData();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(new String[] {
                    Manifest.permission.ACCESS_COARSE_LOCATION,
                    Manifest.permission.ACCESS_FINE_LOCATION},
                    REQUEST_PERMISSION_LOCATION);
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
                setTitle(String.format("%s %s", aMapLocation.getDistrict(), aMapLocation.getStreet()));
                String lnglat = aMapLocation.getLongitude() + "," + aMapLocation.getLatitude();
                getRealWeather(lnglat);
                getRain(lnglat);
            }
        });
    }

    /**
     * 实时天气
     * @param latlng
     */
    private void getRealWeather(String latlng) {
        StringBuilder builder = new StringBuilder();
        builder.append(ServiceApi.weatherIp);
        builder.append(ServiceApi.weatherKey);
        builder.append(latlng);
        builder.append(ServiceApi.realWeather);
        NetManager.newInstance().getServiceApi().getRealWeather(builder.toString()).enqueue(new Callback<RealWeatherBean>() {
            @Override
            public void onResponse(Call<RealWeatherBean> call, Response<RealWeatherBean> response) {
                RealWeatherBean bean = response.body();
                if (bean == null) {
                    ToastUtil.showShort(getString(R.string.error) + "：获取数据失败");
                    return;
                }
                if (!bean.getStatus().equals("ok")) {
                    ToastUtil.showShort(getString(R.string.error) + "：" + bean.getStatus());
                    return;
                }
                //实时天气
                RealWeatherBean.ResultBean.RealtimeBean realtimeBean = bean.getResult().getRealtime();
                //气温
                String temper = String.format(Locale.CHINA, "%.0f", realtimeBean.getTemperature());
                //单位
                String unit = "℃";
                //温度
                String temp = String.format(Locale.CHINA, "%s%s", temper, unit);
                //格式化
                SpannableString span = new SpannableString(temp);
                int index1 = temp.indexOf(temper);
                span.setSpan(new SubscriptSpan(), index1, index1 + temper.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                index1 = temp.indexOf(unit);
                span.setSpan(new RelativeSizeSpan(0.25f),
                        index1, index1 + unit.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                span.setSpan(new SuperscriptSpan(), index1, index1 + unit.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                tempView.setText(span);

                //天气现象
                String skycon = realtimeBean.getSkycon();
                SkyconEnum skyconEnum = SkyconEnum.valueOf(skycon);
                skyconView.setText(skyconEnum.toString());

                //空气
                RealWeatherBean.ResultBean.RealtimeBean.AirQualityBean air = realtimeBean.getAir_quality();
                airView.setText(String.format("空气%s%s", air.getDescription().getChn(), air.getAqi().getChn()));
            }

            @Override
            public void onFailure(Call<RealWeatherBean> call, Throwable t) {

            }
        });

    }

    /**
     * 未来降水
     */
    private void getRain(String latlng) {
        StringBuilder builder = new StringBuilder();
        builder.append(ServiceApi.weatherIp);
        builder.append(ServiceApi.weatherKey);
        builder.append(latlng);
        builder.append(ServiceApi.rain);
        NetManager.newInstance().getServiceApi().getRain(builder.toString()).enqueue(new Callback<RainBean>() {
            @Override
            public void onResponse(Call<RainBean> call, Response<RainBean> response) {
                RainBean bean = response.body();
                if (bean == null) {
                    ToastUtil.showShort(getString(R.string.error) + "：获取数据失败");
                    return;
                }
                if (!bean.getStatus().equals("ok")) {
                    ToastUtil.showShort(getString(R.string.error) + "：" + bean.getStatus());
                    return;
                }
                RainBean.ResultBean resultBean = bean.getResult();
                rainView.setText(resultBean.getForecast_keypoint());
            }

            @Override
            public void onFailure(Call<RainBean> call, Throwable t) {

            }
        });
    }
}
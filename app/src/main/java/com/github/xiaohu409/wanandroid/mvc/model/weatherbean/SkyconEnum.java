package com.github.xiaohu409.wanandroid.mvc.model.weatherbean;

import androidx.annotation.NonNull;

public enum SkyconEnum {

    CLEAR_DAY("晴"), CLEAR_NIGHT("晴"),
    PARTLY_CLOUDY_DAY("多云"), PARTLY_CLOUDY_NIGHT("多云"),
    CLOUDY("阴"),LIGHT_HAZE("轻度雾霾"),
    MODERATE_HAZE("中度雾霾"),HEAVY_HAZE("重度雾霾"),
    LIGHT_RAIN("小雨"),MODERATE_RAIN("中雨"),
    HEAVY_RAIN("大雨"),STORM_RAIN("暴雨"),
    FOG("雾"),LIGHT_SNOW("小雪"), MODERATE_SNOW("中雪"),
    HEAVY_SNOW("大雪"),STORM_SNOW("暴雪"),DUST("浮尘"),
    SAND("沙尘"), WIND("大风");

    private String value;

    SkyconEnum(String value) {
        this.value = value;
    }

    @NonNull
    @Override
    public String toString() {
        return value;
    }
}

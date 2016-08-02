package com.niemisami.homedashboard;

/**
 * Created by sami on 7/9/16.
 */
public class ForecastItem {

    private int mIconId, mTemperature;
    private String mTime;

    public ForecastItem(int iconId, String time) {
        this(iconId, time, 0);
    }

    public ForecastItem(int iconId, String time, int temperature) {
        mIconId = iconId;
        mTime = time;
        mTemperature = temperature;
    }


    public int getIconId() {
        return mIconId;
    }

    public String getTime() {
        return mTime;
    }

    public int getTemperature() {
        return mTemperature;
    }
}


package com.niemisami.homedashboard;

/**
 * Created by sami on 7/9/16.
 */
public class ForecastItem {

    private int mIconId, mTemperature, mTime;

    public ForecastItem(int iconId, int time) {
        this(iconId, time, 0);
    }

    public ForecastItem(int iconId, int time, int temperature) {
        mIconId = iconId;
        mTime = time;
        mTemperature = temperature;
    }


    public int getIconId() {
        return mIconId;
    }

    public int getTime() {
        return mTime;
    }

    public int getTemperature() {
        return mTemperature;
    }

    @Override
    public String toString() {
        return "time: " + mTime + " icon id: " + mIconId + " temperature: " + mTemperature;
    }
}


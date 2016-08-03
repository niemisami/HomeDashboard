package com.niemisami.homedashboard;

import android.support.v7.widget.RecyclerView;

/**
 * Created by sami on 8/2/16.
 */
public class ForecastItemViewHolder extends RecyclerView.ViewHolder {


    private static final String TAG = ForecastItemViewHolder.class.getSimpleName();
    private ForecastItemView mForecastItemView;

    public ForecastItemViewHolder(ForecastItemView forecastItemView) {
        super(forecastItemView);
        mForecastItemView = forecastItemView;
    }

    public void setTime(int time) {
        mForecastItemView.setTime(time);
    }

    public void setIconId(int iconId) {
        mForecastItemView.setIconId(iconId);
    }
}

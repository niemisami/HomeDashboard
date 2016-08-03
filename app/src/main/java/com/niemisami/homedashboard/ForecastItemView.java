package com.niemisami.homedashboard;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by sami on 8/2/16.
 */
public class ForecastItemView extends LinearLayout{

    public TextView mTimeView;
    public ImageView mWeatherIconView;

    public ForecastItemView(Context context) {
        this(context, null);
    }

    public ForecastItemView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ForecastItemView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        setupView();
    }

    private void setupView() {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.forecast_item, this);
        mTimeView = (TextView) view.findViewById(R.id.weather_time);
        mWeatherIconView = (ImageView) view.findViewById(R.id.weather_icon);

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(24, 0, 24, 0);
        setLayoutParams(layoutParams);
        setOrientation(VERTICAL);
        setGravity(Gravity.CENTER);
    }

    public void setTime(int time) {
        String formattedTime = String.format("%02d%n", time);
        mTimeView.setText(formattedTime);
    }
    public void setIconId(int iconId) {
        mWeatherIconView.setImageLevel(iconId);
    }

}

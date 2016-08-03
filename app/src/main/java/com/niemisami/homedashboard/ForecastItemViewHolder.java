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

    /* Wunderground api offers 24 different weather conditions
     *
     * fctcode 	Forecast: https://nihongo.wunderground.com/weather/api/d/docs?d=resources/phrase-glossary
     *    1	Clear
     *    2	Partly Cloudy
     *    3	Mostly Cloudy
     *    4	Cloudy
     *    5	Hazy
     *    6	Foggy
     *    7	Very Hot
     *    8	Very Cold
     *    9	Blowing Snow
     *    10 Chance of Showers
     *    11 Showers
     *    12 Chance of Rain
     *    13 Rain
     *    14 Chance of a Thunderstorm
     *    15 Thunderstorm
     *    16 Flurries
     *    17 OMITTED
     *    18 Chance of Snow Showers
     *    19 Snow Showers
     *    20 Chance of Snow
     *    21 Snow
     *    22 Chance of Ice Pellets
     *    23 Ice Pellets
     *    24 Blizzard
     **/
    public void setIconId(int iconId) {
        int iconLevel;
        switch (iconId) {
            case 1:
            case 7:
            case 8:
                iconLevel = 0; // Sunny
                break;
            case 2:
            case 3:
                iconLevel = 1; // Partly cloydy
                break;
            case 4:
            case 5:
            case 6:
                iconLevel = 2; // Cloud
                break;
            case 10:
            case 11:
            case 12:
                iconLevel = 3; // Rainy
                break;
            case 13:
                iconLevel = 4; // Pouring
                break;
            case 14:
            case 15:
                iconLevel = 5; // Lightning
                break;
            case 17:
                iconLevel = 8; // Night
                break;
            case 16:
            case 22:
            case 23:
                iconLevel = 6; // Hail
                break;
            case 9:
            case 18:
            case 19:
            case 20:
            case 21:
            case 24:
                iconLevel = 7; // Snowy
                break;
            default:
                iconLevel = 2;
        }
        mForecastItemView.setIconId(iconLevel);

    }
}

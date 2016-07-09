package com.niemisami.homedashboard;

import android.util.Log;

/**
 * Created by sami on 7/8/16.
 */
public class WeatherLocation {

    private String mCountry, mCity;

    public WeatherLocation(String country, String city) {
        mCountry = capitalize(country);
        mCity = capitalize(city);
    }

    public String getCountry() {
        return mCountry;
    }

    public String getCity() {
        return mCity;
    }

    private String capitalize(String word) {
        word = word.toLowerCase();
        return word.substring(0, 1).toUpperCase() + word.substring(1);

    }

    @Override
    public String toString() {
        return mCountry + ":" + mCity;
    }
}

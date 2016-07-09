package com.niemisami.homedashboard;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

/**
 * Created by sami on 7/9/16.
 */
public class WeatherHandler {

    private static final String TAG = WeatherHandler.class.getSimpleName();
    private WeatherInformationFetcher mWeatherInformationFetcher;

    public WeatherHandler() {
        mWeatherInformationFetcher = new WeatherInformationFetcher();

    }

    public void setLocation(WeatherLocation location) {
        mWeatherInformationFetcher.setLocation(location);
    }

    public JSONObject fetchOneDayForecast() {
        mWeatherInformationFetcher.setApiMethod("hourly");

        String response = "";
        try {
            response = mWeatherInformationFetcher.fetchForecast();
        } catch (IOException e) {
            Log.e(TAG, "fetchOneDayForecast: ", e);
        } catch (NullPointerException e) {
            Log.e(TAG, "fetchOneDayForecast: ", e);
        }

        return parseResponseToJSON(response);
    }

    private JSONObject parseResponseToJSON(String response) {
        try {
            return new JSONObject(response);
        } catch (JSONException e) {
            e.printStackTrace();
            return new JSONObject();
        }

    }
}

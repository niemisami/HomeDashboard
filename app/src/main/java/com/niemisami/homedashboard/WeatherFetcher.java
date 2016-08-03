package com.niemisami.homedashboard;

import android.util.Log;

import org.json.JSONObject;

import java.io.IOException;

/**
 * Created by sami on 7/9/16.
 */
public class WeatherFetcher {

    private static final String TAG = WeatherFetcher.class.getSimpleName();
    private WeatherInformationFetcher mWeatherInformationFetcher;

    public WeatherFetcher() {
        mWeatherInformationFetcher = new WeatherInformationFetcher();

    }

    public void setLocation(WeatherLocation location) {
        mWeatherInformationFetcher.setLocation(location);
    }

    public JSONObject fetchOneDayForecast() {
        mWeatherInformationFetcher.setApiMethod("hourly10day");
        return fetchForecastAsJSON();
    }

    private JSONObject fetchForecastAsJSON() {
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
        return JSONParser.parseStringToJSON(response);
    }
}

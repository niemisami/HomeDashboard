package com.niemisami.homedashboard;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by sami on 7/8/16.
 */
public class WeatherInformationFetcher {


    OkHttpClient mClient;
    private final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");

    //    http://api.wunderground.com/api/key/hourly/q/Finland/Turku.json
    private static final String WUNDERGROUND_BASE_URL = "http://api.wunderground.com/api/";
    private String mApiKey, mLocation, mUrl, mApiMethod;


    public WeatherInformationFetcher() {
        mClient = new OkHttpClient();
        mApiKey = MainActivity.W_API_KEY;
    }

    public void setmApiKey(String apiKey) {
        mApiKey = apiKey;
    }
    public void setLocation(WeatherLocation location) {
        mLocation = location.getCountry() + '/' + location.getCity();
    }

    public String fetchOneDayForecast() throws IOException {
        mApiMethod = "hourly";
        buildRequestUrl();
        System.out.println(mUrl);
        return fetchWeatherInformation();

    }

    private String buildRequestUrl() {
        return mUrl = WUNDERGROUND_BASE_URL + mApiKey + "/" + mApiMethod + "/q/" + mLocation + ".json";
    }

    private String fetchWeatherInformation() throws IOException {
        Request request = new Request.Builder()
                .url(mUrl)
                .build();

        Response response = mClient.newCall(request).execute();
        return response.body().string();
    }
}

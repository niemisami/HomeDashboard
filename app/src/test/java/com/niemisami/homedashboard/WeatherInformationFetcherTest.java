package com.niemisami.homedashboard;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by sami on 7/8/16.
 */

public class WeatherInformationFetcherTest{

    WeatherInformationFetcher fetcher;

    @Before
    public void init() {
        fetcher = new WeatherInformationFetcher();
        WeatherLocation location = new WeatherLocation("Finland", "Turku");
        fetcher.setLocation(location);
    }


}
package com.niemisami.homedashboard;

import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by sami on 7/9/16.
 */
public class WeatherHandlerTest {

    WeatherHandler handler;
    @Before
    public void init() {
        handler = new WeatherHandler();
        handler.setLocation(new WeatherLocation("Finland", "Turku"));

    }

    @Test
    public void testFetchOneDayForecast() throws Exception {
        JSONObject responseObject = handler.fetchOneDayForecast();
        assertEquals("{result:result}", responseObject.toString());
    }
}
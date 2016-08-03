package com.niemisami.homedashboard;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by sami on 8/3/16.
 */
public class JSONParserTest {

    WeatherFetcher handler;
    @Before
    public void init() {
        handler = new WeatherFetcher();
        handler.setLocation(new WeatherLocation("Finland", "Turku"));
    }


    @Test
    public void testParseJSONObjectToForecastItems() throws Exception {
    }

    @Test
    public void testParseJSONObjectToArray() throws Exception {

    }
}
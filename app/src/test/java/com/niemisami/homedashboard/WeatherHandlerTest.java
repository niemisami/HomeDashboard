package com.niemisami.homedashboard;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by sami on 7/9/16.
 */
public class WeatherHandlerTest {

    WeatherFetcher handler;

    @Before
    public void init() {
        handler = new WeatherFetcher();
        handler.setLocation(new WeatherLocation("Finland", "Turku"));
    }


    @Test
    public void testFetchOneDayForecast() throws Exception {
        JSONObject json = new JSONObject(" { \"response\": { \"version\":\"0.1\", \"termsofService\":\"http://www.wunderground.com/weather/api/d/terms.html\", \"features\": { \"hourly10day\": 1 } } , \"hourly_forecast\": [ { \"FCTTIME\": { \"hour\": \"12\",\"hour_padded\": \"12\",\"min\": \"00\",\"min_unpadded\": \"0\",\"sec\": \"0\",\"year\": \"2016\",\"mon\": \"7\",\"mon_padded\": \"07\",\"mon_abbrev\": \"Jul\",\"mday\": \"9\",\"mday_padded\": \"09\",\"yday\": \"190\",\"isdst\": \"1\",\"epoch\": \"1468054800\",\"pretty\": \"12:00 PM EEST on July 09, 2016\",\"civil\": \"12:00 PM\",\"month_name\": \"July\",\"month_name_abbrev\": \"Jul\",\"weekday_name\": \"Saturday\",\"weekday_name_night\": \"Saturday Night\",\"weekday_name_abbrev\": \"Sat\",\"weekday_name_unlang\": \"Saturday\",\"weekday_name_night_unlang\": \"Saturday Night\",\"ampm\": \"PM\",\"tz\": \"\",\"age\": \"\",\"UTCDATE\": \"\" }, \"temp\": {\"english\": \"70\", \"metric\": \"21\"}, \"dewpoint\": {\"english\": \"48\", \"metric\": \"9\"}, \"condition\": \"Clear\", \"icon\": \"clear\", \"icon_url\":\"http://icons.wxug.com/i/c/k/clear.gif\", \"fctcode\": \"1\", \"sky\": \"21\", \"wspd\": {\"english\": \"8\", \"metric\": \"13\"}, \"wdir\": {\"dir\": \"W\", \"degrees\": \"268\"}, \"wx\": \"Mostly Sunny\", \"uvi\": \"5\", \"humidity\": \"46\", \"windchill\": {\"english\": \"-9999\", \"metric\": \"-9999\"}, \"heatindex\": {\"english\": \"-9999\", \"metric\": \"-9999\"}, \"feelslike\": {\"english\": \"70\", \"metric\": \"21\"}, \"qpf\": {\"english\": \"0.0\", \"metric\": \"0\"}, \"snow\": {\"english\": \"0.0\", \"metric\": \"0\"}, \"pop\": \"0\", \"mslp\": {\"english\": \"29.66\", \"metric\": \"1004\"} } , { \"FCTTIME\": { \"hour\": \"12\",\"hour_padded\": \"12\",\"min\": \"00\",\"min_unpadded\": \"0\",\"sec\": \"0\",\"year\": \"2016\",\"mon\": \"7\",\"mon_padded\": \"07\",\"mon_abbrev\": \"Jul\",\"mday\": \"9\",\"mday_padded\": \"09\",\"yday\": \"190\",\"isdst\": \"1\",\"epoch\": \"1468054800\",\"pretty\": \"12:00 PM EEST on July 09, 2016\",\"civil\": \"12:00 PM\",\"month_name\": \"July\",\"month_name_abbrev\": \"Jul\",\"weekday_name\": \"Saturday\",\"weekday_name_night\": \"Saturday Night\",\"weekday_name_abbrev\": \"Sat\",\"weekday_name_unlang\": \"Saturday\",\"weekday_name_night_unlang\": \"Saturday Night\",\"ampm\": \"PM\",\"tz\": \"\",\"age\": \"\",\"UTCDATE\": \"\" }, \"temp\": {\"english\": \"70\", \"metric\": \"21\"}, \"dewpoint\": {\"english\": \"48\", \"metric\": \"9\"}, \"condition\": \"Clear\", \"icon\": \"clear\", \"icon_url\":\"http://icons.wxug.com/i/c/k/clear.gif\", \"fctcode\": \"1\", \"sky\": \"21\", \"wspd\": {\"english\": \"8\", \"metric\": \"13\"}, \"wdir\": {\"dir\": \"W\", \"degrees\": \"268\"}, \"wx\": \"Mostly Sunny\", \"uvi\": \"5\", \"humidity\": \"46\", \"windchill\": {\"english\": \"-9999\", \"metric\": \"-9999\"}, \"heatindex\": {\"english\": \"-9999\", \"metric\": \"-9999\"}, \"feelslike\": {\"english\": \"70\", \"metric\": \"21\"}, \"qpf\": {\"english\": \"0.0\", \"metric\": \"0\"}, \"snow\": {\"english\": \"0.0\", \"metric\": \"0\"}, \"pop\": \"0\", \"mslp\": {\"english\": \"29.66\", \"metric\": \"1004\"} } ] } ");

//        JSONObject responseObject = handler.fetchOneDayForecast();
//        System.out.println(responseObject.toString());
        JSONArray result = JSONParser.parseJSONObjectToArray("hourly_forecast", json);
        assertEquals("{result:result}", result.toString());
    }

    @Test
    public void testParseForecastItem() throws Exception {
//        JSONObject json = new JSONObject(" { \"response\": { \"version\":\"0.1\", \"termsofService\":\"http://www.wunderground.com/weather/api/d/terms.html\", \"features\": { \"hourly10day\": 1 } } , \"hourly_forecast\": [ { \"FCTTIME\": { \"hour\": \"12\",\"hour_padded\": \"12\",\"min\": \"00\",\"min_unpadded\": \"0\",\"sec\": \"0\",\"year\": \"2016\",\"mon\": \"7\",\"mon_padded\": \"07\",\"mon_abbrev\": \"Jul\",\"mday\": \"9\",\"mday_padded\": \"09\",\"yday\": \"190\",\"isdst\": \"1\",\"epoch\": \"1468054800\",\"pretty\": \"12:00 PM EEST on July 09, 2016\",\"civil\": \"12:00 PM\",\"month_name\": \"July\",\"month_name_abbrev\": \"Jul\",\"weekday_name\": \"Saturday\",\"weekday_name_night\": \"Saturday Night\",\"weekday_name_abbrev\": \"Sat\",\"weekday_name_unlang\": \"Saturday\",\"weekday_name_night_unlang\": \"Saturday Night\",\"ampm\": \"PM\",\"tz\": \"\",\"age\": \"\",\"UTCDATE\": \"\" }, \"temp\": {\"english\": \"70\", \"metric\": \"21\"}, \"dewpoint\": {\"english\": \"48\", \"metric\": \"9\"}, \"condition\": \"Clear\", \"icon\": \"clear\", \"icon_url\":\"http://icons.wxug.com/i/c/k/clear.gif\", \"fctcode\": \"1\", \"sky\": \"21\", \"wspd\": {\"english\": \"8\", \"metric\": \"13\"}, \"wdir\": {\"dir\": \"W\", \"degrees\": \"268\"}, \"wx\": \"Mostly Sunny\", \"uvi\": \"5\", \"humidity\": \"46\", \"windchill\": {\"english\": \"-9999\", \"metric\": \"-9999\"}, \"heatindex\": {\"english\": \"-9999\", \"metric\": \"-9999\"}, \"feelslike\": {\"english\": \"70\", \"metric\": \"21\"}, \"qpf\": {\"english\": \"0.0\", \"metric\": \"0\"}, \"snow\": {\"english\": \"0.0\", \"metric\": \"0\"}, \"pop\": \"0\", \"mslp\": {\"english\": \"29.66\", \"metric\": \"1004\"} } , { \"FCTTIME\": { \"hour\": \"12\",\"hour_padded\": \"12\",\"min\": \"00\",\"min_unpadded\": \"0\",\"sec\": \"0\",\"year\": \"2016\",\"mon\": \"7\",\"mon_padded\": \"07\",\"mon_abbrev\": \"Jul\",\"mday\": \"9\",\"mday_padded\": \"09\",\"yday\": \"190\",\"isdst\": \"1\",\"epoch\": \"1468054800\",\"pretty\": \"12:00 PM EEST on July 09, 2016\",\"civil\": \"12:00 PM\",\"month_name\": \"July\",\"month_name_abbrev\": \"Jul\",\"weekday_name\": \"Saturday\",\"weekday_name_night\": \"Saturday Night\",\"weekday_name_abbrev\": \"Sat\",\"weekday_name_unlang\": \"Saturday\",\"weekday_name_night_unlang\": \"Saturday Night\",\"ampm\": \"PM\",\"tz\": \"\",\"age\": \"\",\"UTCDATE\": \"\" }, \"temp\": {\"english\": \"70\", \"metric\": \"21\"}, \"dewpoint\": {\"english\": \"48\", \"metric\": \"9\"}, \"condition\": \"Clear\", \"icon\": \"clear\", \"icon_url\":\"http://icons.wxug.com/i/c/k/clear.gif\", \"fctcode\": \"1\", \"sky\": \"21\", \"wspd\": {\"english\": \"8\", \"metric\": \"13\"}, \"wdir\": {\"dir\": \"W\", \"degrees\": \"268\"}, \"wx\": \"Mostly Sunny\", \"uvi\": \"5\", \"humidity\": \"46\", \"windchill\": {\"english\": \"-9999\", \"metric\": \"-9999\"}, \"heatindex\": {\"english\": \"-9999\", \"metric\": \"-9999\"}, \"feelslike\": {\"english\": \"70\", \"metric\": \"21\"}, \"qpf\": {\"english\": \"0.0\", \"metric\": \"0\"}, \"snow\": {\"english\": \"0.0\", \"metric\": \"0\"}, \"pop\": \"0\", \"mslp\": {\"english\": \"29.66\", \"metric\": \"1004\"} } ] } ");
//        ForecastItem[] items = JSONParser.parseJSONObjectToForecastItems(json);
        JSONObject responseObject = handler.fetchOneDayForecast();
        ForecastItem[] items = JSONParser.parseJSONObjectToForecastItems(responseObject);

        for (ForecastItem item : items) {
            System.out.println(item);
        }
        assertEquals("time: 15 icon id: 1 temperature: 21", items[0].toString());

    }
}
package com.niemisami.homedashboard;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by sami on 7/9/16.
 */
public class JSONParser {


    /*
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
    *    10	Chance of Showers
    *    11	Showers
    *    12	Chance of Rain
    *    13	Rain
    *    14	Chance of a Thunderstorm
    *    15	Thunderstorm
    *    16	Flurries
    *    17	OMITTED
    *    18	Chance of Snow Showers
    *    19	Snow Showers
    *    20	Chance of Snow
    *    21	Snow
    *    22	Chace of Ice Pellets
    *    23	Ice Pellets
    *    24	Blizzard	*/

    public static JSONObject parseStringToJSON(String jsonString) {
        try {
            return new JSONObject(jsonString);
        } catch (JSONException e) {
            e.printStackTrace();
            return new JSONObject();
        }
    }
}

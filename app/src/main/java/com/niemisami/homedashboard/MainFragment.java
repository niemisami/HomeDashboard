package com.niemisami.homedashboard;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {

    private static final String TAG = MainFragment.class.getSimpleName();

    private Button mStartButton;

    private JSONObject mWundergroundWeatherForecast;

    public MainFragment() {
    }


    ////////FRAGMENT LIFECYCLE METHODS//////
//    region

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        initViews(view);

        if (mForecastItems.length == 0) {
            new WeatherFetcherTask().execute();
        } else {
            Log.d(TAG, "onPostExecute: " + mWundergroundWeatherForecast.toString());
        }

        return view;
    }

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private ForecastItem[] mForecastItems;


    private void initViews(View view) {
        initForecastRecyclerView(view);
    }

    private void initForecastRecyclerView(View view) {

//        mForecastItems = new ForecastItem[]{new ForecastItem(0, 12), new ForecastItem(1, 15), new ForecastItem(2, 21), new ForecastItem(3, 00), new ForecastItem(4, 03), new ForecastItem(5, 06)};

        Log.d(TAG, "initForecastRecyclerView: ");

        mRecyclerView = (RecyclerView) view.findViewById(R.id.forecast_recycler_view);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        setRetainInstance(true);
        mForecastItems = new ForecastItem[]{};
        mAdapter = new ForecastItemAdapter(getActivity());
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

//    endregion


    private class WeatherFetcherTask extends AsyncTask<Void, Void, JSONObject> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }

        @Override
        protected void onPostExecute(JSONObject jsonObject) {
            mWundergroundWeatherForecast = jsonObject;
            new WeatherResponseParserTask().execute(mWundergroundWeatherForecast);
        }

        @Override
        protected JSONObject doInBackground(Void... params) {
            WeatherFetcher weatherFetcher = new WeatherFetcher();
            weatherFetcher.setLocation(new WeatherLocation("Finland", "Turku"));
            return weatherFetcher.fetchOneDayForecast();
        }
    }

    private class WeatherResponseParserTask extends AsyncTask<JSONObject, Void, ForecastItem[]> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(ForecastItem[] items) {
//            mForecastItems = new ForecastItem[6];
//            System.arraycopy(items, 0, mForecastItems, 0, 6);
            mForecastItems = items;
            refreshForecastView();
        }

        @Override
        protected ForecastItem[] doInBackground(JSONObject... params) {
            try {
                return JSONParser.parseJSONObjectToForecastItems(params[0]);
            } catch (JSONException e) {
                Toast.makeText(getActivity().getApplicationContext(), "Error parsing forecast", Toast.LENGTH_SHORT)
                        .show();
                Log.e(TAG, "doInBackground: ", e);
            }

            return new ForecastItem[0];
        }
    }

    private void refreshForecastView() {
        Log.d(TAG, "refreshForecastView: ");
        ((ForecastItemAdapter) mAdapter).setForecastItems(mForecastItems);
    }
}

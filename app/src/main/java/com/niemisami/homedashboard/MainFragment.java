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

        if (mWundergroundWeatherForecast == null) {
            new WeatherFetcherTask().execute();
        } else {
            Log.d(TAG, "onPostExecute: " + mWundergroundWeatherForecast.toString());
        }

        return view;
    }

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ForecastItem[] mForecastItems;


    private void initViews(View view) {

        initForecastRecyclerView(view);
    }

    private void initForecastRecyclerView(View view) {

        mForecastItems = new ForecastItem[]{new ForecastItem(0, "12"), new ForecastItem(1, "15"), new ForecastItem(2, "21"), new ForecastItem(3, "00"), new ForecastItem(4, "03"), new ForecastItem(5, "06")};


        mRecyclerView = (RecyclerView) view.findViewById(R.id.forecast_recycler_view);
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new ForecastItemAdapter(mForecastItems);


        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        setRetainInstance(true);
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
        }

        @Override
        protected JSONObject doInBackground(Void... params) {
            WeatherHandler weatherHandler = new WeatherHandler();
            weatherHandler.setLocation(new WeatherLocation("Finland", "Turku"));
            return weatherHandler.fetchOneDayForecast();
        }
    }
}

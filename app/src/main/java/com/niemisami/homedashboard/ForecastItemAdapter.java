package com.niemisami.homedashboard;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by sami on 7/9/16.
 */
public class ForecastItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private ForecastItem[] mForecastItems;

    public ForecastItemAdapter(ForecastItem[] forecastItems) {
        mForecastItems = forecastItems;
    }

    @Override
    public ForecastItemViewHolder onCreateViewHolder(ViewGroup parent,
                                                             int viewType) {
        ForecastItemView forecastItemView = new ForecastItemView(parent.getContext());
        return new ForecastItemViewHolder(forecastItemView);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ForecastItemViewHolder forecastItemViewHolder = (ForecastItemViewHolder) holder;
        forecastItemViewHolder.setIconId(mForecastItems[position].getIconId());
        forecastItemViewHolder.setTime(mForecastItems[position].getTime());
    }

    @Override
    public int getItemCount() {
        return mForecastItems.length;
    }
}



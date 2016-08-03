package com.niemisami.homedashboard;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.math.MathContext;

/**
 * Created by sami on 7/9/16.
 */
public class ForecastItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public static final String TAG = ForecastItemAdapter.class.getSimpleName();

    private Activity mContext;
    private ForecastItem[] mForecastItems;

    public ForecastItemAdapter(Activity context) {
        mContext = context;
    }

    public void setForecastItems(ForecastItem[] newItems) {
        mForecastItems = new ForecastItem[6];
        mForecastItems[0] = newItems[0];
        int newIndex = 1;
        for (int i = 1; i<15; i++) {
            if(newItems[i].getTime() % 3 == 0) {
                Log.d(TAG, "setForecastItems: " + newIndex + " " + newItems[i].getTime());
                mForecastItems[newIndex] = newItems[i];
                newIndex++;
            }
        }
//        mForecastItems = newItems;
        notifyDataSetChanged();
    }

    @Override
    public ForecastItemViewHolder onCreateViewHolder(ViewGroup parent,
                                                             int viewType) {
        ForecastItemView forecastItemView = new ForecastItemView(mContext);
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
        if (mForecastItems == null) {
            return 0;
        }
        return mForecastItems.length;
    }
}



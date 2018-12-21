package com.example.android.quakereport;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.List;

public class QuakeLoader extends AsyncTaskLoader<List<Quake>>{

    private static final String LOG_TAG = QuakeLoader.class.getName();

    private String mUrl;

    public QuakeLoader(Context context, String url){
        super(context);
        this.mUrl = url;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public List<Quake> loadInBackground() {
        if(mUrl == null){
            return null;
        }

        List<Quake> earthqQuakes  = QueryUtils.fetchEarthquakeData(mUrl);

        return earthqQuakes;
    }
}

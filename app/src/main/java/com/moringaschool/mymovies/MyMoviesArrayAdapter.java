package com.moringaschool.mymovies;

import android.content.Context;
import android.widget.ArrayAdapter;

public class MyMoviesArrayAdapter extends ArrayAdapter {
    private Context mContext;
    private String[] mMovies;
    private String[] mGenres;

    public MyMoviesArrayAdapter(Context mContext, int resource, String[] mMovies, String[] mGenres) {
        super(mContext, resource);
        this.mContext = mContext;
        this.mMovies = mMovies;
        this.mGenres = mGenres;
    }

    @Override
    public Object getItem(int position) {
        String movie = mMovies[position];
        String genre = mGenres[position];
        return String.format("%s \nEnjoy a great: %s", movie, genre);
    }

    @Override
    public int getCount() {
        return mMovies.length;
    }
}

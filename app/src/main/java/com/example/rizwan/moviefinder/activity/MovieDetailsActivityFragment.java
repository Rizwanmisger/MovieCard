package com.example.rizwan.moviefinder.activity;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rizwan.moviefinder.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class MovieDetailsActivityFragment extends Fragment {

    public MovieDetailsActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_movie_details, container, false);
    }
}

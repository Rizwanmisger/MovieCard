package com.example.rizwan.moviefinder.fragment;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rizwan.moviefinder.R;
import com.example.rizwan.moviefinder.adapter.MovieAdapter;
import com.example.rizwan.moviefinder.model.Movie;
import com.example.rizwan.moviefinder.model.MovieResponse;
import com.example.rizwan.moviefinder.network.ApiClient;
import com.example.rizwan.moviefinder.network.ApiInterface;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LatestMoviesFragment extends Fragment {

    private final static String API_KEY = "c7bbf452e855ca0f0107b7c22a7652da";
    MovieAdapter adapter;
    RecyclerView recyclerView;
    ArrayList<Movie> movies = new ArrayList<Movie>();



    public LatestMoviesFragment() {
        // Required empty public constructor
    }





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_latest_movies, container, false);

        final ProgressDialog progressDialog = new ProgressDialog(this.getActivity());
        progressDialog.setMessage("Loading...");
        progressDialog.show();


        adapter = new MovieAdapter(movies);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view_now_playing);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        if(recyclerView == null)
        {
            //recyclerView.setLayoutManager(mLayoutManager);
            Log.v("list null", "yes");
        }
        recyclerView.setLayoutManager(mLayoutManager);
        
        recyclerView.setAdapter(adapter);


        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<MovieResponse> call = apiService.getNowPlayingMovies(API_KEY);
        call.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse>call, Response<MovieResponse> response) {
                progressDialog.hide();
                Log.v("created ", "latest");
                movies.addAll(response.body().getResults());
                adapter.notifyDataSetChanged();

                Log.v("Success", "Number of movies received: " + movies.size());
            }

            @Override
            public void onFailure(Call<MovieResponse>call, Throwable t) {
                // Log error here since request failed
                Log.v("Failure", t.toString());
            }
        });

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
    }


}


package com.example.rizwan.moviefinder.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rizwan.moviefinder.R;
import com.example.rizwan.moviefinder.adapter.TvAdapter;
import com.example.rizwan.moviefinder.model.TvShow;
import com.example.rizwan.moviefinder.model.TvShowResponse;
import com.example.rizwan.moviefinder.network.ApiClient;
import com.example.rizwan.moviefinder.network.ApiInterface;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class TopRatedTvShowsFragment extends Fragment {

    private final static String API_KEY = "c7bbf452e855ca0f0107b7c22a7652da";
    TvAdapter adapter;
    RecyclerView recyclerView;
    ArrayList<TvShow> tvShows = new ArrayList<TvShow>();


    public TopRatedTvShowsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_top_rated_tv_shows, container, false);

        adapter = new TvAdapter(tvShows);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view_top_rated_tv);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        if(recyclerView == null)
        {
            //recyclerView.setLayoutManager(mLayoutManager);
            Log.v("list null", "yes");
        }
        recyclerView.setLayoutManager(mLayoutManager);

        recyclerView.setAdapter(adapter);

        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<TvShowResponse> call = apiService.getTopRatedTV(API_KEY);
        call.enqueue(new Callback<TvShowResponse>() {
            @Override
            public void onResponse(Call<TvShowResponse> call, Response<TvShowResponse> response) {

                Log.v("created ", "latest");
                tvShows.addAll(response.body().getResults());
                adapter.notifyDataSetChanged();

                Log.v("Success", "Number of movies received: " + tvShows.size());
            }

            @Override
            public void onFailure(Call<TvShowResponse> call, Throwable t) {
                // Log error here since request failed
                Log.v("Failure", t.toString());
            }
        });

        return view;
    }





}

package com.example.rizwan.moviefinder.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;

import com.example.rizwan.moviefinder.R;
import com.example.rizwan.moviefinder.adapter.MovieCastAdapter;
import com.example.rizwan.moviefinder.adapter.MovieReviewAdapter;
import com.example.rizwan.moviefinder.model.MovieCast;
import com.example.rizwan.moviefinder.model.MovieCastResponse;
import com.example.rizwan.moviefinder.model.MovieResponse;
import com.example.rizwan.moviefinder.model.MovieReview;
import com.example.rizwan.moviefinder.model.MovieReviewResponse;
import com.example.rizwan.moviefinder.model.Video;
import com.example.rizwan.moviefinder.model.VideoResponse;
import com.example.rizwan.moviefinder.network.ApiClient;
import com.example.rizwan.moviefinder.network.ApiInterface;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieDetailsActivity  extends YouTubeBaseActivity  implements
        YouTubePlayer.OnInitializedListener {

    MovieDetailsActivity activity = this;
    private final static String API_KEY = "c7bbf452e855ca0f0107b7c22a7652da";
    YouTubePlayerView youTubeView;
    int movieId;
    String videoKey;

    RecyclerView recyclerView;
    ArrayList<MovieCast> movieCastList = new ArrayList<MovieCast>();
    MovieCastAdapter movieCastAdapter;

    RecyclerView reviewRecyclerView;
    ArrayList<MovieReview> movieReviewsList = new ArrayList<>();
    MovieReviewAdapter movieReviewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = this.getIntent();
        movieId = intent.getIntExtra("movieId", 0);
        Log.v("movieId=========", new Integer(movieId).toString());
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_movie_details);

        youTubeView = (YouTubePlayerView) findViewById(R.id.youtube_view);
        loadVideo(movieId);

        movieCastAdapter = new MovieCastAdapter(movieCastList);
        recyclerView = (RecyclerView)findViewById(R.id.recycler_view_movie_cast);
        LinearLayoutManager layoutManager
                = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(movieCastAdapter);
        loadCast(movieId);

        movieReviewAdapter = new MovieReviewAdapter(movieReviewsList);
        reviewRecyclerView = (RecyclerView) findViewById(R.id.recycler_view_movie_review);
        LinearLayoutManager reviewLayoutManager
                = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        reviewRecyclerView.setLayoutManager(reviewLayoutManager);
        reviewRecyclerView.setAdapter(movieReviewAdapter);
        loadReviews(movieId);

    }





    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer player, boolean wasRestored) {
        if (!wasRestored) {

            // loadVideo() will auto play video
            // Use cueVideo() method, if you don't want to play it automatically
         //   player.loadVideo("_oEA18Y8gM0");
            player.cueVideo(videoKey);
            Log.v("cueVideo=== " , videoKey);
            // Hiding player controls
          //  player.setPlayerStyle(YouTubePlayer.PlayerStyle.CHROMELESS);
        }
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1) {
            // Retry initialization if user performed a recovery action
            getYouTubePlayerProvider().initialize("AIzaSyAVndwRSm1ImobzFfYwzKxyRmzLJFYis5k", this);
        }
    }

    private YouTubePlayer.Provider getYouTubePlayerProvider() {
        return (YouTubePlayerView) findViewById(R.id.youtube_view);
    }

    void loadVideo(int id)
    {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<VideoResponse> call = apiService.getMovieVideo(movieId,API_KEY);
        call.enqueue(new Callback<VideoResponse>() {
            @Override
            public void onResponse(Call<VideoResponse>call, Response<VideoResponse> response) {
                ArrayList<Video> videos = new ArrayList<Video>();
                Log.v("created ", "latest");
                videos.addAll(response.body().getResults());
                videoKey = getVideoKey(videos);
                Log.v("retrofit===key==" , videoKey);
                youTubeView.initialize("AIzaSyAVndwRSm1ImobzFfYwzKxyRmzLJFYis5k", activity);

                Log.v("Success", "Number of movies received: " + videos.size());
            }

            @Override
            public void onFailure(Call<VideoResponse>call, Throwable t) {
                // Log error here since request failed
                Log.v("Failure", t.toString());
            }
        });
    }
    String getVideoKey(ArrayList<Video> videosList)
    {
        Video video ;
        String key = "";
        for(int i = 0; i < videosList.size() ; i++)
        {
            video = videosList.get(i);
            if(video.getType().contains("Trailer"))
            {
                key = video.getKey();
                break;
            }

        }
        Log.v("getVideokey=== ", key);
        return key;
    }

    void loadCast(int movieId)
    {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<MovieCastResponse> call = apiService.getMovieCast(movieId, API_KEY);
        call.enqueue(new Callback<MovieCastResponse>() {
            @Override
            public void onResponse(Call<MovieCastResponse> call, Response<MovieCastResponse> response) {

                Log.v("created ", "latest");
                movieCastList.addAll(response.body().getCast());
                movieCastAdapter.notifyDataSetChanged();

                Log.v("Success", "Number of movies received: " + movieCastList.size());
            }

            @Override
            public void onFailure(Call<MovieCastResponse> call, Throwable t) {
                // Log error here since request failed
                Log.v("Failure", t.toString());
            }
        });
    }

    void loadReviews(int movieId)
    {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<MovieReviewResponse> call = apiService.getMovieReviews(movieId, API_KEY);
        call.enqueue(new Callback<MovieReviewResponse>() {
            @Override
            public void onResponse(Call<MovieReviewResponse>call, Response<MovieReviewResponse> response) {

                Log.v("created ", "latest");
                movieReviewsList.addAll(response.body().getResults());
                movieReviewAdapter.notifyDataSetChanged();

                Log.v("Success", "Number of movies received: " + movieReviewsList.size());
            }

            @Override
            public void onFailure(Call<MovieReviewResponse>call, Throwable t) {
                // Log error here since request failed
                Log.v("Failure", t.toString());
            }
        });
    }
}

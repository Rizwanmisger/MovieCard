package com.example.rizwan.moviefinder.network;

import com.example.rizwan.moviefinder.model.MovieCastResponse;
import com.example.rizwan.moviefinder.model.MovieResponse;
import com.example.rizwan.moviefinder.model.MovieReview;
import com.example.rizwan.moviefinder.model.MovieReviewResponse;
import com.example.rizwan.moviefinder.model.TvShowResponse;
import com.example.rizwan.moviefinder.model.VideoResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by rizwan on 18/2/17.
 */
public interface ApiInterface {

    @GET("movie/top_rated")
    Call<MovieResponse> getTopRatedMovies(@Query("api_key") String apiKey);

    @GET("movie/now_playing")
    Call<MovieResponse> getNowPlayingMovies(@Query("api_key") String apiKey);

    @GET("movie/{id}")
    Call<MovieResponse> getMovieDetails(@Path("id") int id, @Query("api_key") String apiKey);


    @GET("movie/{id}/videos")
    Call<VideoResponse> getMovieVideo(@Path("id") int id, @Query("api_key") String apiKey);

    @GET("tv/on_the_air")
    Call<TvShowResponse> getNowPlayingTV(@Query("api_key") String apiKey);

    @GET("tv/top_rated")
    Call<TvShowResponse> getTopRatedTV(@Query("api_key") String apiKey);

    @GET("movie/{id}/casts")
    Call<MovieCastResponse> getMovieCast(@Path("id") int id, @Query("api_key") String apiKey);

    @GET("movie/{id}/reviews")
    Call<MovieReviewResponse> getMovieReviews(@Path("id") int id, @Query("api_key") String apiKey);

    @GET("tv/{id}/videos")
    Call<VideoResponse> getTvVideo(@Path("id") int id, @Query("api_key") String apiKey);

    @GET("tv/{id}/casts")
    Call<MovieCastResponse> getTvCast(@Path("id") int id, @Query("api_key") String apiKey);

    @GET("tv/{id}/reviews")
    Call<MovieReviewResponse> getTvReviews(@Path("id") int id, @Query("api_key") String apiKey);
}



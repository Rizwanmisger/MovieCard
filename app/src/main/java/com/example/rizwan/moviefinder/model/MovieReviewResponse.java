package com.example.rizwan.moviefinder.model;

import java.util.List;

/**
 * Created by rizwan on 26/3/17.
 */
public class MovieReviewResponse {

    List<MovieReview> results;

    public MovieReviewResponse(List<MovieReview> results) {
        this.results = results;
    }

    public List<MovieReview> getResults() {
        return results;
    }

    public void setResults(List<MovieReview> results) {
        this.results = results;
    }
}

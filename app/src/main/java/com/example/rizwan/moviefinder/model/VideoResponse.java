package com.example.rizwan.moviefinder.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by rizwan on 18/3/17.
 */
public class VideoResponse {

    @SerializedName("id")
    String id;
    @SerializedName("results")
    List<Video> results;

    public VideoResponse(String id, List<Video> results) {
        this.id = id;
        this.results = results;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Video> getResults() {
        return results;
    }

    public void setResults(List<Video> results) {
        this.results = results;
    }
}

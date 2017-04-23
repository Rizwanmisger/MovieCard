package com.example.rizwan.moviefinder.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by rizwan on 19/3/17.
 */
public class TvShowResponse {
    @SerializedName("page")
    int page;
    @SerializedName("results")
    List<TvShow> results;
    @SerializedName("total_results")
    int totalResults;
    @SerializedName("total_pages")
    int totalPages;

    public TvShowResponse(int page, List<TvShow> results, int totalResults, int totalPages) {
        this.page = page;
        this.results = results;
        this.totalResults = totalResults;
        this.totalPages = totalPages;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public List<TvShow> getResults() {
        return results;
    }

    public void setResults(List<TvShow> results) {
        this.results = results;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }
}

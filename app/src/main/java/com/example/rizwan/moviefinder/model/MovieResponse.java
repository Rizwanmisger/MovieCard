package com.example.rizwan.moviefinder.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by rizwan on 18/2/17.
 */
public class MovieResponse {
    public MovieResponse(Integer page, List<Movie> results, Integer totalResults, Integer totalPages) {
        this.page = page;
        this.results = results;
        this.totalResults = totalResults;
        this.totalPages = totalPages;
    }

    @SerializedName("page")
    Integer page;
    @SerializedName("results")
    List<Movie> results;
    @SerializedName("total_results")
    Integer totalResults;
    @SerializedName("total_pages")
    Integer totalPages;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public List<Movie> getResults() {
        return results;
    }

    public void setResults(List<Movie> results) {
        this.results = results;
    }

    public Integer getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(Integer totalResults) {
        this.totalResults = totalResults;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }
}

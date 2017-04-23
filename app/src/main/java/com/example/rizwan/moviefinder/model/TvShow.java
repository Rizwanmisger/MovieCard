package com.example.rizwan.moviefinder.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by rizwan on 19/3/17.
 */
public class TvShow {
    @SerializedName("id")
    Integer id;
    @SerializedName("original_name")
    String name;
    @SerializedName("poster_path")
    String posterPath;
    @SerializedName("genre_ids")
    Integer genreIds[];
    @SerializedName("vote_average")
    String voteAverage;
    @SerializedName("first_air_date")
    String releaseDate;
    @SerializedName("overview")
    String overview;

    public TvShow(Integer[] genreIds, Integer id, String name, String posterPath, String voteAverage, String releasedate, String overview) {
        this.genreIds = genreIds;
        this.id = id;
        this.name = name;
        this.posterPath = posterPath;
        this.voteAverage = voteAverage;
        this.releaseDate = releasedate;
        this.overview = overview;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public Integer[] getGenreIds() {
        return genreIds;
    }

    public void setGenreIds(Integer[] genreIds) {
        this.genreIds = genreIds;
    }

    public String getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(String voteAverage) {
        this.voteAverage = voteAverage;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }
}

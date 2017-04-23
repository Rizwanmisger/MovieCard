package com.example.rizwan.moviefinder.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by rizwan on 26/3/17.
 */
public class MovieCastResponse {
    @SerializedName("id")
    int id;
    @SerializedName("cast")
    List<MovieCast> cast;
    @SerializedName("crew")
    List<MovieCrew> crew;

    public MovieCastResponse(int id, List<MovieCast> cast, List<MovieCrew> crew) {
        this.id = id;
        this.cast = cast;
        this.crew = crew;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<MovieCast> getCast() {
        return cast;
    }

    public void setCast(List<MovieCast> cast) {
        this.cast = cast;
    }

    public List<MovieCrew> getCrew() {
        return crew;
    }

    public void setCrew(List<MovieCrew> crew) {
        this.crew = crew;
    }
}

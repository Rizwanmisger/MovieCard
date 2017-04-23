package com.example.rizwan.moviefinder.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by rizwan on 26/3/17.
 */
public class MovieCast {
    @SerializedName("cast_id")
    String cast_id;
    @SerializedName("id")
    String id;
    @SerializedName("character")
    String character;
    @SerializedName("name")
    String name;
    @SerializedName("profile_path")
    String profile_path;

    public MovieCast(String cast_id, String character, String name, String profile_path, String id) {
        this.cast_id = cast_id;
        this.character = character;
        this.name = name;
        this.profile_path = profile_path;
        this.id = id;

    }

    public String getCast_id() {
        return cast_id;
    }

    public void setCast_id(String cast_id) {
        this.cast_id = cast_id;
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfile_path() {
        return profile_path;
    }

    public void setProfile_path(String profile_path) {
        this.profile_path = profile_path;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

package com.example.rizwan.moviefinder.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by rizwan on 18/3/17.
 */
public class Video {

    @SerializedName("id")
    String id;
    @SerializedName("site")
    String site;
    @SerializedName("key")
    String key;
    @SerializedName("type")
    String type;

    public Video(String id, String site, String key, String type) {
        this.id = id;
        this.site = site;
        this.key = key;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

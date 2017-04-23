package com.example.rizwan.moviefinder.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by rizwan on 26/3/17.
 */
public class MovieReview {
    @SerializedName("author")
    String author;
    @SerializedName("content")
    String content;

    public MovieReview(String author, String content) {
        this.author = author;
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

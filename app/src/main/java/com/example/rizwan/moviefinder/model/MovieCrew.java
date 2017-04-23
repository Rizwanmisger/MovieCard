package com.example.rizwan.moviefinder.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by rizwan on 26/3/17.
 */
public class MovieCrew {
    @SerializedName("credit_id")
    String credit_id;
    @SerializedName("id")
    String id;
    @SerializedName("department")
    String department;
    @SerializedName("job")
    String job;
    @SerializedName("name")
    String name;
    @SerializedName("profile_path")
    String profile_path;

    public MovieCrew(String credit_id, String id, String department, String job, String name, String profile_path) {
        this.credit_id = credit_id;
        this.id = id;
        this.department = department;
        this.job = job;
        this.name = name;
        this.profile_path = profile_path;
    }

    public String getCredit_id() {
        return credit_id;
    }

    public void setCredit_id(String credit_id) {
        this.credit_id = credit_id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
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
}

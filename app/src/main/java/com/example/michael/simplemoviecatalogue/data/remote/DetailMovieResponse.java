package com.example.michael.simplemoviecatalogue.data.remote;

import com.google.gson.annotations.SerializedName;

public class DetailMovieResponse {

    @SerializedName("id") private Integer id;

    @SerializedName("original_title") private String originalTitle;

    @SerializedName("poster_path") private String posterPath;

    @SerializedName("overview") private String overview;

    @SerializedName("vote_count") private Integer voteCount;

    @SerializedName("vote_average") private Float voteAverage;

    @SerializedName("release_date") private String releaseDate;

    public DetailMovieResponse(Integer id, String originalTitle, String posterPath, String overview, Integer voteCount, Float voteAverage, String releaseDate) {
        this.id = id;
        this.originalTitle = originalTitle;
        this.posterPath = posterPath;
        this.overview = overview;
        this.voteCount = voteCount;
        this.voteAverage = voteAverage;
        this.releaseDate = releaseDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public Integer getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(Integer voteCount) {
        this.voteCount = voteCount;
    }

    public Float getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(Float voteAverage) {
        this.voteAverage = voteAverage;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }
}

package com.example.michael.simplemoviecatalogue.data.dto;

import org.parceler.Parcel;
import org.parceler.ParcelConstructor;

@Parcel(Parcel.Serialization.BEAN)
public class MovieIndex {

    private String posterPath;
    private String genre;
    private String title;
    private Float rating;
    private String releaseDate;
    private String overview;

    @ParcelConstructor
    public MovieIndex(String posterPath, String genre, String title, Float rating, String releaseDate, String overview) {
        this.posterPath = posterPath;
        this.genre = genre;
        this.title = title;
        this.rating = rating;
        this.releaseDate = releaseDate;
        this.overview = overview;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
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

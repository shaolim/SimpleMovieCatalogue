package com.example.michael.simplemoviecatalogue.data.remote;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class MoviesResponse {

    @SerializedName("page") private Integer page;

    @SerializedName("results") private List<Movie> movieList;

    @SerializedName("total_pages") private Integer totalPages;

    @SerializedName("total_results") private Integer totalResults;

    public MoviesResponse(Integer page, List<Movie> movieList, Integer totalPages, Integer totalResults) {
        this.page = page;
        this.movieList = movieList;
        this.totalPages = totalPages;
        this.totalResults = totalResults;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public List<Movie> getMovieList() {
        return movieList;
    }

    public void setMovieList(List<Movie> movieList) {
        this.movieList = movieList;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public Integer getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(Integer totalResults) {
        this.totalResults = totalResults;
    }

    public class Movie {

        @SerializedName("id") private Integer id;

        @SerializedName("title") private String title;

        @SerializedName("overview") private String overview;

        @SerializedName("poster_path") private String posterPath;

        @SerializedName("vote_average") private Float voteAverage;

        @SerializedName("genre_ids") private ArrayList<Integer> genreIds;

        @SerializedName("release_date") private String releaseDate;


        public Movie(Integer id, String title, String overview, String posterPath, Float voteAverage, ArrayList<Integer> genreIds, String releaseDate) {
            this.id = id;
            this.title = title;
            this.overview = overview;
            this.posterPath = posterPath;
            this.voteAverage = voteAverage;
            this.genreIds = genreIds;
            this.releaseDate = releaseDate;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getOverview() {
            return overview;
        }

        public void setOverview(String overview) {
            this.overview = overview;
        }

        public String getPosterPath() {
            return posterPath;
        }

        public void setPosterPath(String posterPath) {
            this.posterPath = posterPath;
        }

        public Float getVoteAverage() {
            return voteAverage;
        }

        public void setVoteAverage(Float voteAverage) {
            this.voteAverage = voteAverage;
        }

        public ArrayList<Integer> getGenreIds() {
            return genreIds;
        }

        public void setGenreIds(ArrayList<Integer> genreIds) {
            this.genreIds = genreIds;
        }

        public String getReleaseDate() {
            return releaseDate;
        }

        public void setReleaseDate(String releaseDate) {
            this.releaseDate = releaseDate;
        }
    }
}

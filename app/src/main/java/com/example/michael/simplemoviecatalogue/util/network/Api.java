package com.example.michael.simplemoviecatalogue.util.network;

import com.example.michael.simplemoviecatalogue.data.remote.DetailMovieResponse;
import com.example.michael.simplemoviecatalogue.data.remote.MoviesResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Api {

    @GET("movie/now_playing")
    Call<MoviesResponse> getNowPlaying(@Query("api_key") String apiKey,
                                       @Query("page") int page);

    @GET("movie/{movie_id}")
    Call<DetailMovieResponse> getDetailMovie(@Path("movie_id") int movieId,
                                             @Query("api_key") String apiKey);

}

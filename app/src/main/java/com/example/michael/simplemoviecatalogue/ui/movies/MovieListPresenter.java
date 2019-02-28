package com.example.michael.simplemoviecatalogue.ui.movies;

import android.support.annotation.NonNull;

import com.example.michael.simplemoviecatalogue.BasePresenter;
import com.example.michael.simplemoviecatalogue.data.remote.MoviesResponse;
import com.example.michael.simplemoviecatalogue.ui.movies.MovieNowPlayingContract;
import com.example.michael.simplemoviecatalogue.util.network.Api;
import com.example.michael.simplemoviecatalogue.util.network.RetrofitClientInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieNowPlayingPresenter extends BasePresenter {

    private MovieNowPlayingContract.View view;
    private Api api;

    MovieNowPlayingPresenter (MovieNowPlayingContract.View view) {
        this.view = view;

        api = RetrofitClientInstance.getRetrofitInstance().create(Api.class);
    }

    void getMovies(int page) {
        Call<MoviesResponse> call = api.getNowPlayingMovie(apiKey, page);

        call.enqueue(new Callback<MoviesResponse>() {
            @Override
            public void onResponse(@NonNull Call<MoviesResponse> call, @NonNull Response<MoviesResponse> response) {
                view.onFetchDataSuccess(response.body());
            }

            @Override
            public void onFailure(@NonNull Call<MoviesResponse> call, @NonNull Throwable t) {
                view.onFetchDataFailure();
            }
        });
    }

}

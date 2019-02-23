package com.example.michael.simplemoviecatalogue.movies;

import com.example.michael.simplemoviecatalogue.data.remote.MoviesResponse;

public interface MovieView {

    void onFetchDataSuccess(MoviesResponse response);

    void onFetchDataFailure();

}

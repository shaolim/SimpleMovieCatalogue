package com.example.michael.simplemoviecatalogue.ui.movies;

import com.example.michael.simplemoviecatalogue.data.remote.MoviesResponse;

public interface MovieNowPlayingContract {

    interface View {
        void onFetchDataSuccess(MoviesResponse response);

        void onFetchDataFailure();
    }
}

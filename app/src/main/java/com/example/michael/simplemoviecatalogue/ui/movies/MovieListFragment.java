package com.example.michael.simplemoviecatalogue.ui.movies;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.example.michael.simplemoviecatalogue.R;
import com.example.michael.simplemoviecatalogue.data.dto.MovieIndex;
import com.example.michael.simplemoviecatalogue.data.remote.MoviesResponse;
import com.example.michael.simplemoviecatalogue.util.GenreUtil;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MovieNowPlayingFragment extends Fragment implements MovieNowPlayingContract.View {

    private ProgressDialog progressDoalog;
    private MovieAdapter adapter;
    private MovieNowPlayingPresenter presenter;

    @BindView(R.id.lv_list) ListView listView;

    public MovieNowPlayingFragment() {
        // Required empty public constructor
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        progressDoalog = new ProgressDialog(getContext());
        progressDoalog.setMessage("Loading....");
        progressDoalog.show();

        adapter = new MovieAdapter(getContext(), new ArrayList<>());

        listView.setAdapter(adapter);

        presenter = new MovieNowPlayingPresenter(this);
        presenter.getMovies(1);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_movie_now_playing, container, false);
        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onFetchDataSuccess(MoviesResponse response) {

        progressDoalog.dismiss();

        ArrayList<MovieIndex> movieIndices = new ArrayList<>();

        for (MoviesResponse.Movie movie: response.getMovieList()) {

            String rating = "";
            for (Integer genreId: movie.getGenreIds()) {
                String genre = GenreUtil.getGenre(genreId);

                if (genre != null && !genre.isEmpty()) {
                    rating = rating.concat(genre + ", ");
                }
            }

            MovieIndex mov = new MovieIndex(movie.getPosterPath(),
                    rating,
                    movie.getTitle(),
                    movie.getVoteAverage(),
                    movie.getReleaseDate(),
                    movie.getOverview());

            movieIndices.add(mov);
        }

        adapter.getMovies().clear();
        adapter.getMovies().addAll(movieIndices);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onFetchDataFailure() {
        progressDoalog.dismiss();

        Toast.makeText(getContext(), "Something wrong!!!", Toast.LENGTH_SHORT).show();
    }
}

package com.example.michael.simplemoviecatalogue.movies;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.example.michael.simplemoviecatalogue.R;
import com.example.michael.simplemoviecatalogue.data.dto.MovieIndex;
import com.example.michael.simplemoviecatalogue.data.remote.MoviesResponse;
import com.example.michael.simplemoviecatalogue.util.GenreUtil;

import java.util.ArrayList;

public class MoviesActivity extends AppCompatActivity implements MovieView {

    private MovieAdapter adapter;
    private ListView listView;
    private MoviesPresenter moviesPresenter;
    private ProgressDialog progressDoalog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);

        progressDoalog = new ProgressDialog(MoviesActivity.this);
        progressDoalog.setMessage("Loading....");
        progressDoalog.show();

        adapter = new MovieAdapter(this, new ArrayList<>());

        listView = findViewById(R.id.lv_list);
        listView.setAdapter(adapter);

        moviesPresenter = new MoviesPresenter(this);
        moviesPresenter.getMovies(1);
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

        Toast.makeText(this, "Something wrong!!!", Toast.LENGTH_SHORT).show();
    }
}

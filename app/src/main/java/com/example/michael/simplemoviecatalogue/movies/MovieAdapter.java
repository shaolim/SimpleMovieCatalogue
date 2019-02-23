package com.example.michael.simplemoviecatalogue.movies;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.michael.simplemoviecatalogue.R;
import com.example.michael.simplemoviecatalogue.data.dto.MovieIndex;
import com.example.michael.simplemoviecatalogue.moviesdetail.MovieDetailActivity;

import org.parceler.Parcels;

import java.util.ArrayList;

public class MovieAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<MovieIndex> movieIndices;

    public ArrayList<MovieIndex> getMovies() {
        return movieIndices;
    }

    public MovieAdapter(Context context, ArrayList<MovieIndex> movieIndices) {
        this.context = context;
        this.movieIndices = movieIndices;
    }

    @Override
    public int getCount() {
        return movieIndices.size();
    }

    @Override
    public Object getItem(int position) {
        return movieIndices.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_movie,
                    viewGroup, false);
        }

        MovieIndex movie = (MovieIndex) getItem(position);
        TextView tvTitle = view.findViewById(R.id.tv_title);
        TextView tvGenre = view.findViewById(R.id.tv_genre);
        TextView tvRating = view.findViewById(R.id.tv_rating);
        TextView tvReleaseDate = view.findViewById(R.id.tv_release_date);
        ImageView ivPoster = view.findViewById(R.id.iv_poster);

        tvTitle.setText(movie.getTitle());
        tvGenre.setText("Genre : " + movie.getGenre());
        tvRating.setText("Rating : " + String.valueOf(movie.getRating()));
        tvReleaseDate.setText("Release Date : " + movie.getReleaseDate());

        String imageUrl = "https://image.tmdb.org/t/p/w185" + movie.getPosterPath();

        Glide.with(context)
                .load(imageUrl)
                .placeholder(R.drawable.ic_launcher_background)
                .into(ivPoster);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MovieDetailActivity.class);
                intent.putExtra(MovieDetailActivity.EXTRA_MOVIE_BUNDLE, Parcels.wrap(movie));

                context.startActivity(intent);
            }
        });

        return view;
    }
}

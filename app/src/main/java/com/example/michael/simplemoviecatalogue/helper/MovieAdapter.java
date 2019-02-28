package com.example.michael.simplemoviecatalogue.ui.movies;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.michael.simplemoviecatalogue.BuildConfig;
import com.example.michael.simplemoviecatalogue.R;
import com.example.michael.simplemoviecatalogue.data.dto.MovieIndex;
import com.example.michael.simplemoviecatalogue.ui.movies.detail.MovieDetailActivity;

import org.parceler.Parcels;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MyViewHolder> {

    private Context context;
    private ArrayList<MovieIndex> movieIndices;

    public ArrayList<MovieIndex> getMovies() {
        return movieIndices;
    }

    public void setMovies(ArrayList<MovieIndex> movieIndices) {
        this.movieIndices = movieIndices;
    }

    public MovieAdapter(Context context, ArrayList<MovieIndex> movieIndices) {
        this.context = context;
        this.movieIndices = movieIndices;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_movie,
                viewGroup, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder viewHolder, int i) {
        MovieIndex movie = getMovies().get(i);

        viewHolder.tvTitle.setText(movie.getTitle());
        viewHolder.tvGenre.setText(String.format("Genre : %s", movie.getGenre()));
        viewHolder.tvRating.setText(String.format("Rating : %s", String.valueOf(movie.getRating())));
        viewHolder.tvReleaseDate.setText(String.format("Release Date : %s", movie.getReleaseDate()));

        String imageUrl = BuildConfig.IMAGE_URL + movie.getPosterPath();

        Glide.with(context)
                .load(imageUrl)
                .placeholder(R.drawable.ic_launcher_background)
                .into(viewHolder.ivPoster);

    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return movieIndices.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_title) TextView tvTitle;
        @BindView(R.id.tv_genre) TextView tvGenre;
        @BindView(R.id.tv_rating) TextView tvRating;
        @BindView(R.id.tv_release_date) TextView tvReleaseDate;
        @BindView(R.id.iv_poster) ImageView ivPoster;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

            itemView.setOnClickListener(v -> {
                MovieIndex movieIndex = movieIndices.get(this.getAdapterPosition());
                Intent intent = new Intent(context, MovieDetailActivity.class);
                intent.putExtra(MovieDetailActivity.EXTRA_MOVIE_BUNDLE, Parcels.wrap(movieIndex));

                context.startActivity(intent);
            });
        }
    }
}
package com.example.michael.simplemoviecatalogue.ui.moviesdetail;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.michael.simplemoviecatalogue.R;
import com.example.michael.simplemoviecatalogue.data.dto.MovieIndex;

import org.parceler.Parcels;

public class MovieDetailActivity extends AppCompatActivity {

    public static String EXTRA_MOVIE_BUNDLE = "extra_movie_bundle";

    private TextView tvTitle;
    private TextView tvGenre;
    private TextView tvRating;
    private TextView tvOverview;
    private ImageView ivPoster;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        tvTitle = findViewById(R.id.tv_title);
        tvGenre = findViewById(R.id.tv_genre);
        tvRating = findViewById(R.id.tv_rating);
        tvOverview = findViewById(R.id.tv_overview);
        ivPoster = findViewById(R.id.iv_poster);

        MovieIndex movieIndex = Parcels.unwrap(getIntent().getParcelableExtra(EXTRA_MOVIE_BUNDLE));

        if (movieIndex != null) {
            tvTitle.setText(movieIndex.getTitle());
            tvGenre.setText(movieIndex.getGenre());
            tvRating.setText(String.valueOf(movieIndex.getRating()));
            tvOverview.setText(movieIndex.getOverview());

            String imageUrl = "https://image.tmdb.org/t/p/w185" + movieIndex.getPosterPath();

            Glide.with(this)
                    .load(imageUrl)
                    .placeholder(R.drawable.ic_launcher_background)
                    .into(ivPoster);
        }
    }
}

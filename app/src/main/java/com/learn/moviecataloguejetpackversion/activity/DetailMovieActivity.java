package com.learn.moviecataloguejetpackversion.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.learn.moviecataloguejetpackversion.BuildConfig;
import com.learn.moviecataloguejetpackversion.MainActivity;
import com.learn.moviecataloguejetpackversion.R;
import com.learn.moviecataloguejetpackversion.model.Movie;

public class DetailMovieActivity extends AppCompatActivity {
    public static final String EXTRA_MOVIES = "extra_movies";
    private ImageView imgMovieDetail;
    private ImageView imgBackdropMovieDetail;
    private TextView tvNameMovieDetail;
    private TextView tvReleaseMovieDetail;
    private TextView tvVoteMovieDetail;
    private TextView tvPopularityMovieDetail;
    private TextView tvOverviewMovieDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Toolbar toolbar;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(getResources().getString(R.string.back));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        bind();

        Movie movie = getIntent().getParcelableExtra(EXTRA_MOVIES);

        Glide.with(this)
                .load(BuildConfig.BASE_URL_IMG_LIST + movie.getPhotoMovie())
                .placeholder(R.drawable.loadimage)
                .error(R.drawable.errorloadimage)
                .into(imgMovieDetail);
        Glide.with(this)
                .load(BuildConfig.BASE_URL_BACKDROP_DETAIL + movie.getBackdropMovie())
                .placeholder(R.drawable.loadimage)
                .error(R.drawable.errorloadimage)
                .into(imgBackdropMovieDetail);
        tvNameMovieDetail.setText(movie.getNameMovie());
        tvReleaseMovieDetail.setText(movie.getReleaseMovie());
        tvVoteMovieDetail.setText(movie.getVoteMovie());
        tvPopularityMovieDetail.setText(movie.getPopularityMovie());
        tvOverviewMovieDetail.setText(movie.getOverviewMovie());
    }

    private void bind() {
        imgMovieDetail = findViewById(R.id.img_movie_detail);
        imgBackdropMovieDetail = findViewById(R.id.img_backdrop_movie_detail);
        tvNameMovieDetail = findViewById(R.id.tv_name_movie_detail);
        tvReleaseMovieDetail = findViewById(R.id.tv_release_movie_detail);
        tvVoteMovieDetail = findViewById(R.id.tv_vote_movie_detail);
        tvPopularityMovieDetail = findViewById(R.id.tv_popularity_movie_detail);
        tvOverviewMovieDetail = findViewById(R.id.tv_overview_movie_detail);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home :
                Intent goToHome = new Intent(DetailMovieActivity.this, MainActivity.class);
                startActivity(goToHome);
                break;
        }

        return true;
    }
}

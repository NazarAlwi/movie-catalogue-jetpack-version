package com.learn.moviecataloguejetpackversion.ui.detail.movie;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.ViewModelProviders;

import com.bumptech.glide.Glide;
import com.learn.moviecataloguejetpackversion.BuildConfig;
import com.learn.moviecataloguejetpackversion.MainActivity;
import com.learn.moviecataloguejetpackversion.R;
import com.learn.moviecataloguejetpackversion.data.source.local.entity.Movie;
import com.learn.moviecataloguejetpackversion.viewmodel.ViewModelFactory;

public class DetailMovieActivity extends AppCompatActivity {
    public static final String EXTRA_MOVIES = "extra_movies";
    private MovieDetailViewModel viewModel;
    private ImageView imgMovieDetail;
    private ImageView imgBackdropMovieDetail;
    private TextView tvNameMovieDetail;
    private TextView tvReleaseMovieDetail;
    private TextView tvVoteMovieDetail;
    private TextView tvPopularityMovieDetail;
    private TextView tvOverviewMovieDetail;
    private ProgressBar progressBar;
    private Menu menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Toolbar toolbar;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(getResources().getString(R.string.back));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        viewModel = obtainViewModel(this);

        bind();

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String movieDetailId = extras.getString(EXTRA_MOVIES);
            if (movieDetailId != null) {
                viewModel.setIdMovie(movieDetailId);
            }
        }

        viewModel.movieById.observe(this, movie -> {
            if (movie != null) {
                switch (movie.status) {
                    case LOADING:
                        showLoading(true);
                        break;
                    case SUCCESS:
                        if (movie.data != null) {
                            showLoading(false);
                            init(movie.data);
                        }
                        break;
                    case ERROR:
                        showLoading(false);
                        break;
                }
            }
        });
    }

    private void bind() {
        imgMovieDetail = findViewById(R.id.img_movie_detail);
        imgBackdropMovieDetail = findViewById(R.id.img_backdrop_movie_detail);
        tvNameMovieDetail = findViewById(R.id.tv_name_movie_detail);
        tvReleaseMovieDetail = findViewById(R.id.tv_release_movie_detail);
        tvVoteMovieDetail = findViewById(R.id.tv_vote_movie_detail);
        tvPopularityMovieDetail = findViewById(R.id.tv_popularity_movie_detail);
        tvOverviewMovieDetail = findViewById(R.id.tv_overview_movie_detail);
        progressBar = findViewById(R.id.progress_bar);
    }

    private void init(Movie movie) {
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

    @NonNull
    private static MovieDetailViewModel obtainViewModel(AppCompatActivity activity) {
        // Use a Factory to inject dependencies into the ViewModel
        ViewModelFactory factory = ViewModelFactory.getInstance(activity.getApplication());

        return ViewModelProviders.of(activity, factory).get(MovieDetailViewModel.class);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home :
                Intent goToHome = new Intent(DetailMovieActivity.this, MainActivity.class);
                startActivity(goToHome);
                break;
            case R.id.favorite :
                viewModel.setFavorite();
                return true;
        }

        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.set_favorite_btn_menu, menu);
        this.menu = menu;
        viewModel.movieById.observe(this, movieResource -> {
            if (movieResource != null) {
                switch (movieResource.status) {
                    case LOADING:
                        showLoading(true);
                        break;
                    case SUCCESS:
                        if (movieResource != null) {
                            showLoading(false);
                            boolean state = movieResource.data.isFavorited();
                            setFavoriteState(state);
                        }
                        break;
                    case ERROR:
                        showLoading(false);
                        Toast.makeText(getApplicationContext(), "Terjadi kesalahan", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });

        return true;
    }

    private void setFavoriteState(boolean state) {
        if (menu == null) return;
        MenuItem menuItem = menu.findItem(R.id.favorite);
        if (state) {
            menuItem.setIcon(ContextCompat.getDrawable(this, R.drawable.like_3));
        } else {
            menuItem.setIcon(ContextCompat.getDrawable(this, R.drawable.like_2));
        }
    }

    private void showLoading(Boolean state) {
        if (state) {
            progressBar.setVisibility(View.VISIBLE);
        } else {
            progressBar.setVisibility(View.GONE);
        }
    }
}

package com.learn.moviecataloguejetpackversion.ui.detail.tvshow;

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
import com.learn.moviecataloguejetpackversion.data.source.local.entity.TvShow;
import com.learn.moviecataloguejetpackversion.viewmodel.ViewModelFactory;

public class DetailTvShowActivity extends AppCompatActivity {
    public static final String EXTRA_TV_SHOWS = "extra_tv_shows";
    private TvShowDetailViewModel viewModel;
    private ImageView imgTvShowDetail;
    private ImageView imgBackdropTvShowDetail;
    private TextView tvNameTvShowDetail;
    private TextView tvReleaseTvShowDetail;
    private TextView tvVoteTvShowDetail;
    private TextView tvPopularityTvShowDetail;
    private TextView tvOverviewTvShowDetail;
    private ProgressBar progressBar;
    private Menu menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Toolbar toolbar;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_tv_show);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(getResources().getString(R.string.back));
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        viewModel = obtainViewModel(this);

        bind();

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String tvShowDetailId = extras.getString(EXTRA_TV_SHOWS);
            if (tvShowDetailId != null) {
                viewModel.setIdTvShow(tvShowDetailId);
            }
        }

        viewModel.tvShowById.observe(this, tvShowResource -> {
            if (tvShowResource != null) {
                switch (tvShowResource.status) {
                    case LOADING:
                        showLoading(true);
                        break;
                    case SUCCESS:
                        if (tvShowResource.data != null) {
                            showLoading(false);
                            init(tvShowResource.data);
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
        imgTvShowDetail = findViewById(R.id.img_tv_show_detail);
        imgBackdropTvShowDetail = findViewById(R.id.img_backdrop_tv_show_detail);
        tvNameTvShowDetail = findViewById(R.id.tv_name_tv_show_detail);
        tvReleaseTvShowDetail = findViewById(R.id.tv_release_tv_show_detail);
        tvVoteTvShowDetail = findViewById(R.id.tv_vote_tv_show_detail);
        tvPopularityTvShowDetail = findViewById(R.id.tv_popularity_tv_show_detail);
        tvOverviewTvShowDetail = findViewById(R.id.tv_overview_tv_show_detail);
        progressBar = findViewById(R.id.progress_bar);
    }

    private void init(TvShow tvShow) {
        Glide.with(this)
                .load(BuildConfig.BASE_URL_IMG_LIST + tvShow.getPhotoTvShow())
                .placeholder(R.drawable.loadimage)
                .error(R.drawable.errorloadimage)
                .into(imgTvShowDetail);
        Glide.with(this)
                .load(BuildConfig.BASE_URL_BACKDROP_DETAIL + tvShow.getBackdropTvShow())
                .placeholder(R.drawable.loadimage)
                .error(R.drawable.errorloadimage)
                .into(imgBackdropTvShowDetail);
        tvNameTvShowDetail.setText(tvShow.getNameTvShow());
        tvReleaseTvShowDetail.setText(tvShow.getReleaseTvShow());
        tvVoteTvShowDetail.setText(tvShow.getVoteTvShow());
        tvPopularityTvShowDetail.setText(tvShow.getPopularityTvShow());
        tvOverviewTvShowDetail.setText(tvShow.getOverviewTvShow());
    }

    @NonNull
    private static TvShowDetailViewModel obtainViewModel(AppCompatActivity activity) {
        // Use a Factory to inject dependencies into the ViewModel
        ViewModelFactory factory = ViewModelFactory.getInstance(activity.getApplication());

        return ViewModelProviders.of(activity, factory).get(TvShowDetailViewModel.class);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home :
                Intent goToHome = new Intent(DetailTvShowActivity.this, MainActivity.class);
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
        viewModel.tvShowById.observe(this, tvShowResource -> {
            if (tvShowResource != null) {
                switch (tvShowResource.status) {
                    case LOADING:
                        showLoading(true);
                        break;
                    case SUCCESS:
                        if (tvShowResource != null) {
                            showLoading(false);
                            boolean state = tvShowResource.data.isFavorited();
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

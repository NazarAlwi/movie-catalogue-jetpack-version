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
import com.learn.moviecataloguejetpackversion.model.TvShow;

public class DetailTvShowActivity extends AppCompatActivity {
    public static final String EXTRA_TV_SHOWS = "extra_tv_shows";
    private ImageView imgTvShowDetail;
    private ImageView imgBackdropTvShowDetail;
    private TextView tvNameTvShowDetail;
    private TextView tvReleaseTvShowDetail;
    private TextView tvVoteTvShowDetail;
    private TextView tvPopularityTvShowDetail;
    private TextView tvOverviewTvShowDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Toolbar toolbar;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_tv_show);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(getResources().getString(R.string.back));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        bind();

        TvShow tvShow = getIntent().getParcelableExtra(EXTRA_TV_SHOWS);

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

    private void bind() {
        imgTvShowDetail = findViewById(R.id.img_tv_show_detail);
        imgBackdropTvShowDetail = findViewById(R.id.img_backdrop_tv_show_detail);
        tvNameTvShowDetail = findViewById(R.id.tv_name_tv_show_detail);
        tvReleaseTvShowDetail = findViewById(R.id.tv_release_tv_show_detail);
        tvVoteTvShowDetail = findViewById(R.id.tv_vote_tv_show_detail);
        tvPopularityTvShowDetail = findViewById(R.id.tv_popularity_tv_show_detail);
        tvOverviewTvShowDetail = findViewById(R.id.tv_overview_tv_show_detail);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home :
                Intent goToHome = new Intent(DetailTvShowActivity.this, MainActivity.class);
                startActivity(goToHome);
                break;
        }

        return true;
    }
}

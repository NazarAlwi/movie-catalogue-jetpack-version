package com.learn.moviecataloguejetpackversion.data.source;

import androidx.lifecycle.LiveData;

import com.learn.moviecataloguejetpackversion.data.source.local.entity.Movie;
import com.learn.moviecataloguejetpackversion.data.source.local.entity.TvShow;

import java.util.List;

public interface MovieCatalogueDataSource {
    LiveData<List<Movie>> getAllMovie();
    LiveData<List<TvShow>> getAllTvShow();
    LiveData<Movie> getMovieById(String idMovie);
    LiveData<TvShow> getTvShowById(String idTvShow);
    LiveData<List<Movie>> getAllMovieFavorite();
    LiveData<List<TvShow>> getAllTvShowFavorite();
}

package com.learn.moviecataloguejetpackversion.data.source;

import androidx.lifecycle.LiveData;

import com.learn.moviecataloguejetpackversion.data.source.local.entity.Movie;
import com.learn.moviecataloguejetpackversion.data.source.local.entity.TvShow;
import com.learn.moviecataloguejetpackversion.vo.Resource;

import java.util.List;

public interface MovieCatalogueDataSource {
    LiveData<Resource<List<Movie>>> getAllMovie();
    LiveData<Resource<List<TvShow>>> getAllTvShow();
    LiveData<Resource<Movie>> getMovieById(String idMovie);
    LiveData<Resource<TvShow>> getTvShowById(String idTvShow);
    LiveData<Resource<List<Movie>>> getAllMovieFavorite();
    LiveData<Resource<List<TvShow>>> getAllTvShowFavorite();
    void setMovieFavorite(Movie movie, boolean state);
    void setTvShowFavorite(TvShow tvShow, boolean state);
}

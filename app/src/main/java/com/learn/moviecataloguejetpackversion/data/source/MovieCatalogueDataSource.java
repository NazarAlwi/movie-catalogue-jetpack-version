package com.learn.moviecataloguejetpackversion.data.source;

import com.learn.moviecataloguejetpackversion.data.source.local.entity.Movie;
import com.learn.moviecataloguejetpackversion.data.source.local.entity.TvShow;

import java.util.List;

public interface MovieCatalogueDataSource {
    List<Movie> getAllMovie();
    List<TvShow> getAllTvShow();
    Movie getMovieById(String idMovie);
    TvShow getTvShowById(String idTvShow);
}

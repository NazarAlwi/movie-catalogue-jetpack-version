package com.learn.moviecataloguejetpackversion.data.source;

import com.learn.moviecataloguejetpackversion.model.Movie;
import com.learn.moviecataloguejetpackversion.model.TvShow;

import java.util.List;

public interface DataSource {
    List<Movie> getAllMovie();
    List<TvShow> getAllTvShow();
}

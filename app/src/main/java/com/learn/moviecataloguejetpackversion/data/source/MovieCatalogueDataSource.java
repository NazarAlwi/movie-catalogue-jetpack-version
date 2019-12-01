package com.learn.moviecataloguejetpackversion.data.source;

<<<<<<< HEAD
=======
import androidx.lifecycle.LiveData;

>>>>>>> repository-dev
import com.learn.moviecataloguejetpackversion.data.source.local.entity.Movie;
import com.learn.moviecataloguejetpackversion.data.source.local.entity.TvShow;

import java.util.List;

public interface MovieCatalogueDataSource {
<<<<<<< HEAD
    List<Movie> getAllMovie();
    List<TvShow> getAllTvShow();
    Movie getMovieWithId(String idMovie);
    TvShow getTvShowWithId(String idTvShow);
=======
    LiveData<List<Movie>> getAllMovie();
    LiveData<List<TvShow>> getAllTvShow();
    LiveData<Movie> getMovieById(String idMovie);
    LiveData<TvShow> getTvShowById(String idTvShow);
    LiveData<List<Movie>> getAllMovieFavorite();
    LiveData<List<TvShow>> getAllTvShowFavorite();
>>>>>>> repository-dev
}

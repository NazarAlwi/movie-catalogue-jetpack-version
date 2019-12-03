package com.learn.moviecataloguejetpackversion.data.source.local;

import androidx.lifecycle.LiveData;
import androidx.paging.DataSource;

import com.learn.moviecataloguejetpackversion.data.source.local.entity.Movie;
import com.learn.moviecataloguejetpackversion.data.source.local.entity.TvShow;
import com.learn.moviecataloguejetpackversion.data.source.local.room.MovieCatalogueDao;

import java.util.List;

public class LocalRepository {
    private final MovieCatalogueDao mMovieCatalogueDao;

    public LocalRepository(MovieCatalogueDao movieCatalogueDao) {
        this.mMovieCatalogueDao = movieCatalogueDao;
    }

    private static LocalRepository INSTANCE;

    public static LocalRepository getInstance(MovieCatalogueDao movieCatalogueDao) {
        if (INSTANCE == null) {
            INSTANCE = new LocalRepository(movieCatalogueDao);
        }
        return INSTANCE;
    }

    public LiveData<List<Movie>> getAllMovie() {
        return mMovieCatalogueDao.getMovie();
    }

    public LiveData<List<TvShow>> getAllTvShow() {
        return mMovieCatalogueDao.getTvShow();
    }

    public DataSource.Factory<Integer, Movie> getAllMovieFavoritePaged() {
        return mMovieCatalogueDao.getMovieFavoriteAsPaged();
    }

    public DataSource.Factory<Integer, TvShow> getAllTvShowFavoritePaged() {
        return mMovieCatalogueDao.getTvShowFavoriteAsPaged();
    }

    public LiveData<Movie> getMovieById(final String idMovie) {
        return mMovieCatalogueDao.getMovieById(idMovie);
    }

    public LiveData<TvShow> getTvShowById(final String idTvShow) {
        return mMovieCatalogueDao.getTvShowById(idTvShow);
    }

    public void insertMovie(List<Movie> movies) {
        mMovieCatalogueDao.insertMovies(movies);
    }

    public void insertTvShow(List<TvShow> tvShows) {
        mMovieCatalogueDao.insertTvShow(tvShows);
    }

    public void setMovieFavorite(Movie movie, boolean newState) {
        movie.setFavorited(newState);
        mMovieCatalogueDao.updateMovie(movie);
    }

    public void setTvShowFavorite(TvShow tvShow, boolean newState) {
        tvShow.setFavorited(newState);
        mMovieCatalogueDao.updateTvShow(tvShow);
    }
}

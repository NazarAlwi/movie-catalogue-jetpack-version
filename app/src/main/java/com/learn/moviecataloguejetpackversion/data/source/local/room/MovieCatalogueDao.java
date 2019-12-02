package com.learn.moviecataloguejetpackversion.data.source.local.room;

import androidx.annotation.WorkerThread;
import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import com.learn.moviecataloguejetpackversion.data.source.local.entity.Movie;
import com.learn.moviecataloguejetpackversion.data.source.local.entity.TvShow;

import java.util.List;

@Dao
public interface MovieCatalogueDao {
    @WorkerThread
    @Query("SELECT * FROM movie")
    LiveData<List<Movie>> getMovie();

    @WorkerThread
    @Query("SELECT * FROM tvshow")
    LiveData<List<TvShow>> getTvShow();

    @WorkerThread
    @Query("SELECT * FROM movie where favoritedMovie = 1")
    LiveData<List<Movie>> getMovieFavorite();

    @WorkerThread
    @Query("SELECT * FROM tvshow where favoritedTvShow = 1")
    LiveData<List<TvShow>> getTvShowFavorite();

    @Transaction
    @Query("SELECT * FROM movie WHERE idMovie = :idMovie")
    LiveData<Movie> getMovieById(String idMovie);

    @Transaction
    @Query("SELECT * FROM tvshow WHERE idTvShow = :idTvShow")
    LiveData<TvShow> getTvShowById(String idTvShow);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long[] insertMovies(List<Movie> movies);

    @Update(onConflict = OnConflictStrategy.FAIL)
    int updateMovie(Movie movie);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long[] insertTvShow(List<TvShow> tvShows);

    @Update(onConflict = OnConflictStrategy.FAIL)
    int updateTvShow(TvShow tvShow);
}

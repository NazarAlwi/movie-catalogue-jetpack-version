package com.learn.moviecataloguejetpackversion.model;

import androidx.lifecycle.ViewModel;

import com.learn.moviecataloguejetpackversion.data.MovieData;
import com.learn.moviecataloguejetpackversion.data.source.local.entity.Movie;

public class MovieDetailViewModel extends ViewModel {
    private Movie mMovie;
    private String idMovie;

    public Movie getMovieDetail() {
        for (int i = 0; i < MovieData.generateMovieList().size(); i++) {
            Movie movie = MovieData.generateMovieList().get(i);
            if (movie.getIdMovie().equals(idMovie)) {
                mMovie = movie;
            }
        }

        return mMovie;
    }

    public void setMovieName(String idMovie) {
        this.idMovie = idMovie;
    }
}

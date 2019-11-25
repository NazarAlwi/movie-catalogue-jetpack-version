package com.learn.moviecataloguejetpackversion.model;

import androidx.lifecycle.ViewModel;

import com.learn.moviecataloguejetpackversion.data.MovieData;
import com.learn.moviecataloguejetpackversion.data.source.MovieCatalogueRepository;

public class MovieDetailViewModel extends ViewModel {
    private Movie mMovie;
    private String movieName;
    private MovieCatalogueRepository movieCatalogueRepository;

    public MovieDetailViewModel(MovieCatalogueRepository mMovieCatalogueRepository) {
        this.movieCatalogueRepository = mMovieCatalogueRepository;
    }

    public Movie getMovieDetail() {
        for (int i = 0; i < MovieData.generateMovieList().size(); i++) {
            Movie movie = MovieData.generateMovieList().get(i);
            if (movie.getNameMovie().equals(movieName)) {
                mMovie = movie;
            }
        }

        return mMovie;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }
}

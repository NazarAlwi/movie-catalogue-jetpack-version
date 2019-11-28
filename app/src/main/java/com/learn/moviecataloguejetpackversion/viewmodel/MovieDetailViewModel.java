package com.learn.moviecataloguejetpackversion.model;

import androidx.lifecycle.ViewModel;

import com.learn.moviecataloguejetpackversion.data.source.MovieCatalogueRepository;
import com.learn.moviecataloguejetpackversion.data.source.local.entity.Movie;

public class MovieDetailViewModel extends ViewModel {
    private Movie mMovie;
    private String idMovie;
    private MovieCatalogueRepository movieCatalogueRepository;

    public MovieDetailViewModel(MovieCatalogueRepository movieCatalogueRepository) {
        this.movieCatalogueRepository = movieCatalogueRepository;
    }

    public Movie getMovieDetail() {
        for (int i = 0; i < movieCatalogueRepository.getAllMovie().size(); i++) {
            Movie movie = movieCatalogueRepository.getAllMovie().get(i);
            if (movie.getIdMovie().equals(idMovie)) {
                mMovie = movie;
            }
        }

        return mMovie;
    }

    public void setIdMovie(String idMovie) {
        this.idMovie = idMovie;
    }
}

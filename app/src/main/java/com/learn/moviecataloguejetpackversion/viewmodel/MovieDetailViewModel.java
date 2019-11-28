package com.learn.moviecataloguejetpackversion.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.learn.moviecataloguejetpackversion.data.source.MovieCatalogueRepository;
import com.learn.moviecataloguejetpackversion.data.source.local.entity.Movie;

public class MovieDetailViewModel extends ViewModel {
    private String idMovie;
    private MovieCatalogueRepository movieCatalogueRepository;

    public MovieDetailViewModel(MovieCatalogueRepository movieCatalogueRepository) {
        this.movieCatalogueRepository = movieCatalogueRepository;
    }

    public LiveData<Movie> getMovieDetail() {
        return movieCatalogueRepository.getMovieById(idMovie);
    }

    public String getIdMovie() {
        return idMovie;
    }

    public void setIdMovie(String idMovie) {
        this.idMovie = idMovie;
    }
}

package com.learn.moviecataloguejetpackversion.ui.movie;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.learn.moviecataloguejetpackversion.data.source.MovieCatalogueRepository;
import com.learn.moviecataloguejetpackversion.data.source.local.entity.Movie;

import java.util.List;

public class MovieViewModel extends ViewModel {
    private MovieCatalogueRepository movieCatalogueRepository;

    public MovieViewModel(MovieCatalogueRepository movieCatalogueRepository) {
        this.movieCatalogueRepository = movieCatalogueRepository;
    }

    LiveData<List<Movie>> getListMovie() {
        return movieCatalogueRepository.getAllMovie();
    }
}

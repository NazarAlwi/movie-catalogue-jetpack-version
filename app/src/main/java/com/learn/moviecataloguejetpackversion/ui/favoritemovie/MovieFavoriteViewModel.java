package com.learn.moviecataloguejetpackversion.ui.favoritemovie;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.learn.moviecataloguejetpackversion.data.source.MovieCatalogueRepository;
import com.learn.moviecataloguejetpackversion.data.source.local.entity.Movie;

import java.util.List;

public class MovieFavoriteViewModel extends ViewModel {
    private MovieCatalogueRepository movieCatalogueRepository;

    public MovieFavoriteViewModel(MovieCatalogueRepository movieCatalogueRepository) {
        this.movieCatalogueRepository = movieCatalogueRepository;
    }

    LiveData<List<Movie>> getListMovieFavorite() {
        return movieCatalogueRepository.getAllMovieFavorite();
    }
}

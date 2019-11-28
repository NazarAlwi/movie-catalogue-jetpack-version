package com.learn.moviecataloguejetpackversion.model;

import androidx.lifecycle.ViewModel;

import com.learn.moviecataloguejetpackversion.data.source.MovieCatalogueRepository;
import com.learn.moviecataloguejetpackversion.data.source.local.entity.Movie;
import com.learn.moviecataloguejetpackversion.data.source.local.entity.TvShow;

import java.util.ArrayList;

public class MainViewModel extends ViewModel {
    private MovieCatalogueRepository movieCatalogueRepository;

    public MainViewModel(MovieCatalogueRepository movieCatalogueRepository) {
        this.movieCatalogueRepository = movieCatalogueRepository;
    }

    public ArrayList<Movie> getListMovie() {
        return movieCatalogueRepository.getAllMovie();
    }

    public ArrayList<TvShow> getListTvShow() {
        return movieCatalogueRepository.getAllTvShow();
    }
}

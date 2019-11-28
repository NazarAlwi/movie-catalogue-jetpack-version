package com.learn.moviecataloguejetpackversion.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.learn.moviecataloguejetpackversion.data.source.MovieCatalogueRepository;
import com.learn.moviecataloguejetpackversion.data.source.local.entity.Movie;
import com.learn.moviecataloguejetpackversion.data.source.local.entity.TvShow;

import java.util.List;

public class MainViewModel extends ViewModel {
    private MovieCatalogueRepository movieCatalogueRepository;

    public MainViewModel(MovieCatalogueRepository movieCatalogueRepository) {
        this.movieCatalogueRepository = movieCatalogueRepository;
    }

    public LiveData<List<Movie>> getListMovie() {
        return movieCatalogueRepository.getAllMovie();
    }

    public LiveData<List<TvShow>> getListTvShow() {
        return movieCatalogueRepository.getAllTvShow();
    }
}

package com.learn.moviecataloguejetpackversion.ui.tvshow;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.learn.moviecataloguejetpackversion.data.source.MovieCatalogueRepository;
import com.learn.moviecataloguejetpackversion.data.source.local.entity.TvShow;

import java.util.List;

public class TvShowViewModel extends ViewModel {
    private MovieCatalogueRepository movieCatalogueRepository;

    public TvShowViewModel(MovieCatalogueRepository movieCatalogueRepository) {
        this.movieCatalogueRepository = movieCatalogueRepository;
    }

    LiveData<List<TvShow>> getListTvShow() {
        return movieCatalogueRepository.getAllTvShow();
    }
}

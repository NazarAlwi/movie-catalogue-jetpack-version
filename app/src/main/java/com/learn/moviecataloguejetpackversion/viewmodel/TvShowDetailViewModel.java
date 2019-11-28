package com.learn.moviecataloguejetpackversion.viewmodel;

import androidx.lifecycle.ViewModel;

import com.learn.moviecataloguejetpackversion.data.source.MovieCatalogueRepository;
import com.learn.moviecataloguejetpackversion.data.source.local.entity.TvShow;

public class TvShowDetailViewModel extends ViewModel {
    private String idTvShow;
    private MovieCatalogueRepository movieCatalogueRepository;

    public TvShowDetailViewModel(MovieCatalogueRepository movieCatalogueRepository) {
        this.movieCatalogueRepository = movieCatalogueRepository;
    }

    public TvShow getTvShowDetail() {
        return movieCatalogueRepository.getTvShowById(idTvShow);
    }

    public void setIdTvShow(String idTvShow) {
        this.idTvShow = idTvShow;
    }
}

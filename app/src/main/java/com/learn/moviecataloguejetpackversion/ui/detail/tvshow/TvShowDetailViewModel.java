package com.learn.moviecataloguejetpackversion.ui.detail.tvshow;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.learn.moviecataloguejetpackversion.data.source.MovieCatalogueRepository;
import com.learn.moviecataloguejetpackversion.data.source.local.entity.TvShow;

public class TvShowDetailViewModel extends ViewModel {
    private String idTvShow;
    private MovieCatalogueRepository movieCatalogueRepository;

    public TvShowDetailViewModel(MovieCatalogueRepository movieCatalogueRepository) {
        this.movieCatalogueRepository = movieCatalogueRepository;
    }

    public LiveData<TvShow> getTvShowDetail() {
        return movieCatalogueRepository.getTvShowById(idTvShow);
    }

    public String getIdTvShow() {
        return idTvShow;
    }

    public void setIdTvShow(String idTvShow) {
        this.idTvShow = idTvShow;
    }
}

package com.learn.moviecataloguejetpackversion.ui.detail.tvshow;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.learn.moviecataloguejetpackversion.data.source.MovieCatalogueRepository;
import com.learn.moviecataloguejetpackversion.data.source.local.entity.TvShow;
import com.learn.moviecataloguejetpackversion.vo.Resource;

public class TvShowDetailViewModel extends ViewModel {
    private TvShow tvShow;
    private MovieCatalogueRepository movieCatalogueRepository;

    private MutableLiveData<String> idTvShow = new MutableLiveData<>();

    public TvShowDetailViewModel(MovieCatalogueRepository movieCatalogueRepository) {
        this.movieCatalogueRepository = movieCatalogueRepository;
    }

    public LiveData<Resource<TvShow>> tvShowById = Transformations.switchMap(idTvShow, mIdTvShow ->
            movieCatalogueRepository.getTvShowById(mIdTvShow));

    public String getIdTvShow() {
        if (idTvShow.getValue() == null) return null;
        return idTvShow.getValue();
    }

    public void setIdTvShow(String idTvShow) {
        this.idTvShow.setValue(idTvShow);
    }

    void setFavorite() {
        if (tvShowById.getValue() != null) {
            TvShow tvShow = tvShowById.getValue().data;

            if (tvShow != null) {
                final boolean newState = !tvShow.isFavorited();
                movieCatalogueRepository.setTvShowFavorite(tvShow, newState);
            }
        }
    }
}

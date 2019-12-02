package com.learn.moviecataloguejetpackversion.ui.favoritetvshow;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.learn.moviecataloguejetpackversion.data.source.MovieCatalogueRepository;
import com.learn.moviecataloguejetpackversion.data.source.local.entity.TvShow;
import com.learn.moviecataloguejetpackversion.vo.Resource;

import java.util.List;

public class TvShowFavoriteViewModel extends ViewModel {
    private MovieCatalogueRepository movieCatalogueRepository;

    public TvShowFavoriteViewModel(MovieCatalogueRepository movieCatalogueRepository) {
        this.movieCatalogueRepository = movieCatalogueRepository;
    }

    LiveData<Resource<List<TvShow>>> getListTvShowFavorite() {
        return movieCatalogueRepository.getAllTvShowFavorite();
    }
}

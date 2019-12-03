package com.learn.moviecataloguejetpackversion.ui.favoritetvshow;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.PagedList;

import com.learn.moviecataloguejetpackversion.data.source.MovieCatalogueRepository;
import com.learn.moviecataloguejetpackversion.data.source.local.entity.TvShow;
import com.learn.moviecataloguejetpackversion.vo.Resource;

public class TvShowFavoriteViewModel extends ViewModel {
    private MovieCatalogueRepository movieCatalogueRepository;

    public TvShowFavoriteViewModel(MovieCatalogueRepository movieCatalogueRepository) {
        this.movieCatalogueRepository = movieCatalogueRepository;
    }

    LiveData<Resource<PagedList<TvShow>>> getListTvShowFavoritePaged() {
        return movieCatalogueRepository.getAllTvShowFavoritePaged();
    }

    void setFavorite(TvShow tvShow) {
        final boolean newState = !tvShow.isFavorited();
        movieCatalogueRepository.setTvShowFavorite(tvShow, newState);
    }
}

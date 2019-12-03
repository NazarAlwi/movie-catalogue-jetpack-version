package com.learn.moviecataloguejetpackversion.ui.favoritemovie;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.PagedList;

import com.learn.moviecataloguejetpackversion.data.source.MovieCatalogueRepository;
import com.learn.moviecataloguejetpackversion.data.source.local.entity.Movie;
import com.learn.moviecataloguejetpackversion.vo.Resource;

public class MovieFavoriteViewModel extends ViewModel {
    private MovieCatalogueRepository movieCatalogueRepository;

    public MovieFavoriteViewModel(MovieCatalogueRepository movieCatalogueRepository) {
        this.movieCatalogueRepository = movieCatalogueRepository;
    }

    LiveData<Resource<PagedList<Movie>>> getListMovieFavoritePaged() {
        return movieCatalogueRepository.getAllMovieFavoritePaged();
    }

    void setFavorite(Movie movie) {
        final boolean newState = !movie.isFavorited();
        movieCatalogueRepository.setMovieFavorite(movie, newState);
    }
}

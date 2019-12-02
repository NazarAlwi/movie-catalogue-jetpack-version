package com.learn.moviecataloguejetpackversion.ui.favoritemovie;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.learn.moviecataloguejetpackversion.data.source.MovieCatalogueRepository;
import com.learn.moviecataloguejetpackversion.data.source.local.entity.Movie;
import com.learn.moviecataloguejetpackversion.vo.Resource;

import java.util.List;

public class MovieFavoriteViewModel extends ViewModel {
    private MovieCatalogueRepository movieCatalogueRepository;

    public MovieFavoriteViewModel(MovieCatalogueRepository movieCatalogueRepository) {
        this.movieCatalogueRepository = movieCatalogueRepository;
    }

    LiveData<Resource<List<Movie>>> getListMovieFavorite() {
        return movieCatalogueRepository.getAllMovieFavorite();
    }
}

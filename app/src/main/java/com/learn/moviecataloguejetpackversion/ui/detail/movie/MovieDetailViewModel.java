package com.learn.moviecataloguejetpackversion.ui.detail.movie;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.learn.moviecataloguejetpackversion.data.source.MovieCatalogueRepository;
import com.learn.moviecataloguejetpackversion.data.source.local.entity.Movie;
import com.learn.moviecataloguejetpackversion.vo.Resource;

public class MovieDetailViewModel extends ViewModel {
    private Movie movie;
    private MovieCatalogueRepository movieCatalogueRepository;

    private MutableLiveData<String> idMovie = new MutableLiveData<>();

    public MovieDetailViewModel(MovieCatalogueRepository movieCatalogueRepository) {
        this.movieCatalogueRepository = movieCatalogueRepository;
    }

    public LiveData<Resource<Movie>> movieById = Transformations.switchMap(idMovie, mIdMovie -> movieCatalogueRepository.getMovieById(mIdMovie));

    public void setIdMovie(String idMovie) {
        this.idMovie.setValue(idMovie);
    }

    public String getIdMovie() {
        if (idMovie.getValue() == null) return null;
        return idMovie.getValue();
    }

    void setFavorite() {
        if (movieById.getValue() != null) {
            Movie movie = movieById.getValue().data;

            if (movie != null) {
                final boolean newState = !movie.isFavorited();
                movieCatalogueRepository.setMovieFavorite(movie, newState);
            }
        }
    }
}

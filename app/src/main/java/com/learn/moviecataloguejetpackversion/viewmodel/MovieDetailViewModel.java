package com.learn.moviecataloguejetpackversion.viewmodel;

import androidx.lifecycle.ViewModel;

import com.learn.moviecataloguejetpackversion.data.source.MovieCatalogueRepository;
import com.learn.moviecataloguejetpackversion.data.source.local.entity.Movie;

public class MovieDetailViewModel extends ViewModel {
    private Movie mMovie;
    private String idMovie;
    private MovieCatalogueRepository movieCatalogueRepository;

    public MovieDetailViewModel(MovieCatalogueRepository mMovieCatalogueRepository) {
        this.movieCatalogueRepository = mMovieCatalogueRepository;
    }

    public Movie getMovieDetail() {
//        for (int i = 0; i < movieCatalogueRepository.getAllMovie().size(); i++) {
////            Movie movie = MovieData.generateMovieList().get(i);
//            Movie movie = movieCatalogueRepository.getAllMovie().get(i);
//            if (movie.getNameMovie().equals(idMovie)) {
//                mMovie = movie;
//            }
//        }

        return movieCatalogueRepository.getMovieWithId(idMovie);
    }

    public void setIdMovie(String idMovie) {
        this.idMovie = idMovie;
    }
}

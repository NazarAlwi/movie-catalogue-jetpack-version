package com.learn.moviecataloguejetpackversion.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.learn.moviecataloguejetpackversion.data.source.MovieCatalogueRepository;
import com.learn.moviecataloguejetpackversion.di.Injection;
<<<<<<< HEAD
=======
import com.learn.moviecataloguejetpackversion.ui.detail.movie.MovieDetailViewModel;
import com.learn.moviecataloguejetpackversion.ui.detail.tvshow.TvShowDetailViewModel;
import com.learn.moviecataloguejetpackversion.ui.favoritemovie.MovieFavoriteViewModel;
import com.learn.moviecataloguejetpackversion.ui.favoritetvshow.TvShowFavoriteViewModel;
import com.learn.moviecataloguejetpackversion.ui.movie.MovieViewModel;
import com.learn.moviecataloguejetpackversion.ui.tvshow.TvShowViewModel;
>>>>>>> repository-dev

public class ViewModelFactory extends ViewModelProvider.NewInstanceFactory {
    private static volatile ViewModelFactory INSTANCE;

    private final MovieCatalogueRepository mMovieCatalogueRepository;

<<<<<<< HEAD
    public ViewModelFactory(MovieCatalogueRepository MovieCatalogueRepository) {
        this.mMovieCatalogueRepository = MovieCatalogueRepository;
=======
    private ViewModelFactory(MovieCatalogueRepository movieCatalogueRepository) {
        mMovieCatalogueRepository = movieCatalogueRepository;
>>>>>>> repository-dev
    }

    public static ViewModelFactory getInstance(Application application) {
        if (INSTANCE == null) {
            synchronized (ViewModelFactory.class) {
                if (INSTANCE == null) {
<<<<<<< HEAD
                    INSTANCE = new ViewModelFactory(Injection.providerRepository(application));
=======
                    INSTANCE = new ViewModelFactory(Injection.provideRepository(application));
>>>>>>> repository-dev
                }
            }
        }
        return INSTANCE;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
<<<<<<< HEAD
        if (modelClass.isAssignableFrom(MainViewModel.class)) {
            return (T) new MainViewModel(mMovieCatalogueRepository);
        } else if (modelClass.isAssignableFrom(MovieDetailViewModel.class)) {
            return (T) new MovieDetailViewModel(mMovieCatalogueRepository);
        } else if (modelClass.isAssignableFrom(TvShowDetailViewModel.class)) {
=======
        if (modelClass.isAssignableFrom(MovieViewModel.class)) {
            //noinspection unchecked
            return (T) new MovieViewModel(mMovieCatalogueRepository);
        } else if (modelClass.isAssignableFrom(TvShowViewModel.class)) {
            //noinspection unchecked
            return (T) new TvShowViewModel(mMovieCatalogueRepository);
        } else if (modelClass.isAssignableFrom(MovieFavoriteViewModel.class)) {
            //noinspection unchecked
            return (T) new MovieFavoriteViewModel(mMovieCatalogueRepository);
        } else if (modelClass.isAssignableFrom(TvShowFavoriteViewModel.class)) {
            //noinspection unchecked
            return (T) new TvShowFavoriteViewModel(mMovieCatalogueRepository);
        } else if (modelClass.isAssignableFrom(MovieDetailViewModel.class)) {
            //noinspection unchecked
            return (T) new MovieDetailViewModel(mMovieCatalogueRepository);
        } else if (modelClass.isAssignableFrom(TvShowDetailViewModel.class)) {
            //noinspection unchecked
>>>>>>> repository-dev
            return (T) new TvShowDetailViewModel(mMovieCatalogueRepository);
        }

        throw new IllegalArgumentException("Unknown ViewModel class: " + modelClass.getName());
    }
}
<<<<<<< HEAD
=======

>>>>>>> repository-dev

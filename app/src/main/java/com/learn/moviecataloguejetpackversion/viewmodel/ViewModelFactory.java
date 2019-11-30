package com.learn.moviecataloguejetpackversion.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.learn.moviecataloguejetpackversion.data.source.MovieCatalogueRepository;
import com.learn.moviecataloguejetpackversion.di.Injection;
import com.learn.moviecataloguejetpackversion.ui.detail.movie.MovieDetailViewModel;
import com.learn.moviecataloguejetpackversion.ui.detail.tvshow.TvShowDetailViewModel;
import com.learn.moviecataloguejetpackversion.ui.movie.MovieViewModel;
import com.learn.moviecataloguejetpackversion.ui.tvshow.TvShowViewModel;

public class ViewModelFactory extends ViewModelProvider.NewInstanceFactory {
    private static volatile ViewModelFactory INSTANCE;

    private final MovieCatalogueRepository mMovieCatalogueRepository;

    private ViewModelFactory(MovieCatalogueRepository movieCatalogueRepository) {
        mMovieCatalogueRepository = movieCatalogueRepository;
    }

    public static ViewModelFactory getInstance(Application application) {
        if (INSTANCE == null) {
            synchronized (ViewModelFactory.class) {
                if (INSTANCE == null) {
                    INSTANCE = new ViewModelFactory(Injection.provideRepository(application));
                }
            }
        }
        return INSTANCE;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(MovieViewModel.class)) {
            //noinspection unchecked
            return (T) new MovieViewModel(mMovieCatalogueRepository);
        } else if (modelClass.isAssignableFrom(TvShowViewModel.class)) {
            //noinspection unchecked
            return (T) new TvShowViewModel(mMovieCatalogueRepository);
        } else if (modelClass.isAssignableFrom(MovieDetailViewModel.class)) {
            //noinspection unchecked
            return (T) new MovieDetailViewModel(mMovieCatalogueRepository);
        } else if (modelClass.isAssignableFrom(TvShowDetailViewModel.class)) {
            //noinspection unchecked
            return (T) new TvShowDetailViewModel(mMovieCatalogueRepository);
        }

        throw new IllegalArgumentException("Unknown ViewModel class: " + modelClass.getName());
    }
}


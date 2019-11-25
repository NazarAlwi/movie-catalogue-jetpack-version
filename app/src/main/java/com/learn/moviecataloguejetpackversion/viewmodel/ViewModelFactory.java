package com.learn.moviecataloguejetpackversion.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.learn.moviecataloguejetpackversion.data.source.MovieCatalogueRepository;
import com.learn.moviecataloguejetpackversion.di.Injection;

public class ViewModelFactory extends ViewModelProvider.NewInstanceFactory {
    private static volatile ViewModelFactory INSTANCE;

    private final MovieCatalogueRepository mMovieCatalogueRepository;

    public ViewModelFactory(MovieCatalogueRepository MovieCatalogueRepository) {
        this.mMovieCatalogueRepository = MovieCatalogueRepository;
    }

    public static ViewModelFactory getINSTANCE(Application application) {
        if (INSTANCE == null) {
            synchronized (ViewModelFactory.class) {
                if (INSTANCE == null) {
                    INSTANCE = new ViewModelFactory(Injection.providerRepository(application));
                }
            }
        }
        return INSTANCE;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(MainViewModel.class)) {
            return (T) new MainViewModel(mMovieCatalogueRepository);
        } else if (modelClass.isAssignableFrom(MovieDetailViewModel.class)) {
            return (T) new MovieDetailViewModel(mMovieCatalogueRepository);
        } else if (modelClass.isAssignableFrom(TvShowDetailViewModel.class)) {
            return (T) new TvShowDetailViewModel(mMovieCatalogueRepository);
        }

        throw new IllegalArgumentException("Unknown ViewModel class: " + modelClass.getName());
    }
}

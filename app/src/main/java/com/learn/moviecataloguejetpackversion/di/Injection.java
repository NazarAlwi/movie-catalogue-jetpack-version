package com.learn.moviecataloguejetpackversion.di;

import android.app.Application;

import com.learn.moviecataloguejetpackversion.data.source.MovieCatalogueRepository;
import com.learn.moviecataloguejetpackversion.data.source.local.LocalRepository;
import com.learn.moviecataloguejetpackversion.data.source.local.room.MovieCatalogueDatabase;
import com.learn.moviecataloguejetpackversion.data.source.remote.RemoteRepository;
import com.learn.moviecataloguejetpackversion.utils.AppExecutors;
import com.learn.moviecataloguejetpackversion.utils.JsonHelper;

public class Injection {
    public static MovieCatalogueRepository provideRepository(Application application) {
        MovieCatalogueDatabase movieCatalogueDatabase = MovieCatalogueDatabase.getInstance(application);

        LocalRepository localRepository = LocalRepository.getInstance(movieCatalogueDatabase.movieCatalogueDao());
        RemoteRepository remoteRepository = RemoteRepository.getInstance(new JsonHelper(application));
        AppExecutors appExecutors = new AppExecutors();

        return MovieCatalogueRepository.getInstance(localRepository, remoteRepository, appExecutors);
    }
}

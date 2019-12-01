package com.learn.moviecataloguejetpackversion.di;

import android.app.Application;

import com.learn.moviecataloguejetpackversion.data.source.MovieCatalogueRepository;
import com.learn.moviecataloguejetpackversion.data.source.remote.RemoteRepository;
import com.learn.moviecataloguejetpackversion.utils.JsonHelper;

public class Injection {
<<<<<<< HEAD
    public static MovieCatalogueRepository providerRepository(Application application) {
=======
    public static MovieCatalogueRepository provideRepository(Application application) {

>>>>>>> repository-dev
        RemoteRepository remoteRepository = RemoteRepository.getInstance(new JsonHelper(application));

        return MovieCatalogueRepository.getInstance(remoteRepository);
    }
}

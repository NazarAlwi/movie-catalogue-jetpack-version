package com.learn.moviecataloguejetpackversion.di;

import android.app.Application;

import com.learn.moviecataloguejetpackversion.data.source.MovieCatalogueRepository;
import com.learn.moviecataloguejetpackversion.data.source.remote.RemoteRepository;
import com.learn.moviecataloguejetpackversion.utils.JsonHelper;

public class Injection {
    public static MovieCatalogueRepository providerRepository(Application application) {
        RemoteRepository remoteRepository = RemoteRepository.getINSTANCE(new JsonHelper(application));

        return MovieCatalogueRepository.getINSTANCE(remoteRepository);
    }
}

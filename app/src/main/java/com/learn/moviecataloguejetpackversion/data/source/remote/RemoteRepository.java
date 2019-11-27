package com.learn.moviecataloguejetpackversion.data.source.remote;

import com.learn.moviecataloguejetpackversion.data.source.remote.response.MovieResponse;
import com.learn.moviecataloguejetpackversion.data.source.remote.response.TvShowResponse;
import com.learn.moviecataloguejetpackversion.utils.JsonHelper;

import java.util.List;

public class RemoteRepository {
    private static RemoteRepository INSTANCE;
    private JsonHelper jsonHelper;

    private RemoteRepository(JsonHelper jsonHelper) {
        this.jsonHelper = jsonHelper;
    }

    public static RemoteRepository getInstance(JsonHelper jsonHelper) {
        if (INSTANCE == null) {
            INSTANCE = new RemoteRepository(jsonHelper);
        }
        return INSTANCE;
    }

    public List<MovieResponse> getAllMovie() {
        return jsonHelper.loadMovie();
    }

    public List<TvShowResponse> getAllTvShow() {
        return jsonHelper.loadTvShow();
    }
}

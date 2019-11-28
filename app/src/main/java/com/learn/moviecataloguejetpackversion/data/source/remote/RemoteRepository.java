package com.learn.moviecataloguejetpackversion.data.source.remote;

import android.os.Handler;

import com.learn.moviecataloguejetpackversion.data.source.remote.response.MovieResponse;
import com.learn.moviecataloguejetpackversion.data.source.remote.response.TvShowResponse;
import com.learn.moviecataloguejetpackversion.utils.JsonHelper;

import java.util.List;

public class RemoteRepository {
    private static RemoteRepository INSTANCE;
    private JsonHelper jsonHelper;
    private final long SERVICE_LATENCY_IN_MILLIS = 2000;

    private RemoteRepository(JsonHelper jsonHelper) {
        this.jsonHelper = jsonHelper;
    }

    public static RemoteRepository getInstance(JsonHelper helper) {
        if (INSTANCE == null) {
            INSTANCE = new RemoteRepository(helper);
        }
        return INSTANCE;
    }

    public void getAllMovie(LoadMovieCallback callback) {
        Handler handler = new Handler();
        handler.postDelayed(() -> callback.onAllMovieReceived(jsonHelper.loadMovies()), SERVICE_LATENCY_IN_MILLIS);
    }

    public void getAllTvShow(LoadTvShowCallback callback) {
        Handler handler = new Handler();
        handler.postDelayed(() -> callback.onAllTvShowReceived(jsonHelper.loadTvShows()), SERVICE_LATENCY_IN_MILLIS);
    }

    public interface LoadMovieCallback {
        void onAllMovieReceived(List<MovieResponse> movieResponses);

        void onDataNotAvailable();
    }

    public interface LoadTvShowCallback {
        void onAllTvShowReceived(List<TvShowResponse> tvShowResponses);

        void onDataNotAvailable();
    }
}

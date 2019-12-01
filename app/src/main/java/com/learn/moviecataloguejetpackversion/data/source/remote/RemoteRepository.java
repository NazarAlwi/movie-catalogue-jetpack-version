package com.learn.moviecataloguejetpackversion.data.source.remote;

<<<<<<< HEAD
import com.learn.moviecataloguejetpackversion.data.source.remote.response.MovieResponse;
import com.learn.moviecataloguejetpackversion.data.source.remote.response.TvShowResponse;
=======
import android.os.Handler;

import com.learn.moviecataloguejetpackversion.data.source.remote.response.MovieResponse;
import com.learn.moviecataloguejetpackversion.data.source.remote.response.TvShowResponse;
import com.learn.moviecataloguejetpackversion.utils.EspressoIdlingResource;
>>>>>>> repository-dev
import com.learn.moviecataloguejetpackversion.utils.JsonHelper;

import java.util.List;

public class RemoteRepository {
    private static RemoteRepository INSTANCE;
    private JsonHelper jsonHelper;
<<<<<<< HEAD
=======
    private final long SERVICE_LATENCY_IN_MILLIS = 2000;
>>>>>>> repository-dev

    private RemoteRepository(JsonHelper jsonHelper) {
        this.jsonHelper = jsonHelper;
    }

<<<<<<< HEAD
    public static RemoteRepository getInstance(JsonHelper jsonHelper) {
        if (INSTANCE == null) {
            INSTANCE = new RemoteRepository(jsonHelper);
=======
    public static RemoteRepository getInstance(JsonHelper helper) {
        if (INSTANCE == null) {
            INSTANCE = new RemoteRepository(helper);
>>>>>>> repository-dev
        }
        return INSTANCE;
    }

<<<<<<< HEAD
    public List<MovieResponse> getAllMovie() {
        return jsonHelper.loadMovie();
    }

    public List<TvShowResponse> getAllTvShow() {
        return jsonHelper.loadTvShow();
=======
    public void getAllMovie(LoadMovieCallback callback) {
        EspressoIdlingResource.increment();
        Handler handler = new Handler();
        handler.postDelayed(() -> {
            callback.onAllMovieReceived(jsonHelper.loadMovies());
            EspressoIdlingResource.decrement();
        }, SERVICE_LATENCY_IN_MILLIS);
    }

    public void getAllTvShow(LoadTvShowCallback callback) {
        EspressoIdlingResource.increment();
        Handler handler = new Handler();
        handler.postDelayed(() -> {
            callback.onAllTvShowReceived(jsonHelper.loadTvShows());
            EspressoIdlingResource.decrement();
        }, SERVICE_LATENCY_IN_MILLIS);
    }

    public interface LoadMovieCallback {
        void onAllMovieReceived(List<MovieResponse> movieResponses);

        void onDataNotAvailable();
    }

    public interface LoadTvShowCallback {
        void onAllTvShowReceived(List<TvShowResponse> tvShowResponses);

        void onDataNotAvailable();
>>>>>>> repository-dev
    }
}

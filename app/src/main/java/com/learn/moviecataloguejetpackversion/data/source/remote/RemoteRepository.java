package com.learn.moviecataloguejetpackversion.data.source.remote;

import android.os.Handler;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.learn.moviecataloguejetpackversion.data.source.remote.response.MovieResponse;
import com.learn.moviecataloguejetpackversion.data.source.remote.response.TvShowResponse;
import com.learn.moviecataloguejetpackversion.utils.EspressoIdlingResource;
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

    public LiveData<ApiResponse<List<MovieResponse>>> getAllMovieAsLiveData() {
        EspressoIdlingResource.increment();
        MutableLiveData<ApiResponse<List<MovieResponse>>> resultMovie = new MutableLiveData<>();

        Handler handler = new Handler();
        handler.postDelayed(() -> {
            resultMovie.setValue(ApiResponse.success(jsonHelper.loadMovies()));
            if (!EspressoIdlingResource.getEspressoIdlingResource().isIdleNow()) {
                EspressoIdlingResource.decrement();
            }
        }, SERVICE_LATENCY_IN_MILLIS);

        return resultMovie;
    }

    public LiveData<ApiResponse<List<TvShowResponse>>> getAllTvShowAsLiveData() {
        EspressoIdlingResource.increment();
        MutableLiveData<ApiResponse<List<TvShowResponse>>> resultTvShow = new MutableLiveData<>();

        Handler handler = new Handler();
        handler.postDelayed(() -> {
            resultTvShow.setValue(ApiResponse.success(jsonHelper.loadTvShows()));
            if (!EspressoIdlingResource.getEspressoIdlingResource().isIdleNow()) {
                EspressoIdlingResource.decrement();
            }
        }, SERVICE_LATENCY_IN_MILLIS);

        return resultTvShow;
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

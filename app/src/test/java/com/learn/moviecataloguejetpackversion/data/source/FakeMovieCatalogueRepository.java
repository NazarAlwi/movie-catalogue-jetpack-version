package com.learn.moviecataloguejetpackversion.data.source;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.learn.moviecataloguejetpackversion.data.source.local.entity.Movie;
import com.learn.moviecataloguejetpackversion.data.source.local.entity.TvShow;
import com.learn.moviecataloguejetpackversion.data.source.remote.RemoteRepository;
import com.learn.moviecataloguejetpackversion.data.source.remote.response.MovieResponse;
import com.learn.moviecataloguejetpackversion.data.source.remote.response.TvShowResponse;

import java.util.ArrayList;
import java.util.List;

public class FakeMovieCatalogueRepository implements MovieCatalogueDataSource {
    private volatile static FakeMovieCatalogueRepository INSTANCE = null;
    private final RemoteRepository remoteRepository;

    FakeMovieCatalogueRepository(@NonNull RemoteRepository remoteRepository) {
        this.remoteRepository = remoteRepository;
    }

    public static FakeMovieCatalogueRepository getInstance(RemoteRepository remoteData) {
        if (INSTANCE == null) {
            synchronized (FakeMovieCatalogueRepository.class) {
                if (INSTANCE == null) {
                    INSTANCE = new FakeMovieCatalogueRepository(remoteData);
                }
            }
        }
        return INSTANCE;
    }

    @Override
    public LiveData<List<Movie>> getAllMovie() {
        MutableLiveData<List<Movie>> movieResult = new MutableLiveData<>();

        remoteRepository.getAllMovie(new RemoteRepository.LoadMovieCallback() {
            @Override
            public void onAllMovieReceived(List<MovieResponse> movieResponses) {
                ArrayList<Movie> movieList = new ArrayList<>();
                for (int i = 0; i < movieResponses.size(); i++) {
                    MovieResponse response = movieResponses.get(i);
                    Movie movie = new Movie(response.getIdMovieResponse(),
                            response.getPhotoMovieResponse(),
                            response.getNameMovieResponse(),
                            response.getOverviewMovieResponse(),
                            response.getVoteMovieResponse(),
                            response.getReleaseMovieResponse(),
                            response.getPopularityMovieResponse(),
                            response.getBackdropMovieResponse());

                    movieList.add(movie);
                }
                movieResult.postValue(movieList);
            }

            @Override
            public void onDataNotAvailable() {

            }
        });

        return movieResult;
    }

    @Override
    public LiveData<List<TvShow>> getAllTvShow() {
        MutableLiveData<List<TvShow>> tvShowResult = new MutableLiveData<>();

        remoteRepository.getAllTvShow(new RemoteRepository.LoadTvShowCallback() {
            @Override
            public void onAllTvShowReceived(List<TvShowResponse> tvShowResponses) {
                ArrayList<TvShow> tvShowList = new ArrayList<>();
                for (int i = 0; i < tvShowResponses.size(); i++) {
                    TvShowResponse response = tvShowResponses.get(i);
                    TvShow tvShow = new TvShow(response.getIdTvShowResponse(),
                            response.getPhotoTvShowResponse(),
                            response.getNameTvShowResponse(),
                            response.getOverviewTvShowResponse(),
                            response.getVoteTvShowResponse(),
                            response.getReleaseTvShowResponse(),
                            response.getPopularityTvShowResponse(),
                            response.getBackdropTvShowResponse());

                    tvShowList.add(tvShow);
                }
                tvShowResult.postValue(tvShowList);
            }

            @Override
            public void onDataNotAvailable() {

            }
        });

        return tvShowResult;
    }

    @Override
    public LiveData<Movie> getMovieById(final String idMovie) {
        MutableLiveData<Movie> movieResult = new MutableLiveData<>();

        remoteRepository.getAllMovie(new RemoteRepository.LoadMovieCallback() {
            @Override
            public void onAllMovieReceived(List<MovieResponse> movieResponses) {
                for (int i = 0; i < movieResponses.size(); i++) {
                    MovieResponse response = movieResponses.get(i);
                    if (response.getIdMovieResponse().equals(idMovie)) {
                        Movie movie = new Movie(response.getIdMovieResponse(),
                                response.getPhotoMovieResponse(),
                                response.getNameMovieResponse(),
                                response.getOverviewMovieResponse(),
                                response.getVoteMovieResponse(),
                                response.getReleaseMovieResponse(),
                                response.getPopularityMovieResponse(),
                                response.getBackdropMovieResponse());

                        movieResult.postValue(movie);
                    }
                }
            }

            @Override
            public void onDataNotAvailable() {

            }
        });

        return movieResult;
    }

    @Override
    public LiveData<TvShow> getTvShowById(String idTvShow) {
        MutableLiveData<TvShow> tvShowResult = new MutableLiveData<>();

        remoteRepository.getAllTvShow(new RemoteRepository.LoadTvShowCallback() {
            @Override
            public void onAllTvShowReceived(List<TvShowResponse> tvShowResponses) {
                for (int i = 0; i < tvShowResponses.size(); i++) {
                    TvShowResponse response = tvShowResponses.get(i);
                    if (response.getIdTvShowResponse().equals(idTvShow)) {
                        TvShow tvShow = new TvShow(response.getIdTvShowResponse(),
                                response.getPhotoTvShowResponse(),
                                response.getNameTvShowResponse(),
                                response.getOverviewTvShowResponse(),
                                response.getVoteTvShowResponse(),
                                response.getReleaseTvShowResponse(),
                                response.getPopularityTvShowResponse(),
                                response.getBackdropTvShowResponse());

                        tvShowResult.postValue(tvShow);
                    }
                }
            }

            @Override
            public void onDataNotAvailable() {

            }
        });

        return tvShowResult;
    }
}

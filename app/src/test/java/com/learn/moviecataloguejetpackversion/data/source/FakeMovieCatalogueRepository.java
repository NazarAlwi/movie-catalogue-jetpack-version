package com.learn.moviecataloguejetpackversion.data.source;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;

import com.learn.moviecataloguejetpackversion.data.source.local.LocalRepository;
import com.learn.moviecataloguejetpackversion.data.source.local.entity.Movie;
import com.learn.moviecataloguejetpackversion.data.source.local.entity.TvShow;
import com.learn.moviecataloguejetpackversion.data.source.remote.ApiResponse;
import com.learn.moviecataloguejetpackversion.data.source.remote.RemoteRepository;
import com.learn.moviecataloguejetpackversion.data.source.remote.response.MovieResponse;
import com.learn.moviecataloguejetpackversion.data.source.remote.response.TvShowResponse;
import com.learn.moviecataloguejetpackversion.utils.AppExecutors;
import com.learn.moviecataloguejetpackversion.vo.Resource;

import java.util.ArrayList;
import java.util.List;

public class FakeMovieCatalogueRepository implements MovieCatalogueDataSource {
    private volatile static FakeMovieCatalogueRepository INSTANCE = null;

    private final LocalRepository localRepository;
    private final RemoteRepository remoteRepository;
    private final AppExecutors appExecutors;

    FakeMovieCatalogueRepository(@NonNull LocalRepository localRepository, @NonNull RemoteRepository remoteRepository, AppExecutors appExecutors) {
        this.localRepository = localRepository;
        this.remoteRepository = remoteRepository;
        this.appExecutors = appExecutors;
    }

    public static FakeMovieCatalogueRepository getInstance(LocalRepository localRepository, RemoteRepository remoteData, AppExecutors appExecutors) {
        if (INSTANCE == null) {
            synchronized (FakeMovieCatalogueRepository.class) {
                if (INSTANCE == null) {
                    INSTANCE = new FakeMovieCatalogueRepository(localRepository, remoteData, appExecutors);
                }
            }
        }
        return INSTANCE;
    }

    @Override
    public LiveData<Resource<List<Movie>>> getAllMovie() {
        return new NetworkBoundResource<List<Movie>, List<MovieResponse>>(appExecutors) {
            @Override
            protected LiveData<List<Movie>> loadFromDB() {
                return localRepository.getAllMovie();
            }

            @Override
            protected Boolean shouldFetch(List<Movie> data) {
                return (data == null) || (data.size() == 0);
            }

            @Override
            protected LiveData<ApiResponse<List<MovieResponse>>> createCall() {
                return remoteRepository.getAllMovieAsLiveData();
            }

            @Override
            protected void saveCallResult(List<MovieResponse> data) {
                List<Movie> movies = new ArrayList<>();

                for (MovieResponse movieResponse : data) {
                    movies.add(new Movie(movieResponse.getIdMovieResponse(),
                            movieResponse.getPhotoMovieResponse(),
                            movieResponse.getNameMovieResponse(),
                            movieResponse.getOverviewMovieResponse(),
                            movieResponse.getVoteMovieResponse(),
                            movieResponse.getReleaseMovieResponse(),
                            movieResponse.getPopularityMovieResponse(),
                            movieResponse.getBackdropMovieResponse(),
                            null));
                }

                localRepository.insertMovie(movies);
            }
        }.asLiveData();
    }

    @Override
    public LiveData<Resource<List<TvShow>>> getAllTvShow() {
        return new NetworkBoundResource<List<TvShow>, List<TvShowResponse>>(appExecutors) {
            @Override
            protected LiveData<List<TvShow>> loadFromDB() {
                return localRepository.getAllTvShow();
            }

            @Override
            protected Boolean shouldFetch(List<TvShow> data) {
                return (data == null) || (data.size() == 0);
            }

            @Override
            protected LiveData<ApiResponse<List<TvShowResponse>>> createCall() {
                return remoteRepository.getAllTvShowAsLiveData();
            }

            @Override
            protected void saveCallResult(List<TvShowResponse> data) {
                List<TvShow> tvShows = new ArrayList<>();

                for (TvShowResponse tvShowResponse : data) {
                    tvShows.add(new TvShow(tvShowResponse.getIdTvShowResponse(),
                            tvShowResponse.getPhotoTvShowResponse(),
                            tvShowResponse.getNameTvShowResponse(),
                            tvShowResponse.getOverviewTvShowResponse(),
                            tvShowResponse.getVoteTvShowResponse(),
                            tvShowResponse.getReleaseTvShowResponse(),
                            tvShowResponse.getPopularityTvShowResponse(),
                            tvShowResponse.getBackdropTvShowResponse(),
                            null));
                }
                localRepository.insertTvShow(tvShows);
            }
        }.asLiveData();
    }

    @Override
    public LiveData<Resource<List<Movie>>> getAllMovieFavorite() {
        return new NetworkBoundResource<List<Movie>, List<MovieResponse>>(appExecutors) {
            @Override
            protected LiveData<List<Movie>> loadFromDB() {
                return localRepository.getAllMovieFavorite();
            }

            @Override
            protected Boolean shouldFetch(List<Movie> data) {
                return false;
            }

            @Override
            protected LiveData<ApiResponse<List<MovieResponse>>> createCall() {
                return null;
            }

            @Override
            protected void saveCallResult(List<MovieResponse> data) {

            }
        }.asLiveData();
    }

    @Override
    public LiveData<Resource<List<TvShow>>> getAllTvShowFavorite() {
        return new NetworkBoundResource<List<TvShow>, List<TvShowResponse>>(appExecutors) {
            @Override
            protected LiveData<List<TvShow>> loadFromDB() {
                return localRepository.getAllTvShowFavorite();
            }

            @Override
            protected Boolean shouldFetch(List<TvShow> data) {
                return false;
            }

            @Override
            protected LiveData<ApiResponse<List<TvShowResponse>>> createCall() {
                return null;
            }

            @Override
            protected void saveCallResult(List<TvShowResponse> data) {

            }
        }.asLiveData();
    }

    @Override
    public LiveData<Resource<Movie>> getMovieById(final String idMovie) {
        return new NetworkBoundResource<Movie, List<MovieResponse>>(appExecutors) {
            @Override
            protected LiveData<Movie> loadFromDB() {
                return localRepository.getMovieById(idMovie);
            }

            @Override
            protected Boolean shouldFetch(Movie data) {
                return data == null;
            }

            @Override
            protected LiveData<ApiResponse<List<MovieResponse>>> createCall() {
                return remoteRepository.getAllMovieAsLiveData();
            }

            @Override
            protected void saveCallResult(List<MovieResponse> data) {
                List<Movie> movies = new ArrayList<>();

                for (MovieResponse movieResponse : data) {
                    movies.add(new Movie(movieResponse.getIdMovieResponse(), movieResponse.getPhotoMovieResponse(), movieResponse.getNameMovieResponse(), movieResponse.getOverviewMovieResponse(), movieResponse.getVoteMovieResponse(), movieResponse.getReleaseMovieResponse(), movieResponse.getPopularityMovieResponse(), movieResponse.getBackdropMovieResponse(), null));
                }

                localRepository.insertMovie(movies);
            }
        }.asLiveData();
    }

    @Override
    public LiveData<Resource<TvShow>> getTvShowById(String idTvShow) {
        return new NetworkBoundResource<TvShow, List<TvShowResponse>>(appExecutors) {
            @Override
            protected LiveData<TvShow> loadFromDB() {
                return localRepository.getTvShowById(idTvShow);
            }

            @Override
            protected Boolean shouldFetch(TvShow data) {
                return data == null;
            }

            @Override
            protected LiveData<ApiResponse<List<TvShowResponse>>> createCall() {
                return remoteRepository.getAllTvShowAsLiveData();
            }

            @Override
            protected void saveCallResult(List<TvShowResponse> data) {
                List<TvShow> tvShows = new ArrayList<>();

                for (TvShowResponse tvShowResponse : data) {
                    tvShows.add(new TvShow(tvShowResponse.getIdTvShowResponse(), tvShowResponse.getPhotoTvShowResponse(), tvShowResponse.getNameTvShowResponse(), tvShowResponse.getOverviewTvShowResponse(), tvShowResponse.getVoteTvShowResponse(), tvShowResponse.getReleaseTvShowResponse(), tvShowResponse.getPopularityTvShowResponse(), tvShowResponse.getBackdropTvShowResponse(), null));
                }

                localRepository.insertTvShow(tvShows);
            }
        }.asLiveData();
    }

    @Override
    public void setMovieFavorite(Movie movie, boolean state) {
        Runnable runnable = () -> localRepository.setMovieFavorite(movie, state);
        appExecutors.diskIO().execute(runnable);
    }

    @Override
    public void setTvShowFavorite(TvShow tvShow, boolean state) {
        Runnable runnable = () -> localRepository.setTvShowFavorite(tvShow, state);
        appExecutors.diskIO().execute(runnable);
    }
}

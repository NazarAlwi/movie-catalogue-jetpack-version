package com.learn.moviecataloguejetpackversion.data.source;

import androidx.annotation.NonNull;
<<<<<<< HEAD

import com.learn.moviecataloguejetpackversion.data.source.remote.RemoteRepository;
import com.learn.moviecataloguejetpackversion.data.source.remote.response.MovieResponse;
import com.learn.moviecataloguejetpackversion.data.source.remote.response.TvShowResponse;
import com.learn.moviecataloguejetpackversion.data.source.local.entity.Movie;
import com.learn.moviecataloguejetpackversion.data.source.local.entity.TvShow;
=======
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.learn.moviecataloguejetpackversion.data.source.local.entity.Movie;
import com.learn.moviecataloguejetpackversion.data.source.local.entity.TvShow;
import com.learn.moviecataloguejetpackversion.data.source.remote.RemoteRepository;
import com.learn.moviecataloguejetpackversion.data.source.remote.response.MovieResponse;
import com.learn.moviecataloguejetpackversion.data.source.remote.response.TvShowResponse;
>>>>>>> repository-dev

import java.util.ArrayList;
import java.util.List;

public class MovieCatalogueRepository implements MovieCatalogueDataSource {
    private volatile static MovieCatalogueRepository INSTANCE = null;
    private final RemoteRepository remoteRepository;

<<<<<<< HEAD
    public MovieCatalogueRepository(@NonNull RemoteRepository remoteRepository) {
        this.remoteRepository = remoteRepository;
    }

    public static MovieCatalogueRepository getInstance(RemoteRepository remoteRepository) {
        if (INSTANCE == null) {
            synchronized (MovieCatalogueRepository.class) {
                if (INSTANCE == null) {
                    INSTANCE = new MovieCatalogueRepository(remoteRepository);
=======
    private MovieCatalogueRepository(@NonNull RemoteRepository remoteRepository) {
        this.remoteRepository = remoteRepository;
    }

    public static MovieCatalogueRepository getInstance(RemoteRepository remoteData) {
        if (INSTANCE == null) {
            synchronized (MovieCatalogueRepository.class) {
                if (INSTANCE == null) {
                    INSTANCE = new MovieCatalogueRepository(remoteData);
>>>>>>> repository-dev
                }
            }
        }
        return INSTANCE;
    }

    @Override
<<<<<<< HEAD
    public ArrayList<Movie> getAllMovie() {
        List<MovieResponse> movieResponses = remoteRepository.getAllMovie();
        ArrayList<Movie> movies = new ArrayList<>();
        for (int i = 0; i < movieResponses.size(); i++) {
            MovieResponse response = movieResponses.get(i);
            Movie movie = new Movie(response.getIdMovie(),
                    response.getPhotoMovie(),
                    response.getNameMovie(),
                    response.getOverviewMovie(),
                    response.getVoteMovie(),
                    response.getReleaseMovie(),
                    response.getPopularityMovie(),
                    response.getBackdropMovie());

            movies.add(movie);
        }

        return movies;
    }

    @Override
    public ArrayList<TvShow> getAllTvShow() {
        List<TvShowResponse> tvShowResponses = remoteRepository.getAllTvShow();
        ArrayList<TvShow> tvShows = new ArrayList<>();
        for (int i = 0; i < tvShowResponses.size(); i++) {
            TvShowResponse response = tvShowResponses.get(i);
            TvShow tvShow = new TvShow(response.getIdTvShow(), response.getPhotoTvShow(), response.getNameTvShow(), response.getOverviewTvShow(), response.getVoteTvShow(), response.getReleaseTvShow(), response.getPopularityTvShow(), response.getBackdropTvShow());
            tvShows.add(tvShow);
        }

        return tvShows;
    }

    @Override
    public Movie getMovieWithId(String idMovie) {
        Movie movie = null;
        List<MovieResponse> movieResponses = remoteRepository.getAllMovie();
        for (int i = 0; i < movieResponses.size(); i++) {
            MovieResponse response = movieResponses.get(i);
            if (response.getIdMovie().equals(idMovie)) {
                movie = new Movie(response.getIdMovie(), response.getPhotoMovie(), response.getNameMovie(), response.getOverviewMovie(), response.getVoteMovie(), response.getReleaseMovie(), response.getPopularityMovie(), response.getBackdropMovie());
            }
        }

        return movie;
    }

    @Override
    public TvShow getTvShowWithId(String idTvShow) {
        TvShow tvShow = null;
        List<TvShowResponse> tvShowResponses = remoteRepository.getAllTvShow();
        for (int i = 0; i < tvShowResponses.size(); i++) {
            TvShowResponse response = tvShowResponses.get(i);
            if (response.getIdTvShow().equals(idTvShow)) {
                tvShow = new TvShow(response.getIdTvShow(), response.getPhotoTvShow(), response.getNameTvShow(), response.getOverviewTvShow(), response.getVoteTvShow(), response.getReleaseTvShow(), response.getPopularityTvShow(), response.getBackdropTvShow());
            }
        }

        return tvShow;
=======
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
                            response.getBackdropMovieResponse(),
                            false);

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
                            response.getBackdropTvShowResponse(),
                            false);

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
    public LiveData<List<Movie>> getAllMovieFavorite() {
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
                            response.getBackdropMovieResponse(),
                            false);

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
    public LiveData<List<TvShow>> getAllTvShowFavorite() {
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
                            response.getBackdropTvShowResponse(),
                            false);

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
                                response.getBackdropMovieResponse(),
                                false);

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
                                response.getBackdropTvShowResponse(),
                                false);

                        tvShowResult.postValue(tvShow);
                    }
                }
            }

            @Override
            public void onDataNotAvailable() {

            }
        });

        return tvShowResult;
>>>>>>> repository-dev
    }
}

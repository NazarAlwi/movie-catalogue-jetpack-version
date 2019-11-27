package com.learn.moviecataloguejetpackversion.data.source;

import androidx.annotation.NonNull;

import com.learn.moviecataloguejetpackversion.data.source.remote.RemoteRepository;
import com.learn.moviecataloguejetpackversion.data.source.remote.response.MovieResponse;
import com.learn.moviecataloguejetpackversion.data.source.remote.response.TvShowResponse;
import com.learn.moviecataloguejetpackversion.data.source.local.entity.Movie;
import com.learn.moviecataloguejetpackversion.data.source.local.entity.TvShow;

import java.util.ArrayList;
import java.util.List;

public class MovieCatalogueRepository implements MovieCatalogueDataSource {
    private volatile static MovieCatalogueRepository INSTANCE = null;
    private final RemoteRepository remoteRepository;

    public MovieCatalogueRepository(@NonNull RemoteRepository remoteRepository) {
        this.remoteRepository = remoteRepository;
    }

    public static MovieCatalogueRepository getInstance(RemoteRepository remoteRepository) {
        if (INSTANCE == null) {
            synchronized (MovieCatalogueRepository.class) {
                if (INSTANCE == null) {
                    INSTANCE = new MovieCatalogueRepository(remoteRepository);
                }
            }
        }
        return INSTANCE;
    }

    @Override
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
    }
}

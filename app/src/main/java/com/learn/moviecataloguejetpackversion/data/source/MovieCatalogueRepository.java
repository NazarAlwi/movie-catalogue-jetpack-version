package com.learn.moviecataloguejetpackversion.data.source;

import androidx.annotation.NonNull;

import com.learn.moviecataloguejetpackversion.data.source.local.entity.Movie;
import com.learn.moviecataloguejetpackversion.data.source.local.entity.TvShow;
import com.learn.moviecataloguejetpackversion.data.source.remote.RemoteRepository;
import com.learn.moviecataloguejetpackversion.data.source.remote.response.MovieResponse;
import com.learn.moviecataloguejetpackversion.data.source.remote.response.TvShowResponse;

import java.util.ArrayList;
import java.util.List;

public class MovieCatalogueRepository implements MovieCatalogueDataSource {
    private volatile static MovieCatalogueRepository INSTANCE = null;
    private final RemoteRepository remoteRepository;

    private MovieCatalogueRepository(@NonNull RemoteRepository remoteRepository) {
        this.remoteRepository = remoteRepository;
    }

    public static MovieCatalogueRepository getInstance(RemoteRepository remoteData) {
        if (INSTANCE == null) {
            synchronized (MovieCatalogueRepository.class) {
                if (INSTANCE == null) {
                    INSTANCE = new MovieCatalogueRepository(remoteData);
                }
            }
        }
        return INSTANCE;
    }

    @Override
    public ArrayList<Movie> getAllMovie() {
        List<MovieResponse> movieResponses = remoteRepository.getAllMovie();
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

        return movieList;
    }

    @Override
    public ArrayList<TvShow> getAllTvShow() {
        List<TvShowResponse> tvShowResponses = remoteRepository.getAllTvShow();
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

        return tvShowList;
    }

    @Override
    public Movie getMovieById(String idMovie) {
//        List<MovieResponse> movieResponses = remoteRepository.
        return null;
    }

    @Override
    public TvShow getTvShow(String idTvShow) {
        return null;
    }
}

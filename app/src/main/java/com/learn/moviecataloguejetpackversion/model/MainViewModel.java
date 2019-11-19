package com.learn.moviecataloguejetpackversion.model;

import androidx.lifecycle.ViewModel;

import com.learn.moviecataloguejetpackversion.data.MovieData;

import java.util.ArrayList;

import static com.learn.moviecataloguejetpackversion.data.MovieData.dataMovieBackdrop;
import static com.learn.moviecataloguejetpackversion.data.MovieData.dataMovieName;
import static com.learn.moviecataloguejetpackversion.data.MovieData.dataMovieOverview;
import static com.learn.moviecataloguejetpackversion.data.MovieData.dataMoviePhoto;
import static com.learn.moviecataloguejetpackversion.data.MovieData.dataMoviePopularity;
import static com.learn.moviecataloguejetpackversion.data.MovieData.dataMovieRelease;
import static com.learn.moviecataloguejetpackversion.data.MovieData.dataMovieVote;
import static com.learn.moviecataloguejetpackversion.data.TvShowData.dataTvShowBackdrop;
import static com.learn.moviecataloguejetpackversion.data.TvShowData.dataTvShowName;
import static com.learn.moviecataloguejetpackversion.data.TvShowData.dataTvShowOverview;
import static com.learn.moviecataloguejetpackversion.data.TvShowData.dataTvShowPhoto;
import static com.learn.moviecataloguejetpackversion.data.TvShowData.dataTvShowPopularity;
import static com.learn.moviecataloguejetpackversion.data.TvShowData.dataTvShowRelease;
import static com.learn.moviecataloguejetpackversion.data.TvShowData.dataTvShowVote;

public class MainViewModel extends ViewModel {

    public static ArrayList<Movie> getListMovie() {
        ArrayList<Movie> list = new ArrayList<>();

        for (int i = 0; i < dataMovieName.length; i++) {
            Movie movie = new Movie();
            movie.setNameMovie(dataMovieName[i]);
            movie.setReleaseMovie(dataMovieRelease[i]);
            movie.setVoteMovie(dataMovieVote[i]);
            movie.setPopularityMovie(dataMoviePopularity[i]);
            movie.setOverviewMovie(dataMovieOverview[i]);
            movie.setPhotoMovie(dataMoviePhoto[i]);
            movie.setBackdropMovie(dataMovieBackdrop[i]);
            list.add(movie);
        }

        return list;
    }

    public static ArrayList<TvShow> getListTvShow() {
        ArrayList<TvShow> list = new ArrayList<>();

        for (int i = 0; i < dataTvShowName.length; i++) {
            TvShow tvShow = new TvShow();
            tvShow.setNameTvShow(dataTvShowName[i]);
            tvShow.setReleaseTvShow(dataTvShowRelease[i]);
            tvShow.setVoteTvShow(dataTvShowVote[i]);
            tvShow.setPopularityTvShow(dataTvShowPopularity[i]);
            tvShow.setOverviewTvShow(dataTvShowOverview[i]);
            tvShow.setPhotoTvShow(dataTvShowPhoto[i]);
            tvShow.setBackdropTvShow(dataTvShowBackdrop[i]);
            list.add(tvShow);
        }

        return list;
    }

    public static Movie getMovieDetail(Movie movie) {
        return movie;
    }

    public static TvShow getTvShowDetail(TvShow tvShow) {
        return tvShow;
    }
}

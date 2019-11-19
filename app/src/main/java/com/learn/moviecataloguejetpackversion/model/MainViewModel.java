package com.learn.moviecataloguejetpackversion.model;

import androidx.lifecycle.ViewModel;

import com.learn.moviecataloguejetpackversion.data.MovieData;
import com.learn.moviecataloguejetpackversion.data.TvShowData;

import java.util.ArrayList;

public class MainViewModel extends ViewModel {
    public static ArrayList<Movie> getListMovie() {
        return MovieData.generateMovieList();
    }

    public static ArrayList<TvShow> getListTvShow() {
        return TvShowData.generateTvShowList();
    }

    public static TvShow getTvShowDetail(TvShow tvShow) {
        return tvShow;
    }
}

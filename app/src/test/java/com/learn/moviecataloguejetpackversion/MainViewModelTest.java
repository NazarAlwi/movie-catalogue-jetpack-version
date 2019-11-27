package com.learn.moviecataloguejetpackversion;

import com.learn.moviecataloguejetpackversion.data.source.local.entity.Movie;
import com.learn.moviecataloguejetpackversion.model.MainViewModel;
import com.learn.moviecataloguejetpackversion.data.source.local.entity.TvShow;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class MainViewModelTest {
    private MainViewModel mainViewModel;

    @Before
    public void before() {
        mainViewModel = new MainViewModel();
    }

    @Test
    public void getListMovieTest() {
        ArrayList<Movie> movies = mainViewModel.getListMovie();

        assertNotNull(movies);
        assertEquals(10, movies.size());
    }

    @Test
    public void getListTvShowTest() {
        ArrayList<TvShow> tvShows = mainViewModel.getListTvShow();

        assertNotNull(tvShows);
        assertEquals(10, tvShows.size());
    }
}

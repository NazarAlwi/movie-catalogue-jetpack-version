package com.learn.moviecataloguejetpackversion;

import com.learn.moviecataloguejetpackversion.data.source.MovieCatalogueRepository;
import com.learn.moviecataloguejetpackversion.data.source.local.entity.Movie;
import com.learn.moviecataloguejetpackversion.data.source.local.entity.TvShow;
import com.learn.moviecataloguejetpackversion.utils.FakeMovieData;
import com.learn.moviecataloguejetpackversion.utils.FakeTvShowData;
import com.learn.moviecataloguejetpackversion.viewmodel.MainViewModel;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MainViewModelTest {
    private MainViewModel mainViewModel;
    private MovieCatalogueRepository movieCatalogueRepository = mock(MovieCatalogueRepository.class);

    @Before
    public void before() {
        mainViewModel = new MainViewModel(movieCatalogueRepository);
    }

    @Test
    public void getListMovieTest() {
        when(movieCatalogueRepository.getAllMovie()).thenReturn(FakeMovieData.generateMovieList());
        List<Movie> movies = mainViewModel.getListMovie();

        verify(movieCatalogueRepository).getAllMovie();

        assertNotNull(movies);
        assertEquals(10, movies.size());
    }

    @Test
    public void getListTvShowTest() {
        when(movieCatalogueRepository.getAllTvShow()).thenReturn(FakeTvShowData.generateTvShowList());
        List<TvShow> tvShows = mainViewModel.getListTvShow();

        verify(movieCatalogueRepository).getAllTvShow();

        assertNotNull(tvShows);
        assertEquals(10, tvShows.size());
    }
}

package com.learn.moviecataloguejetpackversion;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.learn.moviecataloguejetpackversion.data.source.MovieCatalogueRepository;
import com.learn.moviecataloguejetpackversion.data.source.local.entity.Movie;
import com.learn.moviecataloguejetpackversion.data.source.local.entity.TvShow;
import com.learn.moviecataloguejetpackversion.utils.FakeMovieData;
import com.learn.moviecataloguejetpackversion.utils.FakeTvShowData;
import com.learn.moviecataloguejetpackversion.viewmodel.MainViewModel;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MainViewModelTest {
    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    private MainViewModel mainViewModel;
    private MovieCatalogueRepository movieCatalogueRepository = mock(MovieCatalogueRepository.class);

    @Before
    public void before() {
        mainViewModel = new MainViewModel(movieCatalogueRepository);
    }

    @Test
    public void getListMovieTest() {
        ArrayList<Movie> dummyMovie = FakeMovieData.generateMovieList();

        MutableLiveData<List<Movie>> movies = new MutableLiveData<>();
        movies.setValue(dummyMovie);

        when(movieCatalogueRepository.getAllMovie()).thenReturn(movies);

        Observer<List<Movie>> observer = mock(Observer.class);

        mainViewModel.getListMovie().observeForever(observer);

        verify(observer).onChanged(dummyMovie);
    }

    @Test
    public void getListTvShowTest() {
        ArrayList<TvShow> dummyTvShow = FakeTvShowData.generateTvShowList();

        MutableLiveData<List<TvShow>> tvShows = new MutableLiveData<>();
        tvShows.setValue(dummyTvShow);

        when(movieCatalogueRepository.getAllTvShow()).thenReturn(tvShows);

        Observer<List<TvShow>> observer = mock(Observer.class);

        mainViewModel.getListTvShow().observeForever(observer);

        verify(movieCatalogueRepository).getAllTvShow();
    }
}

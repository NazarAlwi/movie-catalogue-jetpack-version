package com.learn.moviecataloguejetpackversion.ui.favoritemovie;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.learn.moviecataloguejetpackversion.data.source.MovieCatalogueRepository;
import com.learn.moviecataloguejetpackversion.data.source.local.entity.Movie;
import com.learn.moviecataloguejetpackversion.utils.FakeMovieData;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MovieFavoriteViewModelTest {
    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    private MovieFavoriteViewModel movieFavoriteViewModel;
    private MovieCatalogueRepository movieCatalogueRepository = mock(MovieCatalogueRepository.class);

    @Before
    public void before() {
        movieFavoriteViewModel = new MovieFavoriteViewModel(movieCatalogueRepository);
    }

    @Test
    public void getListMovieTest() {
        ArrayList<Movie> dummyMovie = FakeMovieData.generateMovieList();

        MutableLiveData<List<Movie>> movies = new MutableLiveData<>();
        movies.setValue(dummyMovie);

        when(movieCatalogueRepository.getAllMovieFavorite()).thenReturn(movies);

        Observer<List<Movie>> observer = mock(Observer.class);

        movieFavoriteViewModel.getListMovieFavorite().observeForever(observer);

        verify(observer).onChanged(dummyMovie);
    }
}
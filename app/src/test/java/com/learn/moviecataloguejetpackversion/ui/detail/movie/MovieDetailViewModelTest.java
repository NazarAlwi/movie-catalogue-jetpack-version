package com.learn.moviecataloguejetpackversion.ui.detail.movie;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.learn.moviecataloguejetpackversion.data.source.MovieCatalogueRepository;
import com.learn.moviecataloguejetpackversion.data.source.local.entity.Movie;
import com.learn.moviecataloguejetpackversion.utils.FakeMovieData;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MovieDetailViewModelTest {
    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    private MovieDetailViewModel movieDetailViewModel;
    private MovieCatalogueRepository movieCatalogueRepository = mock(MovieCatalogueRepository.class);
    private Movie dummyMovie = FakeMovieData.generateMovieList().get(0);
    private String idMovie = dummyMovie.getIdMovie();

    @Before
    public void setUp() {
        movieDetailViewModel = new MovieDetailViewModel(movieCatalogueRepository);
        movieDetailViewModel.setIdMovie(idMovie);
    }

    @Test
    public void getMovieDetailTest() {
        MutableLiveData<Movie> movieMutableLiveData = new MutableLiveData<>();
        movieMutableLiveData.setValue(dummyMovie);

        when(movieCatalogueRepository.getMovieById(idMovie)).thenReturn(movieMutableLiveData);

        Observer<Movie> observer = mock(Observer.class);

        movieDetailViewModel.getMovieDetail().observeForever(observer);

        verify(observer).onChanged(dummyMovie);
    }
}
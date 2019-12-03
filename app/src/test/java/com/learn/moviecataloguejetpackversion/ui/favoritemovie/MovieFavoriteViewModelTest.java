package com.learn.moviecataloguejetpackversion.ui.favoritemovie;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.learn.moviecataloguejetpackversion.data.source.MovieCatalogueRepository;
import com.learn.moviecataloguejetpackversion.data.source.local.entity.Movie;
import com.learn.moviecataloguejetpackversion.utils.FakeMovieData;
import com.learn.moviecataloguejetpackversion.vo.Resource;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

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
        Resource<List<Movie>> resource = Resource.success(FakeMovieData.generateMovieList());
        MutableLiveData<Resource<List<Movie>>> dummyMovie = new MutableLiveData<>();
        dummyMovie.setValue(resource);

        when(movieCatalogueRepository.getAllMovieFavorite()).thenReturn(dummyMovie);

        Observer<Resource<List<Movie>>> observer = mock(Observer.class);

        movieFavoriteViewModel.getListMovieFavorite().observeForever(observer);

        verify(observer).onChanged(resource);
    }
}
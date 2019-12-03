package com.learn.moviecataloguejetpackversion.ui.favoritemovie;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.paging.PagedList;

import com.learn.moviecataloguejetpackversion.data.source.MovieCatalogueRepository;
import com.learn.moviecataloguejetpackversion.data.source.local.entity.Movie;
import com.learn.moviecataloguejetpackversion.vo.Resource;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

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
        MutableLiveData<Resource<PagedList<Movie>>> dummyMovie = new MutableLiveData<>();
        PagedList<Movie> moviePagedList = mock(PagedList.class);

        dummyMovie.setValue(Resource.success(moviePagedList));

        when(movieCatalogueRepository.getAllMovieFavoritePaged()).thenReturn(dummyMovie);

        Observer<Resource<PagedList<Movie>>> observer = mock(Observer.class);

        movieFavoriteViewModel.getListMovieFavoritePaged().observeForever(observer);

        verify(observer).onChanged(Resource.success(moviePagedList));
    }
}
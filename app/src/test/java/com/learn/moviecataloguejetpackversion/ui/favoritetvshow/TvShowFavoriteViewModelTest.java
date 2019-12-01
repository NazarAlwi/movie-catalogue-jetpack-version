package com.learn.moviecataloguejetpackversion.ui.favoritetvshow;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.learn.moviecataloguejetpackversion.data.source.MovieCatalogueRepository;
import com.learn.moviecataloguejetpackversion.data.source.local.entity.TvShow;
import com.learn.moviecataloguejetpackversion.utils.FakeTvShowData;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class TvShowFavoriteViewModelTest {
    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    private TvShowFavoriteViewModel tvShowFavoriteViewModel;
    private MovieCatalogueRepository movieCatalogueRepository = mock(MovieCatalogueRepository.class);

    @Before
    public void before() {
        tvShowFavoriteViewModel = new TvShowFavoriteViewModel(movieCatalogueRepository);
    }

    @Test
    public void getListTvShowTest() {
        ArrayList<TvShow> dummyTvShow = FakeTvShowData.generateTvShowList();

        MutableLiveData<List<TvShow>> tvShows = new MutableLiveData<>();
        tvShows.setValue(dummyTvShow);

        when(movieCatalogueRepository.getAllTvShowFavorite()).thenReturn(tvShows);

        Observer<List<TvShow>> observer = mock(Observer.class);

        tvShowFavoriteViewModel.getListTvShowFavorite().observeForever(observer);

        verify(observer).onChanged(dummyTvShow);
    }
}
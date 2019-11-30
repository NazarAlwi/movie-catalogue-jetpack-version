package com.learn.moviecataloguejetpackversion.viewmodel;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.learn.moviecataloguejetpackversion.data.source.MovieCatalogueRepository;
import com.learn.moviecataloguejetpackversion.data.source.local.entity.TvShow;
import com.learn.moviecataloguejetpackversion.ui.tvshow.TvShowViewModel;
import com.learn.moviecataloguejetpackversion.utils.FakeTvShowData;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class TvShowViewModelTest {
    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    private TvShowViewModel tvShowViewModel;
    private MovieCatalogueRepository movieCatalogueRepository = mock(MovieCatalogueRepository.class);

    @Before
    public void before() {
        tvShowViewModel = new TvShowViewModel(movieCatalogueRepository);
    }

    @Test
    public void getListTvShowTest() {
        ArrayList<TvShow> dummyTvShow = FakeTvShowData.generateTvShowList();

        MutableLiveData<List<TvShow>> tvShows = new MutableLiveData<>();
        tvShows.setValue(dummyTvShow);

        when(movieCatalogueRepository.getAllTvShow()).thenReturn(tvShows);

        Observer<List<TvShow>> observer = mock(Observer.class);

        tvShowViewModel.getListTvShow().observeForever(observer);

        verify(movieCatalogueRepository).getAllTvShow();
    }
}
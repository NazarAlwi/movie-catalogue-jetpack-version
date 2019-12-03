package com.learn.moviecataloguejetpackversion.ui.tvshow;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.learn.moviecataloguejetpackversion.data.source.MovieCatalogueRepository;
import com.learn.moviecataloguejetpackversion.data.source.local.entity.TvShow;
import com.learn.moviecataloguejetpackversion.utils.FakeTvShowData;
import com.learn.moviecataloguejetpackversion.vo.Resource;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class TvShowViewModelTest {
    private String USERNAME = "Nazar";

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
        Resource<List<TvShow>> resource = Resource.success(FakeTvShowData.generateTvShowList());
        MutableLiveData<Resource<List<TvShow>>> dummyTvShow = new MutableLiveData<>();
        dummyTvShow.setValue(resource);

        when(movieCatalogueRepository.getAllTvShow()).thenReturn(dummyTvShow);

        Observer<Resource<List<TvShow>>> observer = mock(Observer.class);

        tvShowViewModel.setUsername(USERNAME);

        tvShowViewModel.tvShows.observeForever(observer);

        verify(observer).onChanged(resource);
    }
}
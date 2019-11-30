package com.learn.moviecataloguejetpackversion.viewmodel;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.learn.moviecataloguejetpackversion.data.source.MovieCatalogueRepository;
import com.learn.moviecataloguejetpackversion.data.source.local.entity.TvShow;
import com.learn.moviecataloguejetpackversion.ui.detail.tvshow.TvShowDetailViewModel;
import com.learn.moviecataloguejetpackversion.utils.FakeTvShowData;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class TvShowDetailViewModelTest {
    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    private TvShowDetailViewModel tvShowDetailViewModel;
    private MovieCatalogueRepository movieCatalogueRepository = mock(MovieCatalogueRepository.class);
    private TvShow dummyTvShow = FakeTvShowData.generateTvShowList().get(0);
    private String idTvShow = dummyTvShow.getIdTvShow();

    @Before
    public void setUp() {
        tvShowDetailViewModel = new TvShowDetailViewModel(movieCatalogueRepository);
        tvShowDetailViewModel.setIdTvShow(idTvShow);
    }

    @Test
    public void getTvShowDetailTest() {
        MutableLiveData<TvShow> tvShowMutableLiveData = new MutableLiveData<>();
        tvShowMutableLiveData.setValue(dummyTvShow);

        when(movieCatalogueRepository.getTvShowById(idTvShow)).thenReturn(tvShowMutableLiveData);

        Observer<TvShow> observer = mock(Observer.class);

        tvShowDetailViewModel.getTvShowDetail().observeForever(observer);

        verify(observer).onChanged(dummyTvShow);
    }
}
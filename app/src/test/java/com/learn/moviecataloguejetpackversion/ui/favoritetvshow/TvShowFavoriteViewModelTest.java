package com.learn.moviecataloguejetpackversion.ui.favoritetvshow;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.paging.PagedList;

import com.learn.moviecataloguejetpackversion.data.source.MovieCatalogueRepository;
import com.learn.moviecataloguejetpackversion.data.source.local.entity.TvShow;
import com.learn.moviecataloguejetpackversion.vo.Resource;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

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
        MutableLiveData<Resource<PagedList<TvShow>>> dummyTvShow = new MutableLiveData<>();
        PagedList<TvShow> tvShowPagedList = mock(PagedList.class);

        dummyTvShow.setValue(Resource.success(tvShowPagedList));

        when(movieCatalogueRepository.getAllTvShowFavoritePaged()).thenReturn(dummyTvShow);

        Observer<Resource<PagedList<TvShow>>> observer = mock(Observer.class);

        tvShowFavoriteViewModel.getListTvShowFavoritePaged().observeForever(observer);

        verify(observer).onChanged(Resource.success(tvShowPagedList));
    }
}
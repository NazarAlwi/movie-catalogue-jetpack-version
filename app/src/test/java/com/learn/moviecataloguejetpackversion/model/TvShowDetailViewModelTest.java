package com.learn.moviecataloguejetpackversion.model;

import com.learn.moviecataloguejetpackversion.data.source.MovieCatalogueRepository;
import com.learn.moviecataloguejetpackversion.data.source.local.entity.TvShow;
import com.learn.moviecataloguejetpackversion.utils.FakeTvShowData;
import com.learn.moviecataloguejetpackversion.viewmodel.TvShowDetailViewModel;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class TvShowDetailViewModelTest {
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
        when(movieCatalogueRepository.getTvShowById(idTvShow)).thenReturn(dummyTvShow);
        TvShow tvShow = tvShowDetailViewModel.getTvShowDetail();

        verify(movieCatalogueRepository).getTvShowById(idTvShow);
        assertNotNull(tvShow);
        String idTvShow = tvShow.getIdTvShow();
        assertNotNull(idTvShow);

        assertEquals(dummyTvShow.getIdTvShow(), tvShow.getIdTvShow());
        assertEquals(dummyTvShow.getPhotoTvShow(), tvShow.getPhotoTvShow());
        assertEquals(dummyTvShow.getNameTvShow(), tvShow.getNameTvShow());
        assertEquals(dummyTvShow.getOverviewTvShow(), tvShow.getOverviewTvShow());
        assertEquals(dummyTvShow.getVoteTvShow(), tvShow.getVoteTvShow());
        assertEquals(dummyTvShow.getReleaseTvShow(), tvShow.getReleaseTvShow());
        assertEquals(dummyTvShow.getPopularityTvShow(), tvShow.getPopularityTvShow());
        assertEquals(dummyTvShow.getBackdropTvShow(), tvShow.getBackdropTvShow());
    }
}
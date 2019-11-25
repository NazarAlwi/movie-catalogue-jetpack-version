package com.learn.moviecataloguejetpackversion.model;

import com.learn.moviecataloguejetpackversion.data.source.MovieCatalogueRepository;
import com.learn.moviecataloguejetpackversion.data.source.local.entity.TvShow;
import com.learn.moviecataloguejetpackversion.utils.FakeTvShowData;
import com.learn.moviecataloguejetpackversion.viewmodel.TvShowDetailViewModel;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class TvShowDetailViewModelTest {
    private TvShowDetailViewModel tvShowDetailViewModel;
    private TvShow dummyTvShow;
    private MovieCatalogueRepository movieCatalogueRepository = mock(MovieCatalogueRepository.class);

    @Before
    public void setUp() {
        tvShowDetailViewModel = new TvShowDetailViewModel(movieCatalogueRepository);
        dummyTvShow = new TvShow("/gKG5QGz5Ngf8fgWpBsWtlg5L2SF.jpg", "Arrow", "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.", "5.8", "2012-10-10", "418.603", "/dXTyVDTIgeByvUOUEiHjbi8xX9A.jpg");
    }

    @Test
    public void getTvShowDetailTest() {
        when(movieCatalogueRepository.getAllTvShow()).thenReturn(FakeTvShowData.generateTvShowList());

        tvShowDetailViewModel.setTvShowName(dummyTvShow.getNameTvShow());
        TvShow tvShow = tvShowDetailViewModel.getTvShowDetail();

        verify(movieCatalogueRepository).getAllTvShow();

        assertNotNull(tvShow);
        assertEquals(dummyTvShow.getPhotoTvShow(), tvShow.getPhotoTvShow());
        assertEquals(dummyTvShow.getNameTvShow(), tvShow.getNameTvShow());
        assertEquals(dummyTvShow.getOverviewTvShow(), tvShow.getOverviewTvShow());
        assertEquals(dummyTvShow.getVoteTvShow(), tvShow.getVoteTvShow());
        assertEquals(dummyTvShow.getReleaseTvShow(), tvShow.getReleaseTvShow());
        assertEquals(dummyTvShow.getPopularityTvShow(), tvShow.getPopularityTvShow());
        assertEquals(dummyTvShow.getBackdropTvShow(), tvShow.getBackdropTvShow());
    }
}
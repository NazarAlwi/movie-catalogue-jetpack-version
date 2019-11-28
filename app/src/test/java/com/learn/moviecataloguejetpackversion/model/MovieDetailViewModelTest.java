package com.learn.moviecataloguejetpackversion.model;

import com.learn.moviecataloguejetpackversion.data.source.MovieCatalogueRepository;
import com.learn.moviecataloguejetpackversion.data.source.local.entity.Movie;
import com.learn.moviecataloguejetpackversion.utils.FakeMovieData;
import com.learn.moviecataloguejetpackversion.viewmodel.MovieDetailViewModel;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MovieDetailViewModelTest {
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
        when(movieCatalogueRepository.getMovieById(idMovie)).thenReturn(dummyMovie);
        Movie movie = movieDetailViewModel.getMovieDetail();

        verify(movieCatalogueRepository).getMovieById(idMovie);
        assertNotNull(movie);
        String idMovie = movie.getIdMovie();
        assertNotNull(idMovie);

        assertEquals(dummyMovie.getIdMovie(), movie.getIdMovie());
        assertEquals(dummyMovie.getPhotoMovie(), movie.getPhotoMovie());
        assertEquals(dummyMovie.getNameMovie(), movie.getNameMovie());
        assertEquals(dummyMovie.getOverviewMovie(), movie.getOverviewMovie());
        assertEquals(dummyMovie.getVoteMovie(), movie.getVoteMovie());
        assertEquals(dummyMovie.getReleaseMovie(), movie.getReleaseMovie());
        assertEquals(dummyMovie.getPopularityMovie(), movie.getPopularityMovie());
        assertEquals(dummyMovie.getBackdropMovie(), movie.getBackdropMovie());
    }
}
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
    private Movie dummyMovie;
    private MovieCatalogueRepository movieCatalogueRepository = mock(MovieCatalogueRepository.class);

    @Before
    public void setUp() {
        movieDetailViewModel = new MovieDetailViewModel(movieCatalogueRepository);
        dummyMovie = new Movie("/udDclJoHjfjb8Ekgsd4FDteOkCU.jpg", "Joker", "During the 1980s, a failed stand-up comedian is driven insane and turns to a life of crime and chaos in Gotham City while becoming an infamous psychopathic crime figure.", "8.5", "2019-10-04", "534.771", "/n6bUvigpRFqSwmPp1m2YADdbRBc.jpg");
    }

    @Test
    public void getMovieDetailTest() {
        when(movieCatalogueRepository.getAllMovie()).thenReturn(FakeMovieData.generateMovieList());

        movieDetailViewModel.setMovieName(dummyMovie.getNameMovie());
        Movie movie = movieDetailViewModel.getMovieDetail();

        verify(movieCatalogueRepository).getAllMovie();

        assertNotNull(movie);
        assertEquals(dummyMovie.getPhotoMovie(), movie.getPhotoMovie());
        assertEquals(dummyMovie.getNameMovie(), movie.getNameMovie());
        assertEquals(dummyMovie.getOverviewMovie(), movie.getOverviewMovie());
        assertEquals(dummyMovie.getVoteMovie(), movie.getVoteMovie());
        assertEquals(dummyMovie.getReleaseMovie(), movie.getReleaseMovie());
        assertEquals(dummyMovie.getPopularityMovie(), movie.getPopularityMovie());
        assertEquals(dummyMovie.getBackdropMovie(), movie.getBackdropMovie());
    }
}
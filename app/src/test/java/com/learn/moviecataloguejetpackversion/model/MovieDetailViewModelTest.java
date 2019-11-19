package com.learn.moviecataloguejetpackversion.model;

import android.media.midi.MidiOutputPort;
import android.view.View;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MovieDetailViewModelTest {
    private MovieDetailViewModel movieDetailViewModel;
    private Movie dummyMovie;

    @Before
    public void setUp() {
        movieDetailViewModel = new MovieDetailViewModel();
        dummyMovie = new Movie("/udDclJoHjfjb8Ekgsd4FDteOkCU.jpg", "Joker", "During the 1980s, a failed stand-up comedian is driven insane and turns to a life of crime and chaos in Gotham City while becoming an infamous psychopathic crime figure.", "8.5", "2019-10-04", "534.771", "/n6bUvigpRFqSwmPp1m2YADdbRBc.jpg");
    }

    @Test
    public void getMovieDetailTest() {
        movieDetailViewModel.setMovieName(dummyMovie.getNameMovie());
        Movie movie = movieDetailViewModel.getMovieDetail();
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
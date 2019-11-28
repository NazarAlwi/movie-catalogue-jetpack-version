package com.learn.moviecataloguejetpackversion.data.source;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;

import com.learn.moviecataloguejetpackversion.data.MovieData;
import com.learn.moviecataloguejetpackversion.data.TvShowData;
import com.learn.moviecataloguejetpackversion.data.source.local.entity.Movie;
import com.learn.moviecataloguejetpackversion.data.source.local.entity.TvShow;
import com.learn.moviecataloguejetpackversion.data.source.remote.RemoteRepository;
import com.learn.moviecataloguejetpackversion.data.source.remote.response.MovieResponse;
import com.learn.moviecataloguejetpackversion.data.source.remote.response.TvShowResponse;
import com.learn.moviecataloguejetpackversion.utils.FakeMovieData;
import com.learn.moviecataloguejetpackversion.utils.FakeTvShowData;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MovieCatalogueRepositoryTest {
    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    private RemoteRepository remoteRepository = mock(RemoteRepository.class);
    private FakeMovieCatalogueRepository movieCatalogueRepository = new FakeMovieCatalogueRepository(remoteRepository);

    private ArrayList<MovieResponse> movieResponses = FakeMovieData.generateMovieResponseList();
    private String idMovie = MovieData.generateMovieList().get(0).getIdMovie();

    private ArrayList<TvShowResponse> tvShowResponses = FakeTvShowData.generateTvShowResponseList();
    private String idTvShow = TvShowData.generateTvShowList().get(0).getIdTvShow();

    private Movie movie = FakeMovieData.generateMovieList().get(0);
    private TvShow tvShow = FakeTvShowData.generateTvShowList().get(0);

    @Before
    public void setUp() {

    }

    @After
    public void tearDown() {

    }

    @Test
    public void getAllMovie() {
        when(remoteRepository.getAllMovie()).thenReturn(movieResponses);
        ArrayList<Movie> movies = movieCatalogueRepository.getAllMovie();
        verify(remoteRepository).getAllMovie();
        assertNotNull(movies);
        assertEquals(movieResponses.size(), movies.size());
    }

    @Test
    public void getAllTvShow() {
        when(remoteRepository.getAllTvShow()).thenReturn(tvShowResponses);
        ArrayList<TvShow> tvShows = movieCatalogueRepository.getAllTvShow();
        verify(remoteRepository).getAllTvShow();
        assertNotNull(tvShows);
        assertEquals(tvShowResponses.size(), tvShows.size());
    }

//    @Test
//    public void getMovieById() {
//        when(movieCatalogueRepository.getMovieById(idMovie)).thenReturn(movie);
//    }
//
//    @Test
//    public void getTvShowById() {
//        when(movieCatalogueRepository.getTvShowById(idTvShow)).thenReturn(tvShow);
//    }
}
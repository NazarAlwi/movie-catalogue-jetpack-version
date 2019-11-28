package com.learn.moviecataloguejetpackversion.data.source;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;

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
    private String idMovie = movieResponses.get(0).getIdMovieResponse();

    private ArrayList<TvShowResponse> tvShowResponses = FakeTvShowData.generateTvShowResponseList();
    private String idTvShow = tvShowResponses.get(0).getIdTvShowResponse();

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

    @Test
    public void getMovieById() {
        when(remoteRepository.getAllMovie()).thenReturn(movieResponses);
        Movie movieResult = movieCatalogueRepository.getMovieById(idMovie);
        verify(remoteRepository).getAllMovie();
        assertNotNull(movieResult);
        assertEquals(movieResponses.get(0).getIdMovieResponse(), movieResult.getIdMovie());
        assertEquals(movieResponses.get(0).getNameMovieResponse(), movieResult.getNameMovie());
    }

    @Test
    public void getTvShowById() {
        when(remoteRepository.getAllTvShow()).thenReturn(tvShowResponses);
        TvShow tvShowResult = movieCatalogueRepository.getTvShowById(idTvShow);
        verify(remoteRepository).getAllTvShow();
        assertNotNull(tvShowResult);
        assertEquals(tvShowResponses.get(0).getIdTvShowResponse(), tvShowResult.getIdTvShow());
        assertEquals(tvShowResponses.get(0).getNameTvShowResponse(), tvShowResult.getNameTvShow());
    }
}
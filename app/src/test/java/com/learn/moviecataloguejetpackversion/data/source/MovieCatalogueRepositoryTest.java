package com.learn.moviecataloguejetpackversion.data.source;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;

import com.learn.moviecataloguejetpackversion.data.source.local.entity.Movie;
import com.learn.moviecataloguejetpackversion.data.source.local.entity.TvShow;
import com.learn.moviecataloguejetpackversion.data.source.remote.RemoteRepository;
import com.learn.moviecataloguejetpackversion.data.source.remote.response.MovieResponse;
import com.learn.moviecataloguejetpackversion.data.source.remote.response.TvShowResponse;
import com.learn.moviecataloguejetpackversion.utils.FakeMovieData;
import com.learn.moviecataloguejetpackversion.utils.FakeTvShowData;
import com.learn.moviecataloguejetpackversion.utils.LiveDataTestUtil;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

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
        doAnswer(invocation -> {
            ((RemoteRepository.LoadMovieCallback) invocation.getArguments()[0])
                    .onAllMovieReceived(movieResponses);
            return null;
        }).when(remoteRepository).getAllMovie(any(RemoteRepository.LoadMovieCallback.class));

        List<Movie> result = LiveDataTestUtil.getValue(movieCatalogueRepository.getAllMovie());

        verify(remoteRepository, times(1)).getAllMovie(any(RemoteRepository.LoadMovieCallback.class));

        assertNotNull(result);
        assertEquals(movieResponses.size(), result.size());
    }

    @Test
    public void getAllTvShow() {
        doAnswer(invocation -> {
            ((RemoteRepository.LoadTvShowCallback) invocation.getArguments()[0])
                    .onAllTvShowReceived(tvShowResponses);
            return null;
        }).when(remoteRepository).getAllTvShow(any(RemoteRepository.LoadTvShowCallback.class));

        List<TvShow> result = LiveDataTestUtil.getValue(movieCatalogueRepository.getAllTvShow());

        verify(remoteRepository, times(1)).getAllTvShow(any(RemoteRepository.LoadTvShowCallback.class));

        assertNotNull(result);
        assertEquals(tvShowResponses.size(), result.size());
    }

    @Test
    public void getAllMovieFavorite() {
        doAnswer(invocation -> {
            ((RemoteRepository.LoadMovieCallback) invocation.getArguments()[0])
                    .onAllMovieReceived(movieResponses);
            return null;
        }).when(remoteRepository).getAllMovie(any(RemoteRepository.LoadMovieCallback.class));

        List<Movie> result = LiveDataTestUtil.getValue(movieCatalogueRepository.getAllMovie());

        verify(remoteRepository, times(1)).getAllMovie(any(RemoteRepository.LoadMovieCallback.class));

        assertNotNull(result);
        assertEquals(movieResponses.size(), result.size());
    }

    @Test
    public void getAllTvShowFavorite() {
        doAnswer(invocation -> {
            ((RemoteRepository.LoadTvShowCallback) invocation.getArguments()[0])
                    .onAllTvShowReceived(tvShowResponses);
            return null;
        }).when(remoteRepository).getAllTvShow(any(RemoteRepository.LoadTvShowCallback.class));

        List<TvShow> result = LiveDataTestUtil.getValue(movieCatalogueRepository.getAllTvShow());

        verify(remoteRepository, times(1)).getAllTvShow(any(RemoteRepository.LoadTvShowCallback.class));

        assertNotNull(result);
        assertEquals(tvShowResponses.size(), result.size());
    }

    @Test
    public void getMovieById() {
        doAnswer(invocation -> {
            ((RemoteRepository.LoadMovieCallback) invocation.getArguments()[0])
                    .onAllMovieReceived(movieResponses);
            return null;
        }).when(remoteRepository).getAllMovie(any(RemoteRepository.LoadMovieCallback.class));

        Movie result = LiveDataTestUtil.getValue(movieCatalogueRepository.getMovieById(idMovie));

        verify(remoteRepository, times(1)).getAllMovie(any(RemoteRepository.LoadMovieCallback.class));

        assertNotNull(result);
        assertNotNull(result.getNameMovie());
        assertEquals(movieResponses.get(0).getNameMovieResponse(), result.getNameMovie());
    }

    @Test
    public void getTvShowById() {
        doAnswer(invocation -> {
            ((RemoteRepository.LoadTvShowCallback) invocation.getArguments()[0])
                    .onAllTvShowReceived(tvShowResponses);
            return null;
        }).when(remoteRepository).getAllTvShow(any(RemoteRepository.LoadTvShowCallback.class));

        TvShow result = LiveDataTestUtil.getValue(movieCatalogueRepository.getTvShowById(idTvShow));

        verify(remoteRepository, times(1)).getAllTvShow(any(RemoteRepository.LoadTvShowCallback.class));

        assertNotNull(result);
        assertNotNull(result.getNameTvShow());
        assertEquals(tvShowResponses.get(0).getNameTvShowResponse(), result.getNameTvShow());
    }
}
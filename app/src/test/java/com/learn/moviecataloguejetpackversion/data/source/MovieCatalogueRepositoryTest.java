package com.learn.moviecataloguejetpackversion.data.source;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;

import com.learn.moviecataloguejetpackversion.data.source.local.LocalRepository;
import com.learn.moviecataloguejetpackversion.data.source.local.entity.Movie;
import com.learn.moviecataloguejetpackversion.data.source.local.entity.TvShow;
import com.learn.moviecataloguejetpackversion.data.source.remote.RemoteRepository;
import com.learn.moviecataloguejetpackversion.data.source.remote.response.MovieResponse;
import com.learn.moviecataloguejetpackversion.data.source.remote.response.TvShowResponse;
import com.learn.moviecataloguejetpackversion.utils.FakeMovieData;
import com.learn.moviecataloguejetpackversion.utils.FakeTvShowData;
import com.learn.moviecataloguejetpackversion.utils.InstantAppExecutors;
import com.learn.moviecataloguejetpackversion.utils.LiveDataTestUtil;
import com.learn.moviecataloguejetpackversion.vo.Resource;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MovieCatalogueRepositoryTest {
    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    private LocalRepository localRepository = mock(LocalRepository.class);
    private RemoteRepository remoteRepository = mock(RemoteRepository.class);
    private InstantAppExecutors instantAppExecutors = mock(InstantAppExecutors.class);
    private FakeMovieCatalogueRepository movieCatalogueRepository = new FakeMovieCatalogueRepository(localRepository, remoteRepository, instantAppExecutors);

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
        MutableLiveData<List<Movie>> dummyMovie = new MutableLiveData<>();
        dummyMovie.setValue(FakeMovieData.generateMovieList());

        when(localRepository.getAllMovie()).thenReturn(dummyMovie);

        Resource<List<Movie>> result = LiveDataTestUtil.getValue(movieCatalogueRepository.getAllMovie());

        verify(localRepository).getAllMovie();
        assertNotNull(result.data);
        assertEquals(movieResponses.size(), result.data.size());
    }

    @Test
    public void getAllTvShow() {
        MutableLiveData<List<TvShow>> dummyTvShow = new MutableLiveData<>();
        dummyTvShow.setValue(FakeTvShowData.generateTvShowList());

        when(localRepository.getAllTvShow()).thenReturn(dummyTvShow);

        Resource<List<TvShow>> result = LiveDataTestUtil.getValue(movieCatalogueRepository.getAllTvShow());

        verify(localRepository).getAllTvShow();
        assertNotNull(result.data);
        assertEquals(tvShowResponses.size(), result.data.size());
    }

    @Test
    public void getAllMovieFavorite() {
        MutableLiveData<List<Movie>> dummyMovie = new MutableLiveData<>();
        dummyMovie.setValue(FakeMovieData.generateMovieList());

        when(localRepository.getAllMovieFavorite()).thenReturn(dummyMovie);

        Resource<List<Movie>> result = LiveDataTestUtil.getValue(movieCatalogueRepository.getAllMovieFavorite());

        verify(localRepository).getAllMovieFavorite();
        assertNotNull(result.data);
        assertEquals(movieResponses.size(), result.data.size());
    }

    @Test
    public void getAllTvShowFavorite() {
        MutableLiveData<List<TvShow>> dummyTvShow = new MutableLiveData<>();
        dummyTvShow.setValue(FakeTvShowData.generateTvShowList());

        when(localRepository.getAllTvShowFavorite()).thenReturn(dummyTvShow);

        Resource<List<TvShow>> result = LiveDataTestUtil.getValue(movieCatalogueRepository.getAllTvShowFavorite());

        verify(localRepository).getAllTvShowFavorite();
        assertNotNull(result.data);
        assertEquals(tvShowResponses.size(), result.data.size());
    }

    @Test
    public void getMovieById() {
        MutableLiveData<Movie> dummyMovie = new MutableLiveData<>();
        dummyMovie.setValue(FakeMovieData.generateMovieById(FakeMovieData.generateMovieList().get(0), false));

        when(localRepository.getMovieById(idMovie)).thenReturn(dummyMovie);

        Resource<Movie> result = LiveDataTestUtil.getValue(movieCatalogueRepository.getMovieById(idMovie));

        verify(localRepository).getMovieById(idMovie);
        assertNotNull(result.data);
        assertNotNull(result.data.getNameMovie());
        assertEquals(movieResponses.get(0).getNameMovieResponse(), result.data.getNameMovie());
    }

    @Test
    public void getTvShowById() {
        MutableLiveData<TvShow> dummyTvShow = new MutableLiveData<>();
        dummyTvShow.setValue(FakeTvShowData.generateTvShowById(FakeTvShowData.generateTvShowList().get(0), false));

        when(localRepository.getTvShowById(idTvShow)).thenReturn(dummyTvShow);

        Resource<TvShow> result = LiveDataTestUtil.getValue(movieCatalogueRepository.getTvShowById(idTvShow));

        verify(localRepository).getTvShowById(idTvShow);
        assertNotNull(result.data);
        assertNotNull(result.data.getNameTvShow());
        assertEquals(tvShowResponses.get(0).getNameTvShowResponse(), result.data.getNameTvShow());
    }
}
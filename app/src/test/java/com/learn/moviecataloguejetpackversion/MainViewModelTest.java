package com.learn.moviecataloguejetpackversion;

import androidx.annotation.NonNull;

import com.learn.moviecataloguejetpackversion.model.Movie;
import com.learn.moviecataloguejetpackversion.model.MainViewModel;
import com.learn.moviecataloguejetpackversion.model.TvShow;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static com.learn.moviecataloguejetpackversion.data.MovieData.dataMovieName;
import static com.learn.moviecataloguejetpackversion.data.MovieData.dataMovieOverview;
import static com.learn.moviecataloguejetpackversion.data.MovieData.dataMoviePhoto;
import static com.learn.moviecataloguejetpackversion.data.MovieData.dataMoviePopularity;
import static com.learn.moviecataloguejetpackversion.data.MovieData.dataMovieRelease;
import static com.learn.moviecataloguejetpackversion.data.MovieData.dataMovieVote;
import static com.learn.moviecataloguejetpackversion.data.TvShowData.dataTvShowName;
import static com.learn.moviecataloguejetpackversion.data.TvShowData.dataTvShowOverview;
import static com.learn.moviecataloguejetpackversion.data.TvShowData.dataTvShowPhoto;
import static com.learn.moviecataloguejetpackversion.data.TvShowData.dataTvShowPopularity;
import static com.learn.moviecataloguejetpackversion.data.TvShowData.dataTvShowRelease;
import static com.learn.moviecataloguejetpackversion.data.TvShowData.dataTvShowVote;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;

public class MainViewModelTest {
    private Movie movie;
    private TvShow tvShow;
    private MainViewModel mainViewModel;

    @NonNull
    @Override
    public String toString() {
        return getClass().getSimpleName() + "@" + Integer.toHexString(hashCode());
    }

    public static ArrayList<Movie> dummyGetListMovie() {
        ArrayList<Movie> list = new ArrayList<>();

        for (int i = 0; i < dataMovieName.length; i++) {
            Movie dummyMovie = new Movie();
            dummyMovie.setNameMovie(dataMovieName[i]);
            dummyMovie.setReleaseMovie(dataMovieRelease[i]);
            dummyMovie.setVoteMovie(dataMovieVote[i]);
            dummyMovie.setPopularityMovie(dataMoviePopularity[i]);
            dummyMovie.setOverviewMovie(dataMovieOverview[i]);
            dummyMovie.setPhotoMovie(dataMoviePhoto[i]);
            list.add(dummyMovie);
        }

        return list;
    }

    public static ArrayList<TvShow> dummyGetListTvShow() {
        ArrayList<TvShow> list = new ArrayList<>();
        for (int i = 0; i < dataTvShowName.length; i++) {
            TvShow dummyTvShow = new TvShow();
            dummyTvShow.setNameTvShow(dataTvShowName[i]);
            dummyTvShow.setReleaseTvShow(dataTvShowRelease[i]);
            dummyTvShow.setVoteTvShow(dataTvShowVote[i]);
            dummyTvShow.setPopularityTvShow(dataTvShowPopularity[i]);
            dummyTvShow.setOverviewTvShow(dataTvShowOverview[i]);
            dummyTvShow.setPhotoTvShow(dataTvShowPhoto[i]);
            list.add(dummyTvShow);
        }

        return list;
    }

    @Before
    public void before() {
        movie = mock(Movie.class);
        tvShow = mock(TvShow.class);
        mainViewModel = new MainViewModel();
    }

    @Test
    public void getListMovieTest() {
        assertNotNull(mainViewModel.getListMovie());
        assertEquals(10, mainViewModel.getListMovie().size());
    }

    @Test
    public void getListTvShowTest() {
        assertNotNull(mainViewModel.getListTvShow());
        assertEquals(10, mainViewModel.getListTvShow().size());
    }
}

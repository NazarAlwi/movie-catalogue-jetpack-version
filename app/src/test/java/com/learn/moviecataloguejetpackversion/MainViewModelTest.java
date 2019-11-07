package com.learn.moviecataloguejetpackversion;

import com.learn.moviecataloguejetpackversion.model.Movie;
import com.learn.moviecataloguejetpackversion.model.MainViewModel;
import com.learn.moviecataloguejetpackversion.model.TvShow;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static com.learn.moviecataloguejetpackversion.data.MovieData.dataMovieBackdrop;
import static com.learn.moviecataloguejetpackversion.data.MovieData.dataMovieName;
import static com.learn.moviecataloguejetpackversion.data.MovieData.dataMovieOverview;
import static com.learn.moviecataloguejetpackversion.data.MovieData.dataMoviePhoto;
import static com.learn.moviecataloguejetpackversion.data.MovieData.dataMoviePopularity;
import static com.learn.moviecataloguejetpackversion.data.MovieData.dataMovieRelease;
import static com.learn.moviecataloguejetpackversion.data.MovieData.dataMovieVote;
import static com.learn.moviecataloguejetpackversion.data.TvShowData.dataTvShowBackdrop;
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
            dummyMovie.setBackdropMovie(dataMovieBackdrop[i]);
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
            dummyTvShow.setBackdropTvShow(dataTvShowBackdrop[i]);
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
        ArrayList<Movie> dummyMovies = dummyGetListMovie();
        ArrayList<Movie> objMovies = mainViewModel.getListMovie();

        assertNotNull(mainViewModel.getListMovie());
        assertEquals(dummyMovies.size(), objMovies.size());

        for (int i = 0; i < dummyMovies.size(); i++) {
            Movie dummy = dummyMovies.get(i);
            Movie obj = objMovies.get(i);

            assertEquals(dummy.getNameMovie(), obj.getNameMovie());
            assertEquals(dummy.getReleaseMovie(), obj.getReleaseMovie());
            assertEquals(dummy.getVoteMovie(), obj.getVoteMovie());
            assertEquals(dummy.getPopularityMovie(), obj.getPopularityMovie());
            assertEquals(dummy.getOverviewMovie(), obj.getOverviewMovie());
            assertEquals(dummy.getPhotoMovie(), obj.getPhotoMovie());
            assertEquals(dummy.getBackdropMovie(), obj.getBackdropMovie());
        }
    }

    @Test
    public void getListTvShowTest() {
        ArrayList<TvShow> dummyTvShows = dummyGetListTvShow();
        ArrayList<TvShow> objTvShows = mainViewModel.getListTvShow();

        assertNotNull(mainViewModel.getListTvShow());
        assertEquals(dummyTvShows.size(), objTvShows.size());

        for (int i = 0; i < dummyTvShows.size(); i++) {
            TvShow dummy = dummyTvShows.get(i);
            TvShow obj = objTvShows.get(i);
            assertEquals(dummy.getNameTvShow(), obj.getNameTvShow());
            assertEquals(dummy.getReleaseTvShow(), obj.getReleaseTvShow());
            assertEquals(dummy.getVoteTvShow(), obj.getVoteTvShow());
            assertEquals(dummy.getPopularityTvShow(), obj.getPopularityTvShow());
            assertEquals(dummy.getOverviewTvShow(), obj.getOverviewTvShow());
            assertEquals(dummy.getPhotoTvShow(), obj.getPhotoTvShow());
            assertEquals(dummy.getBackdropTvShow(), obj.getBackdropTvShow());
        }
    }
}

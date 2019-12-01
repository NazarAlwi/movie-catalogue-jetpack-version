//package com.learn.moviecataloguejetpackversion.data.source.local;
//
//import androidx.lifecycle.LiveData;
//
//import com.learn.moviecataloguejetpackversion.data.source.local.entity.Movie;
//import com.learn.moviecataloguejetpackversion.data.source.local.entity.TvShow;
//import com.learn.moviecataloguejetpackversion.data.source.local.room.MovieCatalogueDao;
//
//import java.util.List;
//
//public class LocalRepository {
//    private final MovieCatalogueDao movieCatalogueDao;
//
//    public LocalRepository(MovieCatalogueDao movieCatalogueDao) {
//        this.movieCatalogueDao = movieCatalogueDao;
//    }
//
//    private static LocalRepository INSTANCE;
//
//    public static LocalRepository getInstance(MovieCatalogueDao movieCatalogueDao) {
//        if (INSTANCE == null) {
//            INSTANCE = new LocalRepository(movieCatalogueDao);
//        }
//        return INSTANCE;
//    }
//
//    public LiveData<List<Movie>> getAllMovie() {
//        return movieCatalogueDao.getMovie();
//    }
//
//    public LiveData<List<TvShow>> getAllTvShow() {
//        return movieCatalogueDao.getTvShow();
//    }
//
//    public LiveData<Movie> getMovieById(final String idMovie) {
//        return movieCatalogueDao.getMovieById(idMovie);
//    }
//
//    public LiveData<TvShow> getTvShowById(final String idTvShow) {
//        return movieCatalogueDao.getTvShowById(idTvShow);
//    }
//}

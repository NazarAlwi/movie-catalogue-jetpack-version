package com.learn.moviecataloguejetpackversion.ui.movie;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.learn.moviecataloguejetpackversion.data.source.MovieCatalogueRepository;
import com.learn.moviecataloguejetpackversion.data.source.local.entity.Movie;
import com.learn.moviecataloguejetpackversion.vo.Resource;

import java.util.List;

public class MovieViewModel extends ViewModel {
    private MovieCatalogueRepository movieCatalogueRepository;
    private MutableLiveData<String> mLogin = new MutableLiveData<>();

    public MovieViewModel(MovieCatalogueRepository movieCatalogueRepository) {
        this.movieCatalogueRepository = movieCatalogueRepository;
    }

    LiveData<Resource<List<Movie>>> movies = Transformations.switchMap(mLogin, data -> movieCatalogueRepository.getAllMovie());

    void setUsername(String username) {
        mLogin.setValue(username);
    }
}

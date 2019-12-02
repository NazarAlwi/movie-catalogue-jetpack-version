package com.learn.moviecataloguejetpackversion.ui.tvshow;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.learn.moviecataloguejetpackversion.data.source.MovieCatalogueRepository;
import com.learn.moviecataloguejetpackversion.data.source.local.entity.TvShow;
import com.learn.moviecataloguejetpackversion.vo.Resource;

import java.util.List;

public class TvShowViewModel extends ViewModel {
    private MovieCatalogueRepository movieCatalogueRepository;
    private MutableLiveData<String> mLogin = new MutableLiveData<>();

    public TvShowViewModel(MovieCatalogueRepository movieCatalogueRepository) {
        this.movieCatalogueRepository = movieCatalogueRepository;
    }

    LiveData<Resource<List<TvShow>>> tvShows = Transformations.switchMap(mLogin, data -> movieCatalogueRepository.getAllTvShow());

    void setUsername(String username) {
        mLogin.setValue(username);
    }
}

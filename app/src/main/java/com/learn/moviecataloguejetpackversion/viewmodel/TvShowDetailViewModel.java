package com.learn.moviecataloguejetpackversion.viewmodel;

import androidx.lifecycle.ViewModel;

import com.learn.moviecataloguejetpackversion.data.TvShowData;
import com.learn.moviecataloguejetpackversion.data.source.MovieCatalogueRepository;
import com.learn.moviecataloguejetpackversion.data.source.local.entity.TvShow;

public class TvShowDetailViewModel extends ViewModel {
    private TvShow mTvShow;
    private String tvShowName;
    private MovieCatalogueRepository movieCatalogueRepository;

    public TvShowDetailViewModel(MovieCatalogueRepository mMovieCatalogueRepository) {
        this.movieCatalogueRepository = mMovieCatalogueRepository;
    }

    public TvShow getTvShowDetail() {
        for (int i = 0; i < TvShowData.generateTvShowList().size(); i++) {
//            TvShow tvShow = TvShowData.generateTvShowList().get(i);
            TvShow tvShow = movieCatalogueRepository.getAllTvShow().get(i);
            if (tvShow.getNameTvShow().equals(tvShowName)) {
                mTvShow = tvShow;
            }
        }

        return mTvShow;
    }

    public void setTvShowName(String tvShowName) {
        this.tvShowName = tvShowName;
    }
}

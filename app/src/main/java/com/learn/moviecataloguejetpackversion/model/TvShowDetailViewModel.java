package com.learn.moviecataloguejetpackversion.model;

import androidx.lifecycle.ViewModel;

import com.learn.moviecataloguejetpackversion.data.TvShowData;
import com.learn.moviecataloguejetpackversion.data.source.local.entity.TvShow;

public class TvShowDetailViewModel extends ViewModel {
    private TvShow mTvShow;
    private String idTvShow;

    public TvShow getTvShowDetail() {
        for (int i = 0; i < TvShowData.generateTvShowList().size(); i++) {
            TvShow tvShow = TvShowData.generateTvShowList().get(i);
            if (tvShow.getIdTvShow().equals(idTvShow)) {
                mTvShow = tvShow;
            }
        }

        return mTvShow;
    }

    public void setTvShowName(String idTvShow) {
        this.idTvShow = idTvShow;
    }
}

package com.learn.moviecataloguejetpackversion.data.source.local.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "tvshow")
public class TvShow {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "idTvShow")
    private String idTvShow;

    @ColumnInfo(name = "photoTvShow")
    private String photoTvShow;

    @ColumnInfo(name = "nameTvShow")
    private String nameTvShow;

    @ColumnInfo(name = "overviewTvShow")
    private String overviewTvShow;

    @ColumnInfo(name = "voteTvShow")
    private String voteTvShow;

    @ColumnInfo(name = "releaseTvShow")
    private String releaseTvShow;

    @ColumnInfo(name = "popularityTvShow")
    private String popularityTvShow;

    @ColumnInfo(name = "backdropTvShow")
    private String backdropTvShow;

    @ColumnInfo(name = "favoritedTvShow")
    private boolean favorited = false;

    public TvShow(@NonNull String idTvShow, String photoTvShow, String nameTvShow, String overviewTvShow, String voteTvShow, String releaseTvShow, String popularityTvShow, String backdropTvShow, Boolean favorited) {
        this.idTvShow = idTvShow;
        this.photoTvShow = photoTvShow;
        this.nameTvShow = nameTvShow;
        this.overviewTvShow = overviewTvShow;
        this.voteTvShow = voteTvShow;
        this.releaseTvShow = releaseTvShow;
        this.popularityTvShow = popularityTvShow;
        this.backdropTvShow = backdropTvShow;
        if (favorited != null) {
            this.favorited = favorited;
        }
    }

    @NonNull
    public String getIdTvShow() {
        return idTvShow;
    }

    public void setIdTvShow(String idTvShow) {
        this.idTvShow = idTvShow;
    }

    public String getPhotoTvShow() {
        return photoTvShow;
    }

    public void setPhotoTvShow(String photoTvShow) {
        this.photoTvShow = photoTvShow;
    }

    public String getNameTvShow() {
        return nameTvShow;
    }

    public void setNameTvShow(String nameTvShow) {
        this.nameTvShow = nameTvShow;
    }

    public String getOverviewTvShow() {
        return overviewTvShow;
    }

    public void setOverviewTvShow(String overviewTvShow) {
        this.overviewTvShow = overviewTvShow;
    }

    public String getVoteTvShow() {
        return voteTvShow;
    }

    public void setVoteTvShow(String voteTvShow) {
        this.voteTvShow = voteTvShow;
    }

    public String getReleaseTvShow() {
        return releaseTvShow;
    }

    public void setReleaseTvShow(String releaseTvShow) {
        this.releaseTvShow = releaseTvShow;
    }

    public String getPopularityTvShow() {
        return popularityTvShow;
    }

    public void setPopularityTvShow(String popularityTvShow) {
        this.popularityTvShow = popularityTvShow;
    }

    public String getBackdropTvShow() {
        return backdropTvShow;
    }

    public void setBackdropTvShow(String backdropTvShow) {
        this.backdropTvShow = backdropTvShow;
    }

    public boolean isFavorited() {
        return favorited;
    }

    public void setFavorited(boolean favorited) {
        this.favorited = favorited;
    }

    //    @Override
//    public int describeContents() {
//        return 0;
//    }
//
//    @Override
//    public void writeToParcel(Parcel parcel, int i) {
//        parcel.writeString(idTvShow);
//        parcel.writeString(photoTvShow);
//        parcel.writeString(nameTvShow);
//        parcel.writeString(overviewTvShow);
//        parcel.writeString(voteTvShow);
//        parcel.writeString(releaseTvShow);
//        parcel.writeString(popularityTvShow);
//        parcel.writeString(backdropTvShow);
//    }
//
//    protected TvShow(Parcel in) {
//        idTvShow = in.readString();
//        photoTvShow = in.readString();
//        nameTvShow = in.readString();
//        overviewTvShow = in.readString();
//        voteTvShow = in.readString();
//        releaseTvShow = in.readString();
//        popularityTvShow = in.readString();
//        backdropTvShow = in.readString();
//    }
//
//    public static final Creator<TvShow> CREATOR = new Creator<TvShow>() {
//        @Override
//        public TvShow createFromParcel(Parcel in) {
//            return new TvShow(in);
//        }
//
//        @Override
//        public TvShow[] newArray(int size) {
//            return new TvShow[size];
//        }
//    };
}

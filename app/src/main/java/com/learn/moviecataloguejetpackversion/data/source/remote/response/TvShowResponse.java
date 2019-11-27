package com.learn.moviecataloguejetpackversion.data.source.remote.response;

import android.os.Parcel;
import android.os.Parcelable;

public class TvShowResponse implements Parcelable {
    private String idTvShow;
    private String photoTvShow;
    private String nameTvShow;
    private String overviewTvShow;
    private String voteTvShow;
    private String releaseTvShow;
    private String popularityTvShow;
    private String backdropTvShow;

    public TvShowResponse(String idTvShow, String photoTvShow, String nameTvShow, String overviewTvShow, String voteTvShow, String releaseTvShow, String popularityTvShow, String backdropTvShow) {
        this.idTvShow = idTvShow;
        this.photoTvShow = photoTvShow;
        this.nameTvShow = nameTvShow;
        this.overviewTvShow = overviewTvShow;
        this.voteTvShow = voteTvShow;
        this.releaseTvShow = releaseTvShow;
        this.popularityTvShow = popularityTvShow;
        this.backdropTvShow = backdropTvShow;
    }

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(idTvShow);
        parcel.writeString(photoTvShow);
        parcel.writeString(nameTvShow);
        parcel.writeString(overviewTvShow);
        parcel.writeString(voteTvShow);
        parcel.writeString(releaseTvShow);
        parcel.writeString(popularityTvShow);
        parcel.writeString(backdropTvShow);
    }

    protected TvShowResponse(Parcel in) {
        idTvShow = in.readString();
        photoTvShow = in.readString();
        nameTvShow = in.readString();
        overviewTvShow = in.readString();
        voteTvShow = in.readString();
        releaseTvShow = in.readString();
        popularityTvShow = in.readString();
        backdropTvShow = in.readString();
    }

    public static final Creator<TvShowResponse> CREATOR = new Creator<TvShowResponse>() {
        @Override
        public TvShowResponse createFromParcel(Parcel in) {
            return new TvShowResponse(in);
        }

        @Override
        public TvShowResponse[] newArray(int size) {
            return new TvShowResponse[size];
        }
    };
}

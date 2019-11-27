package com.learn.moviecataloguejetpackversion.data.source.remote.response;

import android.os.Parcel;
import android.os.Parcelable;

public class TvShowResponse implements Parcelable {
    private String idTvShowResponse;
    private String photoTvShowResponse;
    private String nameTvShowResponse;
    private String overviewTvShowResponse;
    private String voteTvShowResponse;
    private String releaseTvShowResponse;
    private String popularityTvShowResponse;
    private String backdropTvShowResponse;

    public TvShowResponse(String idTvShowResponse, String photoTvShowResponse, String nameTvShowResponse, String overviewTvShowResponse, String voteTvShowResponse, String releaseTvShowResponse, String popularityTvShowResponse, String backdropTvShowResponse) {
        this.idTvShowResponse = idTvShowResponse;
        this.photoTvShowResponse = photoTvShowResponse;
        this.nameTvShowResponse = nameTvShowResponse;
        this.overviewTvShowResponse = overviewTvShowResponse;
        this.voteTvShowResponse = voteTvShowResponse;
        this.releaseTvShowResponse = releaseTvShowResponse;
        this.popularityTvShowResponse = popularityTvShowResponse;
        this.backdropTvShowResponse = backdropTvShowResponse;
    }

    public String getIdTvShowResponse() {
        return idTvShowResponse;
    }

    public void setIdTvShowResponse(String idTvShowResponse) {
        this.idTvShowResponse = idTvShowResponse;
    }

    public String getPhotoTvShowResponse() {
        return photoTvShowResponse;
    }

    public void setPhotoTvShowResponse(String photoTvShowResponse) {
        this.photoTvShowResponse = photoTvShowResponse;
    }

    public String getNameTvShowResponse() {
        return nameTvShowResponse;
    }

    public void setNameTvShowResponse(String nameTvShowResponse) {
        this.nameTvShowResponse = nameTvShowResponse;
    }

    public String getOverviewTvShowResponse() {
        return overviewTvShowResponse;
    }

    public void setOverviewTvShowResponse(String overviewTvShowResponse) {
        this.overviewTvShowResponse = overviewTvShowResponse;
    }

    public String getVoteTvShowResponse() {
        return voteTvShowResponse;
    }

    public void setVoteTvShowResponse(String voteTvShowResponse) {
        this.voteTvShowResponse = voteTvShowResponse;
    }

    public String getReleaseTvShowResponse() {
        return releaseTvShowResponse;
    }

    public void setReleaseTvShowResponse(String releaseTvShowResponse) {
        this.releaseTvShowResponse = releaseTvShowResponse;
    }

    public String getPopularityTvShowResponse() {
        return popularityTvShowResponse;
    }

    public void setPopularityTvShowResponse(String popularityTvShowResponse) {
        this.popularityTvShowResponse = popularityTvShowResponse;
    }

    public String getBackdropTvShowResponse() {
        return backdropTvShowResponse;
    }

    public void setBackdropTvShowResponse(String backdropTvShowResponse) {
        this.backdropTvShowResponse = backdropTvShowResponse;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(idTvShowResponse);
        parcel.writeString(photoTvShowResponse);
        parcel.writeString(nameTvShowResponse);
        parcel.writeString(overviewTvShowResponse);
        parcel.writeString(voteTvShowResponse);
        parcel.writeString(releaseTvShowResponse);
        parcel.writeString(popularityTvShowResponse);
        parcel.writeString(backdropTvShowResponse);
    }

    protected TvShowResponse(Parcel in) {
        idTvShowResponse = in.readString();
        photoTvShowResponse = in.readString();
        nameTvShowResponse = in.readString();
        overviewTvShowResponse = in.readString();
        voteTvShowResponse = in.readString();
        releaseTvShowResponse = in.readString();
        popularityTvShowResponse = in.readString();
        backdropTvShowResponse = in.readString();
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

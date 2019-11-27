package com.learn.moviecataloguejetpackversion.data.source.remote.response;

import android.os.Parcel;
import android.os.Parcelable;

public class MovieResponse implements Parcelable {
    private String idMovieResponse;
    private String photoMovieResponse;
    private String nameMovieResponse;
    private String overviewMovieResponse;
    private String voteMovieResponse;
    private String releaseMovieResponse;
    private String popularityMovieResponse;
    private String backdropMovieResponse;

    public MovieResponse(String idMovieResponse, String photoMovieResponse, String nameMovieResponse, String overviewMovieResponse, String voteMovieResponse, String releaseMovieResponse, String popularityMovieResponse, String backdropMovieResponse) {
        this.idMovieResponse = idMovieResponse;
        this.photoMovieResponse = photoMovieResponse;
        this.nameMovieResponse = nameMovieResponse;
        this.overviewMovieResponse = overviewMovieResponse;
        this.voteMovieResponse = voteMovieResponse;
        this.releaseMovieResponse = releaseMovieResponse;
        this.popularityMovieResponse = popularityMovieResponse;
        this.backdropMovieResponse = backdropMovieResponse;
    }

    public String getIdMovieResponse() {
        return idMovieResponse;
    }

    public void setIdMovieResponse(String idMovieResponse) {
        this.idMovieResponse = idMovieResponse;
    }

    public String getPhotoMovieResponse() {
        return photoMovieResponse;
    }

    public void setPhotoMovieResponse(String photoMovieResponse) {
        this.photoMovieResponse = photoMovieResponse;
    }

    public String getNameMovieResponse() {
        return nameMovieResponse;
    }

    public void setNameMovieResponse(String nameMovieResponse) {
        this.nameMovieResponse = nameMovieResponse;
    }

    public String getOverviewMovieResponse() {
        return overviewMovieResponse;
    }

    public void setOverviewMovieResponse(String overviewMovieResponse) {
        this.overviewMovieResponse = overviewMovieResponse;
    }

    public String getVoteMovieResponse() {
        return voteMovieResponse;
    }

    public void setVoteMovieResponse(String voteMovieResponse) {
        this.voteMovieResponse = voteMovieResponse;
    }

    public String getReleaseMovieResponse() {
        return releaseMovieResponse;
    }

    public void setReleaseMovieResponse(String releaseMovieResponse) {
        this.releaseMovieResponse = releaseMovieResponse;
    }

    public String getPopularityMovieResponse() {
        return popularityMovieResponse;
    }

    public void setPopularityMovieResponse(String popularityMovieResponse) {
        this.popularityMovieResponse = popularityMovieResponse;
    }

    public String getBackdropMovieResponse() {
        return backdropMovieResponse;
    }

    public void setBackdropMovieResponse(String backdropMovieResponse) {
        this.backdropMovieResponse = backdropMovieResponse;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(idMovieResponse);
        parcel.writeString(photoMovieResponse);
        parcel.writeString(nameMovieResponse);
        parcel.writeString(overviewMovieResponse);
        parcel.writeString(voteMovieResponse);
        parcel.writeString(releaseMovieResponse);
        parcel.writeString(popularityMovieResponse);
        parcel.writeString(backdropMovieResponse);
    }

    protected MovieResponse(Parcel in) {
        idMovieResponse = in.readString();
        photoMovieResponse = in.readString();
        nameMovieResponse = in.readString();
        overviewMovieResponse = in.readString();
        voteMovieResponse = in.readString();
        releaseMovieResponse = in.readString();
        popularityMovieResponse = in.readString();
        backdropMovieResponse = in.readString();
    }

    public static final Creator<MovieResponse> CREATOR = new Creator<MovieResponse>() {
        @Override
        public MovieResponse createFromParcel(Parcel in) {
            return new MovieResponse(in);
        }

        @Override
        public MovieResponse[] newArray(int size) {
            return new MovieResponse[size];
        }
    };
}

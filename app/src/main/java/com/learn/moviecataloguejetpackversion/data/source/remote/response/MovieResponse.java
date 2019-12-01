package com.learn.moviecataloguejetpackversion.data.source.remote.response;

import android.os.Parcel;
import android.os.Parcelable;

public class MovieResponse implements Parcelable {
<<<<<<< HEAD
    private String idMovie;
    private String photoMovie;
    private String nameMovie;
    private String overviewMovie;
    private String voteMovie;
    private String releaseMovie;
    private String popularityMovie;
    private String backdropMovie;

    public MovieResponse(String idMovie, String photoMovie, String nameMovie, String overviewMovie, String voteMovie, String releaseMovie, String popularityMovie, String backdropMovie) {
        this.idMovie = idMovie;
        this.photoMovie = photoMovie;
        this.nameMovie = nameMovie;
        this.overviewMovie = overviewMovie;
        this.voteMovie = voteMovie;
        this.releaseMovie = releaseMovie;
        this.popularityMovie = popularityMovie;
        this.backdropMovie = backdropMovie;
    }

    public String getIdMovie() {
        return idMovie;
    }

    public void setIdMovie(String idMovie) {
        this.idMovie = idMovie;
    }

    public String getPhotoMovie() {
        return photoMovie;
    }

    public void setPhotoMovie(String photoMovie) {
        this.photoMovie = photoMovie;
    }

    public String getNameMovie() {
        return nameMovie;
    }

    public void setNameMovie(String nameMovie) {
        this.nameMovie = nameMovie;
    }

    public String getOverviewMovie() {
        return overviewMovie;
    }

    public void setOverviewMovie(String overviewMovie) {
        this.overviewMovie = overviewMovie;
    }

    public String getVoteMovie() {
        return voteMovie;
    }

    public void setVoteMovie(String voteMovie) {
        this.voteMovie = voteMovie;
    }

    public String getReleaseMovie() {
        return releaseMovie;
    }

    public void setReleaseMovie(String releaseMovie) {
        this.releaseMovie = releaseMovie;
    }

    public String getPopularityMovie() {
        return popularityMovie;
    }

    public void setPopularityMovie(String popularityMovie) {
        this.popularityMovie = popularityMovie;
    }

    public String getBackdropMovie() {
        return backdropMovie;
    }

    public void setBackdropMovie(String backdropMovie) {
        this.backdropMovie = backdropMovie;
=======
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
>>>>>>> repository-dev
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
<<<<<<< HEAD
        parcel.writeString(idMovie);
        parcel.writeString(photoMovie);
        parcel.writeString(nameMovie);
        parcel.writeString(overviewMovie);
        parcel.writeString(voteMovie);
        parcel.writeString(releaseMovie);
        parcel.writeString(popularityMovie);
        parcel.writeString(backdropMovie);
    }

    protected MovieResponse(Parcel in) {
        idMovie = in.readString();
        photoMovie = in.readString();
        nameMovie = in.readString();
        overviewMovie = in.readString();
        voteMovie = in.readString();
        releaseMovie = in.readString();
        popularityMovie = in.readString();
        backdropMovie = in.readString();
=======
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
>>>>>>> repository-dev
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

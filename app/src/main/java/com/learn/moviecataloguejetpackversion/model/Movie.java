package com.learn.moviecataloguejetpackversion.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.jar.Pack200;

public class Movie implements Parcelable {
    private int idMovie;
    private String photoMovie;
    private String nameMovie;
    private String overviewMovie;
    private String voteMovie;
    private String releaseMovie;
    private String popularityMovie;
    private String backdropMovie;

    public Movie() {

    }

    public int getIdMovie() {
        return idMovie;
    }

    public void setIdMovie(int idMovie) {
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
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(idMovie);
        parcel.writeString(photoMovie);
        parcel.writeString(nameMovie);
        parcel.writeString(overviewMovie);
        parcel.writeString(voteMovie);
        parcel.writeString(releaseMovie);
        parcel.writeString(popularityMovie);
        parcel.writeString(backdropMovie);
    }

    protected Movie(Parcel in) {
        idMovie = in.readInt();
        photoMovie = in.readString();
        nameMovie = in.readString();
        overviewMovie = in.readString();
        voteMovie = in.readString();
        releaseMovie = in.readString();
        popularityMovie = in.readString();
        backdropMovie = in.readString();
    }

    public static final Creator<Movie> CREATOR = new Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel in) {
            return new Movie(in);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };
}

package com.learn.moviecataloguejetpackversion.data.source.local.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "movie")
public class Movie {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "idMovie")
    private String idMovie;

    @ColumnInfo(name = "photoMovie")
    private String photoMovie;

    @ColumnInfo(name = "nameMovie")
    private String nameMovie;

    @ColumnInfo(name = "overviewMovie")
    private String overviewMovie;

    @ColumnInfo(name = "voteMovie")
    private String voteMovie;

    @ColumnInfo(name = "releaseMovie")
    private String releaseMovie;

    @ColumnInfo(name = "popularityMovie")
    private String popularityMovie;

    @ColumnInfo(name = "backdropMovie")
    private String backdropMovie;

    @ColumnInfo(name = "favorited")
    private boolean favorited = false;

    public Movie() {

    }

    public Movie(String idMovie, String photoMovie, String nameMovie, String overviewMovie, String voteMovie, String releaseMovie, String popularityMovie, String backdropMovie, Boolean favorited) {
        this.idMovie = idMovie;
        this.photoMovie = photoMovie;
        this.nameMovie = nameMovie;
        this.overviewMovie = overviewMovie;
        this.voteMovie = voteMovie;
        this.releaseMovie = releaseMovie;
        this.popularityMovie = popularityMovie;
        this.backdropMovie = backdropMovie;
        if (favorited != null) {
            this.favorited = favorited;
        }
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
    }

    public boolean isFavorited() {
        return favorited;
    }

    public void setFavorited(boolean favorited) {
        this.favorited = favorited;
    }
}

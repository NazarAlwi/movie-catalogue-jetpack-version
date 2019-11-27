package com.learn.moviecataloguejetpackversion.utils;

import android.app.Application;

import com.learn.moviecataloguejetpackversion.data.source.remote.response.MovieResponse;
import com.learn.moviecataloguejetpackversion.data.source.remote.response.TvShowResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class JsonHelper {
    private Application application;

    public JsonHelper(Application application) {
        this.application = application;
    }

    private String parsingFileToString(String fileName) {
        try {
            InputStream is = application.getAssets().open(fileName);
            byte[] buffer = new byte[is.available()];
            is.read(buffer);
            is.close();
            return new String(buffer);

        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public List<MovieResponse> loadMovies() {
        ArrayList<MovieResponse> list = new ArrayList<>();

        try {
            JSONObject responseObject = new JSONObject(parsingFileToString("MovieResponses.json"));
            JSONArray listArray = responseObject.getJSONArray("results");
            for (int i = 0; i < listArray.length(); i++) {
                JSONObject movie = listArray.getJSONObject(i);

                String id = movie.getString("id");
                String name = movie.getString("name");
                String releaseDate = movie.getString("releaseDate");
                String overview = movie.getString("overview");
                String posterPath = movie.getString("posterPath");
                String backdropPath = movie.getString("backdropPath");
                String popularity = movie.getString("popularity");
                String voteAverage = movie.getString("voteAverage");

                MovieResponse movieResponse = new MovieResponse(id, posterPath, name, overview, voteAverage, releaseDate, popularity, backdropPath);
                list.add(movieResponse);
            }
        } catch (JSONException e) {
            e.printStackTrace();;
        }

        return list;
    }

    public List<TvShowResponse> loadTvShows() {
        ArrayList<TvShowResponse> list = new ArrayList<>();

        try {
            JSONObject responseObject = new JSONObject(parsingFileToString("TvShowResponses.json"));
            JSONArray listArray = responseObject.getJSONArray("results");
            for (int i = 0; i < listArray.length(); i++) {
                JSONObject tvshow = listArray.getJSONObject(i);

                String id = tvshow.getString("id");
                String name = tvshow.getString("name");
                String firstAirDate = tvshow.getString("firstAirDate");
                String overview = tvshow.getString("overview");
                String posterPath = tvshow.getString("posterPath");
                String backdropPath = tvshow.getString("backdropPath");
                String popularity = tvshow.getString("popularity");
                String voteAverage = tvshow.getString("voteAverage");

                TvShowResponse tvShowResponse = new TvShowResponse(id, posterPath, name, overview, voteAverage, firstAirDate, popularity, backdropPath);
                list.add(tvShowResponse);
            }
        } catch (JSONException e) {
            e.printStackTrace();;
        }

        return list;
    }
}

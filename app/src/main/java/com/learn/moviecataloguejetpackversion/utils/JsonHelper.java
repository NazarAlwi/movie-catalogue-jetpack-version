package com.learn.moviecataloguejetpackversion.utils;

import android.app.Application;

import com.learn.moviecataloguejetpackversion.data.source.remote.response.MovieResponse;
import com.learn.moviecataloguejetpackversion.data.source.remote.response.TvShowResponse;

import org.json.JSONArray;
import org.json.JSONObject;

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
            InputStream inputStream = application.getAssets().open(fileName);
            byte[] buffer = new byte[inputStream.available()];
            inputStream.read();
            inputStream.close();
            return new String(buffer);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<MovieResponse> loadMovie() {
        ArrayList<MovieResponse> list = new ArrayList<>();

        try {
            JSONObject responseObject = new JSONObject(parsingFileToString("MovieResponse.json"));
            JSONArray listArray = responseObject.getJSONArray("movie");
            for (int i = 0; i < listArray.length(); i++) {
                JSONObject movie = listArray.getJSONObject(i);

                String id = movie.getString("id");
                String photo = movie.getString("image_path");
                String name = movie.getString("title");
                String overview = movie.getString("overview");
                String vote = movie.getString("vote");
                String release = movie.getString("date_release");
                String popularity = movie.getString("popularity");
                String backdrop = movie.getString("backdrop_path");

                MovieResponse movieResponse = new MovieResponse(photo, name, overview, vote, release, popularity, backdrop);
                list.add(movieResponse);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public List<TvShowResponse> loadTvShow() {
        ArrayList<TvShowResponse> list = new ArrayList<>();

        try {
            JSONObject responseObject = new JSONObject(parsingFileToString("TvShowResponse.json"));
            JSONArray listArray = responseObject.getJSONArray("tvshow");
            for (int i = 0; i < listArray.length(); i++) {
                JSONObject tvshow = listArray.getJSONObject(i);

                String id = tvshow.getString("id");
                String photo = tvshow.getString("image_path");
                String name = tvshow.getString("title");
                String overview = tvshow.getString("overview");
                String vote = tvshow.getString("vote");
                String release = tvshow.getString("date_release");
                String popularity = tvshow.getString("popularity");
                String backdrop = tvshow.getString("backdrop_path");

                TvShowResponse tvShowResponse = new TvShowResponse(photo, name, overview, vote, release, popularity, backdrop);
                list.add(tvShowResponse);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}

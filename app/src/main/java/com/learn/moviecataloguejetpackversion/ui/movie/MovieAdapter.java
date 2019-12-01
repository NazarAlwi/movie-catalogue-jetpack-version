package com.learn.moviecataloguejetpackversion.ui.movie;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.learn.moviecataloguejetpackversion.BuildConfig;
import com.learn.moviecataloguejetpackversion.R;
<<<<<<< HEAD:app/src/main/java/com/learn/moviecataloguejetpackversion/adapter/MovieAdapter.java
import com.learn.moviecataloguejetpackversion.activity.DetailMovieActivity;
import com.learn.moviecataloguejetpackversion.data.source.local.entity.Movie;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {
=======
import com.learn.moviecataloguejetpackversion.ui.detail.movie.DetailMovieActivity;
import com.learn.moviecataloguejetpackversion.data.source.local.entity.Movie;

import java.util.ArrayList;
import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {
    private List<Movie> movies = new ArrayList<>();
>>>>>>> repository-dev:app/src/main/java/com/learn/moviecataloguejetpackversion/ui/movie/MovieAdapter.java
    private final Activity activity;
    private List<Movie> movies;

<<<<<<< HEAD:app/src/main/java/com/learn/moviecataloguejetpackversion/adapter/MovieAdapter.java
    public MovieAdapter(List<Movie> movies, Activity activity) {
        this.movies = movies;
        this.activity = activity;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        if (movies == null) return;
        this.movies.clear();
        this.movies.addAll(movies);
=======
    public MovieAdapter(Activity activity) {
        this.activity = activity;
    }

    private List<Movie> getListMovie() {
        return movies;
    }

    public void setListMovie(List<Movie> listMovie) {
        if (listMovie == null) return;
        this.movies.clear();
        this.movies.addAll(listMovie);
>>>>>>> repository-dev:app/src/main/java/com/learn/moviecataloguejetpackversion/ui/movie/MovieAdapter.java
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MovieViewHolder holder, final int position) {
        Glide.with(holder.itemView.getContext())
<<<<<<< HEAD:app/src/main/java/com/learn/moviecataloguejetpackversion/adapter/MovieAdapter.java
                .load(BuildConfig.BASE_URL_IMG_LIST + getMovies().get(position).getPhotoMovie())
                .placeholder(R.drawable.loadimage)
                .error(R.drawable.errorloadimage)
                .into(holder.imgMovie);
        holder.tvNameMovie.setText(getMovies().get(position).getNameMovie());
        holder.tvReleaseMovie.setText(getMovies().get(position).getReleaseMovie());
        holder.tvVoteMovie.setText(getMovies().get(position).getVoteMovie());
        holder.itemView.setOnClickListener(view ->  {
            Intent goToDetailMovie = new Intent(activity, DetailMovieActivity.class);
            goToDetailMovie.putExtra(DetailMovieActivity.EXTRA_MOVIES, movies.get(position).getIdMovie());
=======
                .load(BuildConfig.BASE_URL_IMG_LIST + getListMovie().get(position).getPhotoMovie())
                .placeholder(R.drawable.loadimage)
                .error(R.drawable.errorloadimage)
                .into(holder.imgMovie);
        holder.tvNameMovie.setText(getListMovie().get(position).getNameMovie());
        holder.tvReleaseMovie.setText(getListMovie().get(position).getReleaseMovie());
        holder.tvVoteMovie.setText(getListMovie().get(position).getVoteMovie());
        holder.itemView.setOnClickListener(view ->  {
            Intent goToDetailMovie = new Intent(activity, DetailMovieActivity.class);
            goToDetailMovie.putExtra(DetailMovieActivity.EXTRA_MOVIES, getListMovie().get(position).getIdMovie());
>>>>>>> repository-dev:app/src/main/java/com/learn/moviecataloguejetpackversion/ui/movie/MovieAdapter.java
            activity.startActivity(goToDetailMovie);
        });
    }

    @Override
    public int getItemCount() {
        return getMovies().size();
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder {
        ImageView imgMovie;
        TextView tvNameMovie;
        TextView tvReleaseMovie;
        TextView tvVoteMovie;

        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);

            imgMovie = itemView.findViewById(R.id.img_movie);
            tvNameMovie = itemView.findViewById(R.id.tv_name);
            tvReleaseMovie = itemView.findViewById(R.id.tv_release);
            tvVoteMovie = itemView.findViewById(R.id.tv_vote);
        }
    }
}

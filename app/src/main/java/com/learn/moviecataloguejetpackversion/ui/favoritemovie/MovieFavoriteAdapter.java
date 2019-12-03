package com.learn.moviecataloguejetpackversion.ui.favoritemovie;

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
import com.learn.moviecataloguejetpackversion.data.source.local.entity.Movie;
import com.learn.moviecataloguejetpackversion.ui.detail.movie.DetailMovieActivity;

import java.util.ArrayList;
import java.util.List;

public class MovieFavoriteAdapter extends RecyclerView.Adapter<MovieFavoriteAdapter.MovieViewHolder> {
    private ArrayList<Movie> movies = new ArrayList<>();
    private final Activity activity;

    public MovieFavoriteAdapter(Activity activity) {
        this.activity = activity;
    }

    public void setListMovieFavorite(List<Movie> listMovie) {
        if (listMovie == null) return;
        this.movies.clear();
        this.movies.addAll(listMovie);
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MovieViewHolder holder, final int position) {
        Movie movie = movies.get(position);

        Glide.with(holder.itemView.getContext())
                .load(BuildConfig.BASE_URL_IMG_LIST + movie.getPhotoMovie())
                .placeholder(R.drawable.loadimage)
                .error(R.drawable.errorloadimage)
                .into(holder.imgMovie);
        holder.tvNameMovie.setText(movie.getNameMovie());
        holder.tvReleaseMovie.setText(movie.getReleaseMovie());
        holder.tvVoteMovie.setText(movie.getVoteMovie());
        holder.itemView.setOnClickListener(view ->  {
            Intent goToDetailMovie = new Intent(activity, DetailMovieActivity.class);
            goToDetailMovie.putExtra(DetailMovieActivity.EXTRA_MOVIES, movie.getIdMovie());
            activity.startActivity(goToDetailMovie);
        });
    }

    @Override
    public int getItemCount() {
        return movies.size();
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

package com.learn.moviecataloguejetpackversion.adapter;

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
import com.learn.moviecataloguejetpackversion.model.Movie;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {
    private ArrayList<Movie> movies;
    private OnItemClickCallback onItemClickCallback;

    public MovieAdapter(ArrayList<Movie> movies) {
        this.movies = movies;
    }

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    public interface OnItemClickCallback {
        void onItemClicked(Movie movie, int position);
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MovieViewHolder holder, final int position) {
        final Movie movie = movies.get(position);

        Glide.with(holder.itemView.getContext())
                .load(BuildConfig.BASE_URL_IMG_LIST + movie.getPhotoMovie())
                .placeholder(R.drawable.loadimage)
                .error(R.drawable.errorloadimage)
                .into(holder.imgMovie);
        holder.tvNameMovie.setText(movie.getNameMovie());
        holder.tvReleaseMovie.setText(movie.getReleaseMovie());
        holder.tvVoteMovie.setText(movie.getVoteMovie());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickCallback.onItemClicked(movie, position);
            }
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

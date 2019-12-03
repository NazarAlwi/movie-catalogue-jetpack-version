package com.learn.moviecataloguejetpackversion.ui.favoritemovie;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.learn.moviecataloguejetpackversion.BuildConfig;
import com.learn.moviecataloguejetpackversion.R;
import com.learn.moviecataloguejetpackversion.data.source.local.entity.Movie;
import com.learn.moviecataloguejetpackversion.ui.detail.movie.DetailMovieActivity;

public class MovieFavoritePagedAdapter extends PagedListAdapter<Movie, MovieFavoritePagedAdapter.MovieFavoriteViewHolder> {
    MovieFavoritePagedAdapter() {
        super(DIFF_CALLBACK);
    }

    @NonNull
    @Override
    public MovieFavoriteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row, parent, false);
        return new MovieFavoriteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieFavoriteViewHolder holder, int position) {
        final Movie movie = getItem(position);

        if (movie != null) {
            Glide.with(holder.itemView.getContext())
                    .load(BuildConfig.BASE_URL_IMG_LIST + movie.getPhotoMovie())
                    .placeholder(R.drawable.loadimage)
                    .error(R.drawable.errorloadimage)
                    .into(holder.imgMovie);
            holder.tvNameMovie.setText(movie.getNameMovie());
            holder.tvReleaseMovie.setText(movie.getReleaseMovie());
            holder.tvVoteMovie.setText(movie.getVoteMovie());
            holder.itemView.setOnClickListener(view ->  {
                Context context = holder.itemView.getContext();
                Intent goToDetailMovie = new Intent(context, DetailMovieActivity.class);
                goToDetailMovie.putExtra(DetailMovieActivity.EXTRA_MOVIES, movie.getIdMovie());
                context.startActivity(goToDetailMovie);
            });
        }
    }

    private static DiffUtil.ItemCallback<Movie> DIFF_CALLBACK =
            new DiffUtil.ItemCallback<Movie>() {
                @Override
                public boolean areItemsTheSame(@NonNull Movie oldItem, @NonNull Movie newItem) {
                    return oldItem.getIdMovie().equals(newItem.getIdMovie());
                }

                @SuppressLint("DiffUtilEquals")
                @Override
                public boolean areContentsTheSame(@NonNull Movie oldItem, @NonNull Movie newItem) {
                    return oldItem.equals(newItem);
                }
            };

    Movie getItemById(int swipedPosition) {
        return getItem(swipedPosition);
    }

    public class MovieFavoriteViewHolder extends RecyclerView.ViewHolder {
        ImageView imgMovie;
        TextView tvNameMovie;
        TextView tvReleaseMovie;
        TextView tvVoteMovie;
        public MovieFavoriteViewHolder(@NonNull View itemView) {
            super(itemView);

            imgMovie = itemView.findViewById(R.id.img_movie);
            tvNameMovie = itemView.findViewById(R.id.tv_name);
            tvReleaseMovie = itemView.findViewById(R.id.tv_release);
            tvVoteMovie = itemView.findViewById(R.id.tv_vote);
        }
    }
}

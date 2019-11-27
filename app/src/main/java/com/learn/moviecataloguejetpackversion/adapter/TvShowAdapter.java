package com.learn.moviecataloguejetpackversion.adapter;

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
import com.learn.moviecataloguejetpackversion.activity.DetailTvShowActivity;
import com.learn.moviecataloguejetpackversion.data.source.local.entity.TvShow;

import java.util.ArrayList;

public class TvShowAdapter extends RecyclerView.Adapter<TvShowAdapter.TvShowViewHolder> {
    private ArrayList<TvShow> tvShows;
    private final Activity activity;

    public TvShowAdapter(ArrayList<TvShow> tvShows, Activity activity) {
        this.tvShows = tvShows;
        this.activity = activity;
    }

    @NonNull
    @Override
    public TvShowViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row, parent, false);
        return new TvShowViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TvShowViewHolder holder, final int position) {
        final TvShow tvShow = tvShows.get(position);

        Glide.with(holder.itemView.getContext())
                .load(BuildConfig.BASE_URL_IMG_LIST + tvShow.getPhotoTvShow())
                .placeholder(R.drawable.loadimage)
                .error(R.drawable.errorloadimage)
                .into(holder.imgTvShow);
        holder.tvNameTvShow.setText(tvShow.getNameTvShow());
        holder.tvReleaseTvShow.setText(tvShow.getReleaseTvShow());
        holder.tvVoteTvShow.setText(tvShow.getVoteTvShow());
        holder.itemView.setOnClickListener(view ->  {
            Intent goToDetail = new Intent(activity, DetailTvShowActivity.class);
            goToDetail.putExtra(DetailTvShowActivity.EXTRA_TV_SHOWS, tvShows.get(position).getIdTvShow());
            activity.startActivity(goToDetail);
        });
    }

    @Override
    public int getItemCount() {
        return tvShows.size();
    }

    public class TvShowViewHolder extends RecyclerView.ViewHolder {
        ImageView imgTvShow;
        TextView tvNameTvShow;
        TextView tvReleaseTvShow;
        TextView tvVoteTvShow;

        public TvShowViewHolder(@NonNull View itemView) {
            super(itemView);

            imgTvShow = itemView.findViewById(R.id.img_movie);
            tvNameTvShow = itemView.findViewById(R.id.tv_name);
            tvReleaseTvShow = itemView.findViewById(R.id.tv_release);
            tvVoteTvShow = itemView.findViewById(R.id.tv_vote);
        }
    }
}

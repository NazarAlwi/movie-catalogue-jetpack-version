package com.learn.moviecataloguejetpackversion.ui.tvshow;

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
import com.learn.moviecataloguejetpackversion.ui.detail.tvshow.DetailTvShowActivity;
import com.learn.moviecataloguejetpackversion.data.source.local.entity.TvShow;

import java.util.ArrayList;
import java.util.List;

public class TvShowAdapter extends RecyclerView.Adapter<TvShowAdapter.TvShowViewHolder> {
    private List<TvShow> tvShows = new ArrayList<>();
    private final Activity activity;

    public TvShowAdapter(Activity activity) {
        this.activity = activity;
    }

    private List<TvShow> getListTvShows() {
        return tvShows;
    }

    public void setListTvShow(List<TvShow> listTvShow) {
        if (listTvShow == null) return;
        this.tvShows.clear();
        this.tvShows.addAll(listTvShow);
    }

    @NonNull
    @Override
    public TvShowViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row, parent, false);
        return new TvShowViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TvShowViewHolder holder, final int position) {
        Glide.with(holder.itemView.getContext())
                .load(BuildConfig.BASE_URL_IMG_LIST + getListTvShows().get(position).getPhotoTvShow())
                .placeholder(R.drawable.loadimage)
                .error(R.drawable.errorloadimage)
                .into(holder.imgTvShow);
        holder.tvNameTvShow.setText(getListTvShows().get(position).getNameTvShow());
        holder.tvReleaseTvShow.setText(getListTvShows().get(position).getReleaseTvShow());
        holder.tvVoteTvShow.setText(getListTvShows().get(position).getVoteTvShow());
        holder.itemView.setOnClickListener(view ->  {
            Intent goToDetail = new Intent(activity, DetailTvShowActivity.class);
            goToDetail.putExtra(DetailTvShowActivity.EXTRA_TV_SHOWS, getListTvShows().get(position).getIdTvShow());
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
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
<<<<<<< HEAD:app/src/main/java/com/learn/moviecataloguejetpackversion/adapter/TvShowAdapter.java
import com.learn.moviecataloguejetpackversion.activity.DetailTvShowActivity;
=======
import com.learn.moviecataloguejetpackversion.ui.detail.tvshow.DetailTvShowActivity;
>>>>>>> repository-dev:app/src/main/java/com/learn/moviecataloguejetpackversion/ui/tvshow/TvShowAdapter.java
import com.learn.moviecataloguejetpackversion.data.source.local.entity.TvShow;

import java.util.ArrayList;
import java.util.List;

public class TvShowAdapter extends RecyclerView.Adapter<TvShowAdapter.TvShowViewHolder> {
<<<<<<< HEAD:app/src/main/java/com/learn/moviecataloguejetpackversion/adapter/TvShowAdapter.java
=======
    private List<TvShow> tvShows = new ArrayList<>();
>>>>>>> repository-dev:app/src/main/java/com/learn/moviecataloguejetpackversion/ui/tvshow/TvShowAdapter.java
    private final Activity activity;
    private List<TvShow> tvShows = new ArrayList<>();

<<<<<<< HEAD:app/src/main/java/com/learn/moviecataloguejetpackversion/adapter/TvShowAdapter.java
    public TvShowAdapter(List<TvShow> tvShows, Activity activity) {
        this.tvShows = tvShows;
        this.activity = activity;
    }

    public List<TvShow> getTvShows() {
        return tvShows;
    }

    public void setTvShows(List<TvShow> tvShows) {
        if (tvShows == null) return;
        this.tvShows.clear();
        this.tvShows.addAll(tvShows);
=======
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
>>>>>>> repository-dev:app/src/main/java/com/learn/moviecataloguejetpackversion/ui/tvshow/TvShowAdapter.java
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
<<<<<<< HEAD:app/src/main/java/com/learn/moviecataloguejetpackversion/adapter/TvShowAdapter.java
                .load(BuildConfig.BASE_URL_IMG_LIST + getTvShows().get(position).getPhotoTvShow())
                .placeholder(R.drawable.loadimage)
                .error(R.drawable.errorloadimage)
                .into(holder.imgTvShow);
        holder.tvNameTvShow.setText(getTvShows().get(position).getNameTvShow());
        holder.tvReleaseTvShow.setText(getTvShows().get(position).getReleaseTvShow());
        holder.tvVoteTvShow.setText(getTvShows().get(position).getVoteTvShow());
        holder.itemView.setOnClickListener(view ->  {
            Intent goToDetail = new Intent(activity, DetailTvShowActivity.class);
            goToDetail.putExtra(DetailTvShowActivity.EXTRA_TV_SHOWS, tvShows.get(position).getIdTvShow());
=======
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
>>>>>>> repository-dev:app/src/main/java/com/learn/moviecataloguejetpackversion/ui/tvshow/TvShowAdapter.java
            activity.startActivity(goToDetail);
        });
    }

    @Override
    public int getItemCount() {
        return getTvShows().size();
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

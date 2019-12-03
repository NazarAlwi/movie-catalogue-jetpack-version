package com.learn.moviecataloguejetpackversion.ui.favoritetvshow;

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
import com.learn.moviecataloguejetpackversion.data.source.local.entity.TvShow;
import com.learn.moviecataloguejetpackversion.ui.detail.tvshow.DetailTvShowActivity;

public class TvShowFavoritePagedAdapter extends PagedListAdapter<TvShow, TvShowFavoritePagedAdapter.TvShowFavoriteViewHolder> {
    protected TvShowFavoritePagedAdapter() {
        super(DIFF_CALLBACK);
    }

    @NonNull
    @Override
    public TvShowFavoriteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row, parent, false);
        return new TvShowFavoriteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TvShowFavoriteViewHolder holder, int position) {
        final TvShow tvShow = getItem(position);
        if (tvShow != null) {
            Glide.with(holder.itemView.getContext())
                    .load(BuildConfig.BASE_URL_IMG_LIST + tvShow.getPhotoTvShow())
                    .placeholder(R.drawable.loadimage)
                    .error(R.drawable.errorloadimage)
                    .into(holder.imgTvShow);
            holder.tvNameTvShow.setText(tvShow.getNameTvShow());
            holder.tvReleaseTvShow.setText(tvShow.getReleaseTvShow());
            holder.tvVoteTvShow.setText(tvShow.getVoteTvShow());
            holder.itemView.setOnClickListener(view ->  {
                Context context = holder.itemView.getContext();
                Intent goToDetail = new Intent(context, DetailTvShowActivity.class);
                goToDetail.putExtra(DetailTvShowActivity.EXTRA_TV_SHOWS, tvShow.getIdTvShow());
                context.startActivity(goToDetail);
            });
        }
    }

    private static DiffUtil.ItemCallback<TvShow> DIFF_CALLBACK =
            new DiffUtil.ItemCallback<TvShow>() {
                @Override
                public boolean areItemsTheSame(@NonNull TvShow oldItem, @NonNull TvShow newItem) {
                    return oldItem.getIdTvShow().equals(newItem.getIdTvShow());
                }

                @SuppressLint("DiffUtilEquals")
                @Override
                public boolean areContentsTheSame(@NonNull TvShow oldItem, @NonNull TvShow newItem) {
                    return oldItem.equals(newItem);
                }
            };

    TvShow getItemById(int swipedPosition) {
        return getItem(swipedPosition);
    }

    public class TvShowFavoriteViewHolder extends RecyclerView.ViewHolder {
        ImageView imgTvShow;
        TextView tvNameTvShow;
        TextView tvReleaseTvShow;
        TextView tvVoteTvShow;

        public TvShowFavoriteViewHolder(@NonNull View itemView) {
            super(itemView);

            imgTvShow = itemView.findViewById(R.id.img_movie);
            tvNameTvShow = itemView.findViewById(R.id.tv_name);
            tvReleaseTvShow = itemView.findViewById(R.id.tv_release);
            tvVoteTvShow = itemView.findViewById(R.id.tv_vote);
        }
    }
}

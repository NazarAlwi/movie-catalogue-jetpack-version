package com.learn.moviecataloguejetpackversion.fragment;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.learn.moviecataloguejetpackversion.R;
import com.learn.moviecataloguejetpackversion.activity.DetailTvShowActivity;
import com.learn.moviecataloguejetpackversion.adapter.TvShowAdapter;
import com.learn.moviecataloguejetpackversion.model.MainViewModel;
import com.learn.moviecataloguejetpackversion.model.TvShow;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class TvShowsFragment extends Fragment {
    private RecyclerView recyclerView;
    private ArrayList<TvShow> tvShows = new ArrayList<>();

    public TvShowsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tv_shows, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        recyclerView = view.findViewById(R.id.rv_tv_shows);
        recyclerView.setHasFixedSize(true);
        tvShows.addAll(MainViewModel.getListTvShow());
        showRecyclerList();
    }

    private void showRecyclerList() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        TvShowAdapter tvShowAdapter = new TvShowAdapter(tvShows);
        recyclerView.setAdapter(tvShowAdapter);

//        tvShowAdapter.setOnItemClickCallback(new TvShowAdapter.OnItemClickCallback() {
//            @Override
//            public void onItemClicked(TvShow tvShow, int position) {
//                Intent goToDetail = new Intent(getActivity(), DetailTvShowActivity.class);
//                goToDetail.putExtra(DetailTvShowActivity.EXTRA_TV_SHOWS, tvShows.get(position));
//                startActivity(goToDetail);
//            }
//        });
    }
}

package com.learn.moviecataloguejetpackversion.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.learn.moviecataloguejetpackversion.R;
import com.learn.moviecataloguejetpackversion.adapter.TvShowAdapter;
import com.learn.moviecataloguejetpackversion.viewmodel.MainViewModel;
import com.learn.moviecataloguejetpackversion.data.source.local.entity.TvShow;
import com.learn.moviecataloguejetpackversion.viewmodel.ViewModelFactory;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class TvShowsFragment extends Fragment {
    private RecyclerView recyclerView;
    private List<TvShow> tvShows;
    private MainViewModel viewModel;

    public TvShowsFragment() {
        // Required empty public constructor
    }

    public static Fragment newInstance() {
        return new TvShowsFragment();
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
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getActivity() != null) {
            viewModel = obtainViewModel(getActivity());
            showRecyclerList();
        }
    }

    @NonNull
    private static MainViewModel obtainViewModel(FragmentActivity activity) {
        // Use a Factory to inject dependencies into the ViewModel
        ViewModelFactory factory = ViewModelFactory.getInstance(activity.getApplication());

        return ViewModelProviders.of(activity, factory).get(MainViewModel.class);
    }

    private void showRecyclerList() {
        tvShows = viewModel.getListTvShow();

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        TvShowAdapter tvShowAdapter = new TvShowAdapter(tvShows, getActivity());
        tvShowAdapter.setTvShows(tvShows);

        recyclerView.setAdapter(tvShowAdapter);
    }
}

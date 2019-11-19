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
import com.learn.moviecataloguejetpackversion.activity.DetailMovieActivity;
import com.learn.moviecataloguejetpackversion.adapter.MovieAdapter;
import com.learn.moviecataloguejetpackversion.model.MainViewModel;
import com.learn.moviecataloguejetpackversion.model.Movie;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class MoviesFragment extends Fragment {
    private RecyclerView recyclerView;
    private ArrayList<Movie> movies = new ArrayList<>();

    public MoviesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movies, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        recyclerView = view.findViewById(R.id.rv_movies);
        recyclerView.setHasFixedSize(true);
        movies.addAll(MainViewModel.getListMovie());
        showRecyclerList();
    }

    private void showRecyclerList() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        MovieAdapter movieAdapter = new MovieAdapter(movies, getActivity());
        recyclerView.setAdapter(movieAdapter);
    }
}

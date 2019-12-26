package com.learn.moviecataloguejetpackversion.ui.tvshow;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.facebook.shimmer.ShimmerFrameLayout;
import com.learn.moviecataloguejetpackversion.FavoriteActivity;
import com.learn.moviecataloguejetpackversion.R;
import com.learn.moviecataloguejetpackversion.data.source.local.entity.TvShow;
import com.learn.moviecataloguejetpackversion.viewmodel.ViewModelFactory;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class TvShowsFragment extends Fragment {
    private RecyclerView recyclerView;
    private List<TvShow> tvShows;
    private TvShowViewModel viewModel;
    private TvShowAdapter tvShowAdapter;
    private ShimmerFrameLayout shimmerFrameLayout;

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
        shimmerFrameLayout = view.findViewById(R.id.shimmer_view_container);
        setHasOptionsMenu(true);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getActivity() != null) {
            showLoading(true);
            viewModel = obtainViewModel(getActivity());

            tvShowAdapter = new TvShowAdapter(getActivity());

            viewModel.setUsername("Nazar");
            viewModel.tvShows.observe(this, tvShows -> {
                if (tvShows != null) {
                    switch (tvShows.status) {
                        case LOADING:
                            showLoading(true);
                            break;
                        case SUCCESS:
                            showLoading(false);
                            tvShowAdapter.setListTvShow(tvShows.data);
                            tvShowAdapter.notifyDataSetChanged();
                            break;
                        case ERROR:
                            showLoading(false);
                            Toast.makeText(getContext(), "Terjadi kesalahan", Toast.LENGTH_SHORT).show();
                            break;
                    }
                }
            });

            showRecyclerList();
        }
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.favorite_menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.favorite) {
            Intent goToFavorite = new Intent(getActivity(), FavoriteActivity.class);
            startActivity(goToFavorite);
        }

        return true;
    }

    @NonNull
    private static TvShowViewModel obtainViewModel(FragmentActivity activity) {
        // Use a Factory to inject dependencies into the ViewModel
        ViewModelFactory factory = ViewModelFactory.getInstance(activity.getApplication());
        return ViewModelProviders.of(activity, factory).get(TvShowViewModel.class);
    }

    private void showRecyclerList() {
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(tvShowAdapter);
    }

    private void showLoading(Boolean state) {
        if (state) {
            shimmerFrameLayout.setVisibility(View.VISIBLE);
        } else {
            shimmerFrameLayout.setVisibility(View.GONE);
        }
    }
}

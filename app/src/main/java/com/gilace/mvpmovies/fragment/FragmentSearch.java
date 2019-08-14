package com.gilace.mvpmovies.fragment;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gilace.mvpmovies.R;
import com.gilace.mvpmovies.adapter.MoviesListAdapter;
import com.gilace.mvpmovies.mvp.FragmentSearchVP;
import com.gilace.mvpmovies.presenter.FragmentSearchPresenter;
import com.gilace.mvpmovies.retrofite.model.Datum;

import java.util.List;


public class FragmentSearch extends Fragment implements FragmentSearchVP.View {


    LinearLayoutManager linearLayoutManager;
    RecyclerView recyclerView;
    View rootView;
    ProgressDialog dialog;
    MoviesListAdapter adapter;
    FragmentSearchVP.SearchFragmentPresenter presenter;
    String searchText = "";


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_search, container, false);
        dialog = new ProgressDialog(getContext());
        adapter = new MoviesListAdapter(getContext());
        presenter = new FragmentSearchPresenter(this);
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        FragmentSearchVP.SearchFragmentPresenter presenter = new FragmentSearchPresenter(rootView);
        recyclerView = rootView.findViewById(R.id.rec_movie_search_Frag);
        linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
        if (getArguments() != null) {
            searchText = getArguments().getString("SearchText");
            presenter.getMoviesBySearch("1", getArguments().getString("SearchText"));
        }
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                if (!recyclerView.canScrollVertically(1)) {
                    int totalItemCount = linearLayoutManager.getItemCount();
                    presenter.getMoviesBySearch(String.valueOf((totalItemCount / 10) + 1),searchText);
                }
            }
        });
    }


    @Override
    public void MakeAdapter(List<Datum> mData) {
        adapter.add(mData);
    }

    @Override
    public void showProgress() {
        dialog.show();
    }

    @Override
    public void hideProgress() {
        dialog.hide();
    }

    @Override
    public void Cleanadpter() {
        adapter.cleanAdapter();
    }


}

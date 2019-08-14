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
import com.gilace.mvpmovies.mvp.FragmentMainVP;
import com.gilace.mvpmovies.mvp.FragmentSearchVP;
import com.gilace.mvpmovies.presenter.FragmentMainPresenter;
import com.gilace.mvpmovies.retrofite.model.Datum;

import java.util.List;

import static com.bumptech.glide.util.Preconditions.checkNotNull;


public class FragmentMain extends Fragment implements FragmentMainVP.View {

    LinearLayoutManager linearLayoutManager;
    RecyclerView recyclerView;
    View rootView;
    ProgressDialog dialog;
    MoviesListAdapter adapter;
    FragmentMainVP.MainFragmentPresenter presenter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_main, container, false);
        dialog = new ProgressDialog(getContext());
        adapter = new MoviesListAdapter(getContext());
        presenter = new FragmentMainPresenter(this);
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = rootView.findViewById(R.id.rec_movie_main_Frag);
        linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);

        presenter.getMovies("1");


        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                if (!recyclerView.canScrollVertically(1)) {
                    int totalItemCount = linearLayoutManager.getItemCount();
                    presenter.getMovies(String.valueOf((totalItemCount / 10) + 1));
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

}

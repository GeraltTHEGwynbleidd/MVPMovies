package com.gilace.mvpmovies;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.gilace.mvpmovies.adapter.MoviesListAdapter;
import com.gilace.mvpmovies.retrofite.model.Datum;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainView {

    RecyclerView recyclerView;
    MoviesListAdapter adapter;
    MainPresenterImpl presenter;
    LinearLayoutManager linearLayoutManager;
    ProgressDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.rec_movie);
        presenter = new MainPresenterImpl(this);
        adapter = new MoviesListAdapter(this);
        linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        dialog  = new ProgressDialog(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
        presenter.getMovies("1");

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
    public Activity getActivity() {
        return null;
    }

    @Override
    public Context getAppContext() {
        return null;
    }
}

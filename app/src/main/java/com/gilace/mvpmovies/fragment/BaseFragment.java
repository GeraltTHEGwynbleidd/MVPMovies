package com.gilace.mvpmovies.fragment;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gilace.mvpmovies.adapter.MoviesListAdapter;
import com.gilace.mvpmovies.mvp.BaseFragmentVP;
import com.gilace.mvpmovies.retrofite.model.Datum;

import java.util.List;

public abstract class BaseFragment extends Fragment implements BaseFragmentVP.View{

    View rootView;
    ProgressDialog dialog;
    MoviesListAdapter adapter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(getLayout(),container,false);
        dialog  = new ProgressDialog(getContext());
        adapter = new MoviesListAdapter(getContext());
        return rootView;
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

    protected abstract int getLayout();
}

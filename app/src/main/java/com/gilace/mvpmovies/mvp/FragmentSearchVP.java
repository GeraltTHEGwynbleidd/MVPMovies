package com.gilace.mvpmovies.mvp;

import android.support.v7.widget.RecyclerView;

import com.gilace.mvpmovies.retrofite.model.Datum;

import java.util.List;

public interface FragmentSearchVP {
    interface View {
        void MakeAdapter(List<Datum> mData);

        void showProgress();

        void hideProgress();

        void Cleanadpter();


    }

    interface SearchFragmentPresenter{
        void getMoviesBySearch(String page, String query);
    }
}

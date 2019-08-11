package com.gilace.mvpmovies.mvp;

import com.gilace.mvpmovies.retrofite.model.Datum;

import java.util.List;

public interface BaseFragmentVP {
    interface View {
        void MakeAdapter(List<Datum> mData);

        void showProgress();

        void hideProgress();

        void Cleanadpter();

    }

    interface MainFragmentPresenter{
        void getMovies(String page);
    }

    interface SearchFragmentPresenter{
        void getMoviesBySearch(String page, String query);
    }


}

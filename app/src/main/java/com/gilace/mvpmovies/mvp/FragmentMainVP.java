package com.gilace.mvpmovies.mvp;

import android.support.v7.widget.RecyclerView;

import com.gilace.mvpmovies.retrofite.model.Datum;

import java.util.List;

public interface FragmentMainVP {

    interface View {
        void MakeAdapter(List<Datum> mData);

        void showProgress();

        void hideProgress();

    }

    interface MainFragmentPresenter{


        void getMovies(String page);
    }

}

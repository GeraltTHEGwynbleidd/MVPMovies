package com.gilace.mvpmovies;

import com.gilace.mvpmovies.retrofite.model.Data;
import com.gilace.mvpmovies.retrofite.model.Datum;

import java.util.List;

public interface MainPresenter {

    void getMovies(String page);
    void onDestroy();

}

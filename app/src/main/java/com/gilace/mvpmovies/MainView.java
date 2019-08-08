package com.gilace.mvpmovies;

import android.app.Activity;
import android.content.Context;

import com.gilace.mvpmovies.retrofite.model.Datum;

import java.util.List;

public interface MainView {

    void MakeAdapter(List<Datum> mData);

    void showProgress();

    void hideProgress();

    Activity getActivity();

    Context getAppContext();

}

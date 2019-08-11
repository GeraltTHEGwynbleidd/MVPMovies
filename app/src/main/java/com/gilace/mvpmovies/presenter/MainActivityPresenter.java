package com.gilace.mvpmovies.presenter;

import android.os.Bundle;

import com.gilace.mvpmovies.fragment.FragmentMain;
import com.gilace.mvpmovies.fragment.FragmentSearch;
import com.gilace.mvpmovies.mvp.MainActivityVP;

public class MainActivityPresenter implements MainActivityVP.Presenter {

    private MainActivityVP.View view;


    public MainActivityPresenter(MainActivityVP.View view) {
        this.view = view;
    }

    @Override
    public void getFragment(int i,String text) {
        if (i==0) {
            view.setFragment(new FragmentMain());
        } else {
            FragmentSearch fragmentSearch = new FragmentSearch();
            Bundle argument = new Bundle();
            argument.putString("SearchText",text);
            fragmentSearch.setArguments(argument);
            view.setFragment(fragmentSearch);
        }
    }

}

package com.gilace.mvpmovies.mvp;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;

public interface MainActivityVP {

    interface View {

        void setFragment(Fragment fragment);

        Activity getActivity();

        Context getAppContext();
    }

    interface Presenter {

        void getFragment(int i, String argument);
    }


}

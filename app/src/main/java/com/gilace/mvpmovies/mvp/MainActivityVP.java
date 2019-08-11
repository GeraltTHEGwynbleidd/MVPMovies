package com.gilace.mvpmovies.mvp;

import com.gilace.mvpmovies.fragment.BaseFragment;

public interface MainActivityVP {

    interface View {

        void setFragment(BaseFragment fragment);

//        Activity getActivity();
//
//        Context getAppContext();
    }

    interface Presenter {

        void getFragment(int i, String argument);
    }


}

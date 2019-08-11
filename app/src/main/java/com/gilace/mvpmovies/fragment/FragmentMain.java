package com.gilace.mvpmovies.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.gilace.mvpmovies.R;
import com.gilace.mvpmovies.mvp.BaseFragmentVP;
import com.gilace.mvpmovies.presenter.FragmentMainPresenter;


public class FragmentMain extends BaseFragment implements BaseFragmentVP.View {


    LinearLayoutManager linearLayoutManager;
    RecyclerView recyclerView;


    @Override
    protected int getLayout() {
        return R.layout.fragment_main;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        BaseFragmentVP.MainFragmentPresenter presenter = new FragmentMainPresenter(this);
        recyclerView = rootView.findViewById(R.id.rec_movie_main_Frag);
        linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
        presenter.getMovies("1");
    }


}

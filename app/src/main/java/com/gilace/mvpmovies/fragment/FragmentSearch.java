package com.gilace.mvpmovies.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.gilace.mvpmovies.R;
import com.gilace.mvpmovies.mvp.BaseFragmentVP;
import com.gilace.mvpmovies.presenter.FragmentSearchPresenter;


public class FragmentSearch extends BaseFragment  {


    LinearLayoutManager linearLayoutManager;
    RecyclerView recyclerView;

    @Override
    protected int getLayout() {
        return R.layout.fragment_search;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        BaseFragmentVP.SearchFragmentPresenter presenter = new FragmentSearchPresenter(this);
        recyclerView = rootView.findViewById(R.id.rec_movie_search_Frag);
        linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
        if (getArguments() != null) {
            presenter.getMoviesBySearch("1",getArguments().getString("SearchText"));
        }
    }


}

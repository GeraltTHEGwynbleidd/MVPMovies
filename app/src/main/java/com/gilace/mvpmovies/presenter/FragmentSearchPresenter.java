package com.gilace.mvpmovies.presenter;

import android.support.annotation.NonNull;

import com.gilace.mvpmovies.mvp.FragmentSearchVP;
import com.gilace.mvpmovies.retrofite.ApiClient;
import com.gilace.mvpmovies.retrofite.ApiInterface;
import com.gilace.mvpmovies.retrofite.model.Data;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentSearchPresenter implements FragmentSearchVP.SearchFragmentPresenter {

    private FragmentSearchVP.View view;

    public FragmentSearchPresenter(FragmentSearchVP.View view) {
        this.view = view;
    }


    @Override
    public void getMoviesBySearch(String page, String query) {
        view.showProgress();
        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);
        Call<Data> getDatumCall = apiService.getMoviesList(page, query);
        getDatumCall.enqueue(new Callback<Data>() {
            @Override
            public void onResponse(@NonNull Call<Data> call, @NonNull Response<Data> response) {
                if (page.equals("1")) {
                    view.Cleanadpter();
                }
                if (response.body() != null) {
                    view.MakeAdapter(response.body().getData());
                }
                view.hideProgress();
            }

            @Override
            public void onFailure(@NonNull Call<Data> call, @NonNull Throwable t) {
                view.hideProgress();
            }
        });
    }
}

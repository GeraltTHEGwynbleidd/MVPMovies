package com.gilace.mvpmovies;

import android.util.Log;

import com.gilace.mvpmovies.retrofite.ApiClient;
import com.gilace.mvpmovies.retrofite.ApiInterface;
import com.gilace.mvpmovies.retrofite.model.Data;
import com.gilace.mvpmovies.retrofite.model.Datum;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresenterImpl implements MainPresenter {

    MainView mainView;

    MainPresenterImpl(MainView view) {
        this.mainView = view;
    }


    @Override
    public void getMovies(String page) {
        mainView.showProgress();
        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);
        Call<Data> getDatumCall = apiService.getMoviesList(page);
        getDatumCall.enqueue(new Callback<Data>() {
            @Override
            public void onResponse(Call<Data> call, Response<Data> response) {
                mainView.MakeAdapter(response.body().getData());
                mainView.hideProgress();
            }

            @Override
            public void onFailure(Call<Data> call, Throwable t) {

            }
        });
    }

    @Override
    public void onDestroy() {

    }


}

package com.gilace.mvpmovies.presenter;

import android.support.annotation.NonNull;
import android.util.Log;

import com.gilace.mvpmovies.mvp.BaseFragmentVP;
import com.gilace.mvpmovies.retrofite.ApiClient;
import com.gilace.mvpmovies.retrofite.ApiInterface;
import com.gilace.mvpmovies.retrofite.model.Data;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentMainPresenter implements BaseFragmentVP.MainFragmentPresenter {

    private BaseFragmentVP.View view;

    public FragmentMainPresenter(BaseFragmentVP.View view){
        this.view = view;
    }


    @Override
    public void getMovies(String page) {
        view.showProgress();
        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);
        Call<Data> getDatumCall = apiService.getMoviesList(page);
        getDatumCall.enqueue(new Callback<Data>() {
            @Override
            public void onResponse(@NonNull Call<Data> call, @NonNull Response<Data> response) {
                if (response.body() != null) {
                    view.MakeAdapter(response.body().getData());
//                    Log.d("RetroTag", "onResponse: "+response.body().getData().get(0).getGenres().toString());
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

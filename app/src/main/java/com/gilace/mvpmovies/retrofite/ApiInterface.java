package com.gilace.mvpmovies.retrofite;


import com.gilace.mvpmovies.retrofite.model.Data;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;


public interface ApiInterface {


    @GET("movies")
    Call<Data> getMoviesList(@Query("page") String page);

    @GET("movies")
    Call<Data> getMoviesList(@Query("page") String page, @Query("q") String query);


}

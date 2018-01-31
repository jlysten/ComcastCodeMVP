package com.example.joel.comcastcodemvp.main.network;

import com.example.joel.comcastcodemvp.model.Response;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Joel on 1/25/2018.
 */

public interface ApiInterface {

    @GET(".")
    Call<Response> getData(@Query(value = "q",encoded = true)String q , @Query("format") String format);
}

package com.example.myapplication.retrofit;


import com.example.myapplication.modle.Store;

import java.util.List;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface StoreApi {
    @POST("/stores/register")
    Call<Store> registerStore(@Body Store store);
}

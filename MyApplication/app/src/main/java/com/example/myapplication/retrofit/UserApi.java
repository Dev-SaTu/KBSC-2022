package com.example.myapplication.retrofit;

import com.example.myapplication.modle.Store;
import com.example.myapplication.modle.User;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface UserApi {
    @POST("/user/sign-up")
    Call<User> userSignUp(@Body User user);

    @GET("/users/{userId}")
    Call<User> findUser(@Path("userId") String userId);

    @FormUrlEncoded
    @POST("/benefit_user_allow")
    Call<Map<String, String>> allowBenefitUser(@Field("userId") String userId, @Field("welfareId") String welfareId);

    @GET("/stores/{userId}")
    Call<Store> findStore(@Path("userId") String userId);
}

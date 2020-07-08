package com.pumpkinapplabs.orders.data.remote;

import com.pumpkinapplabs.orders.data.model.LoginPost;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface APIService {
    @POST("auth/login")
    @FormUrlEncoded
    Call<LoginPost> savePost(@Field("username")String username,
                             @Field ("password") String password);
}

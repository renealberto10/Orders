package com.pumpkinapplabs.orders.data.remote;

import com.pumpkinapplabs.orders.data.model.Inventories;
import com.pumpkinapplabs.orders.data.model.LoginPost;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

//informacion que se envia para la solicitud con el api
public interface APIService {
    @POST("auth/login")
    @FormUrlEncoded
    Call<LoginPost> savePost(@Field("email")String username,
                             @Field ("password") String password);


}


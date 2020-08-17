package com.pumpkinapplabs.orders.data.remote;

import com.pumpkinapplabs.orders.data.model.Customer;
import com.pumpkinapplabs.orders.data.model.Inventories;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;

public interface Service {
    @Headers({ "Content-Type: application/json;charset=UTF-8"})
    @GET("inventory")
    Call<Inventories> getInventory(@Header("Authorization") String Authorization);

    @Headers({ "Content-Type: application/json;charset=UTF-8"})
    @GET("customer")
    Call<Customer> getCustomer(@Header("Authorization") String Authorization);
}


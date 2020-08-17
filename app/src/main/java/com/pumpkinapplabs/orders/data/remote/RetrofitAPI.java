package com.pumpkinapplabs.orders.data.remote;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.pumpkinapplabs.orders.data.Deserializer.DeserializerInventory;
import com.pumpkinapplabs.orders.data.model.Inventories;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public  class RetrofitAPI {
    public static final String BASE_URL = "https://pumpkinorder.herokuapp.com/api/";
     private static Service service;

        public static Service getClient() {
                if (service == null) {
                        Gson gson = new GsonBuilder()
                                .setLenient()
                                .create();
                        Retrofit retrofit = new Retrofit.Builder()
                                .baseUrl(BASE_URL)
                                .addConverterFactory(GsonConverterFactory.create(gson))
                                .build();

                        service = retrofit.create(Service.class);
                }
                return service;
        }



}

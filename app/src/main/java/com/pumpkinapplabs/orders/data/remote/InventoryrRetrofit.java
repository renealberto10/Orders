package com.pumpkinapplabs.orders.data.remote;

import com.google.gson.GsonBuilder;
import com.pumpkinapplabs.orders.data.Deserializer.DeserializerInventory;
import com.pumpkinapplabs.orders.data.model.Inventories;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public  class InventoryrRetrofit {
        public static final String BASE_URL = "https://pumpkinorder.herokuapp.com/api/";
        private static Retrofit retrofit = null;


        public static Retrofit getApiInvetory() {
                if (retrofit==null) {
                        GsonBuilder builder = new GsonBuilder();
                       builder.registerTypeAdapter(Inventories.class, new DeserializerInventory());
                       retrofit = new Retrofit.Builder()
                               .baseUrl(BASE_URL)
                            .addConverterFactory(GsonConverterFactory.create(builder.create()))
                              .build();
                       // retrofit = new Retrofit.Builder()
                             //   .baseUrl(BASE_URL)
                             //   .addConverterFactory(GsonConverterFactory.create())
                              //  .build();
                }
                return retrofit;
        }
        }

package com.pumpkinapplabs.orders.data.remote;

import com.google.gson.GsonBuilder;
import com.pumpkinapplabs.orders.data.Deserializer.DeserializerData;
import com.pumpkinapplabs.orders.data.model.LoginPost;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
//Recibe objecto para desarializar json de lo que devuelve el modelo
public class RetrofitClient {
    private static Retrofit retrofit = null;

    public static Retrofit getClient(String baseUrl) {
        if (retrofit==null) {
            GsonBuilder builder = new GsonBuilder();
            builder.registerTypeAdapter(LoginPost.class, new DeserializerData());
            retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create(builder.create()))
                    .build();
        }
        return retrofit;
    }
}

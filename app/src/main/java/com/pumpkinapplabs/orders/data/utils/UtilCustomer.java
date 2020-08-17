package com.pumpkinapplabs.orders.data.utils;

import android.util.Log;

import com.pumpkinapplabs.orders.data.model.Customer;
import com.pumpkinapplabs.orders.data.model.ItemCustomer;
import com.pumpkinapplabs.orders.data.remote.RetrofitAPI;
import com.pumpkinapplabs.orders.data.remote.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UtilCustomer {

    private static Call<Customer> customerCall;
    static String token = (Constants.instance().fetchValueString("token"));
    static List<ItemCustomer> array = new ArrayList<>();





    public static String[] colors = new String[]
            {"F44336", "E91E63", "9C27B0", "673AB7", "3F51B5",
                    "03A9F4", "009688", "4CAF50", "CDDC39", "FFC107",
                    "FF5722", "795548", "9E9E9E", "455A64", "FF5722"};

    public static String getRandomColor() {
        // Número aleatorio entre [0] y [14];
        int randonNumber = new Random().nextInt(colors.length);
        // Devolvemos el color
        return colors[randonNumber];
    }

    public static List<ItemCustomer> getArrayCustomer() {
        return array;
    }



    public static void getdatacustomer() {

        Service serviceAPI = RetrofitAPI.getClient();
        customerCall = serviceAPI.getCustomer("Bearer " + token);

        customerCall.enqueue(new Callback<Customer>() {
            @Override
            public void onResponse(Call <Customer> call, Response<Customer> response) {
                try {

                   array = response.body().getData();

                }
                catch (Exception e){

                    Log.d("onResponse", "There is an error");
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<Customer> call, Throwable t) {

                Log.d("onFailure", t.toString());
            }
        });
    }

}

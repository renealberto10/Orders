package com.pumpkinapplabs.orders.data.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.pumpkinapplabs.orders.data.model.Inventories;
import com.pumpkinapplabs.orders.data.model.ItemInventory;
import com.pumpkinapplabs.orders.data.remote.InventoryRetrofit;
import com.pumpkinapplabs.orders.data.remote.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Util {
    private Call<Inventories> list;
    String token = (Constants.instance().fetchValueString("token"));

        public static String[] colors = new String[]
                {"F44336", "E91E63", "9C27B0", "673AB7", "3F51B5",
                        "03A9F4", "009688", "4CAF50", "CDDC39", "FFC107",
                        "FF5722", "795548", "9E9E9E", "455A64", "FF5722"};

        public static List<ItemInventory> getDummyData() {
            return new ArrayList<ItemInventory>();
        }

        public static String getRandomColor() {
            // Número aleatorio entre [0] y [14];
            int randonNumber = new Random().nextInt(colors.length) + 0;
            // Devolvemos el color
            return colors[randonNumber];
        }

    public void getdatainventory() {

        Service serviceAPI = InventoryRetrofit.getClient();
        list = serviceAPI.getInventory("Bearer "+token);

        list.enqueue(new Callback<Inventories>() {
            @Override
            public void onResponse(Call <Inventories> call, Response<Inventories> response) {
                try {

                    List<ItemInventory> arrayList = response.body().getData();

                }
                catch (Exception e){
                    Log.d("onResponse", "There is an error");
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<Inventories> call, Throwable t) {
                Log.d("onFailure", t.toString());
            }
        });


    }


    }

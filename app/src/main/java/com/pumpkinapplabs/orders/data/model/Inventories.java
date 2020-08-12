package com.pumpkinapplabs.orders.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class Inventories {

    @SerializedName("data")
    @Expose
    private List<ItemInventory> data = null;


    public List<ItemInventory> getData() {
        return data;
    }

    public void setData(List<ItemInventory> data) {
        this.data = data;
    }
}

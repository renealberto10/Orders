package com.pumpkinapplabs.orders.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class Inventories {

    @SerializedName("data")
    @Expose
    private List<InventoryData> data = null;

    public List<InventoryData> getData() {
        return data;
    }

    public void setData(List<InventoryData> data) {
        this.data = data;
    }
}

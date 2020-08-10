package com.pumpkinapplabs.orders.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.pumpkinapplabs.orders.data.utils.Util;

import java.lang.ref.SoftReference;
import java.util.List;


public class Inventories {

    @SerializedName("data")
    @Expose
    private List<InventarioData> data = null;

    public List<InventarioData> getData() {
        return data;
    }

    public void setData(List<InventarioData> data) {
        this.data = data;
    }
}

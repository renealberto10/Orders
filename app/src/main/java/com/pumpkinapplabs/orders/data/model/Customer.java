package com.pumpkinapplabs.orders.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Customer {
    @SerializedName("data")
    @Expose
    private List<ItemCustomer> data = null;

    public List<ItemCustomer> getData() {
        return data;
    }

    public void setData(List<ItemCustomer> data) {
        this.data = data;
    }
}

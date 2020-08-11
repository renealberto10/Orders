package com.pumpkinapplabs.orders.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.pumpkinapplabs.orders.data.utils.Util;

public class InventoryData {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("description")
        @Expose
        private String description;
        @SerializedName("stock")
        @Expose
        private Integer stock;
        @SerializedName("price")
        @Expose
        private float price;
        @SerializedName("commission")
        @Expose
        private float commission;
        private String color;

    public InventoryData(Integer id, String description, Integer stock, float price, float commission) {
        this.id = id;
        this.description = description;
        this.stock = stock;
        this.price = price;
        this.commission = commission;
        this.color = Util.getRandomColor();
    }

    public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public Integer getStock() {
            return stock;
        }

        public void setStock(Integer stock) {
            this.stock = stock;
        }

        public float getPrice() {
            return price;
        }

        public void setPrice(float price) {
            this.price = price;
        }

        public float getCommission() {
            return commission;
        }

        public void setCommission(float commission) {
            this.commission = commission;
        }
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    }

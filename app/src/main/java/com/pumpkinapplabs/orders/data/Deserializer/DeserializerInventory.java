package com.pumpkinapplabs.orders.data.Deserializer;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.pumpkinapplabs.orders.data.model.ItemInventory;

import java.lang.reflect.Type;

public class DeserializerInventory implements JsonDeserializer<ItemInventory> {

    @Override
    public ItemInventory deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

       int id = json.getAsJsonObject().get("data").getAsJsonArray().get(0).getAsJsonObject().get("id").getAsInt();
        String article = json.getAsJsonObject().get("data").getAsJsonArray().get(0).getAsJsonObject().get("Article").getAsString();
        float price = json.getAsJsonObject().get("data").getAsJsonArray().get(0).getAsJsonObject().get("Price").getAsFloat();
        int stock = json.getAsJsonObject().get("data").getAsJsonArray().get(0).getAsJsonObject().get("Stock").getAsInt();
        float commission = json.getAsJsonObject().get("data").getAsJsonArray().get(0).getAsJsonObject().get("Commission").getAsFloat();
        ItemInventory inventoryget = new ItemInventory(id, article, stock, price, commission);

        return inventoryget;
    }

}
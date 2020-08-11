package com.pumpkinapplabs.orders.data.Deserializer;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

public class DeserializerInventory implements JsonDeserializer<String[]> {

    @Override
    public String[] deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Gson gson = new Gson();
        String[] InventoryGet = gson.fromJson("[\"data\"]", String[].class);


       /** int id = json.getAsJsonObject().get("data").getAsJsonArray().get(0).getAsJsonObject().get("id").getAsInt();
        String article = json.getAsJsonObject().get("data").getAsJsonArray().get(0).getAsJsonObject().get("Article").getAsString();
        float price = json.getAsJsonObject().get("data").getAsJsonArray().get(0).getAsJsonObject().get("Price").getAsFloat();
        int stock = json.getAsJsonObject().get("data").getAsJsonArray().get(0).getAsJsonObject().get("Stock").getAsInt();
        float commission = json.getAsJsonObject().get("data").getAsJsonArray().get(0).getAsJsonObject().get("Commission").getAsFloat();
        InventoryData inventoryget = new InventoryData(id, article,  stock, price, commission);*/

        return InventoryGet;
    }

}
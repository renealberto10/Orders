package com.pumpkinapplabs.orders.data.utils;

import com.pumpkinapplabs.orders.data.model.ItemInventory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Util {


        public static String[] colors = new String[]
                {"F44336", "E91E63", "9C27B0", "673AB7", "3F51B5",
                        "03A9F4", "009688", "4CAF50", "CDDC39", "FFC107",
                        "FF5722", "795548", "9E9E9E", "455A64", "FF5722"};

        public static List<ItemInventory> getDummyData() {
            return new ArrayList<ItemInventory>() {{
                add(new ItemInventory(1,"Marcarilla NK95", 23, 33.0f, 0.2f));
                add(new ItemInventory(1,"Marcarilla NK95", 23, 33.0f, 0.2f));
                add(new ItemInventory(1,"Marcarilla NK95", 23, 33.0f, 0.2f));
                add(new ItemInventory(1,"Marcarilla NK95", 23, 33.0f, 0.2f));
                add(new ItemInventory(1,"Marcarilla NK95", 23, 33.0f, 0.2f));
                add(new ItemInventory(1,"Marcarilla NK95", 23, 33.0f, 0.2f));
                add(new ItemInventory(1,"Marcarilla NK95", 23, 33.0f, 0.2f));
                add(new ItemInventory(1,"Marcarilla NK95", 23, 33.0f, 0.2f));
                add(new ItemInventory(1,"Marcarilla NK95", 23, 33.0f, 0.2f));
                add(new ItemInventory(1,"Marcarilla NK95", 23, 33.0f, 0.2f));
                add(new ItemInventory(1,"Marcarilla NK95", 23, 33.0f, 0.2f));
                add(new ItemInventory(1,"Marcarilla NK95", 23, 33.0f, 0.2f));
                add(new ItemInventory(1,"Marcarilla NK95", 23, 33.0f, 0.2f));
                add(new ItemInventory(1,"Marcarilla NK95", 23, 33.0f, 0.2f));
                add(new ItemInventory(1,"Marcarilla NK95", 23, 33.0f, 0.2f));
                add(new ItemInventory(1,"Marcarilla NK95", 23, 33.0f, 0.2f));
                add(new ItemInventory(1,"Marcarilla NK95", 23, 33.0f, 0.2f));
                add(new ItemInventory(1,"Marcarilla NK95", 23, 33.0f, 0.2f));
                add(new ItemInventory(1,"Marcarilla NK95", 23, 33.0f, 0.2f));
                add(new ItemInventory(1,"Marcarilla NK95", 23, 33.0f, 0.2f));
                add(new ItemInventory(1,"Marcarilla NK95", 23, 33.0f, 0.2f));
                add(new ItemInventory(1,"Marcarilla NK95", 23, 33.0f, 0.2f));
                add(new ItemInventory(1,"Marcarilla NK95", 23, 33.0f, 0.2f));
                add(new ItemInventory(1,"Marcarilla NK95", 23, 33.0f, 0.2f));
                add(new ItemInventory(1,"Marcarilla NK95", 23, 33.0f, 0.2f));
                add(new ItemInventory(1,"Marcarilla NK95", 23, 33.0f, 0.2f));
                add(new ItemInventory(1,"Marcarilla NK95", 23, 33.0f, 0.2f));
                add(new ItemInventory(1,"Marcarilla NK95", 23, 33.0f, 0.2f));
                add(new ItemInventory(1,"Marcarilla NK95", 23, 33.0f, 0.2f));
                add(new ItemInventory(1,"Marcarilla NK95", 23, 33.0f, 0.2f));
                add(new ItemInventory(1,"Marcarilla NK95", 23, 33.0f, 0.2f));
                add(new ItemInventory(1,"Marcarilla NK95", 23, 33.0f, 0.2f));
                add(new ItemInventory(1,"Marcarilla NK95", 23, 33.0f, 0.2f));
                add(new ItemInventory(1,"Marcarilla NK95", 23, 33.0f, 0.2f));
                add(new ItemInventory(1,"Marcarilla NK95", 23, 33.0f, 0.2f));
                add(new ItemInventory(1,"Marcarilla NK95", 23, 33.0f, 0.2f));
                add(new ItemInventory(1,"Marcarilla NK95", 23, 33.0f, 0.2f));
                add(new ItemInventory(1,"Marcarilla NK95", 23, 33.0f, 0.2f));
                add(new ItemInventory(1,"Marcarilla NK95", 23, 33.0f, 0.2f));
                add(new ItemInventory(1,"Marcarilla NK95", 23, 33.0f, 0.2f));
                add(new ItemInventory(1,"Marcarilla NK95", 23, 33.0f, 0.2f));
                add(new ItemInventory(1,"Marcarilla NK95", 23, 33.0f, 0.2f));
                add(new ItemInventory(1,"Marcarilla NK95", 23, 33.0f, 0.2f));
                add(new ItemInventory(1,"Marcarilla NK95", 23, 33.0f, 0.2f));
                add(new ItemInventory(1,"Marcarilla NK95", 23, 33.0f, 0.2f));





            }};
        }

        public static String getRandomColor() {
            // Número aleatorio entre [0] y [14];
            int randonNumber = new Random().nextInt(colors.length) + 0;
            // Devolvemos el color
            return colors[randonNumber];
        }


    }

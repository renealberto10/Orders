package com.pumpkinapplabs.orders.data.utils;

import android.content.SharedPreferences;

public class PreferencesSave {

    public static String getToken (SharedPreferences preferences){
        return preferences.getString("token", "");
    }
    public static int getuserid (SharedPreferences preferences){
        return preferences.getInt("user_id", 0);
    }
    public static int getrol (SharedPreferences preferences){
        return preferences.getInt("rol", 0);
    }
}

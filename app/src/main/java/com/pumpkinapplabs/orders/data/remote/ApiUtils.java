package com.pumpkinapplabs.orders.data.remote;

//Utilidades de conexion para api
public class ApiUtils {
    private ApiUtils() {}

   // public static final String BASE_URL = "https://pumpkinorder.herokuapp.com/api/";
   public static final String BASE_URL = "http://192.168.0.6:8000/api/";
    public static APIService getAPIService() {

        return RetrofitClientLogin.getClient(BASE_URL).create(APIService.class);
    }

}

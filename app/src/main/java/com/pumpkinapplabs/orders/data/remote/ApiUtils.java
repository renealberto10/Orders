package com.pumpkinapplabs.orders.data.remote;

//Utilidades de conexion para api
public class ApiUtils {
    private ApiUtils() {}

    public static final String BASE_URL = "https://pumpkinorder.herokuapp.com/api/";

    public static APIService getAPIService() {

        return RetrofitClientLogin.getClient(BASE_URL).create(APIService.class);
    }

}

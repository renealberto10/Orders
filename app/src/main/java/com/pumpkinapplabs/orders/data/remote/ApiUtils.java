package com.pumpkinapplabs.orders.data.remote;

public class ApiUtils {
    private ApiUtils() {}

    public static final String BASE_URL = "http://192.168.50.234:8000/api/";

    public static APIService getAPIService() {

        return RetrofitClient.getClient(BASE_URL).create(APIService.class);
    }
}

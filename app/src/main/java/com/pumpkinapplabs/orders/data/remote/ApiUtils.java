package com.pumpkinapplabs.orders.data.remote;

public class ApiUtils {
    private ApiUtils() {}

    public static final String BASE_URL = "http://pumpkinapplab.herokuapp.com/api/";

    public static APIService getAPIService() {

        return RetrofitClient.getClient(BASE_URL).create(APIService.class);
    }
}

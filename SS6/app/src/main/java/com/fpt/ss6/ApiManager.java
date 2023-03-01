package com.fpt.ss6;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiManager {

    //https://example.com/user/add
    //http://13.212.245.101/data.json
    @GET("/data.json")
    Call<Item> apiData();
}

package com.r2apps.monitoring.rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ravindra.kambale on 3/18/2017.
 */

public class RestManager {

    private static RestManager restManager;
    private ApiService service;
    public static RestManager getInstance() {
        if(restManager == null){
            restManager = new RestManager();
        }
        return restManager;
    }

    public ApiService getService(){
        if(service == null) {

            Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("http://52.8.31.115:9091/")
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();

            service = retrofit.create(ApiService.class);
        }
        return service;
    }
}
